import pac.Access2;

public class AccessMain {

	public AccessMain() {
		
	}
	
	public void start() {
		//객체생성
	
		Access1 a1 = new Access1();
		
		//System.out.println("a1.userid=" + a1.userid); // 객체명.멤버변수
		//System.out.println("a1.userpwd=" + a1.userpwd);
		a1.printData();
		
		
		Access2 a2 = new Access2();  // 빨간줄 이유는 1.  import 안되있음(패키지가 다르기때문에)      2.  패키지가 달라 . 접근제어(한)자가 default다. 
		// 수정해준다 클래스를 public으로 -> 클래스는 open되나  생성자가 default라서 안됨 생성자도 public 해줘야한다.

		//System.out.println("a2.num=" + a2.num);
		//System.out.println("a2.name=" + a2.name);
		
		System.out.println("a2.getName()="+a2.getName());
		System.out.println("a2.getNum()= " + a2.getNum());
		//a2 객체에 있는 num을 200으로 변경
		a2.setNum(300);
		System.out.println("a2.getNum()= " + a2.getNum());
		
		
		
	}	
	public static void main(String[] args) {

		new AccessMain().start();	
				
	}
}
	
	
	
	
		
	

