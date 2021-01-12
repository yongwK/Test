import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class windowEventTest extends JFrame implements WindowListener{
	JLabel lbl = new JLabel("계산기");
	Calculator cal = new Calculator();
	
	public windowEventTest() {
		add(lbl,"North");
		add(cal);
		
		setSize(500,300);
		setVisible(true);
		// 프로그램 종료시 자원 해제
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	
	
		// 창닫기 금지
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
	}



	@Override
	public void windowOpened(WindowEvent e) {	
		System.out.println("Opened()");
	}
	@Override
	public void windowClosing(WindowEvent e) {		
											// 부모의 클래스  	메시지		창타이틀이름			옵션
		int state = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?","종료확인", JOptionPane.YES_NO_OPTION);
		
		if(state == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		System.out.println("Closing()");
		
		
	}
	@Override
	public void windowClosed(WindowEvent e) {	
		System.out.println("Closed()");
	}
	@Override
	public void windowIconified(WindowEvent e) {	
		System.out.println("Iconified()");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {		
		System.out.println("Deiconified()");
	}
	@Override
	public void windowActivated(WindowEvent e) {	
		System.out.println("Activated()");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {	
		System.out.println("Deactivated()");
	}




	public static void main(String[] args) {
	new windowEventTest();

	}
}
