import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
		// TreeMap : Key, Value를 가진다. key를 기준으로 정렬한다.
		
		TreeMap<String, Member> ht = new TreeMap<String, Member>();
		//put(key,value) 데이터 입력
		Member m1 = new Member(100, "홍길동", "010-1111-2222", "서울시 중구");
		ht.put("홍길동", m1);
		ht.put("세종대왕", new Member(200, "세종대왕", "010-2222-3333", "서울시 종로구"));
		ht.put("이순신", new Member(300, "이순신", "010-7777-3333", "서울시 서대문구"));
		ht.put("김정희", new Member(400, "김정희", "010-9999-7777", "서울시 마포구"));
		ht.put("세종대왕2", new Member(500, "세종대왕2", "010-2222-3333", "서울시 종로구"));
		ht.put("이순신2", new Member(600, "이순신2", "010-7777-3333", "서울시 서대문구"));
		ht.put("김정희2", new Member(700, "김정희2", "010-9999-7777", "서울시 마포구"));
		//get(key) => value 출력
		Member m = ht.get("이순신");
		m.memberPrn();
		System.out.println("-------------------keySet 으로 목록 구하기 ascending---------------");
		Set<String> set = ht.keySet();
		Iterator<String> ii = set.iterator();
		while(ii.hasNext()) {
			Member mm = ht.get(ii.next());
			mm.memberPrn();
		}
		
		System.out.println("-------------------descendingkeyset-----------------");
	
		NavigableSet<String> descKey = ht.descendingKeySet();
		Iterator<String> iii = descKey.iterator();
		while(iii.hasNext()) {
			Member mm = ht.get(iii.next());
			mm.memberPrn();
		}
		
		System.out.println("------------------------------values를 이용한 목록 구하기");
		Collection<Member> co = ht.values();
		Iterator<Member> iiii = co.iterator();
		while(iiii.hasNext()) {
			Member mmm = iiii.next();
			mmm.memberPrn();
		}
	}

	public static void main(String[] args) {
		new TreeMapTest();

	}

}
