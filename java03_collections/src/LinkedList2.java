import java.util.LinkedList;

public class LinkedList2 {

	public LinkedList2() {

		LinkedList<String> ll = new LinkedList<String>();
		
		ll.offer("사람1");
		ll.offer("사람2");
		ll.offer("사람3");
		ll.offer("사람4");
		
		ll.offerFirst("사람99");
		
		System.out.println(ll.pollLast());
		
		while(!ll.isEmpty()) {
			System.out.println(ll.pop());
		}
		
		System.out.println(ll.size());
		
	}

	public static void main(String[] args) {
		new LinkedList2();

		
		
		
		
		
	}

}
