// ------------------------------------------------------------------
// Queens.java
// Kevin Duong
// keduong
// pa5
// Computes solutions to the n-Queens problem with user inputted "n".
// Functions presented in order used in main().
// Comments come subsequent to respective function body.
// ------------------------------------------------------------------
import java.util.Scanner;

class Queens{
   
   static boolean posIntcheck(String i){
      int foo=-1;
      try {
         foo = Integer.parseInt(i);  
      }
      catch(NumberFormatException e){
         return false;
      }
      if (foo>=0){
         return true;
      }
      else{
         return false;
      }
   }//checks single input string, T if int type and positive,F if improper string or negative
   
   static void nextPermutation(int[] A) {
      int piv=0; 
      int succ=0;
      for (int a=A.length-2; a>0; a--){
         if (A[a]<A[a+1]) {
            piv = a;	
            break;
         }
      }	
      if (piv==0){
         reverse(A,1,A.length-1);	
    	 return;
      }
      for (int b=A.length-1; b>piv; b--){
         if (A[b]>A[piv]){
            succ = b;
            break;
         }
      }
      swap(A,piv,succ);
      reverse(A,piv+1,A.length-1);
      return;
   }//Scans R to L, assigns pivot and reverses if necessary, assigns successor, swaps piv and succ, reverses pivot portion of array 
    
   static void swap(int[] A, int x, int y){
      int z = A[x];
      A[x] = A[y];
      A[y] = z;
   }//reassigns values to variables, swapping them
   
   static void reverse(int[] A, int k, int h) {
      while(k<h){
         swap(A, k, h);
            h--;
            k++;
      }
   }//calls to swap function to reverse a portion of an array
    
   static int factorial(int f){
      int g=1;
      for (int h=1; h<=f; h++){
         g *= h;
      }
      return g;
   }//numerically computes factorials
   
   static boolean isSolution(int[] A){
      for (int c=2; c<A.length; c++){
         for (int d=1; d<c; d++){
            if ((A[c]-A[d]) == (c-d)){
               return true;            
            }
            else if ((A[d]-A[c]) == (c-d)){
               return true;
            }
	 }
      }
      return false;
   }//checks for diagonal threats and returns true if found, else false
   
   static void print(int[] A){
      System.out.print("(");
         for (int e=1; e<A.length-1; e++){
            System.out.print(A[e]+", ");
         }
         System.out.print(A[A.length-1]+")\n");
   }// formats output values to match array
   
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
         int x=0;
         int y=0;
         int z=0;
         String t = "-v";
            if (t.equals(args[0]) && (args.length == 2)&& posIntcheck(args[1])){
               int b = Integer.parseInt(args[1]);
               x = b;
               int [] A = new int [b+1];
               A[0] = 0;
               for(int m=1; m <= b; m++){
                  A[m] = m;
               }
               y = factorial(b);
               for(int n=1; n<=y; n++){
                  nextPermutation(A);
                  if (!isSolution(A)){
                     z++;
                     print(A);
                  }
               }
               System.out.println(x+"-Queens has "+z+" solutions.");
            }// full verbose setting, only works when "-v (+int)" entered, creates array and prints all solutions.
            else if (args.length == 1 && posIntcheck(args[0])){		
               int b = Integer.parseInt(args[0]);
               x = b;
               int [] A = new int [b+1];
               A[0] = 0;
               for(int o=1; o <= b; o++){
                  A[o] = o;
               }
               y = factorial(b);
               for(int c=1; c<=y; c++){
                  nextPermutation(A);
                  if (!isSolution(A)){
                     z++;
                  }
               } 
               System.out.println(x+"-Queens has "+z+" solutions.");	
            }// if only +int value is entered, creates array and calculates # of solutions, prints that #.
            else if(args.length == 1 && t.equals(args[0])){
               System.out.println("Usage: Queens[-v] (+integer)");
               System.out.println("option: -v verbose output, print all solutions");
               System.exit(1);
            }//if only -v is input
            else{
               System.out.println("Usage: Queens[-v] (+integer)");
               System.out.println("option: -v verbose output, print all solutions");
               System.exit(1);
            }// all other possibilities
   }
}
