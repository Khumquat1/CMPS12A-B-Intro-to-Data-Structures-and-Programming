//-------------------------------------------------------------------
// Search.java
// Kevin Duong
// keduong
// 12B - PA2
// April 4th, 2016
// Searches an input file for given string, returns index if found
// ------------------------------------------------------------------
import java.util.Scanner;
import java.io.*;
class Search{
   
   public static void main(String[] args) throws IOException{

      Scanner in = null;
      String line = null;
      String[] token = null;
      int lineNumbers = 0;
      int[] lineNumber = null;
    
      // invalid input
      if(args.length <2){
         System.err.println("Usage: Search file target1 [target2 ..]");
         System.exit(1);
      }
      
      //scans and counts the number of lines in file
      in = new Scanner(new File(args[0]));
      while(in.hasNextLine()){
         lineNumbers++;
         line = in.nextLine();
      }
      
      //intializes lengths of the String and int array
      token = new String[lineNumbers];
      lineNumber = new int[lineNumbers];
      in = new Scanner(new File(args[0])); //rescan
   
      //number added to array
      for(int i=1; i<=lineNumber.length;i++) lineNumber[i-1] =i;
      
      //scans file, word is placed into String array
      for(int i =0; in.hasNextLine();i++){
         line = in.nextLine();
         token[i] = line;
      }
      
      //orders String array
      mergeSort(token,lineNumber,0,token.length-1);
   
      //prints confirmation and line number if target is found
      for(int i=1;i<args.length;i++) System.out.println(stringSearch(token, lineNumber, 0, token.length-1, args[i]));
     
      //close
      in.close();
    
   }
   //takes two arrays, target, and domain and returns a string with the word and line found on
   static String stringSearch(String[] word, int[] lineNumber, int p, int r, String target){
 
     int q;
      if (p==r) return target + " not found";
      else{
         q = (p+r)/2;
         if(word[q].compareTo(target) == 0) return target + " found on line "+ lineNumber[q];
         else if(word[q].compareTo(target)<0) return stringSearch(word, lineNumber, p, q, target);
         else return stringSearch(word,lineNumber,q+1,r,target);
      }
  
   }
   //gives task to merge
   static void mergeSort(String[] word, int[] lineNumber, int p, int r){
     
      int q;
      if(p<r){
         q = (p+r)/2;
         mergeSort(word,lineNumber,p,q);
         mergeSort(word,lineNumber,q+1,r);
         merge(word,lineNumber,p,q,r);
      }
 
   }
   //lexically orders array
   static void merge(String[] word, int[] lineNumber, int p, int q, int r){
      
      int a = q-p+1; 
      int b = r-q;
      String[] left = new String[a];
      String[] right = new String[b];
      int[] leftNum = new int[a]; 
      int[] rightNum = new int[b];
      int i,j,k;
  
      for(i=0;i<a;i++){
         left[i] = word[p+i];
         leftNum[i] = lineNumber[p+i];
      }
    
      for(j=0; j<b;j++){
         right[j] = word[q+j+1];
         rightNum[j] = lineNumber[q+j+1];
      }
      i = 0;
      j = 0;
      for(k = p; k<=r;k++){
         if(i<a && j<b){
            if(left[i].compareTo(right[j])>0){
               word[k] = left[i];
               lineNumber[k] = leftNum[i];
               i++;
            }else{
               word[k] = right[j];
               lineNumber[k] = rightNum[j];
               j++;
            } 
         }else if(i<a){
            word[k] = left[i];
            lineNumber[k] = leftNum[i];
            i++;
         }else{ //j<b
            word[k] = right[j];
            lineNumber[k] = rightNum[j];
            j++;
         }
      }
           
   }
}
