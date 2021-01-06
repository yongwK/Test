// 패키지 
//import문 - 다른클래스를 객체 또는 상속을 받아 사용할 때  클레스가 있는 위치를 알려준다.
import pac.AAA;   // 패키지 이름. 클래스명              // 같은 클래스 안에 있는 폴더끼리 사용하면 import를 사용안해도 된다. // 하지만 다른 패키지에 있는 건 import를 해야한다.
import java.lang.String;  // lang 안에 있는 클래쓰들은 선언은 안해도 사용할수 있다 자동으로 해준다 
import java.lang.System;  // javac 컴파일할떄 java.lagn에 있는 클래쓰들을 자동으로 import를 해준다.
import java.util.*; // * -> 모든 클래스를 import한다.
public class Calculator {
	// 멤버 영역 - 실행문을 구현할수 없다. 변수 선언만 할수 있다.
	
	//멤버변수 =(전역변수)
	
	
	//생성자 메소드	==> 객체를 만들떄 실행되는 메소드, 호출해줄수 없다.
	
	//메소드  ==> 메소드는 호출을 해줘야 실행을 합니다. 
	
	//메인메소드
	
	//내부클래스
	
	/*
	  	stack = 지역변수 			heap == 주소를 저장한다.
	 */
	
	public static void main(String[] args) {
		// 다른 클래스에서 구현한 기능을 사용할떄 방법은
		// 1. 객체 ( 키워드 new ) : 생성자 메소드		2. 상속
		// 클래스 객체를 담는 변수를 레퍼런스변수라고한다.
		Aclass obj = new Aclass();   //생성과 동시에 [Aclass() 생성자 실행됨,,,] 생성됨 
		int num = 100; 
		System.out.println("obj = " + obj); //Aclass@53bd815b 해시태그라고한다.[주소]
		
		
		Aclass obj2 = new Aclass(10,5,"hong");
		
		Aclass obj3 = new Aclass(120);
		
		
		// 객체 내의 메소드 호출 
		
		obj2.total();
		int result = obj.sum(50);        // 돌아오는 데이터 타입의 자료형을 사용하고 변수에 저장
		System.out.println("result = " + result);
		
		//new로 해서 객체를 생성하는 방법은 api를 가서 찾아서 사용하면 된다.
		String s = new String();
		String ss = new String(new byte[] {65, 66, 67, 68, 69});
		System.out.println(ss);
		
		String sss = new String(new char[] {'T', 'E', 'S', 'T'});
		System.out.println(sss);
		
		char c = sss.charAt(2);
		System.out.println(c);
		
		
		
	}
}	