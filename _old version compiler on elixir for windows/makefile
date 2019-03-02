a.exe:
	elixir VladCompiler.exs # fom file main.VladLang

	#https://stackoverflow.com/questions/2033997/how-to-compile-for-windows-on-linux-with-gcc-g/17740458#17740458
		#https://mingw-w64.org/doku.php
		#sudo apt install wine binutils-mingw-w64 g++-mingw-w64 gcc-mingw-w64
	x86_64-w64-mingw32-gcc ./main.VladLang.s -o a.exe
	wine ./a.exe 
	#or just
	#gcc main.VladLang.s