import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {

	public ExceptionEx() {
		
	}

	public void start() {
		Scanner sc = new Scanner(System.in);
		
		do {
			try {

				System.out.print("첫번째 수 ->");
				//int num1 = sc.nextInt(); //숫자아닌 데이터가 들어오면 에러가 발생한다.(InputMixMatchException)
				// nextInt()-- > 숫자만 바이트로 인식하는게 아니라 enter CR + LF 2byte 처리되어서 무한루프로 진행된다.
				
				//콘솔의 문자열 1줄을 입력받아서 -> 숫자로 변환해준다.
				int num1 = Integer.parseInt(sc.nextLine());
				 
				System.out.print("두번째 수 ->");
				//int num2 = sc.nextInt();  
				int num2 = Integer.parseInt(sc.nextLine());
				
				int result = num1 * num2;
				int result2 = num1 / num2;  // num2 = 0일떄 / 할때 에러가 발생한다.(ArithmeticException)
				
				System.out.println(num1 + "*" + num2 + "=" + result);
				System.out.printf("%d/%d=%d \n", num1,num2,result);
			
				String names[] = {"세종대왕", "이순신"};
				for(int i=0; i<=names.length; i++) {
					System.out.println("name[" + i + "]=" + names[i]); // i=2일떄 names에 값이 없다.
				}											// ArrayindexOUtOfBoundsException
			
			}//catch(InputMismatchException ime) {
			//	System.out.println("숫자만 입력하세요....");
			catch(NumberFormatException ime) {
				System.out.println("숫자만 입력하세요....");
			}catch(ArithmeticException ae) {
				System.out.println("두번째 값은 0이외의 값을 입력해야 합니다.");
			}catch(ArrayIndexOutOfBoundsException ai) {
				System.out.println("배열의 index를 잘못사용하였습니다..." + ai.getMessage());
			}
		}while(true);
		//catch문의 갯수는 정해진게 업속 발생하는 에러만큼 사용한다.
	}
	
	
	public static void main(String[] args) {
		new ExceptionEx().start();
	}
}
