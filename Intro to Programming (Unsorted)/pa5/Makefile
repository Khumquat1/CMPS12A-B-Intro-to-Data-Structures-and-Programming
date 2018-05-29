#-----------------------------------------------
#Makefile
#Kevin Duong
#keduong
#pa5
#Makefile for pa5
#-----------------------------------------------
Queens: Queens.class
	echo Main-class: Queens > Manifest
	jar cvfm Queens Manifest Queens.class
	rm Manifest
	chmod u+x Queens

Queens.class: Queens.java
	javac -Xlint Queens.java

clean:
	rm -f Queens.class Queens

submit:
	submit cmps012a-pt.w16 pa5 Queens.java Makefile

check:
	ls /afs/cats.ucsc.edu/class/cmps012a-pt.w16/pa5/keduong
