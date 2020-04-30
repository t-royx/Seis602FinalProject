
public interface ISEIS602Stack<E> {
	// Adds the specified element to the top of the stack.
	void add(E e);

	// Returns a reference to the top element of this stack without removing it.
	E peek();

	// Removes and returns the top element from the stack.
	E pop();

	// Adds the specified element to the top of the stack.
	void push(E e);

	// Returns the number of elements in the stack.
	int size();
}
