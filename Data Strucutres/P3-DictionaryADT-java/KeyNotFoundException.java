// --------------------------------------
// DuplicateKeyException.java
// Kevin Duong
// keduong
// 12B - PA3
// April 20th, 2016
// Throws exception for interaction with nonexistent key
// --------------------------------------

public class KeyNotFoundException extends RuntimeException{
   public KeyNotFoundException( String s){
      super(s);
   }
}