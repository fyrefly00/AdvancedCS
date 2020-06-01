
public class AdvCSStackDriver {

	public static void main(String[] args) {
		//AdvCSStack<Integer> stack= new AdvCSStack <>();
		AdvCSStack<String> stack = new AdvCSStack();
		System.out.println(stack.isEmpty());
		stack.push("Hello");
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.pop()); 
/*	for(int i = 0; i < 9; i++) {
			stack.push(i);
		}
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty()); */

	} 
	

}
