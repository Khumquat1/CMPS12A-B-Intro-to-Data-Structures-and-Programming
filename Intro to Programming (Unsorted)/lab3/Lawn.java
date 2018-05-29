// Lawn.java
// Kevin Duong
// keduong
// pa1
// Computes time needed to mow a lawn

import java.util.*;

class Lawn{

    public static void main( String[] args ){

    double height, width, areahou, arealot, arealawn, rate, h, m, s;
    
    Scanner scan = new Scanner(System.in);
   
//    System.out.print("Enter the width and height of the lot, in feet: ");
    width = scan.nextDouble();
    height = scan.nextDouble();
    assert (width > 0 & height > 0); //Cannot have negative input quantities.
    arealot = width*height;
           
//    System.out.print("Enter the width and height of the house, in feet: ");
    width = scan.nextDouble();
    height = scan.nextDouble();
    assert (width > 0 & height > 0);
    areahou = height * width;
       
    arealawn = arealot - areahou;
    System.out.printf("The lawn area is %.1f square feet.\n" , arealawn) ;
         
//    System.out.print("Enter the mowing rate, in square feet per second: ");
    rate = scan.nextDouble();
    s = (int) Math.round(rate); //Applying the rate of mowing onto the lawn area.
    s = (1 / rate);
    s = (arealawn * s);
    m = Math.round(s/60);
    s = Math.round(s%60); 
    h = Math.floor(m/60); //Must pick minimum of the hour (round down).
    m = Math.round(m%60);
    System.out.printf("The mowing time is "+h+" hour"+(h==1?", ":"s, ")); //accounting for possible plurality.
    System.out.printf(m+ " minute"+(m==1?", ":"s, "));
    System.out.printf(s+ " second"+(s==1?".\n":"s.\n"));
    }
  
}


