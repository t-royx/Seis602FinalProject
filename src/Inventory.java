import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> items = new ArrayList<Item>();
	
	/*
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
	 */
	public Inventory() {
		
	}
	
	/*
	 * Name: createItem
	 * Description: Creates an item in inventory
	 * Parameters: newItem
	 * Returns: true - item created, false - item already exist
	 */
	public boolean createItem(Item newItem)
	{
		boolean retVal = false;
		//Add the item if it doesn't already exist, we don't want to allow duplicate of the same item
		if(false == items.contains(newItem))
		{
			items.add(newItem);
			retVal = true;
		}
		return retVal;
	}
	
	/*
	 * Name: deleteItem
	 * Description: Deletes an item from the inventory
	 * Parameters: item
	 * Returns: None
	 */
	public void deleteItem(Item item)
	{
		//Delete the item if it already exist
		if(true == items.contains(item))
		{
			items.remove(item);
		}
	}
	
	/*
	 * Name: incrementItemStock
	 * Description: Increments stock for specified  inventory item
	 * Parameters: item
	 * Returns: None
	 */
	public void incrementItemStock(Item item)
	{
		int index = items.indexOf(item);
		//Delete the item if it already exist
		if(index > -1)
		{
			items.get(index).setStock(items.get(index).getStock() + 1);
		}
	}
	
	/*
	 * Name: decrementItemStock
	 * Description: Decrements stock for specified  inventory item
	 * Parameters: item
	 * Returns: None
	 */
	public void decrementItemStock(Item item)
	{
		int index = items.indexOf(item);
		//Delete the item if it already exist
		if(index > 0)
		{
			items.get(index).setStock(items.get(index).getStock() - 1);
		}
	}
	
	/*
	 * Name: getSize
	 * Description: Returns inventory size
	 * Parameters: None
	 * Returns: this.items.size()
	 */
	public int getSize() {
		return this.items.size();
	}
	
	/*
	 * Name: print
	 * Description: Prints entire inventory
	 * Parameters: None
	 * Returns: None
	 */
	public void print() {
		Item temp;
		
		System.out.println("Inventory Report");
		System.out.println("Name, Supplier, Price, Stock, Backorder, Reorder Amount, Reorder Threshold");
		
		//For each item in the array list, go through and execute the Items print function
		for(int i = 0; i < this.items.size(); i++) {
			temp = items.get(i).getItem();
			System.out.println( temp.getName() + ", " +
								temp.getSupplier() + ", " + 
								temp.getPrice() + ", " + 
								temp.getStock() + ", " + 
								temp.getBackordered() + ", " + 
								temp.getReorderAmount() + ", " + 
								temp.getReorderThreshold());
		}
	}
	
	/*
	 * Name: doesItemExist
	 * Description: Checks if an item exist in the inventory
	 * Parameters: item
	 * Returns: true/false
	 */
	public boolean doesItemExist(Item item)
	{
		if(this.items.contains(item)) {
			return true;
		}else {
			return false;
		}
	}
}
