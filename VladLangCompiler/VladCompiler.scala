import java.io._ 
//import scalax.io._

object VladCompiler {

	def parseVladLang(name_of_file: String) = {
		// https://alvinalexander.com/scala/match-entire-string-regex-pattern-in-scala

		//data Qwert a = LetTokin a a | PrintTokin a // ??
		var lets = List[(String, String)]()
		var prints = List[(String)]()
		
		var linesOfInputVladLangFile: Iterator[String] = readFileLineByLine(name_of_file)

		for (line <- linesOfInputVladLangFile) {

/*		// https://www.scala-lang.org/api/current/scala/util/matching/Regex.html
			val date = raw"(\d{4})-(\d{2})-(\d{2})".r

			"2004-01-20" match {
				case date(year, month, day) => s"$year was a good year for PLs."
			}
*/
			var let_tokin = raw"""let ([a-zA-Z]+) = "(.*)"( //.*)?""".r
			var print_tokin = raw"""print ([a-zA-Z]+)( //.*)?""".r

			line match {
				case let_tokin(name_of_val, string, coment) => lets :+= (s"$name_of_val",s"$string")
				case print_tokin(name_of_val, coment) => prints :+= s"$name_of_val"
				case _ => ()
			}
		}
		//println(lets)
		//println(prints)
		(lets, prints)
	}

	def makeAssembler(name_of_file: String) = {

		val header_1 = 
""".file	""""+name_of_file+""""
	.intel_syntax noprefix
	.text
	.section	.rodata
"""

		def makeData(data__counter: String, _string_data_1: String): String = {
""".LC"""+data__counter+""":
	.string	""""+_string_data_1+""""
"""
		}
		val _string_data_1 = """Hello, WO@@RLD!!\n"""
		val data__counter = 0
		val data_1 = makeData(data__counter.toString, _string_data_1)

		val body_1 = 
""".text
	.globl	main
	.type	main, @function
main:
.LFB0:
	push	rbp
	mov	rbp, rsp
"""

		def makePrintAsm(name_of_val: String): String = {
"""lea	rdi, .LC"""+name_of_val+"""[rip]
	mov	eax, 0
	call	printf@PLT
"""
		}

		val print_data_1 = makePrintAsm(0.toString)

		val body_2 = 
"""mov	eax, 0
	pop	rbp
	ret
.LFE0:
	.size	main, .-main
	.ident	"GCC: (Ubuntu 8.2.0-7ubuntu1) 8.2.0"
	.section	.note.GNU-stack,"",@progbits
"""
		//=============================================================

		val (lets, prints) = parseVladLang(name_of_file)

		var allDatas: String = ""
		for((nm, strng) <- lets){
			allDatas = allDatas+makeData(nm, strng)
		}

		var allPrints: String = ""
		for(nm <- prints){
			allPrints = allPrints+makePrintAsm(nm)
		}

		//==============================================================

		val makedAssembler =
			header_1 +
			allDatas + // data_1 
			body_1 +
			allPrints + //print_data_1
			body_2

			makedAssembler
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

		val data: String = makeAssembler( input_file_to_compiling )

		val f: java.io.File = new File( name_of_output_file )

		val p = new java.io.PrintWriter(f)

		try{

			p.write( data )
		}finally{
			p.close()
		}

		println("Done! :)")
	}

	def readFileLineByLine(filename: String) = {
		import scala.io.Source

		var qwerty: Iterator[String] = Source.fromFile(filename).getLines

		qwerty
	}

	def testWriteToFile() = {
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

	def testReadFileLineByLine(filename: String) = {
		// https://alvinalexander.com/scala/how-to-open-read-text-files-in-scala-cookbook-examples
		import scala.io.Source

		for (line <- Source.fromFile(filename).getLines) {
			println(line)
		}
	}
}