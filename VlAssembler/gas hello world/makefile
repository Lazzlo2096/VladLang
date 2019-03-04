# https://eax.me/linux-assembler/
# or https://www.tldp.org/HOWTO/Assembly-HOWTO/hello.html

# https://ru.wikipedia.org/wiki/GNU_Assembler

all:
	# Или: gcc -m32 -c hello-int80.s
	as --32 hello-int80.s -o hello-int80.o
	ld -melf_i386 -s hello-int80.o -o hello-int80

	# objdump ./hello-int80.o -sD -M intel
	# hexdump -C ./hello-int80.o


	as --32 hello-int80-intel-sntx.s -o hello-int80-intel-sntx.o
	ld -melf_i386 -s hello-int80-intel-sntx.o -o hello-int80-intel-sntx


clean:
	rm *.o hello-int80 hello-int80-intel-sntx