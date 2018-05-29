// Lawn.java
// Kevin Duong
// keduong
// pa1
// Computes time needed to mow a law
// First trial, runs but lengthy
import java.util.*;

class lawn{

   public static void main( String[] args ){

      double height, width, areahou, arealot, arealawn, rate, h, m, s;
      
      
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter the width and height of the lot, in feet: ");
      width = scan.nextDouble();
      height = scan.nextDouble();
      assert (width > 0 & height > 0); //Cannot have negative input quantities
      arealot = width*height;
           
      System.out.print("Enter the width and height of the house, in feet: ");
      width = scan.nextDouble();
      height = scan.nextDouble();
      assert (width > 0 & height > 0);
      areahou = height * width;
       
      arealawn = arealot - areahou;
      System.out.printf("The lawn area is %.1f square feet.\n" , arealawn) ;
         
      System.out.print("Enter the mowing rate, in square feet per second: ");
      rate = scan.nextDouble();
      s = (int) Math.round(rate);
      s = (1 / rate);
      s = (arealawn * s);
      m = Math.round(s/60);
      s = Math.round(s%60); 
      h = Math.floor(m/60); //Must pick minimum of the hour (round down)
      m = Math.round(m%60);
     
      {if (h == 1)  // dealing with Plural
      System.out.printf("The mowing time is " +h+ " hour, ");
      else  
      System.out.printf("The mowing time is " +h+ " hours, ");
      }
     
      {if (m == 1)  
      System.out.printf(m+ " minute, ");
      else
      System.out.printf(m+ " minutes, ");
      }
     
      {if (s==1) 
      System.out.printf(s+ " second. \n");
      else 
      System.out.printf(s+ " seconds. \n");      
      }
      }
}
