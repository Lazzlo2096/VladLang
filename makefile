.PHONY: run_VladLang_compiler compile_asm clean

MAIN_PROGRAM=main
MY_LANG_EXTENTION=.VladLang

INPUT_FILE=$(MAIN_PROGRAM)$(MY_LANG_EXTENTION)


compile_asm: run_VladLang_compiler
	gcc $(INPUT_FILE).s #-o $(MAIN_PROGRAM)
	./a.out

run_VladLang_compiler:
	scalac VladCompiler.scala
	scala VladCompiler $(INPUT_FILE)

clean:
	@echo "Cleaning up..."
	rm *.class *.s