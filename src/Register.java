import java.math.BigDecimal;
import java.util.ArrayList;

public class Register {
	private int ID;
	private Employee employee;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	private Transaction currentTransaction;
	private Boolean saleMode;
	
	public Register() {
		this(0);
	}
	
	public Register(int registerID) {
		this.ID = registerID;
		this.employee = null;
		this.currentTransaction = null;
		//Default to sale mode unless employee wants to do returns
		this.saleMode = true;
	}
	
	public boolean setSaleMode() {
		boolean retVal = false;
		//validate employee is logged in 
		if((this.employee != null) && (this.currentTransaction == null))
		{
			saleMode = true;
			retVal = true;
		}
		return retVal;
	}
	
	public boolean setReturnMode() {
		boolean retVal = false;
		//validate employee is logged in 
		if((employee != null) && (this.currentTransaction == null))
		{
			saleMode = false;
			retVal = true;
		}
		return retVal;
	}
	
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
	
	public boolean completeTransaction() {
		boolean retVal = false;
		//validate employee is logged in 
		if((employee != null) && (this.currentTransaction != null))
		{
			retVal = this.transactions.add(this.currentTransaction);
			this.currentTransaction = null;
		}
		return retVal;
	}
	
	public boolean transactionReturn() {
		boolean retVal = false;
		//validate employee is logged in 
		if((employee != null) && (this.currentTransaction == null))
		{
			//validate the 
		}
		return retVal;
	}
	
	public void printCurrentTransaction() {
		System.out.println("Current Transaction:");
		if(this.currentTransaction != null) {
			for(int i = 0; this.currentTransaction.getSize() > i; i++) {
				System.out.println(this.currentTransaction.items.get(i).getName() + "...$" + this.currentTransaction.items.get(i).getPrice());
			}
		}
	}
	
	public void printAllTransactions() {
		//To simplify print function
		String itemName;
		BigDecimal itemPrice;
		
		//For each transaction
		if(this.transactions.size() > 0) {
			for(int i = 0; this.transactions.size() > i; i++) {
				//Iterate through each item in the current transaction
				System.out.println("Transaction Number: " + i);
				for(int j = 0; this.transactions.get(i).getSize() > j; j++) {
					itemName = this.transactions.get(i).items.get(j).getName();
					itemPrice = this.transactions.get(i).items.get(j).getPrice();
					System.out.println(itemName + "...$" + itemPrice);
				}
			}
		}
	}
	
	public void setEmployee(Employee setEmployee) {
		this.employee = setEmployee;
		this.transactions.clear();
		this.currentTransaction = null;
	}
	
	public void clearEmployee() {
		this.employee = null;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
}
