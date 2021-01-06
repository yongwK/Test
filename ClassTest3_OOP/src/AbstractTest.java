// 추상클래스 : 추상메소드 포함하고 있는 클래스
//			 클래스 이전에 abstract 라고 표시하여야 한다.
// 			 추상클래스는 객체 생성을 할수 없고 추상클래스를 상속 받아 모든 추상메소드를 
//			 오버라이딩 하여야 한다. 
public abstract class AbstractTest {
	int num = 1234;
	String name = "홍길동";
	
	public AbstractTest() {
	}

	
	public void totoal() {
		int sum = 0;
		for(int i = 1; i <=100; i++) {
			sum += i;
		}
		this.num = sum;
	}
	
	
	// 추상메소드 : 실행부가 없는 메서드를 추상메서드라고 하며 반드시 반환형 이전에 abstract 키워드를 표기하여야 한다.
	// 추상메소드는 1개 이상이여도된다.
	public abstract void output();
	public abstract void sum(int max);
}
