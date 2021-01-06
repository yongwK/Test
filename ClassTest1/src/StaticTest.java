/*
 클래스는  객체를 만들거나 상속을 만들어야한다		
 */
public class StaticTest {
	// 멤버 변수
	// 초기값을 설정하지 않은 경우 
	//  - 정수 : 0,   - 실수 :  0.0,  - 논리형 : false, - 객체형 = null
	static int num = 100;
	String name = "세종대왕";
	
	public StaticTest() {
		
	}
	
	public void prn() {  // --> 이걸 사용하려면 StaticTest 객체를 생성해야 쓸수있다.
		System.out.println("num = " + num);
		System.out.println("name = " + name);
	}
}
