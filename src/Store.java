
import java.util.ArrayList;


public class Store {
	//Store objects
	private Inventory inventory = new Inventory();
	private ArrayList<Employee> employee = new ArrayList<Employee>();
	private Register[] register;
	private int registerCount;
	private int registerSelected;
	
	/*
	 * Constructors
	 */
	
	/*
	 * Name: Store
	 * Description: Default store constructor, calls our customized constructor
	 * Parameters: None
	 * Returns: None
	 */
	public Store() {
		//If unspecified then default to 1 register in the store
		this(1);
	}
	
	/*
	 * Name: Store
	 * Description: Customized constructor that creates the specified number of registers required for the store object
	 * Parameters: numberOfRegisters - number of register objects to support
	 * Returns: None
	 */
	public Store(int numberOfRegisters) {
		//Create the register array object now that we know how many registers we'll have
		this.register = new Register[numberOfRegisters];
		for(int i = 0; i < numberOfRegisters; i++) {
			this.register[i] = new Register(i);
		}
		this.registerCount = numberOfRegisters;
		this.registerSelected = 0;
	}

	/*
	 * Employee Functions
	 */
	
	/*
	 * Name: createEmployee
	 * Description: Adds a new employee object to the store
	 * Parameters: newEmployee - new employee object to add to the store
	 * Returns: None
	 */
	public void createEmployee(Employee newEmployee) {
		if(false == this.employee.contains(newEmployee)) {
			this.employee.add(newEmployee);
		}
	}
	
	/*
	 * Name: deleteEmployee
	 * Description: Deletes an employee from the store
	 * Parameters: formerEmployee - employee object to remove from the store
	 * Returns: None
	 */
	public void deleteEmployee(Employee formerEmployee) {
		this.employee.remove(formerEmployee);
	}
	
	
	/*
	 * Inventory Functions
	 */
	
	/*
	 * Name: createItemInInventory
	 * Description: Creates a new item in the stores inventory
	 * Parameters: newItem - item to create in the inventory
	 * Returns: None
	 */
	public void createItemInInventory(Item newItem) {
		inventory.createItem(newItem);
	}
	
	/*
	 * Name: deleteItemFromInventory
	 * Description: Deletes an existing item from the stores inventory
	 * Parameters: item - item to delete from the inventory
	 * Returns: None
	 */
	public void deleteItemFromInventory(Item item) {
		inventory.deleteItem(item);
	}
	
	/*
	 * Name: getInventorySize
	 * Description: Returns current inventory size (number of different items in inventory)
	 * Parameters: None
	 * Returns: Inventory Item Size
	 */
	public int getInventorySize() {
		return inventory.getSize();
	}
	
	//These could be used if we needed to added functions to change item information such as price
	//In this case we would add more public get set item functions and use these private functions
	//to get an item from the inventory, update the required field and update the entire item
	//Not implementing unless there is a need to
	//private void setItemInInventory() {
	//	
	//}
	//
	//private void getItemFromInventory() {
	//	
	//}
	
	/*
	 * Name: printInventory
	 * Description: Prints every item in the inventory on the console
	 * Parameters: None
	 * Returns: None
	 */
	public void printInventory() {
		inventory.print();
	}
	
	/*
	 * Transaction Functions
	 */
	
	/*
	 * Name: selectRegister
	 * Description: Selects which register to perform future operations on
	 * Parameters: registerIndex - register to selected
	 * Returns: True - register selected, false - invalid register requested
	 */
	public boolean selectRegister(int registerIndex) {
		boolean retVal = false;
		//Validate register number
		if(registerCount > registerIndex) {
			//Update selected register to operate on
			registerSelected = registerIndex;
			retVal = true;
		}
		return retVal;
	}
	
	/*
	 * Name: setRegisterEmployee
	 * Description: Selects which register to perform future operations on
	 * Parameters: registerIndex - register to selected
	 * Returns: True - employee logged into selected register, false - error occurred somewhere during process (be generic so they don't know where the failure occured)
	 */
	public boolean setRegisterEmployee(String username, String password) {
		boolean retVal = false;
		
		//Validate no one is currently signed onto the register
		//Note: Someone is logged into a register if the employee object isn't null
		if(null == register[registerSelected].getEmployee()) {
			//Search all employees to see if the username matches any
			for(int i = 0; i < employee.size(); i++) {
				if(employee.get(i).getEmployeeUsername().equals(username)) {
					//Username has been found, validate password
					if(employee.get(i).getEmployeePassword().equals(password)) {
						//Everything is good to go, assign the employee to the register
						register[registerSelected].setEmployee(employee.get(i));
						//Update return value to true telling the application an employee was logged in
						retVal = true;
						break;
					}
				}
			}
		}
		return retVal;
	}
	
