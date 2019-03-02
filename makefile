.PHONY: all compileIt clean

MAIN_PROGRAM=main
MY_LANG_EXTENTION=.VladLang

INPUT_FILE=$(MAIN_PROGRAM)$(MY_LANG_EXTENTION)


compileIt: all
	gcc $(INPUT_FILE).s #-o $(MAIN_PROGRAM)

all:
	scalac VladCompiler.scala
	scala VladCompiler $(INPUT_FILE)

clean:
	@echo "Cleaning up..."
	rm *.class *.s