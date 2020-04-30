
public class SEIS602Stack<E> implements ISEIS602Stack<E> {

	private SEIS602DblyLinkList<E> stack = new SEIS602DblyLinkList<E>();

	public SEIS602Stack() {

	}

	// Adds the specified element to the top of the stack.
	public void add(E e) {
		this.stack.addLastNode(e);
	}

	// Returns a reference to the top element of this stack without removing it.
	public E peek() {
		return this.stack.getLastNode();
	}

	// Removes and returns the top element from the stack.
	public E pop() {
		return this.stack.removeLastNode();
	}

	// Adds the specified element to the top of the stack.
	public void push(E e) {
		this.stack.addLastNode(e);
	}

	// Returns the number of elements in the stack.
	public int size() {
		return this.stack.size();
	}

	public void traverseForwards() {
		//Print that we are traversing forward and then let the doubly link list print the proper values
		System.out.print("Stack Traverse Forwards: ");
		//For a stack traversing forwards is to go from the end of the stack until the start
		this.stack.traverseBackwards();
		//Add a new line
		System.out.println("");
	}
	
	public void traverseBackwards() {
		//Print that we are traversing backwards and then let the doubly link list print the proper values
		System.out.print("Stack Traverse Backwards: ");
		//For a stack traversing backwards is to go from the start of the stack until the end
		this.stack.traverseForward();
		//Add a new line
		System.out.println("");
	}
}
