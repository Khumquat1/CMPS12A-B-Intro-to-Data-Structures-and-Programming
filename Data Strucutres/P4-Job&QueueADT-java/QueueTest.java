// QueueTest.java
// Kevin Duong
// keduong
// 12B - PA4
// May 9th, 2016
// testing Queue ADT methods

public class QueueTest{
   public static void main(String[] args){
      Queue test = new Queue();

      System.out.println(test.isEmpty());
  
      //insert
      test.enqueue((int)1);
      test.enqueue((int)2);
      test.enqueue((int)3);
      test.enqueue((int)4);
      test.enqueue((int)5);
      test.enqueue((int)6);
      test.enqueue((int)7);
   
      //length
      System.out.println(test.isEmpty());
      System.out.println(test.length());
      System.out.println(test);

      //deleting
      test.dequeue();
      test.dequeue();
  
      System.out.println(test.length());
      System.out.println(test);

   } 
}
