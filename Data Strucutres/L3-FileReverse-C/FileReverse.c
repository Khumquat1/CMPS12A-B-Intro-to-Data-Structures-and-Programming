/* 
 * FileReverse.c
 * Kevin Duong
 * keduong
 * 12M - Lab3
 * April 11th, 2016
 * C version of FileReverse.java
*/

#include<stdio.h>
#include<stdlib.h> 
#include<string.h>

//reverses string by swapping first and last char, stops at mid point.
void stringReverse(char* s){
   
   int i;
   int j = strlen(s)-1;
   char temp;
   
   for(i=0;i<=j;i++){
      temp = s[j];
      s[j] = s[i];
      s[i] = temp;
      j--; 
   }

}      
int main(int argc, char* argv[]){
 
   FILE* in;
   FILE* out;
   char word[300];

   // invalid input
   if(argc != 3){
      printf("Usage: %s inputFile outputFile \n", argv[0]);
      exit(EXIT_FAILURE);
   }
   //input error
   in = fopen(argv[1],"r");
   if(in==NULL){
      printf("Unable to read from file: %s \n", argv[1]);
      exit(EXIT_FAILURE);
   }
   //output error
   out = fopen(argv[2],"w");
   if(out==NULL){
      printf("Unable to write to file: %s \n", argv[2]);
      exit(EXIT_FAILURE);
   }
   
   // scans file and reverses array
   while(fscanf(in, "%s",word) != EOF){
      stringReverse(word);
      fprintf(out,"%s\n",word);
   }
   
   //close files
   fclose(in);
   fclose(out);

}      
