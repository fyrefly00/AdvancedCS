import java.util.*;


public class Random_Mouse {
	public static int [][] maze;
	static ArrayList<cell> path = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		long startTime = System.nanoTime();
		maze = SolveMazeDFS.readMaze();
		SolveMazeDFS.printMaze(maze);  
		path = solveMaze(0,0, maze); 
		System.out.println();
		SolveMazeDFS.printMaze(maze); 
		System.out.println();
		for(int i = 0; i < path.size(); i ++) {
			System.out.print(path.get(i));
		}

		System.out.println();
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		totalTime = totalTime / 1000000;
		System.out.println(totalTime);
	}
	public static ArrayList<cell> solveMaze(int inR, int inC, int inMaze[][]) {
		int r = inR;
		int c = inC;
		int maze[][] = inMaze;
		cell cellHolder = new cell(r, c);
		while(maze[r][c]!= 2) {
			int rand = randInt(0,4);
			if(rand == 0) { 
				if(isInBounds(r+1,c)) {
					r = r + 1;
					path.add(new cell(r,c));
					maze[r][c] = 7;
				}  
				else {
					continue; 
				}
			}
			else if(rand == 1) {
				if(isInBounds(r - 1,c)) {
					r = r- 1;
					path.add(new cell(r,c));
					maze[r][c] = 7;
				}
				else {
					continue;
				}
			}
			else if(rand == 2) {
				if(isInBounds(r, c +1) ) {
					c = c +1;
					path.add(new cell(r,c));
					//maze[r][c] = 7;
				}
				else {
					continue;
				}
			}
			else if(rand == 3) {
				if(isInBounds(r, c - 1) ) {
					c = c - 1;
					path.add(new cell(r,c));
					maze[r][c] = 7;
				}
				else {
					continue;
				}
			}
		
			
		
		}
		return path;
 		
	}
	public static boolean isInBounds(int inR, int inC) {
		int r = inR; int c = inC;
		if(r < 0 || r > maze.length - 1 || c < 0 || c > maze[0].length -1  || maze[r][c] == 0) {
			 return false;}
		 else {
			 return true;}
	}
	public static int randInt(int min, int max) {
	
		
		 Random rand = new Random();
		 int randomNum = rand.nextInt((max - min) + 1) + min;
		 return randomNum;
	} 
	
	
	
	
	static class cell { 
		 int numC;
		 int numR;
		 public cell(int r, int c) {
			 numR = r;
			 numC = c;
			 }
		
		 
		 public int getR() {
			return numR;}
		
		 public int getC() {
			 return numC;}
		 //Returns the Parent Cell
		
		 
		 public String toString() {
			String output = "(" + numR + ", " + numC+ ")";
			return output;}
	 }


}
