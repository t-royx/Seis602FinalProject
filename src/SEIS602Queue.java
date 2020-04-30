

public class SEIS602Queue<T> implements ISEIS602Queue<T> {
	private SEIS602DblyLinkList<T> stack = new SEIS602DblyLinkList<T>();
	
	SEIS602Queue(){
		
	}
	
	//Adds one element to the rear of this queue.
	public void enqueue(T element) {
		this.stack.addLastNode(element);
	}

	//Removes and returns the element at the front of this queue.
	public T dequeue() {
		return this.stack.removeFirstNode();
	}

	//Returns without removing the element at the front of this queue.
	public T first() {
		return this.stack.getFirstNode();
	}

	//Returns true if this queue contains no elements.
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}

	//Returns the number of elements in this queue.
	public int size() {
		return this.stack.size();
	}

	public void traverseForward()
	{
		//Print that we are traversing forward and then let the doubly link list print the proper values
		System.out.print("Queue Traverse Forwards: ");
		//For a stack traversing forwards is to go from the end of the stack until the start
		this.stack.traverseForward();
		//Add a new line
		System.out.println("");
	}
	
	public void traverseBackwards()
	{
		//Print that we are traversing backwards and then let the doubly link list print the proper values
		System.out.print("Queue Traverse Backwards: ");
		//For a stack traversing backwards is to go from the start of the stack until the end
		this.stack.traverseBackwards();
		//Add a new line
		System.out.println("");
	}
}

