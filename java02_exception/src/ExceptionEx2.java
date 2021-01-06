import java.util.Scanner;

public class ExceptionEx2 {
	Scanner sc = new Scanner(System.in);
	public ExceptionEx2() {
	
	}

	
	public void start() {
		try {
			
			System.out.print("첫번째 수 ->");
			
			//콘솔의 문자열 1줄을 입력받아서 -> 숫자로 변환해준다.
			int num1 = Integer.parseInt(sc.nextLine());  // ----!!! NumberFormatException
			 
			System.out.print("두번째 수 ->");  
			int num2 = Integer.parseInt(sc.nextLine()); // ----------------------------
			
			int result = num1 * num2;
			int result2 = num1 / num2;  // num2 = 0일떄 / 할때 에러가 발생한다.(ArithmeticException)
			
			System.out.println(num1 + "*" + num2 + "=" + result);
			System.out.printf("%d/%d=%d \n", num1,num2,result);
		
			String names[] = {"세종대왕", "이순신"};
			for(int i=0; i<=names.length; i++) {
				System.out.println("name[" + i + "]=" + names[i]); // ArrayIndexOutOfBoundException
			}	
		}catch(ArrayIndexOutOfBoundsException aoe) {
			System.out.println("배열에서 예외발생....");
		}catch(Exception e) { // 순서를 마지막에 해줘야 한다.
			System.out.println("0을 제외한 정수 입력하세요... -->" + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
	 new ExceptionEx2().start();

	}

}
