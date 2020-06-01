import java.util.ArrayList;
import java.util.*;

/********************************
 * Graph.java	Author: Robert Walker
 * 
 * Purpose: Graph
 * *****************************/
public class Graph { 
	protected final int MAX_VERTS = 10;
	protected static Vertex vertexList[]; 
	protected static int adjMat[][];
	protected int nVerts;
	public static ArrayList <String> path;
	public static Stack<Integer> stack;
	//Constructor
	public Graph() { 
		adjMat = new int[MAX_VERTS][MAX_VERTS]; //Instantiate the matrix
		vertexList = new Vertex[MAX_VERTS]; //Instantiate the array to the same length
		for(int r = 0; r < adjMat.length; r ++) {
			for(int c = 0; c < adjMat[0].length; c ++) {
				adjMat[r][c] = 0; //Populate the matrix with 0s
			}
		}
		nVerts = 0;
	}
	
	//Adds a vertex
	public void addVertex(char lab) {
		Vertex vert = new Vertex (lab);
		vertexList[nVerts++] = new Vertex(lab);
		
	}
	
	
	//Adds an edge given two vertexes
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	//Prints out the given vertex label
	public void displayVertex(int inV) {
		System.out.println(vertexList[inV].toString());
	}
	
	
	//Prints out the matrix
	public void displayMat() {
		for(int r = 0; r < adjMat.length; r ++) {
			for(int c = 0; c < adjMat[0].length; c ++) {
				System.out.print(adjMat[r][c]);
			}
			System.out.println();
		}
	}
	
	
	//Search and spit
	public void mst(int inVert) { 
		int temp = 0;
		path = new ArrayList<String>(); //Path Array list
		stack = new Stack<>(); //Vertex Stack of ints
		stack.push(inVert); //Push the input vertex
		while(!stack.isEmpty()) { //While untested vertexes remain
			temp = stack.pop(); //Pop and set
			vertexList[temp].visited = true; //Mark it visited
			for(int c = 0; c < adjMat[0].length; c ++) {
					if(adjMat[temp][c] == 1 && vertexList[c].visited == false ) {
						path.add( vertexList[temp].label+ "" + vertexList[c].label);
						stack.push(c); //Push to the stack
						vertexList[c].visited = true; 
					}
			}
		}
		for(int i = 0; i < path.size();i ++) { // Print it out
			System.out.println(path.get(i));
		}
	}
}
