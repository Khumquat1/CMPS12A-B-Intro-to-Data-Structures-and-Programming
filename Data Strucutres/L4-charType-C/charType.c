// -----------------------------------------------------------------------------
// charType.c
// Kevin Duong
// keduong
// 12M - Lab4
//  April 25th, 2016
// Takes two args, reads from the first, categorizes input, and prints to output
// -----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
#include<assert.h>

#define MAX_STRING_LENGTH 100

// prototype of function extract_chars
void extractChars(char* s , char* a, char* d, char* p, char* w);

int main(int argc, char* argv[]){
 
   FILE* in; // handle for input file
   FILE* out; //handle for output file
   char* cha; // dynamically allocated string holding chars from input
   char* alph; // dynamically allocated string holding alphabetical chars
   char* num;  // dynamically allocated string holding numbers
   char* punc; // dynamically allocated string holding punctuation
   char* wtspc; // dynamically allocated string holding wtspc
   int n=1; // file num count
 
   // command line argument check
   if(argc!=3){
      printf("Usage: %s input-file outputfile \n", argv[0]);
      exit(EXIT_FAILURE);
   } 

   // open input file for reading 
   if( (in=fopen(argv[1], "r"))==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   // open output file for writing 
   if( (out=fopen(argv[2], "w"))==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }
   
   // allocate strings cha, alph, num, punc, and wtspc on the heap
   cha = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   alph = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   num = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   punc = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   wtspc= calloc(MAX_STRING_LENGTH+1, sizeof(char));
   assert(cha!=NULL && alph!=NULL && num!=NULL && punc!=NULL && wtspc!=NULL);
 
   // reads the input file and prints array under proper category
   while( fgets(cha, MAX_STRING_LENGTH, in) != NULL){
      extract_chars(cha,alph,num,punc,wtspc); 
      fprintf(out,"line %d contains: \n",n); 
      
      // accounts for possibilities of singular or plural values 
      if(strlen(alph)>1){
         fprintf(out,"%d alphabetic characters: %s\n",(int)strlen(alph),alph);
      }else{
         fprintf(out,"%d alphabetic character: %s\n",(int)strlen(alph),alph);
      }if(strlen(num)>1){
         fprintf(out,"%d numeric characters: %s\n",(int)strlen(num),num);
      }else{
         fprintf(out,"%d numeric character: %s\n",(int)strlen(num),num);
      }if(strlen(punc)>1){
         fprintf(out,"%d punctuation characters: %s\n",(int)strlen(punc),punc);
      }else{
         fprintf(out,"%d punctuation character: %s\n",(int)strlen(punc),punc);
      }if(strlen(wtspc)>1){
         fprintf(out,"%d whitespacecharacters: %s\n",(int)strlen(wtspc),wtspc);
      }else{
         fprintf(out,"%d whitespacecharacter: %s\n",(int)strlen(wtspc),wtspc);
      } 
      //incrementing line number
      n++; 
   }
  
   // free heap memory
   free(cha);
   free(alph);
   free(num);
   free(punc);
   free(wtspc);
 
   // close input and output files
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;

}

// definition of function extract_chars
void extract_chars(char* c, char* a, char* n, char* p, char* w){
   
   int i=0, j=0, k=0, l=0, m=0;
   while(c[i] != '\0' && i<MAX_STRING_LENGTH){
      if( isupper((int)c[i])){
      a[j]=c[i];
      j++;
      }else if( isalpha((int)c[i])){
         a[j] =c[i];
         j++;
      }else if( isdigit((int)c[i])){
         n[k] = c[i];
         k++;
      }else if(ispunct((int)c[i])){
         p[l]=c[i];
         l++;
      }else{
         w[m]=c[i];
         m++;
      }
      i++;
   } 
   // setting array finalizing null character
   a[j]='\0';
   n[k]='\0';
   p[l]='\0';
   w[m]='\0';	
}
