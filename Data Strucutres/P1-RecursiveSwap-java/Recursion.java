//--------------------------------------------------------
//  Recursion.java
//  Kevin Duong
//  keduong
//  12B - PA1
//  March 31st, 2016
//  Uses recursion to find the extrema indicies of an array
//  Also demonstrates three methods of reversing an array
//--------------------------------------------------------

class Recursion{

   public static void main(String[] args){

      int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
      int[] B = new int[A.length];
      int[] C = new int[A.length];
      int minIndex = minArrayIndex(A, 0, A.length-1);
      int maxIndex = maxArrayIndex(A, 0, A.length-1);

      for(int x: A) System.out.print(x+" ");
         System.out.println();

      System.out.println( "minIndex = " + minIndex ); //returns 6
      System.out.println( "maxIndex = " + maxIndex ); //returns 3
    
      reverseArray1(A, A.length, B);
      for(int x: B) System.out.print(x+" ");
      System.out.println(); //returns 7,5,8,-2,-5,2,9,12,6,2,-1

      reverseArray2(A, A.length, C);
      for(int x: C) System.out.print(x+" ");
      System.out.println();//returns 7,5,8,-2,-5,2,9,12,6,2,-1

      reverseArray3(A, 0, A.length-1);
      for(int x: A) System.out.print(x+" ");
      System.out.println();//returns 7,5,8,-2,-5,2,9,12,6,2,-1

   }
   //puts left most value of X in right most Y
   static void reverseArray1(int[] X, int n, int[] Y){

      if(n>0){ //does nothing n=0
         Y[n-1] = X[X.length-n];
         reverseArray1(X,n-1,Y);
      }   
   
   } 
   //puts right most value of X in left most Y
   static void reverseArray2(int[] X, int n, int[] Y){

      if(n>0){ //does nothing n=0
  //       Y[X.length-n] = X[n-1];
           reverseArray2(X,n-1,Y);
           X[n-1] = Y[X.length-n];
      }
   
   }
   //swaps left most value with right most, keeps swapping values while narrowing towards midpoint.
   static void reverseArray3(int[] X, int i, int j){
      
      int temp, stop = (i+j)/2;
      if(i != stop){ //upon reaching midpoint does nothing
         temp = X[i];
         X[i]=X[j];
         X[j]=temp;
         reverseArray3(X,i+1,j-1);
      }

   }
   //divides array in two parts, finds maximum of both parts and returns larger part's index
   static int maxArrayIndex(int[] X, int p, int r){
   
      int q = (p+r)/2; //midpoint
      if (r-p <= 0) return (X[p]>X[r])?p:r;
      else{
         int left = maxArrayIndex(X,p,q);
         int right = maxArrayIndex(X,q+1,r);
         return (X[left]>X[right])? left:right;
      }
   
   }     
   //divides array in two parts, finds minimum of both parts and returns smaller part's index
   static int minArrayIndex(int[] X, int p, int r){
    
      int q = (p+r)/2; //midpoint
      if (r-p <= 0) return (X[p]<X[r])?p:r;
      else{
         int left = minArrayIndex(X,p,q);
         int right = minArrayIndex(X,q+1,r);
         return (X[left]<X[right])? left:right;
      }
   
   }

}
