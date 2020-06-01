
/**********************************
 * WGraph4.java	Author: Robert Walker
 * 
 * Purpose: Weighted Graph with MST and Dijkstra
 **********************************/
import java.util.*;
import java.util.ArrayList;

public class WGraph4 extends Graph {
	public static PriorityQueue<Edge> pq;
	public static ArrayList<String> path2;
	public static DistPar[] sPath;

	// Constructor
	public WGraph4() {
		pq = new PriorityQueue<>();
		path = new ArrayList<String>();

		for (int i = 0; i < adjMat.length; i++) { // Populate the 2D array to zeroes
			for (int j = 0; j < adjMat[0].length; j++) {
				adjMat[i][j] = 0;
			}
		}
		for (int i = 0; i < vertexList.length; i++) {
			vertexList[i] = new Vertex('~');
		}
	}

	public void addEdge(int orig, int dest, int weight) { // Add the weight into adjMat
		Edge edge = new Edge(weight, orig, dest);
		adjMat[orig][dest] = weight;
		adjMat[dest][orig] = weight;
	}

	// Weighed Edge Class
	public static class Edge implements Comparable<Edge> {
		int weight;
		int originVertex;
		int destinationVertex;

		public Edge(int inWeight, int inO, int inD) {
			weight = inWeight;
			originVertex = inO;
			destinationVertex = inD;
		}

		@Override
		// CompareTo Method. Should return 1 if the in weight is less.
		public int compareTo(Edge arg0) {
			return weight - arg0.weight;
		}
	}

	// MST
	public void mst4(int inOrig) {
		Vertex vert = vertexList[inOrig];
		for (int i = 0; i < adjMat[0].length; i++) { // Find all the edges of the first vertex and try to add them
			if (adjMat[inOrig][i] > 0) {
				tryToInsert2(inOrig, i, adjMat[inOrig][i]);
			}
		}
		while (!pq.isEmpty()) {
			Edge temp = pq.poll(); // Deque the lowest edge and set it's destination vertex as the new vertex
			int dest = temp.destinationVertex;
			vert = vertexList[dest];
			path.add(temp.originVertex + " " + dest);
			vertexList[temp.originVertex].visited = true; // Mark both vertices visited
			vertexList[dest].visited = true;
			for (int i = 0; i < adjMat[0].length; i++) { // Find all edges
				if (adjMat[dest][i] > 0 && vertexList[i].visited == false) { // If the destination is visited, don't add
																				// it.
					tryToInsert2(dest, i, adjMat[dest][i]);
				}
			}
		}
		for (int i = 0; i < path.size(); i++) { // Print the path
			System.out.println(path.get(i));
		}
	}

	// TryToInsert
	public static void tryToInsert2(int orig, int dest, int weight) {
		Object[] vArr = pq.toArray(); // Break the priority queue into an array

		for (int i = 0; i < vArr.length; i++) {
			Edge curE = (Edge) vArr[i];
			if (dest == curE.destinationVertex && weight < curE.weight) { // If the dests are the same but the weights
																			// are lower
				pq.remove(curE);
				pq.add(new Edge(weight, orig, dest));
				return;
			} else if (dest == curE.destinationVertex && weight > curE.weight) { // If the dests are the same but the
																					// weight is higher
				return;
			}

		}
		pq.add(new Edge(weight, orig, dest));

	}

	public static class DistPar {
		public int distance;
		public int parentVert;

		public DistPar(int pv, int d) {
			distance = d;
			parentVert = pv;
		}
	}

	public static void path(int orig, int dest) {
		int temp = orig;
		sPath = new DistPar[vertexList.length];
		for (int i = 0; i < sPath.length; i++) { // Initialize sPath to DistPars with no parent and infinite cost
			sPath[i] = new DistPar(-1, Integer.MAX_VALUE);
		}

		sPath[orig] = new DistPar(0, 0); // Set the origin in sPath

		vertexList[orig].visited = true; // Visit the origin

		for (int r = 0; r < adjMat[0].length; r++) { // Find the first edges of the origin
			if (adjMat[orig][r] > 0 && adjMat[orig][r] < Integer.MAX_VALUE) {
				sPath[r] = new DistPar(orig, adjMat[orig][r]);
			}
		}

		while (temp != dest) {
			temp = getMin(); // Get minimum value
			vertexList[temp].visited = true; // Visit it
			adjustPath(temp); // Adjust the path given the new vertex
		}

		// Code to print the solution
		String finalPath = "";
		finalPath = vertexList[dest].label + finalPath;
		DistPar t = sPath[dest];
		System.out.println(vertexList[dest]);
		while (t.parentVert != orig) {
			finalPath = vertexList[t.parentVert].label + finalPath;
			t = sPath[t.parentVert];
		}
		finalPath = vertexList[orig].label + finalPath;
		System.out.println(finalPath);
		System.out.println("Cost from origin to destination: " + sPath[dest].distance);
	}

	// Returns the minum value in sPath
	public static int getMin() {
		int i = 0;
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for (i = 0; i < sPath.length; i++) {
			if (sPath[i].distance < min && vertexList[i].visited == false) {
				min = sPath[i].distance;
				minIndex = i;
			}
		}
		return minIndex;
	}

	// Adjusts the cost in sPath from the new vertex
	public static void adjustPath(int cur) {

		for (int i = 0; i < adjMat[0].length; i++) {
			if (adjMat[cur][i] > 0) { // If there is an avaliable edge, check if it's cheaper to go through the
										// current vertex
				if (sPath[i].distance > sPath[cur].distance + adjMat[cur][i]) {
					sPath[i].parentVert = cur;
					sPath[i].distance = sPath[cur].distance + adjMat[cur][i];
				}
			}
		}
	}

}