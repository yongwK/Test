
public class MultiClock {

	public MultiClock() {
		
	}

	public static void main(String[] args) {
		
		// 프로세스 1개에서 쓰레드를 사용하여 여러개의 프로그램을 사용한다.
		// 쓰레드를 사용했나 안했나 구분은 run() 메서드가 있는지 없는지 구분한다.
		DigitalClock dc1 = new DigitalClock(1,1,500,200);
		DigitalClock dc2 = new DigitalClock(501,1,500,200);
		DigitalClock dc3 = new DigitalClock(1,201,500,200);
		DigitalClock dc4 = new DigitalClock(501,201,500,200);
		
		Thread t1 = new Thread(dc1);
		Thread t2 = new Thread(dc2);
		Thread t3 = new Thread(dc3);
		Thread t4 = new Thread(dc4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
