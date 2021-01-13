import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class MenuTest extends JFrame implements ActionListener {
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	
	JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
			JMenuItem newMenuItem = new JMenuItem("새문서");
			JMenuItem openMenuItem = new JMenuItem("열기");
			JMenuItem saveMenuItem = new JMenuItem("저장");
			JMenuItem endMenuItem = new JMenuItem("종료");
		JMenu editMenu = new JMenu("편집");
			JMenuItem cutMenuItem = new JMenuItem("오려두기");
			JMenuItem copyMenuItem = new JMenuItem("복사하기");
			JMenuItem pasteMenuItem = new JMenuItem("붙여넣기");
		JMenu runMenu = new JMenu("실행");
			JMenuItem chromMenuItem = new JMenuItem("크롬");
			JMenu editor = new JMenu("편집기");
				JMenuItem memoMenuItem = new JMenuItem("메모장");
				JMenuItem editplusMenuItem = new JMenuItem("에디트플러스");
			JMenuItem compileMenuItem = new JMenuItem("컴파일");
	
		/////////툴바////////////////
		JToolBar tb = new JToolBar();
		// JToolBar 안에 들어갈내용 -> 새문서, 저장, 열기, BOLD, ITALIC
		//새문서
		ImageIcon newIcon = new ImageIcon("icon/new01.gif"); JButton newBtn = new JButton(newIcon);
		//저장
		ImageIcon saveIcon = new ImageIcon("icon/save01.gif"); JButton saveBtn = new JButton(saveIcon);
		//열기
		ImageIcon openIcon = new ImageIcon("icon/open01.gif"); JButton openBtn = new JButton(openIcon);
		//진하게
		ImageIcon boldIcon = new ImageIcon("icon/bold01.gif"); JButton boldBtn = new JButton(boldIcon);
		//이탤릭
		ImageIcon italicIcon = new ImageIcon("icon/italic01.gif"); JButton italicBtn = new JButton(italicIcon);	
		//글자크기
		JComboBox<Integer> fontSize = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> fontSizeModel = new DefaultComboBoxModel<Integer>();
		
		
		
		////////////////////////	
		String textBuffer;
		
		
		public MenuTest() {
			
		super("메모장");
		add(sp);
		// 파일메뉴
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();// 메뉴끼리 경계선
		fileMenu.add(endMenuItem);
		mb.add(fileMenu);
		
		//편집메뉴
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		mb.add(editMenu);
		//실행
		runMenu.add(chromMenuItem);
		runMenu.add(editor);
			editor.add(memoMenuItem);
			editor.add(editplusMenuItem);
		runMenu.add(compileMenuItem);
		mb.add(runMenu);
		
		
		
		setJMenuBar(mb);
		////툴바//////////////////////////
		tb.add(newBtn);
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator();
		tb.add(boldBtn);
		tb.add(italicBtn);
		
		// fontSizeModel에 값 대입하기 addElement()
		for(int i = 8; i<=70; i+=3) {
			fontSizeModel.addElement(i);
		}
		// fontSize에  모델 대입하기 setModel();
		fontSize.setModel(fontSizeModel);
		// tb에 comboBox 대입
		tb.add(fontSize);
		add(BorderLayout.NORTH, tb);
		
		
		//////////////////////////////
		
		//단축키설정
		setShortCut();
		
		
		//
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트등록
		newMenuItem.addActionListener(this);
		openMenuItem.addActionListener(this);
		saveMenuItem.addActionListener(this);
		endMenuItem.addActionListener(this);
		
		cutMenuItem.addActionListener(this);
		copyMenuItem.addActionListener(this);
		pasteMenuItem.addActionListener(this);
		
		chromMenuItem.addActionListener(this);
		memoMenuItem.addActionListener(this);
		editplusMenuItem.addActionListener(this);
		compileMenuItem.addActionListener(this);
		
		
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		}
		
		
	public void actionPerformed(ActionEvent ae) {
		String eventMenu = ae.getActionCommand();
		Object eventObj = ae.getSource();
		
		if(eventMenu.equals("종료")) {
			System.exit(0);
		}else if(eventMenu.equals("오려두기")) {
			setCut();
		}else if(eventMenu.equals("붙여넣기")) {
			setPaste();
		}else if(eventMenu.equals("복사하기")) {
			setCopy();
		}else if(eventMenu.equals("메모장")) {
			startRuntime("notepate.exe");
		}else if(eventMenu.equals("크롬")) {
			//						\ --> / 로 바꿔줘야함			경로쓰고 한칸 띄우고   내가 원하는 주소 설정가능
			startRuntime("C://Program Files/Google/Chrome/Application/chrome.exe https://www.nate.com");
		}else if(eventMenu.equals("에디트플러스")) {
			startRuntime("C://Program Files/EditPlus/editplus.exe");
		}else if(eventObj == boldBtn) {
			Font fnt = new Font("궁서체", Font.BOLD, 20);
			ta.setFont(fnt);
		}
	}
	
	
	
	
	// 툴바 생성  -> 바안에 JButton 이 들어간다(라벨이 이미지임)
	
	
	
	
	
	// 외부 프로그램을 실행시키는 클래스 java.lang    Runtime class
	public void startRuntime(String process) {
		// 멤버변수와, 생성자가 없는 클래스의 경우--> 객체를 생성해주는 메서드가 있다.  ---> Runtime() < ---- getRuntime();
		// Runtime class 의 .exec() 매서드가 프로그램을 시켜주는데  무조건 IOException 예외처리를 해줘야한다. 
		Runtime run = Runtime.getRuntime();
		try {
			run.exec(process);	
		}catch(IOException ie) {
			ie.getStackTrace();
		}
		
	}

	//복사하기
	public void setCopy() {
		textBuffer = ta.getSelectedText();
	}
	
	//붙여넣기 ---> 오려둔 문자가 --> 커서의 위치로 들어가야한다. // 오려두기를 안하면 실행 안되도됨 즉 textBuffer == null일떄
	public void setPaste() {
		if(textBuffer !=null && !textBuffer.equals("")) {
			ta.replaceSelection(textBuffer); // 커서있는 자리는 선택된 자리이다.
		}
	}
	
	//오려두기
	public void setCut() {
		// 선택된 글자를 가져오는것 // 선택된 색을 가져오는것 getSelectedColor()
		textBuffer = ta.getSelectedText();
		ta.replaceSelection(""); // 위에서 선택된 텍스트를 ""로 바꿔준다.
	}
	
	//단축키설정
	public void setShortCut() {
		//종료 : ctrl [마스크라고함] + e
		//1.  단축키를 무엇으로 할것인지 설정 (여기선 e)
		endMenuItem.setMnemonic(KeyEvent.VK_E);
		//2. ctrl 단축키의 Mask설정					
		// //set.Accelerator(KeyStroke keyStroke)	         단축키	             MASK키
		endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	
		//새문서 Ctrl + n
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		//열기 alt + o
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		//저장 Ctrl + s
		saveMenuItem.setMnemonic(KeyEvent.VK_S);
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	
	}

	public static void main(String[] args) {
		new MenuTest();

	}

}
