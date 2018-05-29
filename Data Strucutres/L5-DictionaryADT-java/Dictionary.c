// Dictionary.c
// Kevin Duong
// keduong
// 12M - Lab5
// May 8th, 2016 
// Dictionary ADT in c

#include<stdio.h>
#include<stdlib.h>
#include<assert.h>

#include "Dictionary.h"

// private types --------------------------------------------------------------

//NodeObj
//creates node data type
typedef struct NodeObj{  
   char* key;
   char* value;
   struct NodeObj* next;
} NodeObj;

// Node 
typedef NodeObj* Node;

// newNode()
// constructor of the Node type
Node newNode(char* k, char* v) {
   Node N = malloc(sizeof(Node));
   assert(N!=NULL);
   N->key = k;
   N->value = v;
   N->next = NULL;
   return(N);
}

// Dictionary
// creates Dictionary ADT
typedef struct DictionaryObj{
   Node head;
   int numItems;
}DictionaryObj;

// freeNode()
// free heap memory
void freeNode(Node* pN){
   if(pN!=NULL && *pN!=NULL){
      free(*pN);
      *pN = NULL;
   }
}

// public functions ---------------------------------------

// newDictionary
// Constructor for Dictionary ADT
Dictionary newDictionary(void){
   Dictionary D = malloc(sizeof(Dictionary));
   assert(D!=NULL);
   D->head = NULL;
   D->numItems = 0;
   return D;
}

// freeDictionary
// frees heap memory for Dictionary ADT
void freeDictionary(Dictionary* pD){
   free(*pD);
   *pD = NULL;
}

// isEmpty
// returns t/f for empty stack
int isEmpty(Dictionary D){
   if( D == NULL){
      fprintf(stderr,
         "Stack Error: isEmpty() called on NULL stack reference\n");
      exit(EXIT_FAILURE);
   } return(D->numItems==0);
}

// size
// returns size of stack
int size(Dictionary D){
   return(D->numItems);
}

// lookup
// returns value or NULL
char* lookup(Dictionary D, char* k){
   Node N = D->head;
      while(N != NULL){
         if(N->key == k){
            return N->value;
         }N= N->next;
      }return NULL;
}

// insert
// inserts key into the stack
void insert(Dictionary D, char* k, char* v){
   Node N = D->head;
   if(D==NULL){
      fprintf(stderr,
         "Stack Error: insert() called on Null stack reference\n");
      exit(EXIT_FAILURE);
   }else if (lookup(D,k)!=NULL){
      fprintf(stderr,
         "Stack Error: inserting duplicate key\n");
      exit(EXIT_FAILURE);
   }else{
      if(D->head == NULL){
         N = newNode(k,v);
         D->head = N;
         D->numItems++;
      }else{
         while(N!=NULL){
            if(N->next==NULL){
               break;
            } N = N->next;
         }N->next = newNode(k,v);
         D->numItems++;
      }
   }
}

// delete
// removes key from stack
void delete(Dictionary D, char* k){
   Node N = D->head;
   if(D==NULL){
      fprintf(stderr,
         "Stack Error: delete() called on Null stack reference\n");
      exit(EXIT_FAILURE);
   }else if (lookup(D,k)==NULL){
      fprintf(stderr,
         "Stack Error: deleting nonexistant key\n");
      exit(EXIT_FAILURE);
   }else{
      if(D->numItems<=1){
         freeNode(&N);
      }else{
         if(N->key==k){
            Node temp = D->head;
            D->head = N->next;
            D->numItems--;
            freeNode(&temp);
         }else{
            while(N->next->key!=k){
               N = N->next;
            }
            Node temp = N->next;
            N->next = N->next->next;
            freeNode(&temp);
            D->numItems--;
         }
      }
   }
}
   
// makeEmpty
// frees Dict. ADT heap memory
void makeEmpty(Dictionary D){
   D->numItems = 0;
   freeNode(&D->head);
}

// printDictionary
// prints dictionary to output file
void printDictionary(FILE* out, Dictionary D){
   Node N = D->head;
   while(N != NULL){
      fprintf(out,"%s %s \n",N->key,N->value);
      N = N->next;
   }
}
 
