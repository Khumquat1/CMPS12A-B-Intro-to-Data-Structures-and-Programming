import java.util.Scanner;
class GCD {
  
 public static void main (String[] args) {
      
      Scanner sc = new Scanner(System.in);
      int num1=-1, num2=-1, x=1, y=1, z;
     // num1 & num2 are input values, transcribed to be x and y where x > y for all positve ints.
          
         System.out.print("Enter a positive integer: ");
         while(true) {
                      
            while( !sc.hasNextInt()) { // if a non integer is entered
               sc.next();
               System.out.print("Please enter a positive integer: ");
            }
               if (sc.hasNextInt()) // if a non positive integer is entered
                  num1 = sc.nextInt();
               if (num1 >=0) break;
            System.out.print("Please enter a positive integer: "); 
         } // only positive integers are assigned to num 1 and num2 respectively, loops until appropriate
            
         System.out.print("Enter another positive integer: ");
         while(true) {
 
            while( !sc.hasNextInt()) {
               sc.next();
               System.out.print("Please enter a positive integer: ");
            }
            if (sc.hasNextInt()) 
               num2 = sc.nextInt();
            if (num2 >=0) break;
            System.out.print("Please enter a positive integer: ");
         } 
        
      if (num1 > num2) {// previously mentioned method of insuring x is always the greater value
         x = num1;
         y = num2;
      }
      else {
         x = num2;
         y = num1;
      } 

      while (x != 0 && y != 0) { // actual application of Euclid's Algorithm
         z =  x % y;
         x = y;
         y = z;
      	 if (z==0) break;
      }
      while (x == 0 ^ y == 0) { // possibility of x OR y == 0, returning the non zero value between the 2
         if(x == 0) 
         y = y; 
         else 
         y = x;
      }
      if ( x == 0 && y == 0)  // possibility of two 0's entered, returns 0
         y = 0;

      System.out.println("The GCD of "+num1+" and "+num2+" is "+y+".");
   }
}
