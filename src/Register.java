import java.math.BigDecimal;
import java.util.ArrayList;

public class Register {
	private int ID;
	private Employee employee;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	private Transaction currentTransaction;
	private Boolean saleMode;
	
	/*
	 * Name: Register
	 * Description: Default register constructor, calls our customized constructor
	 * Parameters: None
	 * Returns: None
	 */
	public Register() {
		this(0);
	}
	
	/*
	 * Name: Register
	 * Description: Customized constructor that assigns a register ID to the register object
	 * Parameters: registerID
	 * Returns: None
	 */
	public Register(int registerID) {
		this.ID = registerID;
		this.employee = null;
		this.currentTransaction = null;
		//Default to sale mode unless employee wants to do returns
		this.saleMode = true;
	}
	
	/*
	 * Name: setSaleMode
	 * Description: Sets the register into 'Sale' mode if an employee is logged on and there isn't an open transaction
	 * Parameters: None
	 * Returns: true - sale mode set, false - employee not logged on or transaction in progress
	 */
	public boolean setSaleMode() {
		boolean retVal = false;
		//validate employee is logged in 
		if((this.employee != null) && (this.currentTransaction == null))
		{
			this.saleMode = true;
			retVal = true;
		}
		return retVal;
	}
	
	/*
	 * Name: setReturnMode
	 * Description: Sets the register into 'Return' mode if an employee is logged on and there isn't an open transaction
	 * Parameters: None
	 * Returns: true - return mode set, false - employee not logged on or transaction in progress
	 */
	public boolean setReturnMode() {
		boolean retVal = false;
		//validate employee is logged in 
		if((employee != null) && (this.currentTransaction == null))
		{
			this.saleMode = false;
			retVal = true;
		}
		return retVal;
	}
	
	/*
	 * Name: getMode
	 * Description: Return current register mode
	 * Parameters: None
	 * Returns: True - Sale Mode, False - Return Mode
	 */
	public boolean getMode() {
		return this.saleMode;
	}
	
	/*
	 * Name: scanItem
	 * Description: Return current register mode
	 * Parameters: scannedItem
	 * Returns: True - item added to transaction, False - failure to add item
	 */
	//At this point it is assumed the item scanned is valid
	public boolean scanItem(Item scannedItem) {
		boolean retVal = false;
		//validate employee is logged in 
		if(employee != null)
		{
			//Check if there is an existing transaction started
			if(this.currentTransaction == null)
			{
				//First item of a new transaction, create the new object
				//Check if the transaction is a sale or return
				if(this.saleMode) {
					currentTransaction = new Sale();
				}
				else{
					currentTransaction = new Return();
				}
			}
			
			//Add item to the current transaction
			currentTransaction.addItem(scannedItem);
			retVal = true;
		}
		return retVal;
	}
	
	/*
	 * Function Name: cancelTransaction
	 * Description: Clears all items added to the current sale/return transaction
	 * Parameters: None
	 * Returns: None
	 */
	public void cancelTransaction() {
		this.currentTransaction = null;
	}
	
	/*
	 * Function Name: completeTransaction
	 * Description: Closes the current transaction and adds it the list of completed transactions
	 * Parameters: None
	 * Returns: - Completed transaction or error occurred
	 */
	public Transaction completeTransaction() {
		Transaction retVal = null;
		//validate employee is logged in 
		if((employee != null) && (this.currentTransaction != null))
		{
			if(this.transactions.add(this.currentTransaction))
			{
				retVal = this.currentTransaction;
			}
			this.currentTransaction = null;
		}
		return retVal;
	}
	
	/*
	 * Function Name: printCurrentTransaction
	 * Description: Prints each item in the currently open transaction
	 * Parameters: None
	 * Returns: None
	 */
	public void printCurrentTransaction() {
		System.out.println("Current Transaction:");
		if(this.currentTransaction != null) {
			for(int i = 0; this.currentTransaction.getSize() > i; i++) {
				System.out.println(this.currentTransaction.items.get(i).getName() + "...$" + this.currentTransaction.items.get(i).getPrice());
			}
		}
	}
	
	/*
	 * Function Name: printAllTransactions
	 * Description: Prints all transactions that have occured since the employee has logged on
	 * Parameters: None
	 * Returns: None
	 */
	public void printAllTransactions() {
		BigDecimal totalSaleAmount = new BigDecimal(0);
		BigDecimal totalReturnAmount = new BigDecimal(0);
		BigDecimal totalNet = new BigDecimal(0);
		int itemsReturned = 0;
		int itemsSold = 0;
		int transactionReturns = 0;
		int transactionSales = 0;
		
		//Print cashier
		System.out.println("Employee Username: " + this.employee.getEmployeeUsername());
		System.out.println("Register ID: " + this.ID);
		//Blank line to help separate transactions on console
		System.out.println(" ");
		//Step through each transaction and execute its print function
		if(this.transactions.size() > 0) {
			for(int i = 0; this.transactions.size() > i; i++) {
				System.out.println("Transaction Number: " + i);
				this.transactions.get(i).print();
				if(this.transactions.get(i).saleTransaction) {
					totalSaleAmount = totalSaleAmount.add(this.transactions.get(i).getTotalAmount());
					itemsSold += this.transactions.get(i).getSize();
					transactionSales++;
				}else {
					totalReturnAmount = totalReturnAmount.add(this.transactions.get(i).getTotalAmount());
					itemsReturned += this.transactions.get(i).getSize();
					transactionReturns++;
				}
				//Blank line to help separate transactions on console
				System.out.println(" ");
			}
			
			//Print totals from each transaction
			System.out.println("Total Number of Transactions: " + this.transactions.size());
			System.out.println("Total Sale Transactions: " + transactionSales);
			System.out.println("Total Return Transactions: " + transactionReturns);
			System.out.println("Net Total: $" + totalSaleAmount.subtract(totalReturnAmount));
			System.out.println("Total Sales Amount: $" + totalSaleAmount);
			System.out.println("Total Returns Amount: $" + totalReturnAmount);
			System.out.println("Total Items Sold: " + itemsSold);
			System.out.println("Total Items Returned: " + itemsReturned);
			System.out.println("-------------------------------");
			System.out.println(" ");
		}
	}
	
	/*
	 * Function Name: setEmployee
	 * Description: Logs an employee onto the register object
	 * Parameters: setEmployee - Employee object for employee being logged on
	 * Returns: None
	 */
	public void setEmployee(Employee setEmployee) {
		this.employee = setEmployee;
		this.transactions.clear();
		this.currentTransaction = null;
	}
	
	/*
	 * Function Name: clearEmployee
	 * Description: Clears logged on employee and all transactions that occurred when that employee was logged on
	 * Parameters: None
	 * Returns: None
	 */
	public void clearEmployee() {
		this.transactions.clear();
		this.currentTransaction = null;
		this.employee = null;
	}
	
	/*
	 * Function Name: getEmployee
	 * Description: Returns the current logged on employee object
	 * Parameters: None
	 * Returns: this.employee or null if no employee logged on
	 */
	public Employee getEmployee() {
		return this.employee;
	}
}
