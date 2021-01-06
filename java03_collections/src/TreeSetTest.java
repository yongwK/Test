import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public TreeSetTest() {
		//TreeSet : 중복허용하지 않음, 입력순서 유지하지 않음, 크기 순서대로 정렬됨(문자도 정렬이 될까?)
		int numData[] = {10,50,30,40,10,50,60,70,40,40,40,40};
		String strDate[] = {"홍길동", "세종대왕", "홍길동", "홍길동", "이순신","이순신","김정희"};	
		
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		for( int n : numData) {
			ts.add(n);
		}
		

		TreeSet<String> ts2 = new TreeSet<String>();
			for( String s : strDate) {
				ts2.add(s);
		}
		
		// interator --> 오름차순으로  	
		Iterator<Integer> ii = ts.iterator();
		while(ii.hasNext()) {
			System.out.println("ts -> " + ii.next());
		}
		
		//descendingIterator -- 내림차순으로 
		Iterator<Integer> iii = ts.descendingIterator();
		while(iii.hasNext()) {
			int data = iii.next();
			System.out.println("ts->desc=" + data);
		}
		
		
		// 출력
		
		Iterator<String> is = ts2.iterator();
		while(is.hasNext()) {
			System.out.println("is -> " + is.next());
		}
		
		Iterator<String> iss = ts2.descendingIterator();
		while(iss.hasNext()) {
			System.out.println("iss -> desc" + iss.next());
		}
}	

	
	
	public static void main(String[] args) {
		new TreeSetTest();

	}

}
