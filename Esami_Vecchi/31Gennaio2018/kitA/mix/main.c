// =====================================================================
//  main.c
// =====================================================================

//  Author:         (c) 2018 Camil Demetrescu
//  License:        See the end of this file for license information
//  Created:        Jan 30, 2018

//  Last changed:   $Date: 2018/01/30 --:--:-- $
//  Changed by:     $Author: demetres $
//  Revision:       $Revision: 1.00 $


#include <stdio.h>
#include <stdlib.h>

#include "clut.h"
#include "pgm.h"
#include "mix.h"

#define PROG_NAME "mix.cl"
#define IDX(x,y,w) ((y)*(w)+(x))
#define MIN(a,b) ((a) < (b) ? (a) : (b))


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
// mix_host
// ---------------------------------------------------------------------
// sequential CPU version executed on host

void mix_host(unsigned char* in1, int w1, int h1,
              unsigned char* in2, int w2, int h2,
              unsigned char** out, int* ow, int* oh,
              double* t) {

    int x, y;

    // compute output matrix size
    *oh = MIN(h1,h2);
    *ow = MIN(w1,w2);

    // allocate output matrix
    *out = malloc((*ow)*(*oh)*sizeof(unsigned char));
    if (*out == NULL) exit((printf("out of host memory"), 1));

    // get initial time
    double start = clut_get_real_time();

    // scan pixels of input image
    for (x=0; x<*ow; x++)
        for (y=0; y<*oh; y++)
        	(*out)[IDX(x, y, *ow)] = (in1[IDX(x, y, w1)] + in2[IDX(x, y, w2)]) / 2;

    // get elapsed time
    *t = clut_get_real_time() - start;
}


// ---------------------------------------------------------------------
// run_test
// ---------------------------------------------------------------------
// perform resize test on input matrix

void run_test(unsigned char* in1, int w1, int h1,
              unsigned char* in2, int w2, int h2,
              unsigned char** out, int* ow, int* oh,
              clut_device* dev, char* msg) {

    double t, td;

    unsigned char* out_ok;
    int ow_ok, oh_ok;

    // compute mix on host
    mix_host(in1, w1, h1, in2, w2, h2, &out_ok, &ow_ok, &oh_ok, &t);

    // compute mix on device
    mix(in1, w1, h1, in2, w2, h2, out, ow, oh, dev, &td);

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
    char*           in1_path;			// first input image pathname
    char*           in2_path;			// second input image pathname
    char*           out_path;			// output image pathname
    unsigned char*  in1;                // first input image on host
    unsigned char*  in2;                // second input image on host
    unsigned char*  out;                // output image on host
    int             w1, h1;             // first input image size (width and height)
    int             w2, h2;             // second input image size (width and height)
    int             ow, oh;             // output image size (width and height)
    int             err;                // misc vars

    // args count check
    if (argc < 3) {
        printf("Usage: %s <input-file1> <input-file2> <output-file>\n", argv[0]);
        return 1;
    }

    // set parameters
    in1_path   = argv[1];
    in2_path   = argv[2];
    out_path   = argv[3];

    // open device
    clut_open_device(&dev, PROG_NAME);

    // load first image file in pgm format
    printf("Open image file 1: %s\n", in1_path);
    err = pgm_load(&in1, &h1, &w1, in1_path);
    if (err) clut_panic("failed to load first input image file");
    printf("Loaded %dx%d image 1\n", w1, h1);

    // load second image file in pgm format
    printf("Open image file 2: %s\n", in2_path);
    err = pgm_load(&in2, &h2, &w2, in2_path);
    if (err) clut_panic("failed to load second input image file");
    printf("Loaded %dx%d image 2\n", w2, h2);

    // print device info
    clut_print_device_info(&dev);

    // run test
    run_test(in1, w1, h1, in2, w2, h2, &out, &ow, &oh, &dev, "Running test");

    // save output image
    printf("    Saving image: %s\n", out_path);
    err = pgm_save(out, oh, ow, out_path);
    if (err) clut_panic("failed to save output image file");

    // cleanup
    free(in1);
    free(in2);
    free(out);
    clut_close_device(&dev);

    return 0;
}


// Copyright (C) 2018 Camil Demetrescu

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
