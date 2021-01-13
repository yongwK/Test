import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
// 익명의 내부클래스로 Event prossesed
public class WindowAdapterInnerTest2 extends JFrame {   

	JTextField tf = new JTextField("Anoymos Inner class Event prossesing");
	
	
	
	
	public WindowAdapterInnerTest2() {
		
		
		
		
		add(BorderLayout.SOUTH, tf);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		
		//이벤트 발생 대상이 1개일때 사용한다.   // window Event 는 1개일경우가 많으므로 이렇게 사용을 잘한다.
		addWindowListener(new WindowAdapter() {
			// 익명의 내부 클래스에서 매소드를 다시 오버라이딩
			public void windowClosing(WindowEvent we) {
				tf.setText("Window Event prossesing!!!!!!!!!!");
				System.exit(0);
			}
		});
		
		
		
		
		
	}
	

	
	
	public static void main(String[] args) {
		new WindowAdapterInnerTest2();

	}

}
