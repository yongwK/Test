
public class FinalMain extends FinalTest {

	public FinalMain() {

	}

	public void start() {
		System.out.println("STATUS = " + STATUS);
		//STATUS = 3;
		//total();
		total(); // 상위클래스에 있는걸 사용할떄 super.
	}
	// 오버라이딩
	public void totalEven(final int k) {
		//k=200;  // final 변수이므로 값을 변경할수 없다.
		System.out.println("1~100까지의 짝수의 합은 2550");
	}
	
	
	public static void main(String[] args) {
		new FinalMain().start();

	}

}
