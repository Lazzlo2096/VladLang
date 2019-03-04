.PHONY: run_VlAssembler compile_asm clean

MAIN_PROGRAM=main
LANG_EXTENTION=.s

INPUT_FILE=$(MAIN_PROGRAM)$(LANG_EXTENTION)


compile_asm: run_VlAssembler
	./a.out

run_VlAssembler:
	scalac VlAssembler.scala
	scala VlAssembler

clean:
	@echo "Cleaning up..."
	rm *.class *.s *.out *.o