import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		//Set : 입력 순서 유지하지 않음, 중복데이터 허용하지 않음.
		
		int numData[] = {10,50,30,40,10,50,60,70,40,40,40,40};
		String strDate[] = {"홍길동", "세종대왕", "홍길동", "홍길동", "이순신","이순신","김정희"};
	
		HashSet<Integer> hs1 = new HashSet<Integer>();
		for(int n : numData) {
			hs1.add(n);  
		}
		
		System.out.println("hs1의 객체수 = " + hs1.size());   // 6개 출력 -> 중복값 저장 X
		
		HashSet<String> hs2 = new HashSet<String>();
		for(String s : strDate) {
			hs2.add(s);
		}	
	
		System.out.println("hs2의 객체수 = "+ hs2.size());
	
		// iterator() --> HashSet은 다른클래스에 의존해서 pop,get해야 한다
		Iterator<Integer> i = hs1.iterator();
		
		while(i.hasNext()) {// hasNext() --> 객체에 데이터가 있니?  // index가 있는게 아니기 때문에 반복문은 whlie로 사용
 			System.out.println("hs1 --> "+i.next());
		}
		
		//	
		Iterator<String> i2 = hs2.iterator();
		while(i2.hasNext()){
			System.out.println("hs2 --> "+ i2.next());
		}
		
	}

	public static void main(String[] args) {
		new HashSetTest();

	}

}
