// gcc ./main.c -S -fno-asynchronous-unwind-tables -masm=intel // this compile ELF executable assembler// see .type for COFF and ELF

#include <stdio.h>

int main()
{
	printf("Hello World!");
	printf("Hello Wor22d!");
	//return 0;
}