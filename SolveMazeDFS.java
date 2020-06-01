/*******************
 * SolveMazeDFS.java	Author: Robert Walker
 * 
 * Purpose: Solves a maze. Version 3 of 3 with fixed stacking.
 *******************/

import java.io.File;
import java.util.*;
 class SolveMazeDFS {
	 public static int numCol = 0; 
	 public static int numRow = 0;
	 public static int r = 0;
	 public static int c = 0;
	 public static AdvCSStack<SolveMazeDFS.cell> stack; 
	 public static int[][]maze;
	// public final VISITED = 7;
	 public static void main(String[] arg) throws Exception  {
		 long startTime = System.nanoTime();
		 maze = readMaze();
		 System.out.println(numRow + " " + numCol);
		// printMaze(maze);
		 solveMaze();

		 System.out.println();
		 long endTime = System.nanoTime();
		 long totalTime = endTime - startTime;
		 totalTime = totalTime;
		 System.out.println(totalTime);
	 }
	
	 public static void solveMaze() {
		stack = new AdvCSStack<>();
		 cell cellHolder = new cell(0, 0); 
		 stack.push(cellHolder);
		 maze [0][0] = 7;//Sets first square to 7.
		 //While the cell does not equal 2
		 while(maze[r][c] != 2) {
			 //Pop the stack to set the cell, and set r and c to those values.
			// System.out.println(stack.isEmpty());
			 if(!stack.isEmpty()) {
				 cellHolder = stack.peek();
			 }
			
		
			 r = cellHolder.getR();
			 c = cellHolder.getC();
			// If Row +1 and c isInBounds and resulting cell does not equal 0 or 7.
			 if(isInBounds(r+1, c) == true && maze[r+1][c] != 0 && maze[r+ 1][c] != 7) {
				 r = r + 1;
				 if(maze[r][c] == 1) {
					 maze[r][c] = 7;
					 cellHolder = new cell(r,c);
					 stack.push(cellHolder);
					 continue;
				 }
				 else if(maze[r][c] == 2) {
					 cellHolder = new cell(r,c);
					 stack.push(cellHolder);
					 break;
				 }
			
			 }
			 
			// If Row -1 and c isInBounds and resulting cell does not equal 0 or 7.
			 if(isInBounds(r-1, c) == true && maze[r-1][c] != 0 && maze[r- 1][c] != 7) {
				 r = r - 1;
				 if(maze[r][c] == 1) {
					 maze[r][c] = 7;
					 cellHolder = new cell(r,c);
					 stack.push(cellHolder);
					 continue;
				 }
				 
				 else if(maze[r][c] == 2) {
					 cellHolder = new cell(r,c);
					 stack.push(cellHolder);
					 break;
				 }
				
			 }
			 
			// If Row and c + 1 isInBounds and resulting cell does not equal 0 or 7.
			 if(isInBounds(r, c + 1) == true && maze[r][c+ 1] != 0 && maze[r][c+ 1] != 7) {
				 c = c + 1;
				 if(maze[r][c] == 1) {
					 maze[r][c] = 7;
					 cellHolder = new cell(r,c );
					 stack.push(cellHolder);
					 continue;
				 }
				 else if(maze[r][c] == 2) {
					 cellHolder = new cell(r,c);
					 stack.push(cellHolder);
					 break;
				 }
				 
			 }
			 
			// If Row and c - 1 isInBounds and resulting cell does not equal 0 or 7.
			 if(isInBounds(r, c - 1) == true && maze[r][c- 1] != 0 && maze[r][c-1] != 7) {
				 c = c - 1;
				 if(maze[r][c] == 1) {
					 maze[r][c] = 7;
					 cellHolder = new cell(r,c);
					 stack.push(cellHolder);
					 continue;
				 }
				 else if(maze[r][c] == 2) {
					 cellHolder = new cell(r,c);
					 stack.push(cellHolder);
					 break;
				 }
			

			 }
			 else {
				
				 stack.pop();
			 }
		}
		 
//		 //Prints maze and coordinates
//		System.out.println();
//		printMaze(maze); 
//		System.out.println();
//		String output = "";
//		while(!stack.isEmpty()) {
//			output = "" + stack.pop().toString() + output;
//		}
//		System.out.println(output); 
	 }
	 
	//Reads maze from file and prints it
	 public static int [][] readMaze() throws Exception{
		 Scanner fs = new Scanner(new File("src/maze.txt"));
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
	 
	 // Returns true if r and c are in bounds.
	 public static boolean isInBounds(int r, int c) {
		 if(r < 0 || r > numRow -1 || c < 0 || c > numCol - 1) {
			 return false;
			
		  }
		 else {
	return true;
		 }
	
	 }
	 
	 //Prints the maze.
	 public static void printMaze(int[][] maze)  {
		 for(int r = 0; r < numRow; r ++) {
				System.out.println();
				for(int c = 0; c < numCol; c ++) {
						System.out.print(maze[r][c]);
				} 
			
			 
		 }
	 }

	 static class cell { 
		 int numC;
		 int numR;
		
		 public cell(int r, int c) {
			 numR = r;
			 numC = c;
			 
			
		 }
		 public int getR() {
			return numR;
		 }
		 public int getC() {
			 return numC;
		 }
		 public String toString() {
			String output = "(" + numR + ", " + numC + ") ";
			return output;
		 }
		 
	 }
	
 }

