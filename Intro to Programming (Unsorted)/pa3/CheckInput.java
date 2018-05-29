import java.util.Scanner;

class CheckInput{

   public static void main( String[] args) {
       
      Scanner sc = new Scanner(System.in);
      int i;
      for(i=0; i<3; i++){ 
         System.out.print("Enter a positive double: ");
         while(true)  
          while( !sc.hasNextDouble() ){
sc.next();
System.out.print("Please enter a positive double: "); // ask again
            }
 if( sc.nextDouble()>0 ) break;
  System.out.print("Please enter a positive double: "); 
}
}
}
