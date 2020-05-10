
public class Return extends Transaction {
	/*
	 * Name: Return
	 * Description: Default return constructor
	 * Parameters: None
	 * Returns: None
	 */
	public Return() {
		//Transaction is a return
		super.saleTransaction = false;
	}
}
