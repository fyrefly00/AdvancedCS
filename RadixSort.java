/***************************************
 *  RadixSort.java	Author: Robert Walker
 * 
 * Purpose: Radix Sort
 * 
 **************************************/

import java.util.*;
import java.io.*;

public class RadixSort {
	public static int[] holder;
	public static int length;
	public static AdvCSLL<Integer>[] buckets = new AdvCSLL[10];

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fs = new Scanner(new File("src/radixInput.txt"));
		while (fs.hasNextLine()) {
			length = fs.nextInt();
			int i = 0;
			holder = new int[length];
			for (int j = 0; j < length; j++) {
				holder[i] = fs.nextInt();
				i++;
			}
			System.out.print("Unsorted: ");
			printInput();
			populateLinkedLists();
			radixSort();
			System.out.println(); 
			System.out.print("Sorted: ");
			printInput();
			System.out.println();
		}
	}

	public static void populateLinkedLists() {
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new AdvCSLL<>();

		}
	}

	@SuppressWarnings("unchecked")
	public static void radixSort() {
		String lengthChecker = Integer.toString(holder[0]);
		int intLength = lengthChecker.length() - 1;
		for (int i = intLength; i > 0; i--) { // Runs once for each digit in input
			for (int j = 0; j < holder.length; j++) { // Iterates holder
				String holderString = Integer.toString(holder[j]); // String for each int in holder
				int endValue = Integer.parseInt(holderString.substring(i - 1, i)); // End Value to sort
																					// by
				buckets[endValue].add(holder[j]); // Add to buckets
			}

			int x = 0;
			for (int j = 0; j < buckets.length; j++) {

				while (!buckets[j].isEmpty()) {
					holder[x] = buckets[j].removeFirst();
					x++;
				}

			}

		}
	}
	public static void printInput() {
		String result = "";
		for (int i = 0; i < holder.length; i++) {
			result = result + holder[i] + ", ";

		}
		String finalResult = result.substring(0, result.length() - 2); // Remove last comma
		System.out.print(finalResult);
	}

}