	/*
	 * Name: clearRegisterEmployee
	 * Description: Logs an employee off a selected register
	 * Parameters: None
	 * Returns: True - employee logged off selected register, false - no employee signed onto selected register)
	 */
	public boolean clearRegisterEmployee() {
		boolean retVal = false;
		
		//Validate someone is currently signed onto the register
		//Note: Someone is logged into a register if the employee object isn't null
		if(null != register[registerSelected].getEmployee()) {
			register[registerSelected].clearEmployee();
			retVal = true;
		}
		return retVal;
	}
	
	/*
	 * Name: setSaleMode
	 * Description: Sets the current selected register into 'Sale' mode so sale transactions can be performed
	 * Parameters: None
	 * Returns: None
	 */
	public boolean setSaleMode() {
		return register[registerSelected].setSaleMode();
	}
	
	/*
	 * Name: setReturnMode
	 * Description: Sets the current selected register into 'Return' mode so return transactions can be performed
	 * Parameters: None
	 * Returns: None
	 */
	public boolean setReturnMode() {
		return register[registerSelected].setReturnMode();
	}
	
	/*
	 * Name: scanItem
	 * Description: Scans an item into a sale/return transaction for the current selected register
	 * Parameters: scannedItem
	 * Returns: None
	 */
	public boolean scanItem(Item scannedItem) {
		boolean retVal = false;
		//Validate item exist
		if(inventory.doesItemExist(scannedItem)) {
			//Item is valid so process the scan with the selected register object
			retVal = register[registerSelected].scanItem(scannedItem);
		}
		return retVal;
	}
	
	/*
	 * Name: completeTransaction
	 * Description: Completes a transaction for the current selected register
	 * Parameters: None
	 * Returns: transaction - null (no transaction started to complete) otherwise returns the transaction closed
	 */
	public Transaction completeTransaction() {
		Transaction transaction;
		
		//Complete the transaction
		transaction = register[registerSelected].completeTransaction();
		//Check if a transaction was successfully closed, this happens if the object isn't null
		if(transaction != null) {
			//Update the inventory, for sales decrement from the inventory otherwise increment for returns
			if(register[registerSelected].getMode()) {
				//Sale mode so decrement items from inventory
				for(int i = 0; i < transaction.getSize(); i++) {
					inventory.decrementItemStock(transaction.items.get(i));
				}
			}else {
				//Return mode so add items back into the inventory
				for(int i = 0; i < transaction.getSize(); i++) {
					inventory.incrementItemStock(transaction.items.get(i));
				}
			}
		}
		return transaction;
	}
	
	/*
	 * Name: returnTransaction
	 * Description: Returns all items from a specified transaction
	 * Parameters: transaction - transaction object in which to return all items should be returned
	 * Returns: true - transaction returned successfully, false - error while returning the transaction
	 */
	public boolean returnTransaction(Transaction transaction) {
		//TODO
		//Declare return value and initialize to false until transaction is successfully returned
		//Verify there isn't a transaction currently open
		//Set return mode for selected register
		//Run a for-loop and call 'this.scanItem()' for each item in the transaction
		//After all items have been added then call 'this.completeTransaction()' so the inventory is updated
		//Update return value to true if all other steps are successful
		return false;
	}
	
	/*
	 * Name: printCurrentTransaction
	 * Description: Prints any items that have been scanned for a sale/return for the current selected register
	 * Parameters: None
	 * Returns: None
	 */
	public void printCurrentTransaction() {
		register[registerSelected].printCurrentTransaction();
	}
	
	/*
	 * Name: printAllTransaction
	 * Description: Prints all completed sale/return transactions for the current selected register
	 * Parameters: None
	 * Returns: None
	 */
	public void printAllTransaction() {
		register[registerSelected].printAllTransactions();
	}
}
