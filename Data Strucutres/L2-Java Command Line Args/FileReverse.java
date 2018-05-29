//--------------------------------------------------------------------------------------------------
// FileReverse.java
// Kevin Duong
// keduong
// 12M - LAB2
// April 5th, 2016
// Takes two command line args to take input from args[0] print them reversed in output args[1].
// -------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

class FileReverse{
   public static void main(String[] args) throws IOException{
      
      Scanner in = null;
      PrintWriter out = null;
      String line = null;
      String[] token = null;
      int i, n=0;
   
      // check number of command line arguments is at least 2
      if(args.length < 2){
         System.out.println("Usage: FileReverse <input file> <output file>");
         System.exit(1);
      }
      // open files
      in = new Scanner(new File(args[0]));
      out = new PrintWriter(new FileWriter(args[1]));
     
      // read lines from in, extract and print tokens from each line
      while( in.hasNextLine() ){
         // trim leading and trailing spaces, then add one trailing space so split works on blank lines
         line = in.nextLine().trim() + " ";
         // split line around white space
         token = line.split("\\s+");
         // print out reversed tokens in out 
         for(i=0; i<token.length; i++){
            n = token[i].length();
            out.println(stringReverse(token[i],n));
         }
  
      }
      // close files
      in.close();
      out.close();
   }
   //reverses string with n length, returns string spelled backwards.
   public static String stringReverse(String s, int n){
     
      if(n>0){
         return s.charAt(n-1) + stringReverse(s,n-1);
      }
      return "";     

   }

}
