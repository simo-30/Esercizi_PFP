#include "vseq32.h"
#include <emmintrin.h>
#include <smmintrin.h>

// ---------------------------------------------------------------------
// veq32
// ---------------------------------------------------------------------
// versione vettorizzata

//definisco mie macro
#define LOAD _mm_loadu_si128
#define COMP32 _mm_cmpeq_epi32
#define VEC __m128i
#define TEST _mm_test_all_ones

int veq32(const int* a, int na, const int* b, int nb) {
    int i;
    if (na != nb) return 0;
    for (i=0; i+3<na; i+=4) {
		VEC va = LOAD((const VEC*)(a+i));
		VEC vb = LOAD((const VEC*)(b+i));
		VEC dst = COMP32(va, vb);
		if (!TEST(dst)) return 0;
	}
    for (; i<na; ++i) //ultima parte per scandire gli ultimi indici
        if (a[i] != b[i]) return 0;
    return 1;
}


// ---------------------------------------------------------------------
// veq32_seq
// ---------------------------------------------------------------------
// versione sequenziale

int veq32_seq(const int* a, int na, const int* b, int nb) {
    int i;
    if (na != nb) return 0;
    for (i=0; i<na; ++i)
        if (a[i] != b[i]) return 0;
    return 1;
}
