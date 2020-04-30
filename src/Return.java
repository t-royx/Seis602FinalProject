
public class Return extends Transaction {
	
	
	public Return() {
		
	}
	
	public void addItem(Item item) {
		//Add the item to the items array list
		super.items.add(item);
	}
	
	public boolean removeItem(Item item) {
		boolean retVal = false;
		//Validate the item exist in the transaction
		if(super.items.contains(item)) {
			super.items.remove(item);
			retVal = true;
		}
		return retVal;
	}
}
