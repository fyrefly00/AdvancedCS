
public interface GenQueueInterface<T> {
	//Add item  to the queue.
		public void enqueue(T t);
		
		//Remove one item from the stack and print it
		public T dequeue();
		
		// Return top item in the stack
		public T peek();
		
		// Return true or false if stack is empty
		public boolean isEmpty(); 

}
