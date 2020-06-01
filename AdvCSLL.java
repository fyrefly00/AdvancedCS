
/*************************
 * AdvCSLL.java Author: Robert Walker
 * Purpose: Implementation of a linked list.
 *************************/

import java.util.ArrayList;

public class AdvCSLL<T> {
	LLNode head;

	// Constructor; instantiates head.
	public AdvCSLL() {
		head = new LLNode(null, null);
	}
	public T removeFirst() {
		if(head.next == null) {
			return null;
		} 
		else if(head.next.next != null) {
			T result = head.next.t;
			head.next = head.next.next;
			return result;
		}
		else if(head.next.next == null) {
			T result = head.next.t;
			head.next = null;
			return result;
		}
		else {
			return null;
		}
	
	}

	// Adds a node to the list.
	public void add(T t) {
		// If the list is empty, add the node at the first location.
		if (head.next == null) {
			LLNode newNode = new LLNode(null, t);
			head.next = newNode;
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
		if (temp.next == null) {
			return "Empty list";

		} else {
			while (temp.next != null) {
				//temp = temp.next;
				if (temp.next.t == inT) {
					String result = inT + "";
					temp.next = temp.next.next;
					return result;
				} 
				else {
					temp = temp.next;
				}
			}
			return "Not found";
		}
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
		head.next = null;
	}

	// Returns if the list is empty.
	public Boolean isEmpty() {
		if (head.next == null) {
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