public class OuterTest/*외부클래스*/ {
	//외부클래스에서 내부클래스 데이터를 사용하룻 있느냐?  ==> 사용할수 없다.     외부클래스(상위) <-- 내부클래스(하위)    상위가 하위꺼 못씀
	int num = 1234;
	String name = "세종대왕";
	public OuterTest() {
		System.out.println("OuterTest() 생성자.....");
	}
	
	public void outerprint() {
		System.out.println(num + "->" + name);
		//외부클래스는 내부클래스의 정보를 사용하수 없다.
		//			객체를 생성하면 사용할수 있다.
		//System.out.println(no + "->" + username);
	
		//내부클래스 객체 만들기 -   현재클래스(외부클래스)내에서 내부 클래스 객체 생성가능하다.
		// OuterTest 안에서 만드는것이기 때문에 OuterTest 객체를 따로 안만들고 바로 내부 클래스 객체를 생성하면된다.
		// 메소드 내의 내부클래스는 메소드(외부클래스 메소드) 호출시 생성된다.
		InnerTest it = new InnerTest();
		it.innerPrintln();
	}
	// 내부 클래스(멤버)  채팅프로그램만들때 유용하다.
	// 내부클래스에서 외부클래스의 데이터를 사용할수 있느냐? == > 사용할수 있다.       외부클래스(상위) <-- 내부클래스(하위)
	class InnerTest {
		int no = 6789;
		String username = "이순신";
		InnerTest(){
			System.out.println("InnerTest() 생성자....");
		}
		public void innerPrintln() {
			System.out.println(no + "=====>" + username);
			// 내부 클래스에서는 외부 클래스의 정보를 사용할수 있다
			System.out.println(num + "=====>" + name);
		}
	}
	public static void main(String[] args) {
		OuterTest ot = new OuterTest();    //outerPrint를 사용하기 위해서 OuterTest 객체를 생성하여 호출
//		ot.outerprint();     
		
		//외부에서 내부클래스 객체를 생성하기 위해서는 외부클래스 객체를 이용하여 
		// 		 내부클래스 객체를 생성하여야 한다.
		// 내부클래스는 외부클래스에 의존적이다.
		OuterTest ot2 = new OuterTest();
		OuterTest.InnerTest it = ot2.new InnerTest();  // 외부클래스.new 이너클래스(); 이너클래스객체생성 방법	
//		it.innerPrintln();
		ot2.outerprint();	
	}

}
