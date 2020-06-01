/**********************
 *Vertex.java Author: Robert Walker
 * 
 *Purpose: Vertex for Graph
 ************************/
public class Vertex {
	public char label;
	public boolean visited;
	
	public Vertex(char lab) {
		label = lab; 
		visited = false;
	}


	public String toString() {
		return label + "";
	}
	
}
