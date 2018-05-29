// DictionaryTest.c
// Kevin Duong
// keduong
// 12M - Lab5
// May 8th, 2016
// Test file for Dictionary.c

#include<stdio.h>
#include<stdlib.h>
#include "Dictionary.h"


int main(int arc, char* argv[]){
   char* x;
   Dictionary testStack = newDictionary();
   
   char* a = "it's"; char* b = "if"; char* c = "makes";
   char* d = "working"; char* e = "this"; char* f = "sense";
   insert(testStack, a,d);
   insert(testStack, b,e);
   insert(testStack, c,f);
   printDictionary(stdout, testStack);

   delete(testStack,b);
   printDictionary(stdout, testStack);

   x = lookup(testStack,a);
   printf("%s\n",x);
   x = lookup(testStack,b);
   printf("%s\n",x);   
   x = lookup(testStack,c);
   printf("%s\n",x);

   makeEmpty(testStack);
   printDictionary(stdout, testStack);

   freeDictionary(&testStack);
   return (EXIT_SUCCESS);
}
