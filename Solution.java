// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
   public int solution(int[] A) {
        // write your code in Java SE 8
      int node[] = new int[A.length];
      int lengthN=1; // node start with atleast 1 element
      node[0] = A[0]; // the head of the node
      int temp = node[0];  // temporary value of node
      for(int i =1; i < A.length; i++)
      {
         node[i] = A[temp];
         temp = node[i];
         lengthN++;
         if( node[i] == -1)
            break;
      }
      return lengthN;
   }
   public static void main(String[] args)
   {
      Solution test= new Solution();
      int[] A={1,4,5,4,2,-1,6,7};
     
      System.out.print(test.solution(A));
   }
}