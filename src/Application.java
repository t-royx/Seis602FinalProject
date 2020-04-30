
import java.math.BigDecimal;
import java.util.Scanner;

public class Application {
	//Application store object
	private static Store store = new Store();
	private static Scanner userInputScanner;
	private static Scanner userUsernameScanner;
	private static Scanner userPasswordScanner;
	private static String userInputString;
	private static String username;
	private static String password;
	private static boolean runProgram;
	
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
				
				case "Login":
				case "login":
				{
					//Collect login credentials
					System.out.println("Enter Username:");
					username = userUsernameScanner.nextLine();
					System.out.println("Enter Username:");
					password = userPasswordScanner.nextLine();
					
					//Use credentials to log employee in
					if(true == store.setRegisterEmployee(0, username, password))
					{
						System.out.println("Login Success");
					}else {
						System.out.println("Login Error");
					}
						
				}
				break;
				
				//Sets sale mode
				case "Sale":
				case "sale":
				{
					
				}
				break;
				
				//Enters return mode
				case "Return":
				case "return":
				{
					
				}
				break;
				
				case "ScanCookies":
				case "scancookies":
				{
					store.scanItem(0, itemCookies);
				}
				break;
				
				case "CompleteTransaction":
				case "completeTransaction":
				{
					store.completeTransaction(0);
				}
				break;
				
				case "PrintCurrentTransaction":
				case "printcurrenttransaction":
				{
					store.printCurrentTransaction(0);
				}
				break;
				
				case "PrintAllTransactions":
				case "printalltransactions":
				{
					store.printAllTransaction(0);
				}
				break;
				
				case "Inventory":
				case "inventory":
				{
					//Print an inventory report
					store.printInventory();
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
		System.out.println("P.O.S. System");
		System.out.println("Available Commands:");
		System.out.println("- Create Employee");
		System.out.println("- Remove Employee");
		System.out.println("- Inventory");
		System.out.println("- Quit");
	}
}
