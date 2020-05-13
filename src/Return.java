import java.math.BigDecimal;

public class Return extends Transaction {
	/*
	 * Name: Return
	 * Description: Default return constructor
	 * Parameters: None
	 * Returns: None
	 */
	public Return() {
		//Transaction is a return
		super.saleTransaction = false;
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
		System.out.println("Transaction Type: Return");
		//Iterate through each item in the current transaction
		for(int i = 0; this.getSize() > i; i++) {
			itemName = this.items.get(i).getName();
			itemPrice = this.items.get(i).getPrice();
			totalPrice = totalPrice.add(itemPrice);
			System.out.println(itemName + "...$" + itemPrice);
		}
		System.out.println("Total Items: " + this.getSize());
		System.out.println("Total Refund: $" + totalPrice);
	}
}
