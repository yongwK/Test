
public class MethodInnerClass {
	String email  = "abcd@nate.com";
	public MethodInnerClass() {
	}
	public void output() {
		System.out.println("이메일 ==>" + email);
	}
	public void innerClassMethod() {
		int num = 100;
		
		// 메소드에 정의된 내부 클래스
		class InnerCreate {
			String name = "홍길동";
			
			InnerCreate() {}
		
			void innerPrint() {
				System.out.println("name ----->" + name);
				System.out.println("num ----->" + num);
				System.out.println("email ----->" + email);
				output();
			}
		}
//		  innerClassMethod() 가 호출되어야 이너 클래스 객체를 생성할수 있다.
// 		 즉 innerClassMethod() 안에서만 내부클래스 객체를 생성 할수 있다.
		InnerCreate ic = new InnerCreate();
		ic.innerPrint();

	}
	
	
	public static void main(String[] args) {
		MethodInnerClass mic = new MethodInnerClass();
		mic.innerClassMethod();
		
	}

}
