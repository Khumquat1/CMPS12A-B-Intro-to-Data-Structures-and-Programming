import java.util.Scanner;
class Euclid {
   public static void main (String[] args) {
      
      Scanner sc = new Scanner(System.in);
      int num1=-1, num2=-1, x=1, y=1, z;
     
          
         System.out.print("Enter a positive integer: ");
         while(true) {
                      
            while( !sc.hasNextInt()) {
               sc.next();
               System.out.print("Please enter a positive integer: ");
            }
               if (sc.hasNextInt())
                  num1 = sc.nextInt();
               if (num1 >=0) break;
            System.out.print("Please enter a positive integer: ");
           
         }
            
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
        
      if (num1 > num2) {
         x = num1;
         y = num2;
      }
      else {
         y = num1;
         x = num2;
      }

      while (x != 0 && y != 0) {
         z =  x % y;
         x = y;
         y = z;
      	 if (z==0) break;
      }

      while (x == 0 ^ y == 0) { 
         if(x == 0) 
         y = y; 
         else 
         y = x;
      }
      if ( x == 0 && y == 0)
         y = 0;

      System.out.println("The GCD of "+num1+" and "+num2+" is "+y+".");
   }
}
