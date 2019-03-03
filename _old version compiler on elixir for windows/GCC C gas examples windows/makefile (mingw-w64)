All:
	x86_64-w64-mingw32-gcc ./main.c -S -o main_86.s
	
	#hard way:
	# x86_64-w64-mingw32-ld ./a_86.obj #???
		# x86_64-w64-mingw32-ld: ./a_86.obj:main.c:(.text+0x9): undefined reference to `__main'
		# x86_64-w64-mingw32-ld: ./a_86.obj:main.c:(.text+0x15): undefined reference to `printf'

	#simple way:
	#so just do this:
	x86_64-w64-mingw32-as main_86.s -o a_86.obj
	x86_64-w64-mingw32-gcc ./a_86.obj -o a_86.exe
	#or this:
	x86_64-w64-mingw32-gcc ./main_86.s -o a_86.exe 

	wine ./a_86.exe
	wine64 ./a_86.exe

	#------------
	#i686-w64-mingw32-gcc ./main.c -S -o main_686.s
	#i686-w64-mingw32-as main_686.s -o a_686.obj
	#wine ./a_686.exe
	#wine64 ./a_686.exe

itisworks:
	x86_64-w64-mingw32-gcc ./main.c -o a_na_86.exe
	wine ./a_na_86.exe
	wine64 ./a_na_86.exe

	i686-w64-mingw32-gcc ./main.c -o a_na_686.exe
	wine ./a_na_686.exe
	wine64 ./a_na_686.exe