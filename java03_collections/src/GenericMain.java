import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GenericMain {

	public GenericMain() {
		GenericTest<String> gt = new GenericTest<String>();
		gt.setUsername("홍길동");
		System.out.println("gt -> " + gt.getUsername());
		
		GenericTest<Calendar> gt2 = new GenericTest<Calendar>();
		gt2.setUsername(Calendar.getInstance()); // Calendar 객체를 생성함
		gt2.dateOutput();
	
	}

	public static void main(String[] args) {
		new GenericMain();

	}

}
