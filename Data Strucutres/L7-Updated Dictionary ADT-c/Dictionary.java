//-----------------------------------------------------------------------------
// Dictionary.java
// Kevin Duong
// keduong
// 12M- Lab7
// May 30th
// Binary Search Tree implementation of the Dictionary ADT in java
//-----------------------------------------------------------------------------

public class Dictionary implements DictionaryInterface{

// private types and functions ------------------------------------------------

// ADT construc.
private class Node{
   String key;
   String value;
   Node left;
   Node right;
   
   // Node
   Node(String key, String value){
      this.key = key;
      this.value = value;
      left = null;
      right = null;
   }
}
// root and numpairs
// constructor for the Dictionary type
   private Node root;
   private int numPairs;
   Dictionary(){
      root=null;
      numPairs =0;
}

// findKey()
// returns the Node containing key k in the subtree rooted at R, or returns
// NULL if no such Node exists
private Node findKey(Node R, String k){
   if(R==null || R.key.equals(k)) 
      return R;
   if( R.key.compareToIgnoreCase(k)>0) 
      return findKey(R.left, k);
   else 
      return findKey(R.right, k);
}


// findParent()
// returns the parent of N in the subtree rooted at R, or returns NULL 
// if N is equal to R. (pre: R != NULL)
Node findParent(Node N, Node R){
   Node P=null;
   if( N!=R ){
      P = R;
      while( P.left!=N && P.right!=N ){
         if(N.key.compareToIgnoreCase(P.key)<0)
            P = P.left;
         else
            P = P.right;
      }
   }
   return P;
}

// findLeftmost()
// returns the leftmost Node in the subtree rooted at R, or NULL if R is NULL.
Node findLeftmost(Node R){
   Node L = R;
   if( L!=null ) for( ; L.left!=null; L=L.left) ;
   return L;
}

// printInOrder()
// prints the (key, value) pairs belonging to the subtree rooted at R in order
// of increasing keys to file pointed to by out.
void printInOrder(Node N){
   if( N!=null ){
      printInOrder(N.left);
      System.out.println(N.key+" "+N.value);
      printInOrder(N.right);
   }
}

// deleteAll()
// deletes all Nodes in subtree
void deleteAll(Node N){
   if(N!=null){
      deleteAll(N.left);
      deleteAll(N.right);
   }
}

// public functions -----------------------------------------------------------

// isEmpty()
// returns 1 (true) if D is empty, 0 (false) otherwise
// pre: none
public boolean isEmpty(){
   return(numPairs==0);
}

// size()
// returns the number of (key, value) pairs in D
// pre: none
public int size(){
   return(numPairs);
}

// lookup()
// returns the value v such that (k, v) is in D, or returns NULL if no 
// such value v exists.
// pre: none
public String lookup(String k){
   Node N = findKey(root,k);
   return (N == null? null: N.value);
}

// insert()
// inserts new (key,value) pair into D
// pre: lookup(D, k)==NULL
public void insert(String k, String v) throws DuplicateKeyException{
   Node N, A, B;
   if( findKey(root, k)!=null ){
      throw new DuplicateKeyException("Cannot insert() duplicate key!");
   }
   N = new Node(k, v);
   B = null;
   A = root;
   while( A!=null ){
      B = A;
      if( A.key.compareToIgnoreCase(A.key)>0) A = A.left;
      else A = A.right;
   }
   if( B==null ) root = N;
   else if( B.key.compareToIgnoreCase(k)>0) B.left = N;
   else B.right = N;
   numPairs++;
}

// delete()
// deletes pair with the key k
// pre: lookup(D, k)!=NULL
public void delete(String k) throws KeyNotFoundException{
   Node N, P, S;
   N= findKey(root,k);
   if (N == null){
      throw new KeyNotFoundException("Cannot delete non-existant key!");
   }
   if( N.left==null && N.right==null ){  // case 1
      if( N==root ){
         root = null;      
      }else{
         P = findParent(N, root);
         if( P.right==N ) P.right = null;
         else P.left = null;
      }
   }else if( N.right==null ){  // case 2 (left but no right child)
      if( N==root ){
         root = N.left;
      }else{
         P = findParent(N, root);
         if( P.right==N ) P.right = N.left;
         else P.left = N.left;
      }
   }else if( N.left==null ){  // case 2 (right but no left child)
      if( N==root ){
         root = N.right;
      }else{
         P = findParent(N, root);
         if( P.right==N ) P.right = N.right;
         else P.left = N.right;
      }
   }else{                     // case3: N->left!=NULL && N->right!=NULL
      S = findLeftmost(N.right);
      N.key = S.key;
      N.value = S.value;
      P = findParent(S, N);
      if( P.right==S ) P.right = S.right;
      else P.left = S.right;
   }
   numPairs--;
}

// makeEmpty()
// re-sets D to the empty state.
// pre: none
public void makeEmpty(){
   deleteAll(root);
   root = null;
   numPairs = 0;
}

// toString
// current state of dictionary
public String toString(){
   printInOrder(root);
   return "";
}


}
