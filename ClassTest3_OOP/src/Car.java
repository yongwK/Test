//  objcet를 상속하고 있다 무조건 comfile시에
public class Car {

	
	String carName = "소나타";
	int speed = 0;
	String carColor = "white";
	
	
	public Car() {
		System.out.println("Car()생성자메소드");
		
	}
	
	public Car(String carName, int speed, String carColor) {
		this.carName = carName;
		this.speed = speed;
		this.carColor = carColor;
		System.out.println("Car(sting, int, String)생성자");
	}
	
	public void speedUp() {
		speed += 10;
		if(speed > 100) {
			speed = 100;
		}
	}
	
	public void speedDown() {
		speed -= 10;
		if(speed < 0) {
			speed = 0;
		}
	}
	
	public void call() {
		speedUp();
	}
	
}
