// ProductArray.java

class ProductArray
{
   private SimpleProduct[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public ProductArray(int max)         // constructor
   {
      a = new SimpleProduct[max];                 // create the array
      nElems = 0;                        // no items yet
   }
   //-----------------------------------------------------------
  
   //-----------------------------------------------------------
   public void insert(SimpleProduct product)    // put element into array
   {
      a[nElems] = product;             // insert it
      nElems++;                      // increment size
   }
 
   //-----------------------------------------------------------
   public int size()           // number of items in Array
   {
      return nElems;
   }
}  // end class 

  
