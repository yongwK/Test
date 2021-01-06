
public class TypeCasting {

	public TypeCasting() {
		BBB b1 = new BBB();  // b1에 AAA도 가지고 있다.
		b1.print();
		b1.namePrint();
		// 하위클래스로 객체를 생성하여 상위클래스 변수에 대입가능하다.
		AAA a1 = new BBB(); 
		a1.print();
//		a1.namePrint(); // AAA클래스에는 BBB클래스가 숨겨져있다.
	
	
		BBB b2 = (BBB)a1;
		b2.namePrint();
	
		
		
		//상위 클래스의 객체를 하위클래스의 레퍼런스변수에 대입할수 없다.
		AAA a2 = new AAA();
//		BBB b3 = (BBB)a2;
//		b3.namePrint();
		
		///////////////// override 되어서 BBB에 있는 output실행된다.
		BBB b3 = new BBB();
		b3.output();
		
		
		// 하위클래스에서 오버라이딩 된 메소드는 상위클래스로 타입 캐스팅
		// 하더라도 메소드가 존재한다. (오버라이딩 메서드가 되지 않은 건 숨겨져 있다)
		/// b3는 하위 클래스 객체를 상위클래스 레퍼런스변수 a3로 집어넣은것 ! 
		// 오버라이딩이기 때문에 BBB의 output이 출력된다.
		AAA a3 = b3;
		a3.output();
	
		Object obj = new BBB(); //Object 는 최상위 클래스이다
		BBB b4 = (BBB) obj;
		b4.namePrint();
		
		
	
	}

	public static void main(String[] args) {
		
		new TypeCasting();
		
	}
	
	
}
