// =====================================================================
//  inrange.c
// =====================================================================

//  Author:         (c) 2018 ---
//  License:        See the end of this file for license information
//  Created:        Jan 30, 2018

//  Last changed:   $Date: 2018/01/30 --:--:-- $
//  Changed by:     $Author: demetres $
//  Revision:       $Revision: 1.00 $


#include "inrange.h"
#include <immintrin.h>

/**
 * di seguito dichiaro alcune macro per la gestione più veloce della vettorizzazione
 **/
#define VEC __m128i
#define LOAD _mm_loadu_si128
#define STEP 8
#define CMP_GT _mm_cmpgt_epi16
#define CMP_EQ _mm_cmpeq_epi16
#define TEST _mm_test_all_ones
#define ADD _mm_add_epi16
// ---------------------------------------------------------------------
// inrange
// ---------------------------------------------------------------------
// SSE version

int minimo(unsigned x, unsigned y) {
	if (x<y) return x;
	else return y;
}

int inrange(const short* min, unsigned minn, const short* v,   unsigned n, const short* max, unsigned maxn) {
	VEC vmin, vmax, vv, cmp, cmp2;
	int i, len=minimo(minn, minimo(n, maxn));
	for (i=0; i+STEP<len; i+=STEP) {
		vmin=LOAD((const VEC*)(min+i));
		vmax=LOAD((const VEC*)(max+i));
		vv=LOAD((const VEC*)(v+i));
		cmp=CMP_GT(vv, vmin);
		cmp2=CMP_EQ(vv, vmin);
		cmp=ADD(cmp, cmp2);
		if (!TEST(cmp)) return 0;
		cmp=CMP_GT(vmax, vv);
		cmp2=CMP_EQ(vv, vmax);
		cmp=ADD(cmp, cmp2);
		if (!TEST(cmp)) return 0;
	}
	for (; i<len; i++) {
		if (v[i]<min[i] || max[i]<v[i]) return 0;
	}
    return 1;
}


// Copyright (C) 2018 ---

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
