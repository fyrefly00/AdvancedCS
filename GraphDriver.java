
public class GraphDriver {

	public static void main(String[] args) {
		WGraph4 graph = new WGraph4(); 
		
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D'); 
//		graph.addEdge(0, 1, 1);
//		graph.addEdge(0, 2, 3);
//		graph.addEdge(1, 2, 4);
//		graph.addEdge(2, 3, 1);

		
		
		graph.addVertex('F');
		graph.addVertex('E');
		graph.addVertex('G');
		graph.addVertex('H');
		graph.addVertex('I');
		
		  graph.addEdge(0, 1, 200); //Tennis
		  graph.addEdge(0, 2, 150); //S&& M
		  graph.addEdge(0, 5, 200); //Gym
		  graph.addEdge(0, 6, 400); //Field
		  //Tennis Connections
		  graph.addEdge(1, 7, 100); //PreK
		  graph.addEdge(1, 2, 50); //S&&M

		  //Science COnnections
		  graph.addEdge(2, 5, 100); //Gym


		  //Middle School Connections
		  graph.addEdge(3, 4, 50); //Office
		  graph.addEdge(3, 5, 150); //Gym
		  graph.addEdge(3, 8, 10); //Elementary

		  //Main Office
		  graph.addEdge(4, 7, 50); //PreK
		  graph.addEdge(4, 5, 200); //Gym

		  //Gym
		  graph.addEdge(5, 6, 100); //Field

		  //Elementary
		  graph.addEdge(3, 8, 15); //Middle
		  graph.addEdge(8, 6, 150);
//		graph.addEdge(0, 1, 50);
//		graph.addEdge(0, 3, 80);
//		
//		graph.addEdge(1, 2, 60);
//		graph.addEdge(1, 3, 90);
//		graph.addEdge(1, 4, 50);
//		
//		graph.addEdge(2, 3, 20);
//		graph.addEdge(2, 4, 40);
//		graph.addEdge(2, 5, 6);
//		
//		graph.addEdge(3, 4, 70);
//	
		
		//graph.addEdge(4, 5, 7);
		
//		graph.addEdge(0	, 1, 6);
//		graph.addEdge(0	, 3, 4);
//		//graph.addEdge(1	, 2, 6); //
//		graph.addEdge(1	, 4, 7);
//		graph.addEdge(1	, 2, 10);
//		//graph.addEdge(1	, 4, 7);
//		graph.addEdge(1	, 3, 7);
//		
//		graph.addEdge(2	, 3, 8);
//		graph.addEdge(2	, 4, 12);
//		graph.addEdge(2	, 5, 6);
//		
//		graph.addEdge(3	, 4, 12);
//		
//		graph.addEdge(4	, 5, 7);
//		
		
//		graph.addEdge(4	, 5, 7);
//		graph.addEdge(3, 4, 12);
//		graph.addEdge(1	, 5, 1);
//		graph.addEdge(2	, 5, 3);
//		graph.addEdge(1, 2, 3);
//		graph.addEdge(0, 1, 1);
//		graph.addEdge(0,4, 4);
//		graph.addEdge(1, 3, 1);
//		graph.addEdge(0, 3, 6);
//		graph.addEdge(2, 3, 7);
		//System.out.println(compareTo(2));
		//graph.displayVertex(4);
		//graph.displayMat(); 
		graph.path(1,4);
		//graph.mst4(0);
		
	}

}
