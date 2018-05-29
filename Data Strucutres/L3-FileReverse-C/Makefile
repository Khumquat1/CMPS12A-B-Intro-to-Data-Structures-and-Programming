# Makefile
# Kevin Duong
# keduong
# 12M - Lab3
# April 11th, 2016
# Makefile for FileReverse.c with macros

FLAGS = -std=c99 -Wall
SOURCES = FileReverse.c
SUBSOURCES = FileReverse.c README Makefile
OBJECTS = FileReverse.o
EXEBIN = FileReverse
SUBMIT = submit cmps012b-pt.s16 lab3 
CHECK = ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/lab3/keduong
all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)
$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)
clean :
	rm -f $(EXEBIN) $(OBJECTS)
submit:
	$(SUBMIT) $(SUBSOURCES)
check:
	$(CHECK)
	
