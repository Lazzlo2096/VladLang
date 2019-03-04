
.data
msg:
  .ascii "Hello, world!\n"
  .set len, . - msg

.text

.globl _start
_start:
  # write
  mov $4,   %eax
  mov $1,   %ebx
  mov $msg, %ecx
  mov $len, %edx
  int $0x80

  # exit
  mov $1,   %eax
  xor %ebx, %ebx
  int $0x80
  