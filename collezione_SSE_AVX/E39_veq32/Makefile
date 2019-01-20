CC     = gcc
CFLAGS = -O1 -Wall -g
LFLAGS = -msse4.2         # modificare se serve AVX

veq32: vseq32-main.c vseq32.c vseq32.h
	$(CC) $(CFLAGS) vseq32-main.c vseq32.c -o veq32 $(LFLAGS)

.phony: clean

clean:
	rm -rf veq32 *.dSYM
