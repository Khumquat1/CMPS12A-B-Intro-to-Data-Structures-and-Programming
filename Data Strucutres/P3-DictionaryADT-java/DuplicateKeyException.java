// --------------------------------------
// DuplicateKeyException.java
// Kevin Duong
// keduong
// 12B - PA3
// April 20th, 2016
// Throws exception for attempting to add duplicate key
// --------------------------------------

public class DuplicateKeyException extends RuntimeException{
   public DuplicateKeyException( String s){
      super(s);
   }
}