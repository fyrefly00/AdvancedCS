/****************************
 * AdvCSHeap.java	Author: Robert Walker
 * 
 * Purpose: Heap
 ***************************/

import java.util.Scanner;

public class AdvCSHeap<T> {
	public static heapNode[] heap;
	static int numInputs;

	public AdvCSHeap(int numInputs) {
		heap = new heapNode[numInputs]; //Builds array given input
	}

	// Add
	public void add(int inPriority, T inData) {
		int n = 0; // Set the position, which is the level of the tree
		if (heap[0] == null) { // If heap is empty
			heap[0] = new heapNode<T>(inPriority, inData);
		} 
		else {
			while (heap[n] != null) { // Cycle down the array
				n++;
			}
			heap[n] = new heapNode<T>(inPriority, inData); // Set the empty space to the values
			trickleUp(n); // Trickle it
		}
	}

	public void trickleUp(int x) {
		int val = x - 1 ; //Set value as the parent
		val = val / 2;
		if (heap[val].priority < heap[x].priority) { // If the node is in the wrong spot
			while (heap[val].priority < heap[x].priority) { // While it's in the wrong spot
				heapNode<T> holder = new heapNode(heap[x].priority, heap[x].data); // Make a holder
				heap[x] = heap[val]; // Copy up
				heap[val] = holder; // Copy down
				x = x - 1; //Update x and val
				x = x / 2;
				val = x - 1;
				val = val / 2;
			}
		} 
		else {
			return;
		}

	}

	public static void remove() {
		int x = 0;
		while (heap[x] != null) { //Find the last value
			x++;
		}
		heap[0] = heap[x - 1]; //Set it as root
		heap[x - 1] = null; //Remove old spot
		trickleDown(0);
	}

	public static void trickleDown(int x) {
		int val = 2 * x;
		val = val + 2; //Set val as right child (update -1 on the fly)

		if (val > heap.length) { //If it's out of bounds, exit
			return;
		}
		if (heap[val - 1] != null && heap[val] != null) { //If there are both  a right and left child
			if (heap[val - 1].priority > heap[val].priority) { //If left is greater than right
				heapNode temp = new heapNode(heap[x].priority, heap[x].data);
				heap[x] = heap[val - 1];
				heap[val - 1] = temp;
				x = x * 2;
				x = x + 1;
				trickleDown(x);
			} 
			else { //If right is greater than left
				heapNode temp = new heapNode(heap[x].priority, heap[x].data);
				heap[x] = heap[val];
				heap[val] = temp;
				x = x * 2;
				x = x + 2;
				trickleDown(x);
			}
		} 
		else if (heap[val - 1] != null && heap[val - 1].priority > heap[x].priority) { //Else if there is one left child
			heapNode temp = new heapNode(heap[x].priority, heap[x].data);
			heap[x] = heap[val - 1];
			heap[val - 1] = temp;

		}

	}

	public String toString() {
		String string = "";
		for (int i = 0; i < heap.length; i++) {
			if (heap[i] != null) {
				string = string + heap[i].data + " ";
			}
		}
		return string;
	}

	public static class heapNode<T> {
		public int priority;
		public T data;
		public heapNode leftChild;
		public heapNode rightChild;

		public heapNode(int inPriority, T inData) {
			priority = inPriority;
			data = inData;
		}

	}
}
