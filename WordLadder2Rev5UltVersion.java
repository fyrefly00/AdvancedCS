
/****************************
 * WordLadder2Rev5UltVersion.java	Author: Robert Walker
 * Purpose: Solves a word ladder using BFS.
 **************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordLadder2Rev5UltVersion {
	public static HashSet<String> dict; // Total Hash Set
	public static HashSet<String> opt; // Optimized Hash Set

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("src/ladderInput.txt"));
		String s;
		String[] input;

		// Reads input file and tests each ladder.
		while (scan.hasNextLine()) {
			s = scan.nextLine();
			input = getStartEnd(s);
			loadDict(input[0]);
			s = findLadder(input[0], input[1]);
			if (s.equals("")) {
				System.out.println("No word ladder exists between " + input[0] + " and " + input[1] + "!");
			} else {
				System.out.println(s);
			}
		}

	}

	// Finds a ladder, if it exists.
	public static String findLadder(String start, String end) {

		if (opt.contains(start) && start.length() == end.length()) { // If the word is in the dictionary and start and
																		// end are equal, continue.

			HashSet<String> visited = new HashSet<>(); // Keeps track of already used words.
			AdvCSStack<String> startStack = new AdvCSStack<>();
			startStack.push(start);
			visited.add(startStack.peek());
			AdvCSQueue<AdvCSStack<String>> stackQueue = new AdvCSQueue<>();
			stackQueue.enqueue(startStack);

			while (!stackQueue.isEmpty()) {

				AdvCSStack<String> stack = stackQueue.dequeue();
				visited.add(stack.peek());

				if (stack.peek().equals(end)) {
					String result = "";
					String finalResult = "";
					while (!stack.isEmpty()) {
						result = stack.pop() + ", " + result;
						finalResult = result.substring(0, result.length() - 2); //Removes the last comma and space for good formating.

					}
					return "[" + finalResult + "]";
				}

				else {
					for (String s : opt) { // Iterates through dictionary and checks words based on number of differences.
						int differences = 0;
						if (s.length() == stack.peek().length() && !visited.contains(s)) {
							for (int i = 0; i < stack.peek().length(); i++) {
								if (!(s.charAt(i) == stack.peek().charAt(i))) {
									differences++;
									if (differences > 1)
										break;
								}
							}
							if (differences == 1) {
								AdvCSStack<String> copiedStack = copyStack(stack);
								copiedStack.push(s);
								stackQueue.enqueue(copiedStack);
							}
						}
					}
				}
			}
		}
		return ""; // If no ladder exists, return an empty string.
	}

	// Loads dictionary and optimizes it.
	public static void loadDict(String inString) throws FileNotFoundException {

		dict = new HashSet<>();
		opt = new HashSet<>();
		dict.clear(); //Clear the Hash Sets for run time optimization.
		opt.clear();
		Scanner fs = new Scanner(new File("src/dictionary.txt"));
		while (fs.hasNext()) {
			dict.add(fs.next());

		}
		for (String s : dict) { 
			if (s.length() == inString.length()) {
				opt.add(s);

			}
		}
	}

	// Returns starting and ending strings in an Array.
	public static String[] getStartEnd(String inString) {
		Scanner scan = new Scanner(inString);
		String[] returnSplit = new String[2];
		returnSplit[0] = scan.next();
		returnSplit[1] = scan.next();
		return returnSplit;
	}

	// Create a Deep Copy of a stack.
	public static AdvCSStack<String> copyStack(AdvCSStack<String> inStack) {
		AdvCSStack<String> holder = new AdvCSStack<String>();
		AdvCSStack<String> returnStack = new AdvCSStack<String>();
		while (!inStack.isEmpty()) {
			holder.push(inStack.pop());
		}
		while (!holder.isEmpty()) {
			inStack.push(holder.peek()); // Peek and then pop.
			returnStack.push(holder.pop());

		}
		return returnStack;
	}

}
