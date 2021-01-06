
public class AbstractMain extends AbstractTest{

	public AbstractMain() {
	
	}
	// 모든 추상메서드 오버라이딩 -> 모두 똑같이 쓴다 (abstract 빼고) 
	// 모든 추상메서드 오버라이딩은 문법이다 -> 무조건 해야되는것
	public void output() {
		System.out.println("num---> " + num);
		System.out.println("name---> " + name);
	}
	
	public void sum(int max/*변수명은 달라도된다.*/) {
		int total = 0;
		for(int i=1; i<=max; i++) {
			total += i;
		}
		System.out.println("1~"+max+"까지의 합은 "+ total);
	}
	
	
	public void start() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		AbstractMain am = new AbstractMain();
		am.sum(100);
		
		// 추상클래스는 객체 생성이 안되고 상속 받아서 사용해야한다.
		// 그래서 AbstractTest() 객체가 생성되지 않는것이다.
		//AbstractTest at = new AbstractTest();
		
	}

}
