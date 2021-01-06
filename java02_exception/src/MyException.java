
public class MyException extends Exception {
//	1~10 까지의 값만 유효한 값이다. 예외 메시지로 설정
	public MyException() {
		super("1~10 까지의 값만 유효한 값이다");
	}
//	매개변수의 값이 예외 메시지로 설정
	public MyException(String message) {
		super(message);       // 생성자 메소드이믈 super()로 호출했다

	}
}
