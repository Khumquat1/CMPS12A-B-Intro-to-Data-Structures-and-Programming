# -----------------------------------------------------------------------------
# Makefile
# Kevin Duong
# keduong
# 12M - Lab4
# April 25th, 2016
# Simple macro based Makefile for lab 4
# -----------------------------------------------------------------------------

FLAGS = -std=c99 -Wall
CSOURCE = charType.c
SOURCES = charType.c Makefile README
OBJECTS = charType.o
EXEBIN = charType
SUBMIT = cmps012b-pt.s16 lab4 

all: $(EXEBIN)

$(EXEBIN): $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS): $(CSOURCE)
	gcc -c $(FLAGS) $(CSOURCE)

clean:
	rm $(EXEBIN) $(OBJECTS)

submit: 
	submit $(SUBMIT) $(SOURCES) 			
