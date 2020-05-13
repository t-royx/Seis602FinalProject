import java.math.BigDecimal;

public class Sale extends Transaction {
	/*
	 * Name: Sale
	 * Description: Default sale constructor
	 * Parameters: None
	 * Returns: None
	 */
	public Sale()  {
		//Transaction is a sale
		super.saleTransaction = true;
	}
	
	/*
	 * Function Name: print
	 * Description: Prints the transaction to the console
	 * Parameters: None
	 * Returns: None
	 */
	public void print() {
		//To simplify print function
		String itemName;
		BigDecimal itemPrice;
		BigDecimal totalPrice = new BigDecimal(0);
		
		//Print transaction date and time
		System.out.println("Transaction Date:" + Date_of_Opening);
		System.out.println("Transaction Time:" + Time_of_Opening);
		System.out.println("Transaction Type: Sale");
		//Iterate through each item in the current transaction
		for(int i = 0; this.getSize() > i; i++) {
			itemName = this.items.get(i).getName();
			itemPrice = this.items.get(i).getPrice();
			totalPrice = totalPrice.add(itemPrice);
			System.out.println(itemName + "...$" + itemPrice);
		}
		System.out.println("Total Items: " + this.getSize());
		System.out.println("Total Sale: $" + totalPrice);
	}
}
