// --------------------------------------
// DictionaryTest.java
// Kevin Duong
// keduong
// 12B - PA3
// April 20th, 2016
// Test for Dictionary.java
// --------------------------------------

class DictionaryTest{
   public static void main (String[] args){
      Dictionary A = new Dictionary();
    
      System.out.println(A.isEmpty());
      A.insert("a","1");
      System.out.println(A.isEmpty());
      A.insert("b","2");
      System.out.println(A.size());
    
      A.insert("c","2");
      A.insert("d","3");
      A.insert("e","4");
      A.insert("f","5");
      A.delete("g");
      A.insert("d","6"); //throws exception 
      A.toString();
   
      System.out.println(A);
      System.out.println(A.lookup("a"));
 
      A.delete("d");
      System.out.println(A.size());
      System.out.println(A.lookup("d"));

      System.out.println(A.lookup("h"));
      System.out.println(A.size());
      System.out.println(A);
      A.makeEmpty();
      System.out.println(A.size() + " " + A.isEmpty());
    
  }
}