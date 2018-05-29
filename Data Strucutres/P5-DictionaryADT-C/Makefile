#------------------------------------------------------------------------------
#----------------------------------------------------------------------------
# Makefile for DictionaryClient.c with macros
#-----------------------------------------------------------------------------
 FLAGS   = -std=c99 -Wall
 SOURCES = Dictionary.c DictionaryClient.c
 OBJECTS = Dictionary.o DictionaryClient.o
 HEADERS = Dictionary.h
 EXEBIN  = DictionaryClient
 SUBMIT = cmps012b-pt.s16 pa5
 ADDONS = README Makefile

 all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS) $(HEADERS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES) $(HEADERS)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:
	valgrind --leak-check=full $(EXEBIN) 
submit:
	submit $(SUBMIT) $(SOURCES) $(HEADERS) $(ADDONS)
