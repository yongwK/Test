import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

// Adapter 상속
// JFrame , windowAdapter 중 선택해야함 1개만 상속받을수 있으므로
public class WindowAdapterTest extends WindowAdapter{
	JFrame frm = new JFrame("WindowAdapter Test");
	
	public WindowAdapterTest() {
		
		frm.setSize(500,500);
		frm.setVisible(true);
		// frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		frm.setDefaultCloseOperation(frm.DO_NOTHING_ON_CLOSE);
	
		frm.addWindowListener(this); //frm에 대한 이벤트 등록
	}

	public void windowClosing(WindowEvent we) {    // WindowAdapter에서 필요한 것만 오버라이딩한것 Adapter class 덕분에 가능
		System.out.println("윈도우 이벤트 발생합니다.");
		//자원해제
		frm.dispose();
		System.exit(0);
		
	}
	
	
	public static void main(String[] args) {
	
		new WindowAdapterTest();
	}

}
