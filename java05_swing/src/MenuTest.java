import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


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
		
		//글꼴을 넣을 콤보박스
		JComboBox<String> fontName;
		
		//font 관련기능
		int bold = 0, italic = 0;
		Font fnt = new Font("굴림체",0,14);
		
		////////////////////////	
		String textBuffer;
		
		
		//현재 작업중인 파일객체
		File nowFile;
		
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
		
		//초기글자크기
		fontSize.setSelectedItem(14);
		
		// tb에 comboBox 대입
		tb.add(fontSize);
		add(BorderLayout.NORTH, tb);
		
		// 윈도우 운영체제의 글꼴 얻어오기  클래스 GraphicsEnvironment // 생성자메서드 protected라서 객체를 return해주는 메서드 사용
		GraphicsEnvironment ge =  GraphicsEnvironment.getLocalGraphicsEnvironment();
		 // fontList에 글꼴이 다 들어가있다 getAvailableFontFamilyNames() 메서드가 글꼴을 가져오는 메소드 임
		String[] fntList = ge.getAvailableFontFamilyNames();
		fontName = new JComboBox<String>(fntList);
		
		//폰트 초기값설정
		fontName.setSelectedItem("굴림체");
		tb.add(fontName);
		
		
		ta.setFont(fnt);
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
		
		//툴바
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		fontSize.addActionListener(this);
		fontName.addActionListener(this);
		}
		
		
		
		
		
		
		
		
		
		
		
	//	오버라이딩						JMenu, JButton, JComboBOx  // 종류를 구별하는것
	public void actionPerformed(ActionEvent ae) {
		
		Object eventObj = ae.getSource();//getSource()는 componenet구분없이 사용가능 
		
		//이벤트가 발생한 객체가 어떤 클래스로 생성된 것인지 확인(객체의종류)
		if(eventObj instanceof JMenuItem) {    // eventObj 이 JMenuItem 클래스로 만들어진거니?
			String eventMenu = ae.getActionCommand();
			if(eventMenu.equals("새문서")) {
				newFile();
			}else if(eventMenu.equals("열기")) {
				fileOpen();
			}else if(eventMenu.equals("저장")) {
				fileSave();
			}else if(eventMenu.equals("종료")) {
				System.exit(0);
			}else if(eventMenu.equals("오려두기")) {
				setCut();
			}else if(eventMenu.equals("붙여넣기")) {
				setPaste();
			}else if(eventMenu.equals("복사하기")) {
				setCopy();
			}else if(eventMenu.equals("메모장")) {
				startRuntime("notepad.exe");
			}else if(eventMenu.equals("크롬")) {
				//				\ --> / 로 바꿔줘야함			경로쓰고 한칸 띄우고   내가 원하는 주소 설정가능
				startRuntime("C://Program Files/Google/Chrome/Application/chrome.exe https://www.nate.com");
				
			}
		}
		
		else if(eventObj instanceof JButton) {
			if(eventObj == boldBtn) {
				if(bold == 0) {
					bold = 1;
				}else {
					bold = 0;
				}
				fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}
		
		
			else if(eventObj == italicBtn) {
				if(italic ==0) { italic =2; }
				else { italic = 0; }
				fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}
			else if(eventObj == openBtn) {
				fileOpen();
			}
			else if(eventObj == newBtn) {
				newFile();
			}
			else if(eventObj == saveBtn) {
				fileSave();
			}
			
		}
		
		else if(eventObj instanceof JComboBox) {
			if(eventObj == fontSize || eventObj == fontName) {
				fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}
		}	
	}
	
	
	
	//새문서
	public void newFile() {
		//작업문서 객체 초기화
		nowFile = null;
		ta.setText("");
		setTitle("메모장");
	}
		
	//파일저장
	public void fileSave() {
		//처음저장할때
		if(nowFile==null) {
			//파일을 저장할수 있는 경로를 만들어줘야 한다. FileChooser . showSaveDialog
			JFileChooser fc = new JFileChooser();
			
			//save == 0, cancle == 1;
			int state = fc.showSaveDialog(this); //부모 컨테이너는 Frame뜻함
			if(state ==0) { // 저장버튼 선택시
				//선택한 드라이브명, 경로, 파일명 
				File nFile = fc.getSelectedFile();
				// 글내용 
				String str = ta.getText();
				// 중복된이름
				if(nFile.exists()) {
					JOptionPane.showMessageDialog(this, "이미존재하는 파일명입니다.\n저장하기가 취소되었습니다.");
				}else {
					try {
						// FileWriter 객체
						FileWriter fw = new FileWriter(nFile);	
						fw.write(str,0,str.length());
						fw.flush();
						fw.close();
						
						nowFile = nFile;
						setTitle(nFile.getPath());
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}	
		else {
			//이미있는 문서를 열어서 수정후 저장한다.
			String writeText = ta.getText();
			try {
				FileWriter fw = new FileWriter(nowFile);
				fw.write(writeText, 0, writeText.length());
				fw.flush();
				fw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
		
		
	//파일열기
	public void fileOpen() {
		File f = new File("D://SAMPLE");
		// 파일탐색기    ---- 열기를 누르면 파일탐색기가 나와야 한다.  JFileChooser()
		JFileChooser fc = new JFileChooser(f);      //  showOpenDialog(Component parent) // Component parent --> 부모컨테이너를 알려줘  this
		
		//여러파일을 선택할 수 있도록 설정
		fc.setMultiSelectionEnabled(true); // true: 다중선택 가능, false : 1개 // 드라이브명, 경로, 파일명
		//필터설정
		FileFilter ff1 = new FileNameExtensionFilter("이미지","jpg","jpeg","gif","png","bmp");
		fc.addChoosableFileFilter(ff1);
		FileFilter ff2 = new FileNameExtensionFilter("Java", "java","JAVA","JAVA");
		fc.addChoosableFileFilter(ff2);
		
		// 0 : 열기, 1 : 취소
		int state = fc.showOpenDialog(this); // 파일 탐색기가 열림 --> 기본경로 지정  객체 생성할떄 JFileChooser(String ~);  
		if(state == 0) {
			try {
				// 원래 있던 컨텐츠 지우기
				ta.setText("");
				// 선택된 파일을 가져오기      getSelectedFIle() --> File      // getSelectedFiles() ---> File[]
				// File selFile = fc.getSelectedFile(); 1개파일 열기가능
				File selFile[] = fc.getSelectedFiles();
				
				for( File s : selFile) {
					// 현재 파일명을 JFrame의 제목으로 설정
					// 현재 프레임이 상속되어있다.
					String path = s.getPath();
					setTitle(path);
					
					nowFile = s;
					
					FileReader fr = new FileReader(s);
					BufferedReader br = new BufferedReader(fr);
					
					while(true) {
						String inData = br.readLine();
						if(inData==null) {
							break;
						}
						else {
							ta.append(inData+"\n");
						}
					} // while종료
					// ta.append("==========================\n");
				} //for문 종료			
			}catch(Exception e) {
				System.out.println("파일열기 에러 발생..");
			}
					
		}
		
		//showOpenDialog() --- > int 로 반환되며   이때 open 일떄 cancle일떄 마다 int 값이 다르므로 구분가능하다.
	}
	
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
