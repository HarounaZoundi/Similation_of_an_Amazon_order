// stack.java
// demonstrates stacks
// to run this program: C>java StackApp
////////////////////////////////////////////////////////////////
public class Stack
   {
   private int maxSize;        // size of stack array
   private SimpleProduct[] stackArray;
   private int top;            // top of stack
   private int nItems;
//--------------------------------------------------------------
   public Stack(int s)         // constructor
      {
      maxSize = s;             // set array size
      stackArray = new SimpleProduct[maxSize];  // create array
      top = -1;                // no items yet
      nItems =0;
      }
//--------------------------------------------------------------
   public void push(SimpleProduct j)    // put item on top of stack
      {
      stackArray[++top] = j;     // increment top, insert item
      nItems++;
      }
//--------------------------------------------------------------
   public SimpleProduct pop()           // take item from top of stack
      {
       nItems--;
      return stackArray[top--];  // access item, decrement top
     
      }
//--------------------------------------------------------------
   public SimpleProduct peek()          // peek at top of stack
      {
      return stackArray[top];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if stack is empty
      {
      return (top == -1);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if stack is full
      {
      return (top == maxSize-1);
      }
//--------------------------------------------------------------
   public int size()           // number of items in Stack
      {
      return nItems;
      }
   }  // end class StackX
////////////////////////////////////////////////////////////////

