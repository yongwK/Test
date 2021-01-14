import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class JButtonTest extends JFrame {

	ImageIcon ii1 = new ImageIcon("img/movie01.png");
	ImageIcon ii2 = new ImageIcon("img/movie02.png");
	ImageIcon ii3 = new ImageIcon("img/movie03.png");
	ImageIcon ii4 = new ImageIcon("img/movie04.png");
	ImageIcon ii5 = new ImageIcon("img/movie05.png");
	public JButtonTest() {
	
		super("JButton Test");
		setLayout(new GridLayout(0,3,10,10)); //레이아웃변경
		
		JButton btn1 = new JButton(ii1);
		add(btn1);
		//버튼의 비활성화
		btn1.setEnabled(false); // true : 활성화, false : 비할성화
		
		JButton btn2 = new JButton("확인", ii2);
		add(btn2);
		
		
		//JRadioButton 만들기
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(3,1));
		
		JRadioButton rb1 = new JRadioButton("ONE");
		JRadioButton rb2 = new JRadioButton("TWO");
		JRadioButton rb3 = new JRadioButton("THREE",true);
		
		//radioButton 그룹화 (n개중 1개만 선택할수 있게)
		// ButtonGroup : radiobutton  객체를 만들어 등록
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		
		pane.add(rb1);	pane.add(rb2);	pane.add(rb3);
		add(pane);
		
		//마우스를 올리면 아이콘 ii3로 변경
		btn2.setRolloverIcon(ii3);
		
		//마우스 누른상태일 아이콘 ii4로 변경
		btn2.setPressedIcon(ii4);
		
		
		
		//ToggleButton 1->0 0->1 A->B B->A
		JToggleButton tb1 = new JToggleButton("토글버튼");
		JToggleButton tb2 = new JToggleButton(ii5, true);
		//tb2.setRolloverSelectedIcon(ii4);
		//tb2.setVisible(false);
		add(tb1);   add(tb2);
		
		
		//setBackground() : 컴퍼넌트 or 컨테이너 배경색을 설정한다.
		btn2.setBackground(Color.PINK);
		
		//
		Color clr1 = new Color(150,200,50); // 컬러는 숫자가 높을수록 연한색
		rb1.setBackground(clr1);
		
		//글자색 변경
		tb1.setForeground(Color.blue);
		
		
		// JLabel : 라벨 컴포넌트  , 설명 같은 내용임 [ 기타 :  ] <<- 이런 내용   
		JLabel lbl1 = new JLabel(ii3);
		JLabel lbl2 = new JLabel("라벨", JLabel.CENTER);
		add(lbl1);
		add(lbl2);
		
		
		//라벨에 배경색 --> 투명처리되있어서 라벨에는 배경색이 안씌워진다. 투명을 true해줘야 된다.
		lbl2.setBackground(Color.blue);
		
		// 투명처리 setOpaque(true : 투명해제, or false: 투명)
		lbl2.setOpaque(true);
		
		// 툴팁 - 마우스 대면 설명 나오고 마우스 떄면 없어지고
		btn2.setToolTipText("버튼연습중...");
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
	new JButtonTest();

	}

}
