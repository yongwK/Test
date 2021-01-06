
public class ExceptionTestMethod {

	public ExceptionTestMethod() throws ArithmeticException, NumberFormatException, ArrayIndexOutOfBoundsException {
		method1(); 									// method1()이 에러이므로 호출하는 ExceptionTestMain() 
	} 												// 도 에러이다.

	public void method1() throws ArithmeticException, NumberFormatException, ArrayIndexOutOfBoundsException {
		int a = 100, b =10;
		int c = a/b;                                 ////// 해결하지 않으면 그 아래가 실행되지 않는다.
		System.out.println("c=" + c);            	////// 메소드에서 발생한 에러를 메소드에서 책임진다.
		method2();		
	}
	
	public void method2() throws NumberFormatException, ArrayIndexOutOfBoundsException {
		String numStr = "12";
		int num = Integer.parseInt(numStr);          //////NumberFormatException
		System.out.println("num = " + num);  
		method3();
		
	}
	
	public void method3() throws ArrayIndexOutOfBoundsException{
		int num[] = {10,20,30};
		System.out.println(num[num.length]);           //////
		
	}
	
	public static void main(String[] args) {
		try {
		new ExceptionTestMethod(); 
		}catch(ArithmeticException ae) {
			System.out.println("0으로 나눌수 없습니다. --->" + ae.getMessage());
		}catch(NumberFormatException nfe) {
			System.out.println("문자는 숫자로 변경할 수 없습니다.");
		}catch(ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("배열의 첨자값을 잘못 입력하였습니다.");
			aioobe.printStackTrace();
		}
		System.out.println("프로그램 종료......");
	}
	
	
	
	// 그 메소드를 사용하는 메서드에서도 throws해줘야한다.
}
