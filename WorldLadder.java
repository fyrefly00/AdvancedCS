import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class WorldLadder {

	private static HashSet<String> hs = new HashSet<String>();
	private static HashSet<String> nhs = new HashSet<String>();
	private static HashSet<String> lhs = new HashSet<String>();
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("src/ladderInput.txt"));
		AdvCSSeanStack stringstack = new AdvCSStack();
		
		loadDict();
		while (scan.hasNextLine())
		{
			String s = scan.nextLine();
			Scanner dan = new Scanner(s);
			stringstack = findLadder(dan.next(), dan.next());
			while (!stringstack.isEmpty())
			{
				System.out.print(stringstack.pop());
			}
		}

		
		
	}
	
	public static void loadDict() throws FileNotFoundException {
		Scanner plan = new Scanner(new File("src/dictionary.txt"));
		while (plan.hasNextLine())
		{
			hs.add(plan.nextLine());
		}
		
	}
	
	public static AdvCSStack findLadder(String start, String end) throws FileNotFoundException
	{
		AdvCSQueue<AdvCSStack> queue = new AdvCSQueue<AdvCSStack>();
		AdvCSSStack<String> stack = new AdvCSStack<String>();
		
		
		for (String s: hs)
		{
			if (s.length() == start.length())
				nhs.add(s);
		}
		
		for (String s: nhs)
		{
			if (oneLetterCheck(start, s))
			{
				AdvCSStack<String> stacktwo = stack.copy();
				stacktwo.push(s);
				queue.enqueue(stacktwo);
				lhs.add(s);
			}
		}
		
		while (!queue.isEmpty())
		{
			stack = queue.dequeue();
			for (String s: nhs)
			{
				if (oneLetterCheck(start, s))
				{
					AdvCSStack<String> stacktwo = stack.copy();
					stacktwo.push(s);
					queue.enqueue(stacktwo);
					lhs.add(s);
				}
			}
		}
		
		
		return queue.dequeue();
	}
	
	public static boolean oneLetterCheck(String str, String strtwo)
	{
		int length = str.length();
		int count = 0;
		for (int i = 0; i < length; i++)
		{
			if (str.charAt(i) == strtwo.charAt(i))
			{
				count++;
			}
		}
		if (count == str.length() - 1 && !(lhs.contains(strtwo)))
		{
			return true;
		}
		else
			return false;
	}
	
	
}
