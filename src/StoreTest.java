import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class StoreTest {
	
	//Application store object with 2 registers
	private static Store store = new Store(2);
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
	private static Item monkey;
	
	public static void loadExampleStore() {
		//Create Employees
		store.createEmployee(employeeTroyE);
		store.createEmployee(employeeAshleyP);
		
		//Create example Items
		store.createItemInInventory(itemCrackers);
		store.createItemInInventory(itemCookies);
		store.createItemInInventory(itemMilk);
	}
		
	// Test selection of register
	@Test
	void testRegister() {
		String result;				
		selectedRegister = 1;
		if(true == store.selectRegister(selectedRegister)) {
			//Register successfully selected
			result = "Register successfully selected";
		}else {
			//Register failed to be selected
			result = "Failure to select register:" + selectedRegister + ", please try again";
		}
		assertEquals("Register successfully selected" , result);
	}
	
	// Test incorrect login credentials
	@Test
	void testIncorrectLoginCredentials() {
		String result;
		store.createEmployee(employeeAshleyP);
		//Create Employees
		store.createEmployee(employeeTroyE);
		
		String username2 = "TroyE";
		String password2 = "Donkey";
			
		//Use credentials to log employee in
		if(true == store.setRegisterEmployee(username2, password2))
		{
			//Print out that we were successfully logged in
			result = "Login Success";
		}else {
			//Credentials not accepted or 
			result = "Login Error";
		}
			
		assertEquals("Login Error", result);	
	}
	
	// Test salemode
	@Test
	void testSaleMode() {
		String result;
		selectedRegister = 1;
		String username = "AshleyP";
		String password = "Password2";
		store.createEmployee(employeeAshleyP);
		store.setRegisterEmployee(username, password);
		store.setSaleMode();
		//Try to set the store into sale mode and tell the user the status
		if(true == store.setSaleMode()){
			result = "Sale mode successfully set";
		}else {
			result = "Transaction in progress or employee not logged in";
		}
				
		assertEquals("Sale mode successfully set", result);
	}
	
	// Test scanning the correct items
	@Test
	void testScanCorrentItems() {
		loadExampleStore();
		String result;
		selectedRegister = 1;
		String username = "AshleyP";
		String password = "Password2";
		store.setRegisterEmployee(username, password);
		store.setSaleMode();
		//Try to set the store into sale mode and tell the user the status
		if(true == store.setSaleMode()){
			System.out.println("Sale mode successfully set");
		}else {
			System.out.println("Transaction in progress or employee not logged in");
		}
		
		//Scan milk item and verify it was added to a transaction
		if(false == store.scanItem(itemMilk)) {
			result = "Invalid item or no employee signed onto selected register";
		}else {
			result = "Milk scanned";
		}
				
		assertEquals("Milk scanned", result);
	}
	
	// Test scanning incorrect items
	@Test
	void testScanIncorrentItems() {
		String result;
		selectedRegister = 1;
		String username = "AshleyP";
		String password = "Password2";
		store.setRegisterEmployee(username, password);
		store.setSaleMode();
		//Try to set the store into sale mode and tell the user the status
		if(true == store.setSaleMode()){
			System.out.println("Sale mode successfully set");
		}else {
			System.out.println("Transaction in progress or employee not logged in");
		}
		
		//Scan monkey item and verify it was added to a transaction
		if(false == store.scanItem(monkey)) {
			result = "Invalid item or no employee signed onto selected register";
		}else {
			result = "Monkey scanned";
		}
				
		assertEquals("Invalid item or no employee signed onto selected register", result);
	}
	
	// Test Returns
	@Test
	void testReturnItems() {
		String result;
		selectedRegister = 1;
		String username = "AshleyP";
		String password = "Password2";
		store.setRegisterEmployee(username, password);
		store.setReturnMode();
		//Try to set the store into sale mode and tell the user the status
		if(true == store.setReturnMode()){
			System.out.println("Return mode successfully set");
		}else {
			System.out.println("Transaction in progress or employee not logged in");
		}
		
		//Scan cracker item and verify it was added to a transaction
		if(false == store.scanItem(itemCrackers)) {
			result = "Invalid item or no employee signed onto selected register";
		}else {
			result = "Crackers scanned";
		}
		
		store.printCurrentTransaction();
				
		assertEquals("Crackers scanned", result);
	}
	
	// Test Returns
	@Test
	void testCancelTransaction() {
		selectedRegister = 1;
		String username = "AshleyP";
		String password = "Password2";
		store.setRegisterEmployee(username, password);
		store.setReturnMode();
		//Try to set the store into sale mode and tell the user the status
		if(true == store.setReturnMode()){
			System.out.println("Return mode successfully set");
		}else {
			System.out.println("Transaction in progress or employee not logged in");
		}
		
		//Scan cracker item and verify it was added to a transaction
		if(false == store.scanItem(itemCrackers)) {
			System.out.println("Invalid item or no employee signed onto selected register");
		}else {
			System.out.println("Crackers scanned");
		}
		
		System.out.println("Cancelling transation... ");
		store.cancelTransaction();
	}
	
	// Test Printing Inventory
	@Test
	void testPrintInventory() {
		selectedRegister = 1;
		String username = "AshleyP";
		String password = "Password2";
		store.setRegisterEmployee(username, password);
		store.setReturnMode();
		//Try to set the store into sale mode and tell the user the status
		if(true == store.setReturnMode()){
			System.out.println("Return mode successfully set");
		}else {
			System.out.println("Transaction in progress or employee not logged in");
		}
		
		//Scan cracker item and verify it was added to a transaction
		if(false == store.scanItem(itemCrackers)) {
			System.out.println("Invalid item or no employee signed onto selected register");
		}else {
			System.out.println("Crackers scanned");
		}
		
		System.out.println("Output for Printing Inventory: ");
		store.printInventory();
	}
}