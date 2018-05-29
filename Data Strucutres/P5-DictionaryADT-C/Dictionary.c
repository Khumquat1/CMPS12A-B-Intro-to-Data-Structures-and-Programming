//-------------------------------------------------------------------------
// Dictionary.c
// Kevin Duong
// keduong
// May 20th, 2016
// 12B - PA5
// Dictionary ADT in C using hash table
//-------------------------------------------------------------------------


#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"

// private types and functions ------------------------------------------------

//defined tableSize
const int tableSize=100;

// NodeObj
typedef struct NodeObj{
   char* key;
   char* value;
   struct NodeObj* next;
} NodeObj;

// Node
typedef NodeObj* Node;

// constructor
Node newNode(char* k, char* v) {
   Node N = malloc(sizeof(NodeObj));
   assert(N!=NULL);
   N->key = k;
   N->value = v;
   N->next = NULL;
   return(N);
}

// freeNode()
// destructor for private Node type
void freeNode(Node* pN){
   if( pN!=NULL && *pN!=NULL ){
      free(*pN);
      *pN = NULL;
   }
}

// list data type
// ListObj
typedef struct ListObj{
   Node head;
   int size;
} ListObj;

// List
typedef ListObj* List;

// constructor for list
List newList(void){
   List L = malloc(sizeof(ListObj));
   assert(L!=NULL);
   L->head = NULL;
   L->size = 0;
   return(L);
}

// freeList()
// destructor for private List type
void freeList(List* pL){
   if( pL!=NULL && *pL!=NULL ){
      free(*pL);
      *pL = NULL;
   }
}

// DictionaryObj
typedef struct DictionaryObj{
   List* table;
   int numPairs;
} DictionaryObj;

// rotate the bits in an unsigned int
unsigned int rotate_left(unsigned int value, int shift) {
   int sizeInBits = 8*sizeof(unsigned int);
   shift = shift & (sizeInBits - 1);
   if ( shift == 0 )
      return value;
   return (value << shift) | (value >> (sizeInBits - shift));
}

// pre_hash function
unsigned int pre_hash(char* input) {
   unsigned int result = 0xBAE86554;
   while (*input) {
      result ^= *input++;
      result = rotate_left(result, 5);
   }
   return result;
}

// hash function
int hash(char* k){
   return pre_hash(k)%tableSize;
}

// public functions -----------------------------------------------------------

// newDictionary()
// constructor for the Dictionary type
Dictionary newDictionary(void){
   int i;
   Dictionary D = malloc(sizeof(DictionaryObj));
   assert(D!=NULL);
   D->table = calloc(tableSize+1,sizeof(List));
   D->numPairs = 0;
   for(i=0;i<tableSize;i++){
      D->table[i] = newList();
   }
   return D;
}   

// freeDictionary()
// destructor for the Dictionary type
void freeDictionary(Dictionary* pD){
   if( pD!=NULL && *pD!=NULL ){
      makeEmpty(*pD);
      free(*pD);
      *pD = NULL;
   }
}

// isEmpty()
// returns 1 (true) if D is empty, 0 (false) otherwise
// pre: none
int isEmpty(Dictionary D){
   if( D==NULL ){
      fprintf(stderr, 
         "Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   return(D->numPairs==0);
}

// size()
// returns the number of (key, value) pairs in D
// pre: none
int size(Dictionary D){
   if( D==NULL ){
      fprintf(stderr, 
         "Dictionary Error: calling size() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   return(D->numPairs);
}

// lookup()
// returns the value v such that (k, v) is in D, or returns NULL if no 
// such value v exists.
// pre: none
char* lookup(Dictionary D, char* k){
   Node N = D->table[hash(k)]->head;
   if( D==NULL ){
      fprintf(stderr, 
         "Dictionary Error: calling lookup() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   while(N!=NULL){
      if(N->key == k){
         return N->value;
      }
      N = N->next;
   }
   return NULL;
}
// insert()
// inserts new (key,value) pair into D
// pre: lookup(D, k)==NULL
void insert(Dictionary D, char* k, char* v){
   Node N = newNode(k,v);
   int h = hash(k);

   if( D==NULL ){
      fprintf(stderr, 
         "Dictionary Error: calling insert() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   if( lookup(D, k)!=NULL ){
      fprintf(stderr, 
         "Dictionary Error: cannot insert() duplicate key: \"%s\"\n", k);
      exit(EXIT_FAILURE);
   }
   if(D->table[h]->head == NULL){
      D->table[h]->head =N;
   }
   else{
      N->next = D->table[h]->head;
      D->table[h]->head = N;
   }
   D->numPairs++;
   D->table[h]->size++;
}

// delete()
// deletes pair with the key k
// pre: lookup(D, k)!=NULL
void delete(Dictionary D, char* k){
   int h = hash(k);
   Node N = D->table[h]->head;
   Node P = NULL;
   if( D==NULL ){
      fprintf(stderr, 
         "Dictionary Error: calling delete() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   if( lookup(D,k) ==NULL ){
      fprintf(stderr, 
         "Dictionary Error: cannot delete() non-existent key: \"%s\"\n", k);
      exit(EXIT_FAILURE);
   }
   if(D->table[h]->size ==1){
      freeNode(&N);
   }
   else if( N->key ==k){
      P = N;
      D->table[h]->head = N->next;
      freeNode(&P);
   }
   else{
      while(N->next->key !=k){
         N = N->next;
      }
      P = N->next;
      N->next = P->next;
      freeNode(&P);
   }
   D->numPairs--;
   D->table[h]->size--;
}

// makeEmpty()
// re-sets D to the empty state.
// pre: none
void makeEmpty(Dictionary D){
   if( D==NULL ){
      fprintf(stderr, 
         "Dictionary Error: calling makeEmpty() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   int i;
   for(i=0;i<tableSize;i++){
      D->table[i]->size = 0;
      freeNode(&D->table[i]->head);
   }
   D->numPairs = 0;
}
   
// printDictionary()
// pre: none
// prints a text representation of D to the file pointed to by out
void printDictionary(FILE* out, Dictionary D){
   if( D==NULL ){
      fprintf(stderr, 
         "Dictionary Error: calling printDictionary() on NULL"
         " Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   Node N = NULL;
   int i;
   for(i=0;i<tableSize;i++){
      N = D->table[i]->head;
      while(N !=NULL){ 
         fprintf(out,"%s %s\n",N->key, N->value);
         N = N->next;
      }
   }
}
