
public class Knapsack {

	public static void main(String[] args) {
		int [] v = new int[6];
		int [] w = new int[6];
		int cap = 11;
		v[0] = 0;
		v[1] = 1;
		v[2] = 6;
		v[3] = 18;
		v[4] = 22;
		v[5] = 28;
		w[0] = 0;
		w[1] = 1;
		w[2] = 2;
		w[3] = 5;
		w[4] = 6;
		w[5] = 7;
		knapSack(v,w, 11);
	}
	//take value and subtract the weight + the value. If it's better, add it
	
	public static void knapSack(int[] v, int [] w, int cap) {
		int [][] sack = new int[11][6];
		for(int j = 1; j < 5; j ++) {
		for(int i = 1; i < 11; i ++) {
			
				if(j <= i) {
					if(i - w[j] < 0) {
						sack[i][j] = sack[i - 1][j];
					}
					else if(v[j] + sack[i - w[j]][j] > sack[i][j - 1]) {
						sack[i][j] = v[j] + sack[i - w[j]][j];
					}
					else {
						sack[i][j] = sack[i - 1][j];
					}
				}
				
				
				
				
			}
		}
		for(int i = 0; i < sack.length; i ++) {
			for(int j = 0; j < sack[0].length; j ++) {
				System.out.print(sack[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
