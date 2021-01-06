package pac;
// 클래스는 public, default 둘중에 하나만 사용
public class ProtectedTest {

	protected String username = "이순신";
	
	
	protected ProtectedTest() {
		System.out.println("protected 생성자 실행됨..1");
	}
	
	protected void print() {
		System.out.println("username = " + username);
	}
}
