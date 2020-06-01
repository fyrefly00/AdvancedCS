import java.util.*;

public class WGraph extends Graph {
	public static ArrayList<Edge> edgeList;
	public static PriorityQueue <Edge> pq;
	public static ArrayList<String> path;
	public static ArrayList<String> path2;
	public WGraph() {
		pq = new PriorityQueue<>();
		path = new ArrayList<String>();
		for(int i = 0; i < adjMat.length; i ++) {
			for(int j = 0; j < adjMat[0].length; j ++) {
				adjMat[i][j] = 0;
			}
		}
	}
	
	public void addEdge(int orig, int dest, int weight) {
		Edge edge = new Edge(weight, orig, dest);
		adjMat[orig][dest] = weight;
		adjMat[dest][orig] = weight;
	}
	

	public static class Edge implements Comparable<Edge> {
		int weight;
		static int originVertex;
		int destinationVertex;
		
		public Edge(int inWeight, int inO, int inD) {
			weight = inWeight;
			originVertex = inO;
			destinationVertex = inD;
		}

		@Override
		public int compareTo(Edge arg0) {
			int inWeight1 = arg0.weight;
			if(inWeight1 < weight) {
				return -1;
			}
			if(inWeight1 > weight) { 
				return 1;
			}
			else {
				return 0;
			}
		}
		

		
	}
	public static void mst2(int inOrig) { 
		Vertex temp = vertexList[inOrig];
		for(int i = 0; i < adjMat[0].length; i ++) {
			if(adjMat[inOrig][i] > 0) {
//				tryToInsert2(inOrig, i,adjMat[inOrig][i]);
				tryToInsert2(inOrig, i,adjMat[inOrig][i]);
			//	pq.add(new Edge(adjMat[inOrig][i], inOrig, i));
			} //&& vertexList[pq.peek().originVertex].visited == false&& vertexList[pq.peek().destinationVertex].visited == false
		} //&& vertexList[pq.peek().originVertex].visited == false
		while(!pq.isEmpty() ) {
			//if(!path.contains(vertexList[pq.peek().originVertex] + " " + vertexList[pq.peek().destinationVertex] )) {
				Edge tempE = pq.poll();
				temp = vertexList[tempE.originVertex];
				vertexList[tempE.destinationVertex].visited = true;
				vertexList[tempE.originVertex].visited = true;
				for(int i = 0; i < adjMat[0].length; i ++) {
					if(adjMat[tempE.destinationVertex][i] > 0 && vertexList[i].visited == false ) { 
						//System.out.println("Trying" + tempE.originVertex + " " + i);
						vertexList[tempE.destinationVertex].visited = true;
						tryToInsert2(tempE.destinationVertex, i,adjMat[tempE.destinationVertex][i]);
					}
				}
	//	}
		}
		for(int i = 0; i < vertexList.length; i ++) {
			System.out.println( vertexList[i]);
		}
		for(int i = 0; i < path.size(); i ++) {
			System.out.println(path.get(i));
		}
		
		
	}
	public static void tryToInsert2(int orig, int dest, int weight) {
		Object [] vArr = pq.toArray();
		
		for(int i = 0; i < vArr.length; i ++) {
			Edge curE = (Edge) vArr[i];
			if(vertexList[orig].visited == true && vertexList[dest].visited == true) {
				return;
			}
			else if(dest == curE.destinationVertex && weight < curE.weight) {
				pq.poll();
				pq.add(new Edge(weight, orig, dest));
				vertexList[orig].visited = true;
//			vertexList[dest].visited = true;
				path.add(orig + " " + dest);
				System.out.println(orig + " "+ dest);
				return;
			}
			else if( dest == curE.destinationVertex && weight > curE.weight) {
				return;
			}
//			else {
//				pq.add(new Edge(weight, orig, dest));
//				System.out.println(orig + " "+ dest);
//			}
			
		}
		pq.add(new Edge(weight, orig, dest));
		vertexList[orig].visited = true;
//		vertexList[dest].visited = true;
		path.add(orig + " " + dest);
		System.out.println(orig + " "+ dest + " " + weight);
	}
	

	public static void mst3(int orig) {
		path2 = new ArrayList<String>();
		Vertex tempV = vertexList[orig];
		path2.add(vertexList[orig] + " ");
		for(int i = 0; i < adjMat[0].length; i ++) {
			if(adjMat[orig][i] > 0) {
				tryToInsert3(orig, i, adjMat[orig][i]);
			}
		}
		while(!pq.isEmpty()) {
			Edge temp = pq.poll();
			tempV = vertexList[temp.destinationVertex];
			vertexList[temp.originVertex].visited = true;
			vertexList[temp.destinationVertex].visited = true; 
			
			//vertexList[temp.].visited = true; 
			path.add(temp.originVertex+ " " + temp.destinationVertex);
			for(int i = 0; i < adjMat[0].length; i ++ ) {
				if(adjMat[temp.destinationVertex][i] > 0 && vertexList[i].visited == false) {
					tryToInsert3(temp.destinationVertex, i, adjMat[temp.destinationVertex][i]);
					path2.add(tempV + " ");
					tempV.visited = true;
					
				}
			} 
		} 
		
		for(int i = 0; i < path.size(); i ++) {
			System.out.println(path.get(i));
		}
//		for(int i = 0; i < path2.size(); i ++) {
//			System.out.print(path2.get(i));
//		}
	}
	
	public static void tryToInsert3(int orig, int dest, int weight) {
		Object [] vArr = pq.toArray();
		Edge inEdge = new Edge(weight, orig, dest);
		for(int i = 0; i < vArr.length; i ++) {
			Edge curE = (Edge) vArr[i];
//			if(curE.destinationVertex == dest && curE.originVertex == orig) {
//				return;
//			}
			if(curE.destinationVertex == dest && curE.weight > weight) {
				//vArr[i] = inEdge;
				pq.remove(curE);
				pq.add(inEdge);
//				vertexList[dest].visited = true; 
//				path.add(orig + " " + dest);
				return;
			}
			else if(curE.destinationVertex == dest && curE.weight < weight) {
//				vertexList[dest].visited = true;
//				path.add(orig + " " + dest);
				return;
			}
	}
		pq.add(inEdge);
		//vertexList[dest].visited = true;
	//	System.out.println(orig + " " + dest);
		//path.add(orig + " " + dest);
	}
	
	public  void mst4 (int inOrig) {
		Vertex vert = vertexList[inOrig];
		for(int i = 0; i < adjMat[0].length; i ++) {
			if(adjMat[inOrig][i] > 0) {
				tryToInsert2(inOrig, i, adjMat[inOrig][i]);
			}
		}
		while(!pq.isEmpty()) {
			int dest = pq.poll().destinationVertex;
			vert = vertexList[dest];
			vertexList[dest].visited = true;
			for(int i =0; i < adjMat[0].length; i ++) {
				if(adjMat[dest][i] > 0 && vertexList[i].visited == false) {
					tryToInsert2(dest, i, adjMat[dest][i]);
				}
			}
		}
		for(int i = 0; i < path.size(); i ++) {
			System.out.println(path.get(i));
		}
	}
}
