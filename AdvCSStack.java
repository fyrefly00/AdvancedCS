/****************************
 * AdvCSSstack.java	Author: Robert Walker
 * 
 * Purpose: Implementation of generic type stack.
 *****************************/

import java.util.ArrayList;

public class AdvCSStack<T> implements GenStackInterface<T> {
	
	//Constructor
	public AdvCSStack() {
	}

	ArrayList<T> stackPrep = new ArrayList <>(); //Stack ArrayList
 
	// Adds item T to ArrayList
	public void push(T t) {
		stackPrep.add(t);
	}
	
	// Remove and return top item in the stack
	public T pop() {
		//T t = stackPrep.get(stackPrep.size() -1);
	   return  stackPrep.remove((stackPrep.size()-1));
		//return t;
	}
	
	// Return top item in the stack
	public T peek() {
		return stackPrep.get(stackPrep.size()-1);
	}
	
	//Returns true or false if stack is empty
	public boolean isEmpty() {
		return stackPrep.isEmpty();
	}
	public String toString() {
		String output =  stackPrep.size()-1 + " ";
		return output;
	}
}

