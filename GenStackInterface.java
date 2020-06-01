/****************************
 * GenStackInterface.java	Author: Robert Walker
 * 
 * Purpose: Interface for a stack of any type.
 *****************************/
public interface GenStackInterface<T> {
	//Add an integer to the stack
	public void push(T t);
	
	//Remove one integer from the stack and print it
	public T pop();
	
	// Return top integer in the stack
	public T peek();
	
	// Return true or false if stack is empty
	public boolean isEmpty(); 
}
