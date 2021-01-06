import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {

	public ExceptionTest1() {
		//예외처리
		try {
			//예외발생가능한 코드와 예외발생가능성이 없는 코드도 명시가 가능하다.
			Scanner sc = new Scanner(System.in);
			System.out.print("정수를 입력하세요...");
			int n = sc.nextInt(); ///////////////////예외가 발생할곳. 12.5
			System.out.println("n = " + n);
		}catch(InputMismatchException ime) {
			//try 영역의 코드가 예외가 발생하면 실행될 영역
			//ime.printStackTrace();	// ---> 에러메세지의 종류와 위치를 알려준다.
			
			
			//System.out.println(ime.getMessage());  // ----> null
			
			//System.out.println("숫자를 잘못 입력하였습니다.");
		}
		//System.out.println("프로그램이 종료 되었습니다");
	
	}

	public static void main(String[] args) {
	
		new ExceptionTest1();
	}

}
