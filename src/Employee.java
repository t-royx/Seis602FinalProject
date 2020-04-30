
public class Employee {
	private static int MAX_ID = 0;
	private int uniqueID;
	private String username;
	private String password;
	
	public Employee() {
		this(null, null);
	}
	
	public Employee(String employeeUsername, String employeePassword) {
		this.uniqueID = MAX_ID++;
		this.username = employeeUsername;
		this.password = employeePassword;
	}
	
	public String getEmployeeUsername() {
		return this.username;
	}
	
	public void setEmployeeUsername(String employeeUsername) {
		this.username = employeeUsername;
	}
	
	public String getEmployeePassword() {
		return this.password;
	}
	
	public void setEmployeePassword(String employeePassword) {
		this.password = employeePassword;
	}
	
	public int getEmployeeID() {
		return this.uniqueID;
	}
	
	public void setEmployeeID(int uniqueID) {
		this.uniqueID = uniqueID;
	}
}
