// ListTest.java
// Kevin Duong
// keduong
// May 20th, 2016
// 12M - Lab6
// Test class for list

class ListTest{
 
  public static void main(String[] args){      
      List<Integer> I = new List<Integer>();
      List<String> S = new List<String>();
 
      //add
      I.add(1,6);
      I.add(2,5);
      I.add(3,4);
      I.add(4,3);
      I.add(5,2);
      I.add(6,1);
    
      S.add(1,"this");
      S.add(2,"is");
      S.add(3,"a");
      S.add(4,"test");
      S.add(5,"please");
      S.add(6,"work");
      S.add(7,"working");

      //remove
      I.remove(1);
      I.remove(2);
      S.remove(3);
      S.remove(4);
      S.remove(2);
//      S.remove(5);

      //print
      System.out.println(I.size());
      System.out.println(S.size());
      System.out.println(I.equals(S));
      System.out.println("I contents: "+I);
      System.out.println("S contents: "+S);
   }
}
