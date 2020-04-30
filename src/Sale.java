
public class Sale extends Transaction {
	
	
	public Sale()  {
		
	}
	
	public void addItem(Item item) {
		//Add the item to the items array list
		items.add(item);
	}
	
	public boolean removeItem(Item item) {
		boolean retVal = false;
		//Validate the item exist in the transaction
		if(this.items.contains(item)) {
			this.items.remove(item);
			retVal = true;
		}
		return retVal;
	}
}
