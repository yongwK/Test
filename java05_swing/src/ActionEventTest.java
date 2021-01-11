import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//										인터페이스 상속	
public class ActionEventTest implements ActionListener {
	JFrame frm = new JFrame("Action event");
	JButton jbtn = new JButton("클릭");
	JButton jbtn2 = new JButton("3단");
	JTextArea jta = new JTextArea("버튼을 클릭하세요..."); 
	JScrollPane sp = new JScrollPane(jta); // jta를 스크린 패널에 넣고 sp를 frm에 넣는다.
	
	public ActionEventTest() {

		frm.add(jbtn, BorderLayout.NORTH);
		frm.add(jbtn2, BorderLayout.SOUTH);
		frm.add(sp);

		
		frm.setSize(500, 500);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
		// 이벤트등록	(객체 생성하자마자 실행되므로)
		jbtn.addActionListener(this); // append 처리할거고 --> 
		jbtn2.addActionListener(this); // text 박스에 구구단을 출력시킬거임
	}

	public void actionPerformed(ActionEvent ae) {
		// method : setText() : 새로운문자로 셋팅
		//			append() : 마지막에 문자 추가
		// 			insert() : 원하는위치(index)에 문자추가
		// jta.append("Click\n");
		
		
		// 1. 이벤트가 발생한 버튼 알아내기 -> getActionCommand()
		
		String evt = ae.getActionCommand(); // 라벨을 얻어서 if를 통해 찾아서 실행
		if(evt.equals("클릭")) {
			jta.append(evt + "\n");
		}else if(evt.equals("3단")) {
			gugudan(3);
		}
		
		/*
		//2. 이벤트가 발생한 객체를 이용하여 알아내는 방법
		Object obj = ae.getSource();
		if(obj == jbtn) { // 클릭버튼 선택시
 			jta.append("btn버튼 클릭\n");
		}else if(obj == jbtn2) {
			gugudan(9);
		}
		*/
	}
	
	public void gugudan(int dan) {
		for(int i = 1; i<=9; i++) {
			jta.append(dan + "*" + i + " = " + (dan*1)+ "\n" );
		}
	}
	
	
	
	public static void main(String[] args) {
		new ActionEventTest();

	}

}
