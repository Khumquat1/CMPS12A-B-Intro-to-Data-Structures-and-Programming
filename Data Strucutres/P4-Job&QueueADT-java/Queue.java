// Queue.java
// Kevin Duong
// keduong
// 12B PA4
// April 28th, 2016
// Queue ADT for PA4

public class Queue implements QueueInterface{
   
   // Constructs the queue
   private class Node{
      Object item;
      Node next;
   
      Node(Object item){
         this.item = item;
         next = null;
      }
   } 
 
   // private fields  
   private Node head;
   private Node tail;
   private int numItems;
   
   // constructor
   Queue(){
      head = null;
      tail = null;
      numItems = 0;
   } 
  
   // isEmpty()
   // pre: none
   // post: returns the length of the Queue
   public boolean isEmpty(){
      return (numItems == 0);
   }
   
   // length()
   // pre: none
   // post: return the length of the queue
   public int length(){
      return numItems;
   }
 
   // enqueue()
   // adds newItem to back of the queue
   // pre: none
   // post: !isEmpty()
   public void enqueue(Object newItem){
      if(head == null){
         head = new Node(newItem);
         numItems++;
      }else{
         Node N = head;
         while(N.next != null){
            N = N.next;
         }
         N.next = new Node(newItem);
         tail = N.next;
         numItems++;
      }
   }
  
   // dequeue
   // deletes and return item from front of this Queue
   // pre: !isEmpty()
   // post: this Queue will have one few element
   public Object dequeue() throws QueueEmptyException{
      if(head == null){
         throw new QueueEmptyException("Usage: using dequeue() on empty queue stack");
      }else{
         Node N = head;
         head = N.next;
         numItems--;
         return N.item;
      }
   }

   // peek()
   // pre: !isEmpty()
   // post: isEmpty();
   public Object peek(){
      if(head == null){
         throw new QueueEmptyException("Usage: using peek() on empty queue stack");
      }else{
         return head.item;
      }
   }
 
   // dequeueAll
   // sets this queue to the empty state
   // pre: !isEmpty()
   // post: isEmpty()
   public void dequeueAll() throws QueueEmptyException{
      if(head == null){
         throw new QueueEmptyException("Usage: using peek() on empty queue stack");
      }else{ 
         head = null;
         tail = null;
         numItems = 0;
      }
   }

   // toString
   // overrides Object's toString() method
   public String toString(){
      String s ="";
      Node N = head;
      while(N != null){
         s += N.item + " ";
         N = N.next;
      }return s;
   }
}
     
