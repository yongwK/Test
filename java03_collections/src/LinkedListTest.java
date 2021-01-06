import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		// List, 
		// Queue : 객체를 한쪽에서 추가(input) 다른쪽에서 제거(output)
		// Deque : 객체를 양쪽에서 추가, 제거 할수 있다.
		// 객체를 get() 하면 컬렉션에서 객체가 지워진다.
		
		LinkedList<String> ll = new LinkedList<String>();
		
		
		
		
		//데이터추가     (offer -> 순차대로 )
		ll.offer("홍길동");
		ll.offer("세종대왕");
		ll.offer("이순신");
		ll.offer("김정은");
		
		//데이터 추가  (offerFirst -> 새치기 맨앞에다 넣기) 
		ll.offerFirst("Hong");
		
		
		// 제일마지막 객체를 pop --> pollLast() 
		System.out.println(ll.pollLast());
		// get()하니까 지워지지 않았다.
		System.out.println(ll.get(1));
		
		while(!ll.isEmpty()) { // 컬렉션이 비어있는지 확인 후 true // false 결정 
			// 안비어있을때 = true
			System.out.println(ll.pop());
		}
		
		
		// 객체수      --> 위에서 다 빠지고 나서 size는 0 출력된다
		System.out.println("size() ->"+ll.size());
		
		// LinkedList는 index가 의미가 없는게 하나가 빠져나가면 그 뒤에있는게 
		// 0이되므로 index 번호가 의미가 없고 그냥 위치상 가장 앞에 있는거 뒤에있는거 
		// 이런개념으로 사용한다.
		// 반복시킬때 그래서 비어있는지 없는지로 판단해서 반복문을 돌려야 한다.
		
		
		
	}

	public static void main(String[] args) {
		new LinkedListTest();

	}

}
