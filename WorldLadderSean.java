import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class WorldLadderSean {

	private static HashSet<String> hs = new HashSet<String>();
	private static HashSet<String> nhs = new HashSet<String>();
	private static HashSet<String> lhs = new HashSet<String>();
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("src/ladderInput.txt"));
		AdvCSSeanStack stringstack = new AdvCSSeanStack();
		
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
        AdvCSStack<String> stack = new AdvCSStack<String>();
        AdvCSStack<String> stacktwo = new AdvCSStack<String>();
        String str = "";

        for (String s: hs)
        {
            if (s.length() == start.length())
                lengthhs.add(s);
        }

        for (String s: lengthhs)
        {
            if (oneLetterCheck(start, s))
            {
                stacktwo = stack.copy();
                stacktwo.push(s);
                queue.enqueue(stacktwo);
                usedhs.add(s);
            }
        }

        while (!queue.isEmpty())
        {

            stack = queue.dequeue();
            usedhs.add(stack.peek());
            for (String s: lengthhs)
            {
                str = (String) queue.peek().peek();
                if (oneLetterCheck(str, s))
                {
                    stacktwo = stack.copy();
                    stacktwo.push(s);
                    queue.enqueue(stacktwo);
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
