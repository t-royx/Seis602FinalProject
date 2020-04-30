import java.math.BigDecimal;

public class Item {
	private String name;
	private String supplier;
	private BigDecimal price;
	private int stock;
	private int backOrdered;
	private int reorderAmount;
	private int reorderThreshold;
	
	/*
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
	 */
	public Item() {
		this(null,null,null,0,0,0,0);
	}
	
	/*
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
	 */
	public Item(String itemName, String itemSupplier, BigDecimal itemPrice, int initialStock, int initialBackOrder, int itemReorderAmount, int itemReorderThreshold) {
		this.name = itemName;
		this.supplier = itemSupplier;
		this.price = itemPrice;
		this.stock = initialStock;
		this.backOrdered = initialBackOrder;
		this.reorderAmount = itemReorderAmount;
		this.reorderThreshold = itemReorderThreshold;
	}
	
	/*
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
	 */
	public Item getItem() {
		return this;
	}
	
	/*
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Name: 
	 * Description:
	 * Parameters:
	 * Returns:
	 */
	public void setName(String itemName) {
		this.name = itemName;
	}
	
	/*
	 * Name:
	 * Description:
	 * Parameters: 
	 * Returns: 
	 */
	public String getSupplier() {
		return this.supplier;
	}
	
	/*
	 * Name: 
	 * Description: 
	 * Parameters: 
	 * Returns: 
	 */
	public void setSupplier(String itemSupplier) {
		this.supplier = itemSupplier;
	}
	
	/*
	 * Name: 
	 * Description: 
	 * Parameters: 
	 * Returns: 
	 */
	public BigDecimal getPrice() {
		return this.price;
	}
	
	/*
	 * Name: 
	 * Description: 
	 * Parameters: 
	 * Returns: 
	 */
	public void setPrice(BigDecimal itemPrice) {
		this.price = itemPrice;
	}
	
	/*
	 * Name: 
	 * Description: 
	 * Parameters: 
	 * Returns: 
	 */
	public int getStock() {
		return this.stock;
	}
	
	/*
	 * Name: 
	 * Description: 
	 * Parameters: 
	 * Returns: 
	 */
	public void setStock(int itemStock) {
		this.stock = itemStock;
	}
	
	/*
	 * Name: 
	 * Description: 
	 * Parameters: 
	 * Returns: 
	 */
	public int getBackordered() {
		return this.backOrdered;
	}
	
	/*
	 * Name: 
	 * Description: 
	 * Parameters: 
	 * Returns: 
	 */
	public void setBackordered(int itemBackordered) {
		this.backOrdered = itemBackordered;
	}
	
	/*
	 * Name: 
	 * Description: 
	 * Parameters: 
	 * Returns: 
	 */
	public int getReorderAmount() {
		return this.reorderAmount;
	}
	
	/*
	 * Name: 
	 * Description: 
	 * Parameters: 
	 * Returns: 
	 */
	public void setReordered(int itemReorderAmount) {
		this.reorderAmount = itemReorderAmount;
	}
	
	/*
	 * Name: 
	 * Description: 
	 * Parameters: 
	 * Returns: 
	 */
	public int getReorderThreshold() {
		return this.reorderThreshold;
	}
	
	/*
	 * Name: 
	 * Description: 
	 * Parameters: 
	 * Returns: 
	 */
	public void setReorderThreshold(int itemReorderThreshold) {
		this.reorderThreshold = itemReorderThreshold;
	}
}
