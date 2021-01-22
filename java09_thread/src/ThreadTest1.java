
// 1. Thread 클래스 상속
public class ThreadTest1 extends Thread {
	String title;
	public ThreadTest1(String title) {
		
		this.title = title;
	}
	public ThreadTest1() {	}
	
	//2. run() 메서드 오바라이딩 - 스레드로 구현하고자 하는 코드
	public void run() {
		for(int i=1; ;i++) {
			System.out.println(title + "=" + i);
			try {Thread.sleep(500);} catch(Exception e) {}
		}
	}
	
	
	public static void main(String[] args) {  //main 메서듣도 JVM이 Thread로 구현하고있는것
		ThreadTest1 tt1 = new ThreadTest1("첫번쨰 쓰레드");
		ThreadTest1 tt2 = new ThreadTest1("두번쨰 쓰레드");
		// 3. 스레드 등록 --> 등록한 순서대로 시작하는건 아니고 순서는 랜덤이다.
		// 프로그램한개 에서 여러개가 실행되고 있다.
		tt1.start();
		tt2.start();
	}

}
