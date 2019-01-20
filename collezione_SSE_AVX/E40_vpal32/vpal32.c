#include "vpal32.h"
#include <immintrin.h>

// ---------------------------------------------------------------------
// vpal32
// ---------------------------------------------------------------------
// SSE version

//mie macro
#define VEC __m128i
#define LOAD _mm_loadu_si128
#define COMP _mm_cmpeq_epi32
#define SHUFFLE _mm_shuffle_epi32
#define TEST _mm_test_all_ones

int vpal32(const int* v, int n) {
    int i;
    for (i=0; i+3<n/2; i+=4) {
		VEC va = LOAD((const VEC*)(v+i));
		VEC vb = LOAD((const VEC*)(v+n-4-i));
		va = SHUFFLE(va, 0x1B);
		va = COMP(va, vb);
		if (!TEST(va)) return 0; 
	}
    for (; i<n/2; ++i) {
        if (v[i] != v[n-1-i]) return 0;
	}
    return 1;
}


// ---------------------------------------------------------------------
// vpal32_seq
// ---------------------------------------------------------------------
// sequential version

int vpal32_seq(const int* v, int n) {
    int i;
    for (i=0; i<n/2; ++i)
        if (v[i] != v[n-1-i]) return 0;
    return 1;
}
