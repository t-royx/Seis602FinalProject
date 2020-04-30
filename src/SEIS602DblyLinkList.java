
public class SEIS602DblyLinkList<E> {
	class Node {
		public E element;
		public Node prev;
		public Node next;

		public Node() {
			element = null;
			prev = null;
			next = null;
		}
	}

	private Node head = new Node();
	private Node tail = new Node();
	private int size;

	public SEIS602DblyLinkList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void addFirstNode(E e) {
		// Create the new node in memory
		Node n = new Node();

		// Save element contents
		n.element = e;

		// If size is 0
		if (this.size == 0) {
			// This is the head and tail
			this.head = n;
			this.tail = n;
		} else {
			// Point head to the first node
			n.next = this.head;
			this.head.prev = n;
			this.head = n;
		}

		// Update size
		this.size++;
	}

	public void addLastNode(E e) {
		// Create the new node in memory
		Node n = new Node();

		// Save element contents
		n.element = e;

		// If size is 0
		if (this.size == 0) {
			// This is the head and tail
			this.head = n;
			this.tail = n;
		} else {
			// Point tail to the last node
			n.prev = this.tail;
			this.tail.next = n;
			this.tail = n;
		}

		// Update size
		this.size++;
	}

	public E removeFirstNode() {
		E RetVal = null;
		if (size != 0) {
			RetVal = this.head.element;
			// Point head to next element cutting off connections with the old previous head
			this.head = this.head.next;
			this.head.prev = null;
			// Update size
			this.size--;
		}
		return RetVal;
	}

	public E removeLastNode() {
		E RetVal = null;
		if (size != 0) {
			RetVal = this.tail.element;
			// Point tail to previous element cutting off connections with the old previous
			// head
			this.tail = this.tail.prev;
			this.tail.next = null;
			// Update size
			this.size--;
		}
		return RetVal;
	}

	public E getLastNode() {
		return this.tail.element;
	}

	public E getFirstNode() {
		return this.head.element;
	}

	public void traverseForward() {
		Node test = this.head;
		
		//Print all nodes from head to tail
		for (int i = 0; i < this.size; i++) {
			System.out.print(test.element.toString());
			// Validate there is a next element, should never be an issue unless a memory error has occurred
			if (test.next != null) {
				test = test.next;
				// Comma separate values
				System.out.print(", ");
			}
		}
	}
	
	public void traverseBackwards() {
		Node test = this.tail;

		//Print all nodes from head to tail
		for (int i = (this.size - 1); i >= 0; i--) {
			System.out.print(test.element.toString());
			// Validate there is a previous element, should never be an issue unless a memory error has occurred
			if (test.prev != null) {
				test = test.prev;
				// Comma separate values
				System.out.print(", ");
			}
		}
	}
}
