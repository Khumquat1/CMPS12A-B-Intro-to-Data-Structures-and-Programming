// List.java
// Kevin Duong
// keduong
// May 20th, 2016
// 12M - Lab6
// Uses arrayDoubling and implements generics

class List<T> implements ListInterface<T>{
   
   // private fields-----------------------
   private static final int INITIAL_SIZE=1;
   private int sizeArray;
   private T[] item;
   private int numItems;
   
   // arrayIndex()
   // returns List index into Array index
   private int arrayIndex(int listIndex){
      return listIndex-1;
   }
   
   // doubleArray()
   // doubles array size
   @SuppressWarnings("unchecked")
    private void doubleArray(){
      sizeArray *= 2;
      T[] newArray = (T[])new Object[sizeArray];
      for(int i=0;i<numItems;i++){
         newArray[i]=item[i];
      }
      item = newArray;
   }

   // constructor--------------------------------
   @SuppressWarnings("unchecked")
   public List(){
      sizeArray = INITIAL_SIZE;
      item = (T[])new Object[sizeArray];
      numItems =0;
   }

   // ADT operations-----------------------------

   // isEmpty()
   // returns true if list is empty
   public boolean isEmpty(){
      return (numItems == 0);
   }

   // size()
   // returns size of list
   public int size(){
      return numItems;
   }
   
   // get()
   // returns value at position
   public T get(int index) throws ListIndexOutOfBoundsException{
      if( index>(numItems+1) || index<1){
         throw new ListIndexOutOfBoundsException("List Error: get() called on invalid index");
      }
      return item[arrayIndex(index)];
   }
  
   // add() 
   // adds element to list
   public void add(int index, T newItem) throws ListIndexOutOfBoundsException{
      if( index>(numItems+1) || index<1){
         throw new ListIndexOutOfBoundsException("List Error: add() called on invalid index");
      }
      if(numItems==sizeArray) doubleArray();
      for(int i = numItems;i>=index;i--) 
         item[arrayIndex(i+1)]=item[arrayIndex(i)];
      item[arrayIndex(index)]= newItem;
      numItems++;
   }

   // remove() 
   // removes element from list
   public void remove(int index) throws ListIndexOutOfBoundsException{
      if( index>(numItems+1) || index<1){
         throw new ListIndexOutOfBoundsException("List Error: remove() called on invalid index");
      }
      for(int i = numItems;i<=index;i++) 
         item[arrayIndex(i-1)]=item[arrayIndex(i)];
      numItems--;
   }

   // removeAll()
   // clears list
   public void removeAll(){
      numItems=0;
   }
   
   // other operations-------------------------------------------------

   // toString()
   // prints current state to stdout
   public String toString(){
      String s= "";
      for(int i =0;i<numItems;i++) s +=item[i]+" ";
      return s;
   }
   
   // equals()
   //  returns true if contents of list equals rhs element
   @SuppressWarnings("unchecked")
   public boolean equals(Object rhs){
      boolean eq = false;
      List<T> R= null;
  
      if(this.getClass() == rhs.getClass()){
         int i=0;
         R = (List<T>)rhs;
         eq = (this.numItems==R.numItems);
         while (eq && i<numItems){
            eq=(this.item[i]==R.item[i]);
            i++;
         }
      }
      return eq;
      }
}
