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
	 * Function Name: totalAmount
	 * Description: Returns total amount for sale/return transaction
	 * Parameters: None
	 * Returns: totalAmount
	 */
	public BigDecimal getTotalAmount() {
		BigDecimal totalAmount = new BigDecimal(0);
		for(int i = 0; i < this.getSize(); i++) {
			totalAmount = totalAmount.add(this.items.get(i).getPrice());
		}
		return totalAmount;
	}
	
	/*
	 * Function Name: print
	 * Description: Prints the transaction to the console
	 * Parameters: None
	 * Returns: None
	 */
	public void print() {
		
	}
}
