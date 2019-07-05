

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TermProject {
	
   private Customer customer;	
   private ProductArray productList = new ProductArray(200);
   private SimpleProduct product;	
   private Queue stockedQueue = new Queue(200);
   private Stack unstockedStack = new Stack(200);	
   private double subtotal;
   private double preShipTotal;
   private double shipTotal;
   private double shippingPercent;
   private boolean safeToAdd;
	
	/**
	  Customer constructor 
	  gets file information and dishpach correctly
	  
	 */
   public TermProject() {
   	//Get file from user
      String fileName = getUserFile();
   	
   	//place file contents in correct data structures
      dispatchFile(fileName);	
   	
   	//print reports
      reportOne();
      reportTwo();
   }

	/**
	return String file name that contains order database.
	 */
   private String getUserFile(){	
      System.out.println("Please enter the file name? ");
      Scanner inFile = new Scanner(System.in);		
      String fileName = inFile.nextLine();
      return fileName;
   }
	
	/*
	
	  appropriately allocates contents of file to customer info, stocked queue, and unstocked stack
	 */
   private void dispatchFile(String fileName){
      Scanner input = null;
      int i = 0;
      try {
         input = new Scanner(new File(fileName));
         if((i == 0) && (! input.hasNext())){
            System.out.println("Error: Empty text file");
            System.exit(0);
         }
         while (input.hasNextLine()) {
         	
         	//if scanner has read past customer info
            if (i >= 7)
            {
               product = new SimpleProduct(input);
               this.safeToAdd = true;
               for (int j = 0; j < productList.size(); j++){
               	/*if (product.equals(productList[j].getName(), productList[j].getType()))
                  {
               		this.safeToAdd = false;
               	}*/
               }
            	
               if (this.safeToAdd == true){
                  productList.insert(product);
               
               	// in stock?
                  if (product.getInStock() == true) {
                  	// add to FIFO queue
                     stockedQueue.insert(product);
                  } 
                  else { 
                  	// add to stack
                     unstockedStack.push(product);
                  }
               
                  i = i + 5;
               }
            //if customer info
            } 
            else {
               customer = new Customer(input);
               i = i + 7;
            }
         
         }
      } 
      catch (FileNotFoundException e) {
      	// TODO Auto-generated catch block
         System.out.println("Error: file not found. Exiting System. ");
         System.exit(0);
      }
   }

	/**
	 * prints report with in-stock items to be shipped
	 */
   private void reportOne(){
      System.out.println("");
      System.out.println("-------------------------------------------------");
      System.out.println("");
      System.out.println("Shipping to:");
   	//print address
      generateAddress();		
      System.out.println("-------------------------------------------------");
      System.out.println("");
   	//print queue info		
      printQueueInfo();	
      System.out.println("");
      System.out.println("-------------------------------------------------");
      System.out.println("");
      System.out.format("Subtotal:				  $%.2f%n", this.subtotal);     
      System.out.format("Sales tax (%.2f): 	  $%.2f%n", customer.getTax(),
         	(customer.getTax() * this.subtotal));	
   	//get shipping 
      calculateShippingTotal();	
      System.out.format("Shipping: 				  $%.2f%n", this.shipTotal);
      System.out.println("");
      System.out.println("-------------------------------------------------");
      System.out.println(""); 
      System.out.format("Total: 					 $%.2f%n", (this.shipTotal + this.preShipTotal));
      System.out.println("");
      System.out.println("-------------------------------------------------");
   }
	
	/**
	 * Print queue product information and 
	 * @return subtotal
	 */
   public double printQueueInfo(){
      this.subtotal = 0;	
      String openBrace ="(";
      String closeBrace = ")";
      SimpleProduct current;
      for (int i = 0; i < stockedQueue.size(); i++) {
      		//pop from queue, assign local variable, and get info
         current = stockedQueue.remove();	
         double sub = current.getQuantity() * current.getPrice(); 
      	
         System.out.format("%d x %s %10s%s%s %10.2f\n",current.getQuantity()
            ,current.getName(),openBrace,current.getType(),closeBrace,current.getPrice());
         this.subtotal = sub + this.subtotal;
      }
      return this.subtotal;
   }
	
	/*
	  total cost with shipping
	 */
   public void calculateShippingTotal(){
      this.preShipTotal = (this.subtotal * customer.getTax()) + this.subtotal;
   	
      if (this.preShipTotal > 25) {
         this.shippingPercent = 0;
      } 
      else if (this.preShipTotal > 10) {
         this.shippingPercent = .05;
      } 
      else {
         this.shippingPercent = .15;
      }	
      this.shipTotal = this.shippingPercent * this.preShipTotal;
   }
	
	
	/**
	 * prints report with items that are on hold, along with outstanding balance
	 */
   private void reportTwo(){
      System.out.println("");
      System.out.println("Orders Outstanding For:");
   	//print address
      generateAddress();
      System.out.println("-------------------------------------------------");
      System.out.println("");
   	//print stack info
      printStackInfo();	
      System.out.println("");
      System.out.println("-------------------------------------------------");
      System.out.println("");	
      System.out.format("Outstanding balance: 			$%.2f%n", this.subtotal);
      System.out.println("");
      System.out.println("-------------------------------------------------");
      System.out.println("");
   }
	
	/**
	 * prints on-hold items with product info
	 */
   public void printStackInfo(){
      String openBrace ="(";
      String closeBrace = ")";
      this.subtotal = 0;
      int unstockedStackSize = unstockedStack.size();
      SimpleProduct unstocked;
      double sub; 
      for (int i = 0; i < unstockedStackSize; i++) {
         unstocked = unstockedStack.pop();
         sub = unstocked.getQuantity() * unstocked.getPrice(); 
      
         System.out.format("%d x %s %10s%s%s %10.2f\n",unstocked.getQuantity()
            ,unstocked.getName(),openBrace,unstocked.getType(),closeBrace,unstocked.getPrice());
         this.subtotal = sub + this.subtotal;
      }
   }
	
	/**
	 * prints out customer address
	 */
   public void generateAddress(){
      System.out.println("");
      System.out.println(customer.getFirst() + " " + customer.getLast());
      System.out.println(customer.getStreet());
      System.out.println(customer.getCity() + ", " + customer.getState()
         	+ " " + customer.getZip());
      System.out.println("");
   }
	
   public static void main(String[] args) {
   
      TermProject lab = new TermProject();
   
   }

}





