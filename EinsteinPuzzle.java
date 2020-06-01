// Template for solution to the "Einstein Riddle"
// Uses simulated annealing
// Mr. Berniker
// October 2016
// Robert Walker

//Can take a while to run
import java.text.DecimalFormat;

public class EinsteinPuzzle {

	static String[] nat = { "Dane", "Brit", "Swede", "Norwegian", "German" };
	static String[] col = { "Yellow", "Red", "White", "Green", "Blue" };
	static String[] pet = { "Horse", "Cat", "Bird", "Fish", "Dog" };
	static String[] bev = { "Water", "Tea", "Milk", "Coffee", "Root Beer" };
	static String[] cig = { "Pall Mall", "Prince", "Blue Master", "Dunhill", "Blends" };

	static String[][] lookup = { nat, col, pet, bev, cig };

	// generate starting state
	public static int[][] init() {
		int[][] S = new int[5][5];
		for (int i = 0; i < S.length; i++) {
			for (int j = 0; j < S[0].length; j++) {
				S[j][i] = j;
			}
		}
		return S;
	}

	// generate new state by swapping one pair of items
	public static int[][] step(int[][] S) {
		int[][] newSol = deepCopy(S);
		int house1 = (int) (Math.random() * 5); //First house (r)
		int house2 = (int) (Math.random() * 5); //Second house (r)
		int category = (int) (Math.random() * 5); //Category to swap (c)
		if (house1 == house2) { //If the houses are equal, random values
			while (house1 == house2) {
				house2 = (int) (Math.random() * 5);
			}
		}
		if (house1 != house2) {
			int val1 = newSol[house1][category]; //Swap everything
			int val2 = newSol[house2][category];
			newSol[house1][category] = val2;
			newSol[house2][category] = val1;
		}

		return newSol;

	}

	//Deep copy of int[][]
	public static int[][] deepCopy(int[][] S) {
		int[][] Scopy = new int[S.length][S[0].length];
		for (int i = 0; i < S.length; i++) {
			for (int j = 0; j < S[0].length; j++) {
				Scopy[i][j] = S[i][j];
			}
		}
		return Scopy;
	}

	// determine the "cost" for state S
	// for every rule that is satisfied, reduce the cost
	public static int cost(int[][] S, int testLength) {
		int cost = 15;
		for (int i = 0; i < 5; i++) {
			if (S[i][0] == 1) { // Rule 1
				if (S[i][1] == 1) {
					cost--;
				}
			}

			if (S[i][0] == 2) { // Rule 2
				if (S[i][2] == 4) {
					cost--;
				}
			}

			if (S[i][0] == 0) { // Rule 3
				if (S[i][3] == 1) {
					cost--;
				}
			}

			if (i < 4) { // Rule 4
				if (S[i][1] == 3) {
					if (S[i + 1][1] == 2) {
						cost--;
					}
				}
			}

			if (S[i][1] == 3) { // Rule 5
				if (S[i][3] == 3) {
					cost--;
				}
			}

			if (S[i][4] == 0) { // Rule 6
				if (S[i][2] == 2) {
					cost--;
				}
			}

			if (S[i][1] == 0) { // Rule 7
				if (S[i][4] == 3) {
					cost--;
				}
			}

			if (i == 2) { // Rule 8
				if (S[2][3] == 2) {
					cost--;
				}
			}

			if (i == 0) {
				if (S[i][0] == 3) { // Rule 9
					cost--;
				}
			}

			if (S[i][4] == 4) { // Rule 10
				if (i > 0 && i < 4) {
					if (S[i - 1][2] == 1) {
						cost--;
					} else if (S[i + 1][2] == 1) {
						cost--;
					}
				} else if (i == 0) {
					if (S[i + 1][2] == 1) {
						cost--;
					}
				} else if (i == 4) {
					if (S[i - 1][2] == 1) {
						cost--;
					}
				}
			}

			if (S[i][2] == 0) { // Rule 11
				if (i > 0 && i < 4) {
					if (S[i - 1][4] == 3) {
						cost--;
					} else if (S[i + 1][4] == 3) {
						cost--;
					}
				} else if (i == 0) {
					if (S[i + 1][4] == 3) {
						cost--;
					}
				} else if (i == 4) {
					if (S[i - 1][4] == 3) {
						cost--;
					}
				}
			}

			if (S[i][4] == 2) { // Rule 12
				if (S[i][3] == 4) {
					cost--;
				}
			}

			if (S[i][0] == 4) { // Rule 13
				if (S[i][4] == 1) {
					cost--;
				}
			}

			if (S[i][0] == 3) { // Rule 14
				if (i > 0 && i < 4) {
					if (S[i - 1][1] == 4) {
						cost--;
					} else if (S[i + 1][1] == 4) {
						cost--;
					}
				} else if (i == 0) {
					if (S[i + 1][1] == 4) {
						cost--;
					}
				} else if (i == 4) {
					if (S[i - 1][1] == 4) {
						cost--;
					}
				}
			}

			if (S[i][4] == 4) { // Rule 15
				if (i > 0 && i < 4) {
					if (S[i - 1][3] == 2) {
						cost--;
					} else if (S[i + 1][3] == 2) {
						cost--;
					}
				} else if (i == 0) {
					if (S[i + 1][3] == 2) {
						cost--;
					}
				} else if (i == 4) {
					if (S[i - 1][3] == 2) {
						cost--;
					}
				}
			}

		}
		return cost;

	}

	// determine the probability of transitioning to the new state
	public static double acceptProb(double temp, double cost, double cPrime) {
		double deltaCost = cPrime - cost;
		if (deltaCost <= 0)
			return 1;
		else
			return Math.exp((-deltaCost / temp));

	}

	// print an array
	public static void printArr(int[][] arr) {
		for (int[] r : arr) {
			for (int i : r)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	// print the actual words, not just the ints
	public static void printStr(int[][] arr) {
		for (int c = 0; c < 5; c++) {
			System.out.print("House " + (c + 1) + ": ");
			for (int r = 0; r < 5; r++)
				System.out.print(lookup[r][arr[c][r]] + ", "); //r and c values swapped for house orientation with lookup
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] S = init(), Sprime;
		int cost = cost(S, 0), steps = 0; 
		double temp = 1000;

		while (cost > 0) {
			Sprime = step(S);
			int Cprime = cost(Sprime, steps); 
			double ap = acceptProb(temp, cost, Cprime);

			if (Math.random() < ap) {
				S = Sprime;
				cost = Cprime;
				temp = Math.max(temp - 1, 1);
			}
			steps++;
		}

		System.out.println("Final cost is " + cost(S, steps) + "\n");
		printStr(S);
		double percent = ((double) steps) / (Math.pow(120, 5));
		String perStr = (new DecimalFormat("##.#####%")).format(percent);
		System.out.print("\n[" + steps + " steps,");
		System.out.println(perStr + " of all states]");
	}

}
