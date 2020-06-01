
import java.io.File;
import java.util.Scanner;

public class SolveMazeBFS2 {

	private static int[][] array;
	private static AdvCSQueue<Cell> queue = new AdvCSQueue<Cell>();
	
	public static void main(String[] args) throws Exception {
		SolveMazeDFS.readMaze();
		SolveMazeDFS.printMaze(array);
		solveMaze();
		
		// Reverses queue returned by solveMaze();
		AdvCSQueue<Cell> reverse = new AdvCSQueue<Cell>();
		while (!(queue.isEmpty()))
		{
			reverse.enqueue(queue.dequeue());
		}
		
		// Prints queue
		while (!(reverse.isEmpty()))
		{
			System.out.print("(" + reverse.peek().row);
			System.out.print("," + reverse.peek().col + ")");
			System.out.print(" ");
			reverse.dequeue();
		}
	}
	
	static class Cell {
		int row, col;
		Cell cell;
		
		public Cell(int row_, int col_, Cell cell_)
		{
			row = row_;
			col = col_;
			cell = cell_;
		}
	}
	
	
	public static AdvCSQueue solveMaze()
	{
		// enqueues the initial position of 0,0 to the queue
		queue.enqueue(new Cell(0,0, null));
		Cell cur = new Cell(0,0, null);
		
	
	while(array[queue.peek().row][queue.peek().col] != 2 && (!queue.isEmpty()))
		{	
			placeVisits(queue.peek().row, queue.peek().col);
			cur = new Cell(queue.peek().row, queue.peek().col, cur);
			if (queue.peek().row + 1 < array.length && ifPossible(queue.peek().row + 1, queue.peek().col))
			{
					queue.enqueue(new Cell(queue.peek().row + 1, queue.peek().col, cur));
			}
			if (queue.peek().row - 1 >= 0 && ifPossible(queue.peek().row - 1, queue.peek().col)) 
			{
					queue.enqueue(new Cell(queue.peek().row - 1, queue.peek().col, cur));
			}
			if (queue.peek().col + 1 < array[0].length && ifPossible(queue.peek().row, queue.peek().col + 1))
				{
						queue.enqueue(new Cell(queue.peek().row, queue.peek().col + 1, cur));
				}
			if (queue.peek().col - 1 >= 0 && ifPossible(queue.peek().row, queue.peek().col - 1)) 
			{
					queue.enqueue(new Cell(queue.peek().row, queue.peek().col - 1, cur));	
			}
			else 
			{
				queue.dequeue();
			}	
		}
		// Prints out the solved array
		for (int r = 0; r < array.length; r++)
		{
			System.out.println();
			for(int c = 0; c < array[0].length; c++)
			{
				System.out.print(array[r][c]);
			}
		}
		System.out.println();
		return queue;
	}
	
	// Checks to see, based off the maze's rules, whether or not the object can
	// move to a position. 
	public static boolean ifPossible(int row, int col)
	{
		if (array[row][col] == 1 || array[row][col] == 2)
			return true;
		else
			return false;
	}
	
	// A method to replace the current position with a 7 to show it was visited.
	public static void placeVisits(int row, int col)
	{
		array[row][col] = 7;
	}
}