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
	 * Name: Item
	 * Description: Default item constructor
	 * Parameters: None
	 * Returns: None
	 */
	public Item() {
		this(null,null,null,0,0,0,0);
	}
	
	/*
	 * Name: Item
	 * Description: Customized constructor that initializes an Item object
	 * Parameters: 	itemName
	 * 				itemSupplier
	 * 				itemPrice
	 * 				initialStock
	 * 				initialBackOrder
	 * 				itemReorderAmount
	 * 				itemReorderThreshold
	 * Returns: None
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
	 * Name: getItem
	 * Description: returns Item object
	 * Parameters: None
	 * Returns: this item object
	 */
	public Item getItem() {
		return this;
	}
	
	/*
	 * Name: getName
	 * Description: Returns item's name string
	 * Parameters: None
	 * Returns: this.name
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Name: setName
	 * Description: Sets item's name string
	 * Parameters: itemName
	 * Returns: None
	 */
	public void setName(String itemName) {
		this.name = itemName;
	}
	
	/*
	 * Name: getSupplier
	 * Description: Returns Items supplier
	 * Parameters: None
	 * Returns: this.supplier
	 */
	public String getSupplier() {
		return this.supplier;
	}
	
	/*
	 * Name: setSupplier
	 * Description: Sets item supplier
	 * Parameters: itemSupplier
	 * Returns: None
	 */
	public void setSupplier(String itemSupplier) {
		this.supplier = itemSupplier;
	}
	
	/*
	 * Name: getPrice
	 * Description: Returns Items price
	 * Parameters: None
	 * Returns: this.price
	 */
	public BigDecimal getPrice() {
		return this.price;
	}
	
	/*
	 * Name: setPrice
	 * Description: Sets items price
	 * Parameters: itemPrice
	 * Returns: None
	 */
	public void setPrice(BigDecimal itemPrice) {
		this.price = itemPrice;
	}
	
	/*
	 * Name: getStock
	 * Description: Returns items stock
	 * Parameters: None
	 * Returns: this.stock
	 */
	public int getStock() {
		return this.stock;
	}
	
	/*
	 * Name: setStock
	 * Description: Sets items stock
	 * Parameters: itemStock
	 * Returns: None
	 */
	public void setStock(int itemStock) {
		this.stock = itemStock;
	}
	
	/*
	 * Name: getBackordered
	 * Description: Returns backordered amount
	 * Parameters: None
	 * Returns: this.backOrdered
	 */
	public int getBackordered() {
		return this.backOrdered;
	}
	
	/*
	 * Name: setBackordered
	 * Description: Sets back ordered amount
	 * Parameters: itemBackordered
	 * Returns: None
	 */
	public void setBackordered(int itemBackordered) {
		this.backOrdered = itemBackordered;
	}
	
	/*
	 * Name: getReorderAmount
	 * Description: Returns items backordered amount
	 * Parameters: None
	 * Returns: this.reorderAmount
	 */
	public int getReorderAmount() {
		return this.reorderAmount;
	}
	
	/*
	 * Name: setReordered
	 * Description: Sets items backordered amount
	 * Parameters: itemReorderAmount
	 * Returns: None
	 */
	public void setReordered(int itemReorderAmount) {
		this.reorderAmount = itemReorderAmount;
	}
	
	/*
	 * Name: getReorderThreshold
	 * Description: Returns items reorder threshold
	 * Parameters: None
	 * Returns: this.reorderThreshold
	 */
	public int getReorderThreshold() {
		return this.reorderThreshold;
	}
	
	/*
	 * Name: setReorderThreshold
	 * Description: Sets items reorder threshold
	 * Parameters: itemReorderThreshold
	 * Returns: None
	 */
	public void setReorderThreshold(int itemReorderThreshold) {
		this.reorderThreshold = itemReorderThreshold;
	}
}
