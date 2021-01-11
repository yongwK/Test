import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FrameTest2 extends Frame {

	public FrameTest2() {
		super("상속받은 frame");// 창제목 
		
		
		//레이아웃 변경 BorderLayout ---> FlowLayout으로 변경  [ ] [ ] [ ] 이형식
		//상속 받아서 쓸때는 객체명을 쓰지 않고 사용할수 있다.
		setLayout(new FlowLayout());
		Button btn = new Button("레이아웃변경됨");
		add(btn);
		Button btn2 = new Button("레이아웃변경됨");
		Button btn3 = new Button("레이아웃변경됨");
		Button btn4 = new Button("레이아웃변경됨");
		
		add(btn2);
		add(btn3);
		add(btn4);
		
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
	new FrameTest2();

	}

}
