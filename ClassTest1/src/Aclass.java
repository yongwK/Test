import java.util.Scanner;

public class Aclass {
	
	//멤버 변수 = 전역변수
	int num = 500;
	String username = "홍기동";
		
	Scanner scan = new Scanner(System.in);
	//	생성자 메소드
	// 1. 생성자 메소드 = 클래스명 생성자 메소드명이 같다.
	// 2. 메소드는 반드시 ( ) 가 있다.
	// 3. 생성자 메소드는 반환값이 없다.
	// 4. 매개변수(arguments)는 갯수 제한은 없다.
	// 5. 생성자 메소드는 객체 생성시 한번만 실행됩니다.
	// 6. 객체 생성시 여러개의 생성자 메쏘드 호출 하는 방법
	// 7. 생성자 메소드에서 일반 메소드 호출할수 있다.
	public Aclass() {
		System.out.println("Aclass() 생성자 실행됨,,,");//매개변수 없음
		//total(); // 메소드 호출
	}
	
	public Aclass(int n ) {
		// this : 다른 생성자 호출
		// 반드시 첫번째 실행문으로 처리
		this();
		System.out.println("Aclass(int n )실행 -> " + n);
		//매개변수 정수형 1개
	}
	public Aclass(int x, int y, String name) {
		System.out.println("Aclass(int x, int y, String name)실행 -> " + x + ","+ y + ","+ name);
		//매개변수 정수형 2개, 문자열형1개
	}
	public Aclass(int a, int c, double firstName) {
		System.out.println("Aclass(int a, int b, String firstName)실행 -> " + a + "," + c + "," + firstName);
		// 데이터 타입이 달라야한다 중복되는 데이터 타입 이 있으면 안된다.
	}
	
	public Aclass (int num, String name) {
		// 지역변수와 멤버변수가 같을경우 멤버변수를 지정하는 키워드 : this
		this.num = num;  
		username = name;	
	}
	
	
	
	
	// 메소드 : 1 ~ 100까지 합
	// 	   반환형  메소드명[소문자시작, ()가있다,합성어면 두번쨰 대문자] 
	public void total() {
		int tot = 0;
		for(int i = 1; i <= 100; i++) {
			tot += i;
		}
		System.out.printf(" tot = %d \n" ,tot);
	}
	
	
	
	
	// 메소드 : 임의의 값을 전달받아 그 수까지 합을 구하는 것
	// 메소드명 왼쪽이 반환형 을 넣는다.
	public int sum(int max) {
		int sum = 0;
		for(int i = 1; i <=  max; i++) {
			sum += i;
		}
		//System.out.println("sum = " + sum);
		return sum;
	}
	
	
	
	
	
	
	
}
