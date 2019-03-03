# VladLang
Новый компилируемый, декларативный язык програмирования. Для практических (and of coz 4 fun) целей.

## Цель
Создать такой язык, чтобы он cмог скомпилировать сам себя.
Как доп. возможность: прямо на нём дописывать его же ассемблер.
Чтобы обращялся непосредственно к ОС, инструкциям процессора, и переферии (напр. сетевой карте).
Эффективность генерации машинного кода.

## Пример
(см. файл ./VladLang/VladLangCompiler/main.VladLang)
```sh
let b = "Hi, Vlad?\n" //non mutable, no variable
print b
print a
let a = "No, Hello World!\n"
```

## Принцип работы (на данный момент)
Команда make скомпилирует 'компилятор' языка VladLang (написаный на scala). Затем им транслирует VladLang на gnu assembler, а затем с помошью gas скомпилирует VladLang.s в исполняемый файл a.out

## Build
### Вам понадобиться:
Scala, GCC

### Linux:
```sh
git clone https://github.com/Lazzlo2096/VladLang.git
cd ./VladLang/VladLangCompiler/
make
./a.out #запустить готовый, бинарный "Hello World"
```

## Release History
* 0.0.1
    * Создание строковых переменных
    * Печать переменных в терминал