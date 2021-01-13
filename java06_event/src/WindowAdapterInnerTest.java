
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowAdapterInnerTest extends JFrame {
	
	JLabel lbl = new JLabel("WindowAdapter Test...");
	public WindowAdapterInnerTest() {
		add(lbl);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // 강제로 못닫히게 하는 방법은 자원해제보다 더 아래쪽에 있어야한다.
		
		//객체를 생성해서 변수에 넣어서 사용해도 가능
		AdapterInner ai = new AdapterInner();
		addWindowListener(ai); // 이벤트가 다른 클래스에 있으므로 객체 생성
		
	}

	
	
	//내부클래스에서 Window 이벤트 처리하기
	class AdapterInner extends WindowAdapter{
		//다시 오버라이딩
		public void windowClosing(WindowEvent we) {
			lbl.setText("Window Event prossesed");
			System.exit(0);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new WindowAdapterInnerTest();

	}

}
