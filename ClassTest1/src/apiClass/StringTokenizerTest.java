package apiClass;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public StringTokenizerTest() {
		
	}

	
	
	public void start() {
		String hobby = "등산/쇼핑/IT//////축구,인터넷,야구";
		
		StringTokenizer st = new StringTokenizer(hobby, "/,");
		
		System.out.println("토큰수 = " + st.countTokens());
		//토큰이 있으면 실행
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new StringTokenizerTest().start();

	}

}
