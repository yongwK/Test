package apiClass;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatPaternTest {

	public FormatPaternTest() {
			try {
				// 숫자포맷   DecimalForamt 클래스
				int won = 56567854;
				//	      56,567,854원 --> 으로 표시하고 싶음
				//		  67,854원
				
				DecimalFormat dFmt = new DecimalFormat("#,###원"); // 0,000원 자리수가 모자란영역에 0으로 표기된다.
				String wonStr = dFmt.format(won);
				System.out.println("wonStr = " + wonStr);
			
				// 패턴화 된 데이터를 원래데이터 돌려 놓기
				// 56,567,854원 -> 다시 숫자  56567854 로 변환하는 방법
				// NumberFormat() 클래스 사용 -> 생성자 메소드 protected 라서 객체 생성이 안된다 --> 그래서 상속 받아서 사용해야 한다.
				// 상속 받으면 다른걸 상속 못받으니까  현재클래스를 객체로 만들어서 리턴해주는메소드 Instance() 를 사용한다.
				// --> NumberFormat.getInstance();
				
				NumberFormat nFmt = NumberFormat.getInstance();
				// 패턴화 된 데이터를 NumberFormat에 파싱한다. 그때 사용하는 메서드가 parse(String source)이다.
				Number num = nFmt.parse(wonStr);
				int numValue = num.intValue();
				System.out.println("numValue = " + numValue);
				
				// 날자 패턴  2021-01-04(월) 11:25 오전      // SimpleDateFormat() 사용
				//String pattern = "yyyy-MM-dd(E) hh:mm a";
				SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm a");
				
				//날짜
				Calendar now = Calendar.getInstance();
				
				//String    format(Date date)
				String dateStr = dateFmt.format(now.getTime());
				
				System.out.println("dateStr = " + dateStr);
				
			} catch(Exception e) {
				
			}
	}

	
	
	
	public static void main(String[] args) {
		new FormatPaternTest();
		

	}

}
