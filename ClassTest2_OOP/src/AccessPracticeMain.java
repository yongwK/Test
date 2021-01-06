import pac.AccessPractice2;

public class AccessPracticeMain {

	public AccessPracticeMain() {
		
	}

	
	
	public void start() {
		AccessPractice1 ap = new AccessPractice1();   // 같은 패키지 이고 AccessPractice1 
//														 클래스의 접근제한자가  public 이므로 객체 생성이 된다 
		AccessPractice2 ap2 = new AccessPractice2();
		
	}
	
	
	
	
	public static void main(String[] args) {
	new AccessPracticeMain().start();

	}

}
