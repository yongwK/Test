//상속은 클래스명 오른쪽에다가 쓴다     extends 상속받을 클래스명
// 클래스 - 클래스 상속시 ( extends 상속받을 클래스명 )
// 클래스는 1개만 상속 받을수 있다. 
public class Sedan extends Car {
	//하위클래스에서 상위클래스에 있는 변수와 같은 변수를 정의할수 있다.
	String carColor = "Orange";  // 상위클래스에 있음
	int speedMax = 150;   // 상위클래스에 없음
	public Sedan() {
	//상속 받을 경우 상속 받은 상위 클래스의 생성자메소드가 실행되고
		// 현재 생성자 메소드가 실행된다.
		System.out.println("Sedan()생성자메소드");
	}

	public Sedan(String carName, String carColor) {
		//상위클래스의 생성자를 호출하는 방법 - 기본적으로는 매개변수가 없는 생성자메소드가 생성된다.
		// 다른 매개변수 있는 생성자메소드를 호출한다.  -> 그러면 매개변수 없는 생성자메소드는 호출되지 않는다.
		// 상위클래스의 생성자 호출은 첫번째 행으로 표시.
		super("그랜져", 50, "Gray");
		
		
		//super.carName = carName;
		this.carName = carName; // 위와 동일  this를 쓸때 현재 클레스가 없으면 상위 클래스에 가서 멤버변수를 사용을한다.
		super.carColor = carColor;
		System.out.println("Sedan(String, String)생성자메소드");
	}
	
	
	public void start() {
		System.out.println(" 색상 = " + carColor); 
		System.out.println(" 색상(parent) = " + super.carColor);
		System.out.println(" 이름 : " + carName);
	}											
	// this는 자신의 클래스 ,, 상위 클래스 super 
	// 상위,하위 다있는데 뭐가 될거냐 --> //현재 클래스에 있는게 출력됨
	// 그럼 상위 클래스에 있는 걸 사용하고 싶을떄는 어떻게 하냐?  super.   사용
	
	public void speedUp() {         // 상위클래스와 동일한 메서드가 있을때 어느게 호출될까?
		speed += 15;				// 가까운 자기 클래스의 메서드가 호출된다.
		if(speed>150) {				// 이렇게 동일한 메서드를 하위에서 새로 정의하는 것음
			speed = 150;			// 오버라이딩이라고 한다.
		}
	}
	
	
	
	public static void main(String[] args) { 
		Sedan s = new Sedan();
		s.speedUp();
		
		//super.speedUp(); 이 안되는 이유는 메인은 Sedan클래스 안이라고 생각하지 말고 보여주기위해
		// 					생성한거라고 생각하면 안되는 이유는 간단하다. main은 또다른 객체다.
		
		
		//System.out.println("s.speedUp() = " + s.speed );	
		
		// s.start();
		//Sedan ss = new Sedan("레오","Blue");
		//ss.start();
	}

}
