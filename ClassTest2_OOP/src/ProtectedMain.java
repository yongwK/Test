import pac.ProtectedTest;


public class ProtectedMain extends ProtectedTest {

	public ProtectedMain() {

	}

	public void start() {
		// protected 접근제한자는 같은 패키지일 경우 접근허용
		// protected 접근제한자는 다른 패키지일 경우 상속받아 접근
		// ProtectedTest 클래스는 public이므로 클래스 생성은 가능하나
		// 생성자 매서드가 protected이므로 객체 생성이 안된다.
		//ProtectedTest pt = new ProtectedTest(); // 상속 받았기 때문에 객체를 생성하지 않아도된다.
	
		ProtectedEx pe = new ProtectedEx();      // ProtectedEx 같은 패기지 일경우 호출가능
		System.out.println("------------" + pe.username);
		pe.print();
		
		
		System.out.println();
		// 상속을 받았기 때문에 username 을 바로 사용하고 메서드를 print(); 로 바로 호출할수 있다.
		System.out.println("이름 = " + username);
		print();
		
		//pe.print();
		
	}
	
	
	
	public static void main(String[] args) {
		new ProtectedMain().start();

	}

}
