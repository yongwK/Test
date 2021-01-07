

import java.util.Stack;

public class StackTest {

	public StackTest() {
		Stack<String> stack = new Stack<String>();
		stack.push("한국");
		stack.push("일본");
		stack.push("중국");
		stack.push("러시아");
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
			System.out.println(stack.size());
		}
		
		
		
	}

	public static void main(String[] args) {
		new StackTest();

	}

}
