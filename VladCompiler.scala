import java.io._ 
//import scalax.io._

object VladCompiler {
	

	val qwer = 
""".file	"main.c" 
	.text
	.section	.rodata
.LC0:
	.string	"Hello World!\n"
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	leaq	.LC0(%rip), %rdi
	movl	$0, %eax
	call	printf@PLT
	movl	$0, %eax
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.ident	"GCC: (Ubuntu 8.2.0-7ubuntu1) 8.2.0"
	.section	.note.GNU-stack,"",@progbits
"""


	def makeAssembler() = {


		qwer

	}


	def main(args: Array[String]): Unit = {
		println("Compiling starts...")


		var input_file_to_compiling: String = null   // https://stackoverflow.com/questions/37174687/declare-a-variable-without-an-initial-value/37174753#37174753

		if(!args.isEmpty) // args.length == 0
		{
			println("Name of imput file is "+args(0))
			input_file_to_compiling = args(0)
		}else{
			println("Nothing was inputed")
			input_file_to_compiling = "main.VladLang"
			// or exit immediatly
		}

		val name_of_output_file = input_file_to_compiling+".s"



		val data: String = makeAssembler()




		val f: java.io.File = new File( name_of_output_file )

		val p = new java.io.PrintWriter(f)

		try{

			p.write( data )
		}finally{
			p.close()
		}




		println("Done! :)")
	}

	def writeToFile() = {
		// https://stackoverflow.com/a/4608061
		val data = Array("FIVE","strings","in","a","file!")
		val f: java.io.File = new File("example.txt")
		val p = new java.io.PrintWriter(f)
		try{
			data.foreach(p.println)
		}finally{
			p.close()
		}
	}

}