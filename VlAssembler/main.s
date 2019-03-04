.intel_syntax noprefix
.data
msg:
  .ascii "Hello, world!\n"
  .set len, . - msg #len = . - msg 

.text

.globl _start # точка входа в программу
_start:
  # write
  mov    eax, 0x4
  mov    ebx, 0x1
  mov    ecx, OFFSET FLAT:msg   # указатель на выводимую строку
  mov    edx, len
  int    0x80

  # exit
  mov    eax, 0x1
  xor    ebx, ebx
  int    0x80
