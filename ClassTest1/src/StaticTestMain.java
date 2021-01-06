
public class StaticTestMain {

	public static void main(String[] args) {
		
		//클래스 내의 메소드를 호출하기 위해 객체를 생성 	
		//StaticTest st = new StaticTest();
		//st.prn();
		
		
		// 멤버 변수에 static 키워드를 사용하면 클래스를 객체 생성하지 않고 사용 할 수 있다.
		// 								클래스명.static멤버변수
		//System.out.println( " num = " + StaticTest.num);
		
		//static 메서드 호출 
		// 클래스명.static메서드
		//StaticTest.prn();
		
		//static 멤버변수는 객체를 생성시 공통 변수로 사용된다.
		
		StaticTest st = new StaticTest();
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		
		
		//값변경 
		st.num = 1234;
		st.name = "이순신";
		
		st2.prn();
	}

}
