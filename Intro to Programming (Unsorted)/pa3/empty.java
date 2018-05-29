import java.util.Scanner;
class empty {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int x=-1; 
      
     
      
         
         System.out.print("Enter a positive integer: ");   
         while(true){
         while(!sc.hasNextInt()){
         sc.next();
         System.out.print("Please enter a positive integer: ");
         }
         if (sc.hasNextInt())
         x = sc.nextInt();
       
         if (x >=0) break;
         System.out.print("Please enter a positive integer: ");
         }

















//         while(true){
  //          while(!sc.hasNextInt()){
    //           sc.next();
      //         System.out.print("Please enter a positive integer: ");
//            }
  //          if(sc.nextInt() >=0) break;
            
    //        System.out.print("Please enter a positive integer: ");
      //    }
            
         
         


System.out.println("Your value is: "+x+".");
   }
}
