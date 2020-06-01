/****************************
 * DecToBin.java	Author: Robert Walker
 * 
 * Purpose: Decimal to Binary Converter
 *****************************/
import java.util.*;
class DecToBin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AdvCSStack<Integer> stack = new AdvCSStack<>();
		
		System.out.println("Enter an integer."); 
		int input = scan.nextInt();
		
		//Converts number to binary and adds to stack
		while (input != 0) { 
			stack.push(input % 2);
			input = input / 2;
		}
	
		
		while (!stack.isEmpty()) { 
			System.out.print(stack.pop());
		} 
	}
}
