
public class DeepCopyBoi {

	public static void main(String[] args) {
		AdvCSStack<String> stack = new AdvCSStack<>();
		AdvCSStack<String> newStack = new AdvCSStack<>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		newStack = copyStack(stack);
		while(!newStack.isEmpty()) {
			System.out.println(newStack.pop());
		}
	}
	public static AdvCSStack copyStack(AdvCSStack<String> inStack) {
		AdvCSStack<String> holder = new AdvCSStack<>();
		AdvCSStack<String> finalOutput = new AdvCSStack<>();
		while(!inStack.isEmpty()) {
			holder.push(inStack.pop());
		}
		while(!holder.isEmpty()) {
			finalOutput.push(holder.peek());
			inStack.push(holder.pop());
			
		} 
	
		return finalOutput;
	}
}
