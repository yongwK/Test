import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorTest {
		String name = "홍길동";
		int num = 12;
		Member member = new Member();
		Member member2 = new Member(500,"이순신","010-7777-8888","서울시 종로구 통인동");
		Calendar now = Calendar.getInstance();
		Random ran = new Random();
		

	public VectorTest() {
			
	}
	
	public Vector getdata() {
		
		//입력순서유지 / 중복데이터 유지 / index를 가진다 / 중간에 객체를 추가, 삭제, 수정 할 수 있다.
		Vector v = new Vector();
		// add(Object e), addElement(E obj), add(int index, E element)
		
//		v.add(new Integer(num)); 오토박싱 안될때
		
		v.add(num); //오토박싱으로 int -> Integer로
		v.addElement(name);
		v.add(member);
		v.add(member2);
		v.addElement(now);
		v.addElement(ran);
		
		//추가
		
		v.add(3, new String("hong gil dong"));
		
		
		System.out.println("v.cap = " + v.capacity());
		
		return v;
	}
	

}
