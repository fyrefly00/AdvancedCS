/*************************
 * AdvCSQueue.java Author:Robert Walker
 * 
 * Purpose: Implements a queue.
 ************************/
import java.util.ArrayList;

public class AdvCSQueue<T> implements GenQueueInterface<T> {
	ArrayList<T> queuePrep;
	
	//Constructor
	public AdvCSQueue() {
		queuePrep = new ArrayList <>(); //Queue ArrayList
	}
	
	//Enqueue to end of queue
	public void enqueue(T t) {
		queuePrep.add(0, t);
	}
	
	//Dequeue first element.
	public T dequeue() {
		 return  queuePrep.remove((queuePrep.size()-1));
	} 
	
	//Return front element.
	public T peek() {
		return queuePrep.get(queuePrep.size()-1);
	}
	

	public boolean isEmpty() {
		return queuePrep.isEmpty();
	}
	
}
