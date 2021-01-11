import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyEventTest extends JFrame implements KeyListener{
	JTextArea jta = new JTextArea();
	JPanel jpane = new JPanel();
	JScrollPane jsp = new JScrollPane(jta); 
	JTextField jtf = new JTextField(20);
	JButton jbtn = new JButton("보내기");
	
	Font fnt = new Font("궁서체",Font.BOLD,20);
	
	public KeyEventTest() {
	
		super("Key이벤트");
		
		add(jsp);
		
		add(jpane, BorderLayout.SOUTH);
		jpane.add(jtf);
		jpane.add(jbtn);
		
		
		//jta 에 Font 객체 설정
		jta.setFont(fnt);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록 --> 현재클래스에매서드가 있으면 this
		jtf.addKeyListener(this);
		
		//다른클래스에서 엑션이벤트처리 -> 다른클래스 객체 생성
		jbtn.addActionListener(new SendButton(jta, jtf));
		
	}
	
	//오버라이딩
	public void keyPressed(KeyEvent ke) { /* 키를 누른상태*/		}
	public void keyReleased(KeyEvent ke) { // 키를 누른후 놓으면
		// 방금 이벤트가 발생한 키 정보 없어오기
		char evtchar = ke.getKeyChar();
		int evtInt = ke.getKeyCode();
		System.out.println(evtchar + "->" + evtInt);
		//1. 엔터키를 눌렀을때 jta에 추가되고 jft에서는 삭제.
		if(evtInt == KeyEvent.VK_ENTER) {
			jta.append(jtf.getText()+"\n");
			jtf.setText("");
		}
		//2. esc 눌렀을떄 종료
		if(evtInt == KeyEvent.VK_ESCAPE) {
			//프로그램 종료
			System.exit(0);
		}

	}
	
	public void keyTyped(KeyEvent ke) { /*키를 누른후 놓으면*/ }
	
	
	
	
	
	

	public static void main(String[] args) {
		
		new KeyEventTest();
	}

}
