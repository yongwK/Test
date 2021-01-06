class PrivateChild extends PrivateParent{
	PrivateChild(){
		//private 접근제어자가 있는 멤버 변수는 상속 되지 않아요. 그래서 num을 호출이 안되요
		//System.out.println("num = " + num); 	
		setNum();
		// private 접근제어자 메소드는 상속되지 않는다.
		//super.setNum();
	}
	//오버라이딩 override  == 부모와 반환형과 메소드명과 매개변수가 같은 것을 재정의하는것
	
	// 현재 클래스에서 정의된 메소드
	private void setNum() {
		age += 2;
	}
}
/////////////////////////////////////////////////////////////////////////
// 저장해야할 클래스명에 public을 붙여야한다. public클래스는 1개만 이썽야한다.//////////
////////////////////////////////////////////////////////////////////////
public class PrivateMain {

	public PrivateMain() {

	}

	public static void main(String[] args) {
		PrivateChild pc = new PrivateChild();
		
		System.out.println("pc.getNum()->" + pc.age);
	//   private은 객체명을 통한 접근이 불가능하다
	//	System.out.println("pc.num -> " + pc.num);
	
	
	
	
	
	
	
	}

	
	
	
	
}



