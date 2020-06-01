/***********************************************
 * LinearSystemSolver.java Author: Robert Walker
 * 
 * Purpose: Solves a system of linear equations
 ***********************************************/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LinearSystemSolver {

	public static void main(String[] args) throws FileNotFoundException {
		readFile();
	}
	
	public static void readFile() throws FileNotFoundException {
		Scanner fs = new Scanner(new File("src/input.txt"));
		int length = fs.nextInt(); // Number of inputs
		for (int a = 0; a < length; a++) {
			int dims = fs.nextInt(); //Dimensions of matrix
			Double[][] hold = new Double[dims][dims + 1]; //2D Array for matrix
			for (int i = 0; i < dims; i++) { //Populate the array
				for (int j = 0; j < dims + 1; j++) {
					hold[i][j] = fs.nextDouble();
				}
			}
			solveSystem(hold); //Solve the matrix
		}
	}
	
	public static void solveSystem(Double[][] inSys) {
		for (int r = 0; r < inSys.length; r++) {
			if (inSys[r][r] == 0) { //If one of the variable spots equals 0, the system is infinite or unsolvable
				System.out.println("No Solution");
				return;
			} 
			double mod = 1 / inSys[r][r]; //Modifier to get the first number in a row to equal 1.
			for (int j = r; j < inSys[0].length; j++) {
				inSys[r][j] = inSys[r][j] * mod; // Apply that modifier to each number in that row
			}
			for (int j = r + 1; j < inSys.length; j++) { // Finds a common multiple of the two rows and uses it to set the value to 0
				Double cm = (findCM(inSys[r][r], inSys[j][r]));
				for (int k = r; k < inSys[0].length; k++) {
					inSys[j][k] = ((-1 * cm * inSys[r][k]) + inSys[j][k]);
				}
			}
		}
		findSolutions(inSys);
	} 
	
	//Print method
	public static void printSystem(Double[][] inSys) {
		for (int r = 0; r < inSys.length; r++) {
			for (int c = 0; c < inSys[0].length; c++) {
				System.out.print(inSys[r][c] + " ");
			}
			System.out.println();
		}
	}

	// Returns a common multiple of two numbers
	public static double findCM(double a, double b) {
		return a * b;
	}

	//Finds and outputs the solutions to the matrix
	public static void findSolutions(Double[][] inSys) {
		Double[] solutions = new Double[inSys.length]; //Array to hold the solutions
		for (int i = 0; i < solutions.length; i++) { //Initialized to 0
			solutions[i] = 0.0; 
		}
		//Last value set to last spot in solutions array (the given value)
		solutions[solutions.length - 1] = inSys[inSys.length - 1][inSys[0].length - 1]/ inSys[inSys.length - 1][inSys[0].length - 2];
		for (int r = inSys.length - 2; r >= 0; r--) {
			Double hold = 0.0; //Holder value
			for (int c = r; c < inSys.length; c++) {
				hold = hold + solutions[c] *  inSys[r][c];//Use the solutions array to plug in each variable  
			}
			solutions[r] = (inSys[r][inSys[0].length - 1] - hold) / inSys[r][r]; //Solve the row and add result to solution array
		}

		//Format the answer string to get rid of the extra comma 
		String ans = "";
		for (int i = 0; i < solutions.length; i++) {
			ans = ans + ("X" + (i + 1) + " = " + solutions[i] + ", ");
		}
		ans = ans.substring(0, ans.length() - 2);
		System.out.println(ans);

	}

	
	//Unused method to determine if the matrix was solved
	public static Boolean solved(Double[][] inSys) {
		for (int r = 0; r < inSys.length - 1; r++) {
			if (inSys[r][r] != 1) {
				return false;
			}
		}
		return true;
	}
}
