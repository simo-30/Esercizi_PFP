// =====================================================================
//  main.c
// =====================================================================

//  Author:         (c) 2017 Camil Demetrescu
//  License:        See the end of this file for license information
//  Created:        Feb 13, 2017

//  Last changed:   $Date: 2017/02/13 --:--:-- $
//  Changed by:     $Author: demetres $
//  Revision:       $Revision: 1.00 $


#include <stdio.h>
#include <stdlib.h>

#include "clut.h"
#include "pgm.h"
#include "mosaic.h"
#include "rand_perm.h"

#define PROG_NAME "mosaic.cl"
#define IDX(x,y,w) ((y)*(w)+(x))


// ---------------------------------------------------------------------
// equal
// ---------------------------------------------------------------------
// compare two matrices

int equal(unsigned char* a, unsigned char* b, int w, int h) {
    int x, y, res = 1;
    for (x=0; x<w; x++)
        for (y=0; y<h; y++) 
            if (a[IDX(x,y,w)] != b[IDX(x,y,w)]) {
                printf("a[%d,%d] - b[%d,%d] = %d\n", x, y, x, y,
                       a[IDX(x,y,w)]-b[IDX(x,y,w)]);
                res = 0;
            }
    return res;
}


// ---------------------------------------------------------------------
// mosaic_host
// ---------------------------------------------------------------------
// sequential CPU version executed on host

void mosaic_host(unsigned char* in, int w, int h, 
                 unsigned char** out, int* ow, int* oh,
                 unsigned tile_size, double* t) {

    int x, y;

    // compute output matrix size
    *ow = w - w % tile_size;
    *oh = h - h % tile_size;
    unsigned bw = *ow / tile_size; // number of horizontal tiles
    unsigned bh = *oh / tile_size; // number of vertical tiles

    unsigned* perm = rand_perm(bw*bh);

    // allocate output matrix
    *out = malloc((*ow)*(*oh)*sizeof(unsigned char));
    if (*out == NULL) exit((printf("out of host memory"), 1));

    // get initial time
    double start = clut_get_real_time();

    // scan pixels of input image
    for (x=0; x<*ow; x++)
        for (y=0; y<*oh; y++) {
            unsigned bx = x / tile_size;
            unsigned by = y / tile_size;
            unsigned bi = IDX(bx, by, bw);
            unsigned bj = perm[bi];
            unsigned bxo = bj % bw;
            unsigned byo = bj / bw;
            unsigned xo = bxo*tile_size + x % tile_size;
            unsigned yo = byo*tile_size + y % tile_size;
            (*out)[IDX(xo, yo, *ow)] = in[IDX(x,y,w)];
        }

    // get elapsed time
    *t = clut_get_real_time() - start;

    free(perm);
}


// ---------------------------------------------------------------------
// run_test
// ---------------------------------------------------------------------
// perform resize test on input matrix

void run_test(unsigned char* in, int w, int h, 
              unsigned char** out, int* ow, int* oh, 
              unsigned tile_size, clut_device* dev, char* msg) {

    double t, td;
    
    unsigned char* out_ok;
    int ow_ok, oh_ok;

    // compute on host
    mosaic_host(in, w, h, &out_ok, &ow_ok, &oh_ok, tile_size, &t);

    // compute on device
    mosaic(in, w, h, out, ow, oh, tile_size, dev, &td);

    // validate our results

    printf("%s\n", msg);
    printf("    CPU took %.3f msec\n", t*1E03);
    printf("    Device took %.3f msec\n", td*1E03);
    printf("    Correctness test: %s\n", *ow == ow_ok && *oh == oh_ok &&
                                         equal(*out, out_ok, ow_ok, oh_ok) ? 
										 "PASSED" : "FAILED");    
    // cleanup
	free(out_ok);
}


// ---------------------------------------------------------------------
// main
// ---------------------------------------------------------------------
int main(int argc, char** argv) {

    clut_device     dev;                // device structure
    char*           in_path;			// input image pathname
    char*           out_path;			// output image pathname
    unsigned char*  in;                 // input image on host
    unsigned char*  out;                // output image on host
    int             w, h;               // input image size (width and height)
    int             ow, oh;             // output image size (width and height)
    int             err;                // misc vars
    unsigned        tile_size;          // size of mosaic tile

    // args count check
    if (argc < 4) {
        printf("Usage: %s <input-file> <output-file> <tile-size>\n", argv[0]);
        return 1;
    }

    // set parameters
    in_path    = argv[1];
    out_path   = argv[2];
    tile_size  = atoi(argv[3]);

    // open device
    clut_open_device(&dev, PROG_NAME);

    // load image file in pgm format
    printf("Open image file: %s\n", in_path);
    err = pgm_load(&in, &h, &w, in_path);
    if (err) clut_panic("failed to load input image file");
    printf("Loaded %dx%d image\n", w, h);

    // print device info
    clut_print_device_info(&dev);

    // run test
    run_test(in, w, h, &out, &ow, &oh, tile_size, &dev, "Running test");

    // save output image
    printf("    Saving image: %s\n", out_path);
    err = pgm_save(out, oh, ow, out_path);
    if (err) clut_panic("failed to save output image file");

    // cleanup
    free(in);
    free(out);
    clut_close_device(&dev);
    
    return 0;
}


// Copyright (C) 2017 Camil Demetrescu
  
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
  
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
  
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
// USA
