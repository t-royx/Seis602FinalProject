
import java.math.BigDecimal;
import java.util.Scanner;

public class Application {
	//Application store object with 2 registers
	private static Store store = new Store(2);
	private static Scanner userInputScanner;
	private static Scanner userUsernameScanner;
	private static Scanner userPasswordScanner;
	private static Scanner selectedRegisterScanner;
	private static String userInputString;
	private static String username;
	private static String password;
	private static int selectedRegister;
	private static boolean runProgram;
	private static Transaction lastTransaction;
	
	//Example Items
	//private static Item itemName = new Item("Name", "Supplier", price, initialStock, initialBackOrder, itemReorderAmount, itemReorderThreshold)
	private static Item itemCrackers = new Item("Crackers", "Ritz", BigDecimal.valueOf(2.50), 25, 0, 25, 10);
	private static Item itemCookies = new Item("Cookies", "Oreo", BigDecimal.valueOf(2.00), 30, 0, 30, 15);
	private static Item itemMilk = new Item("Milk", "Land O Lakes", BigDecimal.valueOf(1.50), 35, 0, 35, 20);
	private static Employee employeeTroyE = new Employee("TroyE", "Password1");
	private static Employee employeeAshleyP = new Employee("AshleyP", "Password2");
	
	/*
	 * Name: main
	 * Description: Entry to P.O.S application
	 * Parameters: args - application arguments aren't used
	 * Returns: None
	 */
	public static void main(String[] args) {
		runProgram = true;
		userInputScanner = new Scanner(System.in);
		userUsernameScanner = new Scanner(System.in);
		userPasswordScanner = new Scanner(System.in);
		selectedRegisterScanner = new Scanner(System.in);
		
		//Load the example store
		loadExampleStore();
		
		//Print startup console message
		printStartupMessage();
		
		//Run through the loop at least one time, if the user tells us to quit then exit the program
		do {
			// Get input from the user on what we should do
			System.out.println("Enter Operation:");
			userInputString = userInputScanner.nextLine();
			// Process user input
			switch(userInputString)
			{
				//TODO: Add application cases here
				case "":
				{
					
				}
				break;
				
				case "SelectRegister":
				case "selectregister":
				{
					//Collect login credentials
					System.out.println("Enter register number:");
					selectedRegister = Integer.valueOf(selectedRegisterScanner.nextLine());
					if(true == store.selectRegister(selectedRegister)) {
						//Register successfully selected
						System.out.println("Register successfully selected");
					}else {
						//Register failed to be selected
						System.out.println("Failure to select register:" + selectedRegister + ", please try again");
					}	
				}
				break;
				
				case "Login":
				case "login":
				{
					//Collect login credentials
					System.out.println("Enter Username:");
					username = userUsernameScanner.nextLine();
					System.out.println("Enter Username:");
					password = userPasswordScanner.nextLine();
					
					//Use credentials to log employee in
					if(true == store.setRegisterEmployee(username, password))
					{
						//Print out that we were successfully logged in
						System.out.println("Login Success");
					}else {
						//Credentials not accepted or 
						System.out.println("Login Error");
					}
						
				}
				break;
				
				case "LogOff":
				case "logoff":
				{
					//Attempt to log the employee off
					if(true == store.clearRegisterEmployee())
					{
						//User signed off
						System.out.println("Log off Success");
					}else {
						//No user was signed on
						System.out.println("User not logged on");
					}
						
				}
				break;
				
				//Sets sale mode
				case "SetSaleMode":
				case "setsalemode":
				{
					//Try to set the store into sale mode and tell the user the status
					if(true == store.setSaleMode()){
						System.out.println("Sale mode successfully set");
					}else {
						System.out.println("Transaction in progress or employee not logged in");
					}
				}
				break;
				
				//Enters return mode
				case "SetReturnMode":
				case "setreturnMode":
				{
					//Try to set the store into return mode and tell the user the status
					if(true == store.setReturnMode()){
						System.out.println("Return mode successfully set");
					}else {
						System.out.println("Transaction in progress or employee not logged in");
					}
				}
				break;
				
				case "ScanCrackers":
				case "scancrackers":
				{
					//Scan cracker item and verify it was added to a transaction
					if(false == store.scanItem(itemCrackers)) {
						System.out.println("Invalid item or no employee signed onto selected register");
					}else {
						System.out.println("Crackers scanned");
					}
				}
				break;
				
				case "ScanCookies":
				case "scancookies":
				{
					//Scan cookie item and verify it was added to a transaction
					if(false == store.scanItem(itemCookies)) {
						System.out.println("Invalid item or no employee signed onto selected register");
					}else {
						System.out.println("Cookies scanned");
					}
				}
				break;
				
				case "ScanMilk":
				case "scanmilk":
				{
					//Scan milk item and verify it was added to a transaction
					if(false == store.scanItem(itemMilk)) {
						System.out.println("Invalid item or no employee signed onto selected register");
					}else {
						System.out.println("Milk scanned");
					}
				}
				break;
				
				case "CompleteTransactio":
				case "completetransaction":
				{
					lastTransaction = store.completeTransaction();
				}
				break;
				
				case "ReturnLastTransaction":
				case "returnlasttransaction":
				{
					store.returnTransaction(lastTransaction);
					//clear last transaction so it can't be returned 2x
					lastTransaction = null;
				}
				break;
				
				case "PrintCurrentTransaction":
				case "printcurrenttransaction":
				{
					store.printCurrentTransaction();
				}
				break;
				
				case "PrintAllTransactions":
				case "printalltransactions":
				{
					store.printAllTransaction();
				}
				break;
				
				case "PrintInventory":
				case "printinventory":
				{
					//Print an inventory report
					store.printInventory();
				}
				break;
				
				case "Help":
				case "help":
				{
					printHelpMessage();
				}
				
				case "Commands":
				case "commands":
				{
					printCommandsMessage();
				}
				break;
				
				case "Quit":
				case "quit":
				{
					//Stop running
					runProgram = false;
				}
				break;
				
				//Invalid command
				default:
				{
					System.out.println("Invalid command, please try again");
				}
				break;
			}
		}while(runProgram);
	}
	
