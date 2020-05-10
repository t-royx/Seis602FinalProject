import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Transaction {
	protected LocalDate Date_of_Opening;
	protected LocalTime Time_of_Opening;
	protected boolean saleTransaction;
	protected ArrayList<Item> items = new ArrayList<Item>();
	
	/*
	 * Name: Transaction
	 * Description: Default transaction constructor
	 * Parameters: None
	 * Returns: None
	 */
	public Transaction() {
		this.Date_of_Opening = LocalDate.now();
		this.Time_of_Opening = LocalTime.now();
	}
	
	/*
	 * Function Name: addItem
	 * Description: Adds an item to the transaction array list
	 * Parameters: item
	 * Returns: None
	 */
	public void addItem(Item item) {
		//Add the item to the items array list
		items.add(item);
	}
	
	/*
	 * Function Name: removeItem
	 * Description: Removes an item from the transaction array list
	 * Parameters: item
	 * Returns: None
	 */
	public boolean removeItem(Item item) {
		boolean retVal = false;
		//Validate the item exist in the transaction
		if(this.items.contains(item)) {
			this.items.remove(item);
			retVal = true;
		}
		return retVal;
	}
	
	/*
	 * Function Name: getSize
	 * Description: Returns transaction element size
	 * Parameters: None
	 * Returns: this.items.size()
	 */
	public int getSize() {
		return this.items.size();
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
		//Print if transaction type is sale or return
		if(saleTransaction) {
			//Transaction is a sale
			System.out.println("Transaction Type: Sale");
		}else {
			//Transaction is a return
			System.out.println("Transaction Type: Return");
		}
		//Iterate through each item in the current transaction
		for(int i = 0; this.getSize() > i; i++) {
			itemName = this.items.get(i).getName();
			itemPrice = this.items.get(i).getPrice();
			totalPrice = totalPrice.add(itemPrice);
			System.out.println(itemName + "...$" + itemPrice);
		}
		System.out.println("Total Items: " + this.getSize());
		if(saleTransaction) {
			System.out.println("Total Sale: $" + totalPrice);
		}else {
			System.out.println("Total Refund: $" + totalPrice);
		}
	}
}
