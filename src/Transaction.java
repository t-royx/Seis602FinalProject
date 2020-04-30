import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Transaction {
	protected LocalDate Date_of_Opening;
	protected LocalTime Time_of_Opening;
	protected ArrayList<Item> items = new ArrayList<Item>();
	
	public Transaction() {
		this.Date_of_Opening = LocalDate.now();
		this.Time_of_Opening = LocalTime.now();
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
	
	public BigDecimal getTotal() {
		BigDecimal retVal = new BigDecimal(0);
		//Add up the total for all items in the transaction
		for(int i = 0; i < this.items.size(); i++) {
			retVal = retVal.add(this.items.get(i).getPrice());
		}
		return retVal;
	}
	
	public int getSize() {
		return this.items.size();
	}
}
