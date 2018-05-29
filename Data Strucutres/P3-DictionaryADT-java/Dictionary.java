// ---------------------------------------------
// Dictionary.java
// Kevin Duong
// 12B - PA3
// April 20th, 2016
// Contains method definition for dictionary ADT
// ---------------------------------------------

public class Dictionary implements DictionaryInterface{
  
   // private inner Node class
   private class Node{
      String key;
      String value;
      Node next;
      //node class constructor
      Node(String key, String value){
         this.key = key;
         this.value = value;
         next = null;
      }
   }

   // Fields for the Dictionary class
   private Node head; // reference to first Node in List
   private int numItems; //number of items in Dictionary

   // private helper fuction ------------------------------
   
   // findKey
   // returns a reference to key at position index
   private Node findKey(String key){
      Node N = head;
      while(N != null){
         if(N.key.equals(key)){
            return N;
         }else{
            N = N.next;
         }  
      }
      return null;
   }
   
   // toString
   // does real work of toString()
   private String myString(Node N){
      if(N == null){
         return "";
      }else{
         return (N.key + " " + N.value +"\n"+ myString(N.next));
      }
   }
      
   // ADT operations---------------------------------------

   // isEmpty()
   // pre: none
   // post: returns true if Dictionary is empty, else false
   public boolean isEmpty(){  
      return (numItems==0);
   }

   // size()
   // pre: none
   // post: returns the number of (key,value) pairs in Dictionary
   public int size(){
      return numItems;
   }
   
   // lookup()
   // pre: takes string "key"
   // post: returns value of key, otherwise null
   public String lookup(String key){
      Node N = head;
      while(N != null){
         if(N.key.equals(key)){
            return N.value;
         }
         N = N.next;
      }
      return null;
   }
  
   // insert()
   // pre: takes key and value string not in list
   // post: adds key/value string into list or throws exception
   public void insert(String key, String value) throws DuplicateKeyException{
      if(lookup(key) != null){
         throw new DuplicateKeyException("cannot insert duplicate keys");
      }else{
         if(head == null){
            Node N = new Node(key,value);
            head = N;
            numItems++;
         }else{
            Node N = head;
            while (N != null){
               if(N.next == null){
                  break;
               }
               N = N.next;
            }
            N.next = new Node(key,value);
            numItems++;
         }
      }
   }
         
   // delete()
   // pre: takes key value in Dictionary
   // post: removes the key/value from list
   public void delete(String key){
      if( lookup(key) == null){
         throw new DuplicateKeyException("cannot delete non-existent key");
      }else{
         if(numItems <= 1){
            Node N = head;
            head = head.next;
            N.next = null;
            numItems--;
         }else{
            Node N = head;
            if(N.key.equals(key)){
               head = N.next;
               numItems--;
            }else{
               while(!N.next.key.equals(key)){
                  N = N.next;
               }
               N.next = N.next.next;
               numItems--;
            }
         }
       }
   }
 
   // makeEmpty()
   // pre: none
   // post: isEmpty()
   public void makeEmpty(){
      head = null;
      numItems = 0;
   }
   
   // toString()
   // pre: none
   // post: prints current state to stdout using myString() recur.
   public String toString(){
      return myString(head);
   }
}