	/*
	 * Name: loadExampleStore
	 * Description: Loads any example users, registers and items
	 * Parameters: None
	 * Returns: None
	 */
	private static void loadExampleStore() {
		//Create Employees
		store.createEmployee(employeeTroyE);
		store.createEmployee(employeeAshleyP);
		
		//Create example Items
		store.createItemInInventory(itemCrackers);
		store.createItemInInventory(itemCookies);
		store.createItemInInventory(itemMilk);
	}
	
	/*
	 * Name: printStartupMessage
	 * Description: Prints application startup message to the console
	 * Parameters: None
	 * Returns: None
	 */
	private static void printStartupMessage() {
		System.out.println("P.O.S. System Startup");
		//Print all commands
		printCommandsMessage();
	}
	
	/*
	 * Name: printCommandsMessage
	 * Description: Prints application help message to the console
	 * Parameters: None
	 * Returns: None
	 */
	private static void printCommandsMessage() {
		System.out.println("Available Commands:");
		System.out.println("- 'SelectRegister': Selects a register to perform upcoming operations on");
		System.out.println("- 'Login': Used to login an employee into the current register selected");
		System.out.println("- 'LogOff': Used to log off the employee signed into the current register selected");
		System.out.println("- 'SetSaleMode': Used to set the current register selected into 'sale' mode so the next item scanned will start a sale transaction");
		System.out.println("- 'SetReturnMode': Used to set the current register selected into 'return' mode so the next item scanned will start a return transaction");
		System.out.println("- 'ScanCrackers': Scans 1 cracker item into an existing sale/return transaction for the current register selected, if transaction hasn't been started then this starts a new transaction");
		System.out.println("- 'ScanCookies': Scans 1 cookie item into an existing sale/return transaction for the current register selected, if transaction hasn't been started then this starts a new transaction");
		System.out.println("- 'ScanMilk': Scans 1 milk item into an existing sale/return transaction for the current register selected, if transaction hasn't been started then this starts a new transaction");
		System.out.println("- 'CompleteTransaction': Completes an open transaction, if one exist, for the current register selected, this is called when the user has paid for a sale or been refunded for a return");
		System.out.println("- 'PrintCurrentTransaction': Prints any items added to a current sale/return transaction for the current register selected");
		System.out.println("- 'PrintAllTransactions': Prints all completed transaction for the current register selected");
		System.out.println("- 'PrintInventory': Prints entire inventory for store");
		System.out.println("- 'Help': Prints how the application is used");
		System.out.println("- 'Commands': Prints commandsS");
		System.out.println("- 'Quit': Ends application");
	}
	
	/*
	 * Name: printHelpMessage
	 * Description: Prints application help message to the console
	 * Parameters: None
	 * Returns: None
	 */
	private static void printHelpMessage() {
		System.out.println("Help Message");
		System.out.println("Viewing Store Inventory:");
		System.out.println("1. Use the 'PrintInventory'");
		System.out.println("P.O.S application sale/return transaction operation:");
		System.out.println("1. Select register to operate on using 'SelectRegister' command");
		System.out.println("2. Log employee into register using 'Login' command");
		System.out.println("3. Set return mode using 'SetReturnMode' command if return is desired, otherwise by default 'SetSaleMode' is selected");
		System.out.println("4. Scan desired items using 'ScanCrackers', 'ScanCookies', or 'ScanMilk' commands");
		System.out.println("4A. At any time use the 'PrintCurrentTransaction' command to view items that have been scanned and are a part of the current sale/return transaction");
		System.out.println("5. Once all items have been added to the sale/return transaction then use the 'CompleteTransaction' command. At this point the customer has paid or been refunded");
		System.out.println("5A. After 'CompleteTransaction' command then the 'PrintCurrentTransaction' should return there is no transaction open");
		System.out.println("5B. After 'CompleteTransaction' command then the 'PrintAllTransactions' should print the completed transaction");
	}
}
