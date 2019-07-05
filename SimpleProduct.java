
import java.util.Scanner;

public class SimpleProduct implements Product {

   private String name;
   private String type;
   private double price;
   private int quantity;
   private boolean inStock;
   
  // constructor
	public SimpleProduct(Scanner inputFile) {
		readNextProduct(inputFile);
	}
   
	public void setName(String name)
   {
      this.name = name;
   }

	
	  //return the name of the product
	 
	public String getName()
   {
      return name;
   }


	  // the type of the product
	
	public void setType(String type)
   {
      this.type = type;
   }

	
	 //return - the product type
	
	public String getType()
   {
      return type;
   }

	 // - the price of the product
	
	public void setPrice(double price)
   {
      this.price = price;
   }

	//return the price of the product
	
	public double getPrice()
   {
      return price;
   }

	
	 //the number of this product in inventory
	
	public void setQuantity(int quantity)
   {
      this.quantity = quantity;
   }


	//return the number of this product in inventory
	
	public int getQuantity()
   {
      return quantity;
   }
	

	// true if this product is in stock
	public void setInStock(boolean inStock)
   {
      this.inStock = inStock;
   }

	//return true if this product is in stock
	
	public boolean getInStock()
   {
      return inStock;
   }
	
     /*-  Scanner containing product entries
	    return false if the product cannot be completely read,
	  			true otherwise
	 */
public boolean readNextProduct(Scanner input) {
		int i = 0;
		while (input.hasNextLine())
      {
			if (i > 4) 
         {
				return false;
			}
			
				String line = input.nextLine().trim();
			if (line.length() <=0){
				System.out.println("Error: empty product ");
				System.exit(0);
			}
			if (i == 0) {
				setName(line);
			} else if (i == 1) {
				setType(line);
			} else if (i == 2) {
				// convert string to double
				try{
					double price = Double.parseDouble(line);
					setPrice(price);
				} catch (Exception e) {
					System.out.println("Error: invalid text entry. ");
					System.exit(0);
				}
				
			} else if (i == 3) {
				// convert string to int
				try{
					int quantity = Integer.parseInt(line);
					setQuantity(quantity);
				} catch (Exception e) {
					System.out.println("Error: invalid text entry..");
					System.exit(0);
				}
			} else if (i == 4) {
				// convert string to boolean
				if (line.equalsIgnoreCase("true")
						|| line.equalsIgnoreCase("false")) {
					setInStock(Boolean.valueOf(line));
				} else {
					System.out.println("Error: invalid text file entry.");
					System.exit(0);
				}
			}

			i++;
		}
		return true;
	}


  public boolean equals(String name, String type) {
		return (this.name.equals(name) && this.type.equals(type));
	}

	
	public String toString() {
		return ("(" + getName() + ", " + getType() + ", " + getPrice() + ", " + getQuantity()+ ")");
	}
}
   
