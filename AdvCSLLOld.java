/*************************
 * AdvCSLL.java Author: Robert Walker
 * Purpose: Implementation of a linked list.
 *************************/

import java.util.ArrayList;

public class AdvCSLLOld<T> {
	LLNode head;

	// Constructor; instantiates head.
	public AdvCSLLOld() {
		head = null;
		//head = new LLNode(null, null);
	}
	 

	public T removeFirst() {
//		if(head.next == null) { 
//			return "Empty";
//		}
		
//			
		if(head == null) {
			return null;
		}
		else {
			
			T result = head.t;
			if(head.next != null) {
				head = head.next;
			}
			else {
				head = null;
			}
			return result;
		} 
	}
	// Adds a node to the list.
	public void add(T t) {
		// If the list is empty, add the node at the first location.
		if (head == null) {
			LLNode newNode = new LLNode(null, t);
			head = newNode;
		}
		// Else add at the end of the list.
		else {
			LLNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			LLNode newNode = new LLNode(null, t);
			temp.next = newNode;

		}
	}

	// Searches for and removes a given node.
	public String remove(T inT) {
		LLNode temp = head;
		
		// If head doesn't reference anything, the list is empty.
		if (temp == null) {
			return "Empty list"; 
 
		} else {
			while (temp.next != null) {
				temp = temp.next;
				if (temp.next.t == inT) {
					String result = inT + "";
					temp.next = temp.next.next;
					return result;
				}
				else {
					return "Not found";
				}
			}
			return "Not found";
		}
		//return "Not in  list";
	
	}

	// Prints out the list.
	public String toString() {
		String result = "";
		LLNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
			result = result + temp.t + " ";
		}
		return result;
	}

	// Returns if the list contains a specific node.
	public Boolean contains(T inT) {
		LLNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
			if (temp.t == inT) {
				return true;
			}
		}
		return false;

	}

	// Empties the list by clearing head's reference.
	public void clear() {
		head= null;
	}

	// Returns if the list is empty.
	public Boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	// LLNode Nested Class
	public class LLNode {
		public LLNode next;
		public T t;

		// Constructor
		public LLNode(LLNode inNext, T inT) {
			t = inT;
			next = inNext;
		}
	}
}
