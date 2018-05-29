//-------------------------------------------------------------------------
// DictionaryTest.c
// Kevin Duong
// keduong
// May 20th, 2016
// 12B - PA5
// Test client for Dictionary
//-------------------------------------------------------------------------


#include<stdio.h>
#include<stdlib.h>
#include"Dictionary.h"

int main(void){
   Dictionary D = newDictionary();
   
   printf("inserting.....\n");
   insert(D,"one","is");
   insert(D,"two","this");
   insert(D,"three","test");
   insert(D,"four","a");
   insert(D,"five","working");

   printDictionary(stdout,D);
 
   printf("deleting....\n");
   delete(D,"three");
   delete(D,"four");
  
   printDictionary(stdout,D);

   printf("emptying....\n");
   makeEmpty(D);
  
   printDictionary(stdout,D);
   
   printf("done! \n");
}
