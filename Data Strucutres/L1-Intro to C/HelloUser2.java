//-----------------------------------------
// HelloUser2.java
// Kevin Duong
// keduong
// 12M
// March 28th, 2016
// Prints a greeting and date/time to stdout
//------------------------------------------
class HelloUser2{
   public static void main(String[] args){
      String user = System.getProperty("user.name");
      long time = System.currentTimeMillis();
      
      System.out.println("Hello "+user+"!");
      System.out.printf("You executed this program on: %tc.%n", time);
      System.out.println("Thanks for stopping by, have a great day!");
   }
}
