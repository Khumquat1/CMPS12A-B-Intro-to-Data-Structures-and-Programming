#------------------------------------------------------------------------------
#Makefile for List ADT
#------------------------------------------------------------------------------

# Variables
 SOURCES    = List.java ListInterface.java ListClient.java\
 ListIndexOutOfBoundsException.java
 MAINCLASS = ListClient
 CLASSES    = List.class ListInterface.class ListClient.class\
              ListIndexOutOfBoundsException.class
 JARFILE = ListClient
 SUBMIT = cmps012b-pt.s16 lab6
 MISC = README Makefile

# Build Targets
all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(SOURCES)
	javac -Xlint $(SOURCES)  

clean:
	rm -f $(CLASSES) $(JARFILE)

submit: 
	submit $(SUBMIT) $(SOURCES) $(MISC)
