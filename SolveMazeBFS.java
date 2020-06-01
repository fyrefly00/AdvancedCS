import java.io.File;
import java.util.Scanner;

/*****************************
 * SolveMazeBFS.java	Author: Robert Walker
 * Purpose: Implementation of BFS.
 ****************************/
public class SolveMazeBFS {	
	public static int [][] maze; 
	public static AdvCSQueue<cell> queue;
	public final static int VISITED = 7; 
	public static int numRow;
	public static int numCol;
	public static void main(String[] args) throws Exception {
		long startTime = System.nanoTime();
		maze = readMaze(); 
		//SolveMazeDFS.printMaze(maze); 
		int numRow = maze.length;
		int numCol = maze[0].length; 
		cell parentCell = new cell (0,0, null);
		cell finalCell  = solveMaze(numRow,numCol, parentCell); //Final cell equals the output of solveMaze
		System.out.println();
	//	SolveMazeDFS.printMaze(maze); 
		System.out.println();
		String output = "";
		while(finalCell.getParentCell() != null) { //Loop until all cells are printed (final cell  = null).
			output = finalCell.toString() + " " + output;
			finalCell = finalCell.getParentCell();}
		System.out.println(output);

System.out.println();
long endTime = System.nanoTime();
long totalTime = endTime - startTime;
totalTime = totalTime / 1000000;
System.out.println(totalTime);
	
		}
	
	
	public static cell solveMaze(int inRow, int inCol, cell parentCell) {
		int r = 0; int c = 0;
		queue = new AdvCSQueue<>();
		int numRow = inRow; int numCol = inCol;
		cell cellHolder = new cell(0, 0, parentCell);
		queue.enqueue(cellHolder); 
		
		while(!queue.isEmpty() && maze[r][c] != 2) {  
			cellHolder = queue.dequeue();
			r = cellHolder.getR();  
			c = cellHolder.getC(); 
			parentCell = cellHolder;
			if(maze[r][c] != 2) { //Don't mark the last cell as a 7.
				maze[r][c] = VISITED;}
			
			if(isInBounds(r + 1,c)) {
				queue.enqueue(new cell(r + 1, c, parentCell));}
			
			if (isInBounds(r, c + 1)) {
				queue.enqueue(new cell(r , c + 1, parentCell));}
		
			if(isInBounds(r - 1, c)) {
				queue.enqueue(new cell(r - 1, c, parentCell));}
				
			if(isInBounds(r, c - 1)) {
				 queue.enqueue(new cell(r , c - 1, parentCell));}
			}
		return cellHolder;
	}
	//Returns false if is out of bounds or is 7 or 0.
	public static boolean isInBounds(int inR, int inC) {
		int r = inR; int c = inC;
		if(r < 0 || r > maze.length - 1 || c < 0 || c > maze[0].length -1 || maze[r][c] == 7 || maze[r][c] == 0) {
			 return false;}
		 else {
			 return true;}
	}
	
	 static class cell { 
		 int numC;
		 int numR;
		 cell parentCell;
		 public cell(int r, int c, cell parentCell) {
			 numR = r;
			 numC = c;
			 this.parentCell = parentCell;}
		 
		 public int getR() {
			return numR;}
		
		 public int getC() {
			 return numC;}
		 //Returns the Parent Cell
		 public cell getParentCell() {
			 return parentCell;}
		 
		 public String toString() {
			String output = "(" + numR + ", " + numC+ ")";
			return output;}
	 }
	 public static int [][] readMaze() throws Exception{
		 Scanner fs = new Scanner(new File("src/maze50005000"));
		 Scanner ls = new Scanner(fs.nextLine());
		 numRow = ls.nextInt(); numCol = ls.nextInt();
		// int numRow = ls.nextInt(), numCol = ls.nextInt();
		 int [][] maze = new int [numRow][numCol];
		 
		  for(int r = 0; r < numRow; r ++) {
			for(int c = 0; c < numCol; c ++) {
				maze [r][c] = fs.nextInt();
			}
		  }
		 return maze;
	 }
}

