/****************************
 * IntStackInterface.java	Author: Robert Walker
 * 
 * Purpose: Inteface for a stack
 *****************************/


public interface IntStackInterface {
	public void push(int x); //Add an integer to the stack
	public int pop(); //Remove one integer from the stack and print it
	public int peek(); // Return top integer in the stack
	public boolean isEmpty(); // Return true or false if stack is empty
}