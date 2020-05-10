
public class Sale extends Transaction {
	/*
	 * Name: Sale
	 * Description: Default sale constructor
	 * Parameters: None
	 * Returns: None
	 */
	public Sale()  {
		//Transaction is a sale
		super.saleTransaction = true;
	}
}
