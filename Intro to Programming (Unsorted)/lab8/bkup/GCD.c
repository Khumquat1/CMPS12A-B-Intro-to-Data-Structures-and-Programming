/* GCD.c
 * Kevin Duong
 * keduong
 * lab8
 * C version of GCD.java, uses recursion to compute GCD of two given integers.
*/ 
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

int main(){
   int n,num1,num2,res;
   char str[100], str2[100];
   
   printf("Enter a positive integer: ");  
   while(1){
      n = scanf("%d",&num1);
      while(n != 1){
         scanf("%s", str);
         printf("Please enter a positive integer: ");
         n = scanf(" %d", &num1);
      }
      if (num1>0) break;
      printf("Please enter a positive integer: ");
   }
   printf("Enter another positive integer: ");
   while(1){
      n = scanf("%d",&num2);
      while(n =! 1){
         scanf("%s", str);
         printf("Please enter a positive integer: ");
         n = scanf(" %d", &num2);
      }
      if (num2>0) break;
      printf("Please enter a positive integer: ");
   }
   res = gcd(num1,num2);
   printf("The GCD of %d and %d is %d.\n",num1,num2,res);
   return 0;
}

int gcd(int a, int b){
   while(a != b){
      if (a>b)
         return gcd(a-b, b);
      else  
         return gcd(a, b-a);
   }
   return a;
}
