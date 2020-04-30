import java.lang.reflect.Array;
import java.util.ArrayList;


public class Store {
	//Store objects
	private Inventory inventory = new Inventory();
	private ArrayList<Employee> employee = new ArrayList<Employee>();
	private Register[] register;
	private int registerCount;
	
	/*
	 * Constructors
	 */
	
	public Store() {
		//If unspecified then default to 1 register in the store
		this(1);
	}
	
	public Store(int numberOfRegisters) {
		//Create the register array object now that we know how many registers we'll have
		this.register = new Register[numberOfRegisters];
		for(int i = 0; i < numberOfRegisters; i++) {
			this.register[i] = new Register(i);
		}
		this.registerCount = numberOfRegisters;
	}

	/*
	 * Employee Functions
	 */
	
	public void createEmployee(Employee newEmployee) {
		if(false == this.employee.contains(newEmployee)) {
			this.employee.add(newEmployee);
		}
	}
	
	public void deleteEmployee(Employee formerEmployee) {
		this.employee.remove(formerEmployee);
	}
	
	
	/*
	 * Inventory Functions
	 */
	
	public void createItemInInventory(Item newItem) {
		inventory.createItem(newItem);
	}
	
	public void deleteItemFromInventory() {
		
	}
	
	public int getInventorySize() {
		return inventory.getSize();
	}
	
	private void setItemInInventory() {
		
	}
	
	private void getItemFromInventory() {
		
	}
	
	public void printInventory() {
		inventory.print();
	}
	
	/*
	 * Transaction Functions
	 */
	
	public boolean setRegisterEmployee(int registerIndex, String username, String password) {
		boolean retVal = false;
		//Validate register number
		if(registerCount > registerIndex)
		{
			//Validate no one is currently signed onto the register
			if(null == register[registerIndex].getEmployee()) {
				//Register index is valid, search all employees to see if the username matches any
				for(int i = 0; i < employee.size(); i++) {
					if(employee.get(i).getEmployeeUsername().equals(username)) {
						//Username has been found, validate password
						if(employee.get(i).getEmployeePassword().equals(password)) {
							//Everything is good to go, assign the employee to the register
							register[registerIndex].setEmployee(employee.get(i));
							retVal = true;
							break;
						}
					}
				}
			}
		}
		return retVal;
	}
	
	public boolean clearRegisterEmployee(int registerIndex) {
		return false;
	}
	
	public boolean setSaleMode() {
		return false;
	}
	
	public boolean setReturnMode() {
		return false;
	}
	
	public boolean scanItem(int registerIndex, Item scannedItem) {
		boolean retVal = false;
		//Validate item exist and register
		if((inventory.doesItemExist(scannedItem) && (registerCount > registerIndex))) {
			//Item is valid so process the scan with the register object
			retVal = register[registerIndex].scanItem(scannedItem);
		}
		return retVal;
	}
	
	public boolean completeTransaction(int registerIndex) {
		boolean retVal = false;
		//Validate register
		if(registerCount > registerIndex) {
			retVal = register[registerIndex].completeTransaction();
		}
		return retVal;
	}
	
	public void printCurrentTransaction(int registerIndex) {
		//Validate register
		if(registerCount > registerIndex) {
			register[registerIndex].printCurrentTransaction();
		}
	}
	
	public void printAllTransaction(int registerIndex) {
		//Validate register
		if(registerCount > registerIndex) {
			register[registerIndex].printAllTransactions();
		}
	}
	
	public boolean returnTransaction(int registerIndex, Transaction transaction) {
		return false;
	}
	
}
