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
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
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
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
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
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
	 */
	public void incrementItemStock(Item item)
	{
		int index = items.indexOf(item);
		//Delete the item if it already exist
		if(index > 0)
		{
			items.get(index).setStock(items.get(index).getStock() + 1);
		}
	}
	
	/*
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
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
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
	 */
	public int getSize() {
		return this.items.size();
	}
	
	/*
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
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
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
	 */
	public boolean doesItemExist(Item item)
	{
		if(this.items.contains(item)) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
	 */
	public Item getItem()
	{
		return null;
	}
	
	/*
	 * Name:
	 * Description:
	 * Parameters:
	 * Returns:
	 */
	public void setItem() {
		
	}
}
