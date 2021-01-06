
import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorMain {

	public VectorMain() {

	}

	public static void main(String[] args) {
			VectorTest vt = new VectorTest();
			Vector vv = vt.getdata();
			
//			System.out.println(vv);
//			
//			//컬렉션에 객체 얻어오기 - 객체가 지워지지 않는다.
//			
//			System.out.println(vv.elementAt(2));
//			System.out.println(vv.get(2));
			
			Member m1 = (Member)vv.elementAt(2);
			Calendar date = (Calendar)vv.get(5);
			
			m1.memberPrn();
			System.out.println(date);
			
			
			//크기
			System.out.println("Vector의 크기 =" + vv.size());
			
			
			//마지막객체 얻어오기
			Random ran = (Random)vv.lastElement();
			System.out.println("난수=" + ran.nextInt());
			
			//
	}

}
