import java.util.ArrayList;
import java.util.List;

public class ArrayListTest1 {

	public ArrayListTest1() {

	}
	public static void main(String[] args) {
		// 다른종류의 객체 추가 가능
		ArrayList al = new ArrayList(); // 이렇게 잘 쓰지 않고 
		List<Member> lst = new ArrayList<Member>();
		
		Member mem1 = new Member(100, "강", "010", "서욼");
		Member mem2 = new Member(200, "김", "010", "울산");
		Member mem3 = new Member(300, "최", "010", "부산");
		
		lst.add(mem1);
		lst.add(mem2);
		lst.add(mem3);
		
		for(int i = 0; i<lst.size(); i++) {
			Member m = lst.get(i);
			m.memberPrn();
		}
	}

}
