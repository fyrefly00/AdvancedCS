

public class HeapDriver2<T>  {
	public static heapNode[] heap;
	static int numInputs;
	
	public HeapDriver2(int numInputs) {
		heap = new heapNode[numInputs];
	}
	
	//Add
	public void add(int inPriority, T inData) {
		int n = 0; //Set the position, which is the level of the tree
		if(heap[0] == null) {  //If heap is empty
			heap [0] = new heapNode<T> (inPriority, inData);
		}
		else {
			while(heap[n] != null) { //Cycle down the array
				n ++;
				
			}
			heap[n] = new heapNode<T> (inPriority, inData); //Set the empty space to the values
			trickleUp(n); //Trickle it
		}
		
		
		
	}
	public void trickleUp(int x) {
			if(heap[x - 1 /2].priority < heap[x].priority) { //If the node is in the wrong spot
				while(heap[x - 1 /2].priority < heap[x].priority) { //While it's in the wrong spot
					heapNode<T> holder = new heapNode(heap[x].priority, heap[x].data); //Make a holder
					heap[x] = heap[x - 1 /2]; //Copy up
					heap[x - 1/2] = holder; //Copy down
					x = x - 1 /2;
				
			}
			}
			else {
				return;
			}
		
	}
	
	public static void remove() {
		System.out.println("2");
		int x = 0;
		while(heap[x] != null) {
			x ++;
		}
		heap[0] = heap[x - 1];
		heap[x  - 1] = null;
		trickleDown(0);
	}
	
	public static void trickleDown(int x) {
		
		if(2 * x + 2 > heap.length) {
			return;
		}
		if(heap[2 * x + 1] != null && heap[2 * x + 2] != null ) {
			if(heap[2 * x + 1].priority > heap[2 * x + 2].priority) {
				heapNode temp = new heapNode(heap[x].priority, heap[x].data);
				heap[x] = heap[2 * x + 1];
				heap[2 * x + 1] = temp;
				x = x * 2 + 1;
				trickleDown(x);
			}
			else {
				heapNode temp = new heapNode(heap[x].priority, heap[x].data);
				heap[x] = heap[2 * x + 2];
				heap[2 * x +2] = temp;
				x = x * 2 + 2;
				trickleDown(x);
			}
		}
		else if(heap[2 * x + 1] != null && heap[2 * x + 1].priority > heap[x].priority) {
			heapNode temp = new heapNode(heap[x].priority, heap[x].data);
			heap[x] = heap[2 * x + 1];
			heap[2 * x + 1] = temp;
			
		}

	}
		
	//I wonder what this method does?
	public  String toString() { 
		String string = "";
		for(int i = 0; i < heap.length; i ++) {
			if(heap[i] != null) {
				string = string + heap[i].data + " ";
			}
		}
		return string;
	}
	public static class heapNode <T> {
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
