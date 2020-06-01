
public class Dijkstra {
	public static DistPar[] sPath;
	
	
	public static class DistPar {
		public int distance;
		public int parentVert;
		
		public DistPar(int pv, int d) {
			distance = d;
			parentVert = pv;
		}
	}
}
