# https://elixir-lang.org/getting-started/mix-otp/introduction-to-mix.html#project-compilation


something_header =
"	.file	\"main.c\"
	.def	__main;	.scl	2;	.type	32;	.endef
	.section .rdata,\"dr\"
"


counter_lol = 0
data_0 = "Hello World!\\n" # WTF is that \\n - ??
stack_data_ascii_1 = 
".LC#{counter_lol}:
	.ascii \"#{data_0}\\0\"
"

other_stack_data = 
"	.text
	.globl	main
	.def	main;	.scl	2;	.type	32;	.endef
	.seh_proc	main
"


something_mainn_topper =
"main:
	pushq	%rbp
	.seh_pushreg	%rbp
	movq	%rsp, %rbp
	.seh_setframe	%rbp, 0
	subq	$32, %rsp
	.seh_stackalloc	32
	.seh_endprologue
	call	__main
"

push_from_datastack = 0
call_asm_comand = "printf"
instruction_1 =
"	leaq	.LC#{push_from_datastack}(%rip), %rcx
	call	#{call_asm_comand}
"

something_mainn_footer = 
"	movl	$0, %eax
	addq	$32, %rsp
	popq	%rbp
	ret
	.seh_endproc
	.ident	\"GCC: (Rev1, Built by MSYS2 project) 7.2.0\"
	.def	printf;	.scl	2;	.type	32;	.endef
"

#B======== generate assembler code funcs: =============


# defmodule Greeter do
# 	def hello(name) do
# 		stack_data
# 	end
# end



#IO.puts(stack_data)

#E====================================================


input_file_to_compile = "main.VladLang"
{:ok, prog1_vladLang} = File.read(input_file_to_compile)
#B====== parce VladLang ==============


#--------разбить на список строк с новой строки ---------
#предпологаем одна команда - одна операция
asdf = String.split(prog1_vladLang, "\n")
qwer = ["dasfg ","frfsd"]
IO.puts( Enum.at(asdf, 1) )

#затем удаляем пустые строки
# https://stackoverflow.com/questions/41495953/assign-splited-string-to-array-in-elixir
# http://elixir-recipes.github.io/strings/splitting-strings/
# https://stackoverflow.com/questions/19824391/elixir-erlang-split-bitstring-on-newlines/19829864#19829864

#--------------------------------------------------------



#EB====== составляем асемблер ===============





whole_programm = something_header <> stack_data_ascii_1 <> other_stack_data <> something_mainn_topper <> instruction_1 <> something_mainn_footer

#E======================

# https://elixir-lang.org/getting-started/io-and-the-file-system.html

{:ok, tranclated_file_s} = File.open(input_file_to_compile<>".s", [:write]) 
IO.write(tranclated_file_s, whole_programm) # puts # Not IO.write потому что, gcc требует чтобы в конце был \n
File.close(tranclated_file_s)