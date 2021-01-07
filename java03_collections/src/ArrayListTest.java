import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		//	다른종류의 객체 추가 가능
		ArrayList al = new ArrayList();
		
		// 멤버 객체만 추가 가능 // <> 제너릭이라고함
		// <>안에 넣고 싶은 데이터타입을 입력하면 그이외에는 추가 불가능 
		List<Member> lst = new ArrayList<Member>(); // 이형식으로 많이 사용한다.
	
		Member mem1 = new Member(100,"hong","010-1234-5688","서울시 서대문구");
		Member mem2 = new Member(200,"kim", "010-4587-8888","서울시 종로구");
		Member mem3 = new Member(300,"park", "010-7895-9696","서울시 중구");
		
		al.add(mem1); // 0
		al.add(mem2); // 1
		al.add(mem3); // 2
		
		lst.add(mem1); //0
		lst.add(mem2); //1
		lst.add(mem3); //2
		
		//al.add(new String("홍길동"));
//		lst.add(new String(""));   // generic은 같은 종류의 객체만 추가 가능
		
		//					3
		for(int i = 0; i<lst.size(); i++) { // 0,1,2
			Member m = lst.get(i);  // 제너릭 컬렉션의 형변환하지 않아도 된다
		//	Member m1 = (Member)al.get(i);// 제너릭 컬렉션이 아니므로 오류 형변환실시
		
			m.memberPrn();
		}							 
	}

	public static void main(String[] args) {
		new ArrayListTest();

	}

}
