
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

//implements는 클래스에서 인터페이스를 상속받을때 키워드로 사용한다.
// 클래스에서 인터페이스는 여러개를 상속받을수 있다 그럴떈 lmplements a,b,c,b ,를사용한다.
// 상속받은 모든 추상메소드를 오버라이딩 해야한다.

public class InterfaceMain implements InterfaceTest, ActionListener{

	public InterfaceMain() {
		
	}

	// 인터페이스에 있는 모든 추상메서드를 다 오버라이딩 해야됨
	
	public void print() {
		System.out.println(global + "-->" + MAX);
	}
	
	public int[] recordAll(int num) {
		Random r = new Random();
		int[] ran = new int[num];
		for(int i=0; i<ran.length; i++) {
			ran[i] = r.nextInt(100);
		}
		return ran;
	}
	
	public String total(int max) {
		return "total";
	}
	
	public double getDate(int data) {
		return (double)data;
	}
	
	public void actionPerformed(ActionEvent ae) {}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		InterfaceMain im = new InterfaceMain();
		im.print();
		int n[] = im.recordAll(10);
		System.out.println(Arrays.toString(n));

	}

}
