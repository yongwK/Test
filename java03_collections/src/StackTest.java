import java.util.Stack;

public class StackTest {

	public StackTest() {
		Stack<Integer> stack = new Stack<Integer>();
		//First in Last Out : 먼저 추가된 객체가 제일 마지막에 얻어진다.
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
			System.out.println(stack.size());
			
		}
	
	
	}

	public static void main(String[] args) {
		new StackTest();

	}

}
