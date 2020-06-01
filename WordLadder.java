import java.util.*;
import java.io.*;

public class WordLadder {
	public static HashSet<String> h = new HashSet<>();
	public static AdvCSQueue<AdvCSStack> wordSims = new AdvCSQueue<>();
	public static HashSet<String> visited = new HashSet<>();
	public static AdvCSStack<String> wordList = new AdvCSStack<>();
	public static HashSet<String> optimized = new HashSet<>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fs = new Scanner(new File("src/dictionary.txt"));
		Scanner ls = new Scanner(fs.nextLine());
		String[] input = new String[2];
		String s;
		AdvCSStack<String> wordList = null;
		loadDict();
		System.out.println(h.size());
//		while(fs.hasNextLine()) {
//			s = fs.nextLine();
//			//input =getStartEnd(s, input); 
//			
//			wordList.push(input[0]); 
//			wordSims.enqueue(wordList);
//			s = findLadder(input [0], input[1]);
//		}
//		input[0] = "dears";
//		input[1] = "fears";
		s = findLadder("stone", "money");

		System.out.println(s);
	}

	public static String findLadder(String start, String end) {
		optimized = optimize(h, start, end);
		AdvCSStack<String> holder = new AdvCSStack<>();
		holder.push(start);
		visited.add(start);
		wordSims.enqueue(holder);
		while (!wordSims.isEmpty()) {
			holder = wordSims.dequeue();
			String top = holder.peek(); 
			visited.add(holder.peek());
			if (holder.peek().equals(end)) {
				String result = "";
				while (!holder.isEmpty()) {
					result = holder.pop() + " " + result + " ";

				}
				return result;
			} else if (!holder.peek().equals(end)) {
				int startLength = top.length();
				// holder = wordSims.dequeue();
				int differences = 0;
			//	Iterator<String> iterator = optimized.iterator();
				// for(int i = 0; i < h.size(); i ++) {
				// while(iterator.hasNext()) {
				for (String s : h) {
					// String holderString = (String) iterator.next();
					String holderString = s;
					if (holderString.length() == top.length()) {
						differences = 0;
						for (int j = 0; j < startLength; j++) {
							if (!top.substring(j, j + 1).equals(holderString.substring(j, j + 1))) {
								differences = differences + 1;
							}

						}
						if (differences == 1 && !visited.contains(holderString)) {
							AdvCSStack<String> newList = new AdvCSStack<>();
							newList = copyStack(holder);
							newList.push(holderString);
							wordSims.enqueue(newList);

						}

						else {
							continue;
						}

					}

				}

			} else {
				continue;
			}

		}
		System.out.println("nope");
		return null;
//		int startLength = start.length();
//		holder = wordSims.dequeue();
//		int differences = 0;
//		for(int i = 0; i < h.size(); i ++) {
//			String holderString = ((List<String>) h).get(i);
//			for(int j = 0; j < startLength; j ++) {
//			if (!start.substring(i, i + 1).equals(holderString.substring(i, i + 1))) {
//				differences ++;
//			}
//			}
//			if(differences == 1) {
//				
//			}
//		}
//		
//		
//		
//		return null;
	}

	public static AdvCSStack copyStack(AdvCSStack<String> inStack) {
		AdvCSStack<String> holder = new AdvCSStack<>();
		AdvCSStack<String> finalOutput = new AdvCSStack<>();
		while (!inStack.isEmpty()) {
			holder.push(inStack.pop());
		}
		while (!holder.isEmpty()) {
			finalOutput.push(holder.peek());
			inStack.push(holder.pop());

		}

		return finalOutput;

	}

	public static String[] getStartEnd(String inString, String[] input) {

//		int space = inString.indexOf(" ");
//		input[0] = inString.substring(0, space - 1);
//		input[1] = inString.substring(space);
//		return input;
		input = inString.split("\\s+");
		return input;
	}

	public static void loadDict() throws FileNotFoundException {
		Scanner fs = new Scanner(new File("src/dictionary.txt"));
		while (fs.hasNextLine()) {

			h.add(fs.nextLine());
		}
	}

	public static HashSet optimize(HashSet inH, String start, String end) {
		Iterator<String> iterator = h.iterator();
		String holder = "";
		for (String s : h) {
			if (s.length() == start.length()) {
				optimized.add(s);
			}
		}
		return optimized;
//		while(iterator.hasNext()) {
//			holder = iterator.next();
//			if(holder.length() == start.length()) {
//				optimized.add(holder);
//			}
//		}
//		return optimized;
	}

}
