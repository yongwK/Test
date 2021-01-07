import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashTableTest {

	public HashTableTest() {

	}

	
	public void start() {
		// Key, Value
		// Hashtable : 동기화지원
		// HashMap : 동기화지원안됨
		
		//회원정보 4명을 Hashtable에 저장
		
		Hashtable<String, Member> ht = new Hashtable<String, Member>();
		
		Member m1 = new Member(100, "홍길동", "010-1111-2222", "서울시 중구");
		ht.put("홍길동", m1);
		ht.put("세종대왕", new Member(200, "세종대왕", "010-2222-3333", "서울시 종로구"));
		ht.put("이순신", new Member(300, "이순신", "010-7777-3333", "서울시 서대문구"));
		ht.put("김정희", new Member(400, "김정희", "010-9999-7777", "서울시 마포구"));
		ht.put("세종대왕2", new Member(500, "세종대왕", "010-2222-3333", "서울시 종로구"));
		ht.put("이순신2", new Member(600, "이순신", "010-7777-3333", "서울시 서대문구"));
		ht.put("김정희2", new Member(700, "김정희", "010-9999-7777", "서울시 마포구"));
		//key를 기준으로 가져오기 : Key 값을 알고있을 경우
		Member vo = ht.get("세종대왕"); // vo안에 세종대왕의 번호,주소 등이 들어있는것
		vo.memberPrn();
		
		// -----------------Map의 Key목록을 구하기 : Set으로 받는다. 
		// Set<K>	keySet()    --> keySet은 순서를 유지하지 않는다. 
		// Returns a Set view of the keys contained in this map.
	
		Set<String> keyList = ht.keySet();
		Object[] obj = keyList.toArray();       //Set 의 메서드중에 toArray가 있고 반환형이 Object라서 Object로 받는다.
		for(Object o : obj) {					// key값 출력
			System.out.println(o);
		}
		System.out.println("---------------------------------------");
		
		Iterator<String> ii = keyList.iterator(); //Set 의 메서드중에 iterator()가 있고 반환형이 Iterator라서 Iterator로 받는다.
		while(ii.hasNext()) {
			//System.out.println(ii.next());  --> key값 출력 
			Member v= ht.get(ii.next());      //-- > key값을 get안에 넣고 Member변수에 넣어서 다 다른 값을 출력한다. 
			v.memberPrn();
		}
		
		System.out.println("-------------전체 value 목록을 얻어오기---------------------------");
		
		Collection<Member> value = ht.values();
		Iterator<Member> iii = value.iterator();
		while(iii.hasNext()) {
			Member vvv = iii.next();
			vvv.memberPrn();
		}
	}
	public static void main(String[] args) {
		new HashTableTest().start();

	}

}
