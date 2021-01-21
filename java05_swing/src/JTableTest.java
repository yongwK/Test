import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame {
	JTable table;
		//JTable(TableModel dm)
		// 제목 Object[] columnNames,  TabelColumnModel
		//DefaultTableModel(Object[][] data, Object[] columnNames)
		String title[] = {"번호","이름","연락처","이메일"};
		Object data[][] = {
				{1,"홍길동","010-2525-9999","abcde@nate.com"},
				{2,"이순신","010-1111-9999","zyz@nate.com"},
				{3,"세종대왕","010-6666-1111","ccccc@nate.com"},
				{4,"장영실","010-3232-8888","ggggg@nate.com"},
				{5,"유승룡","010-5656-3333","kkkkk@nate.com"},
		};
		
		DefaultTableModel model;
		
		JScrollPane sp;
	
	JLabel lbl =new JLabel("선택한 정보가 표시되는곳");
	
	public JTableTest() {
		
		model = new DefaultTableModel(data,title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		add(lbl,"South");
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {  // me 안에 마우스 왼쪽, 가운데, 오른쪽 어느걸 클릭했는지다 들어간다
				//마우스의 버튼 종류 알아내기   왼쪽, 가운데, 오른쪽
				int clickBtn = me.getButton(); // 1 : 왼쪽, 2: 휠, 3: 오른쪽버튼
				
				if(clickBtn ==1) {
					//선택한 행의 데이터 가져오기
					int selRow = table.getSelectedRow();
					String txt = "";
					for(int c= 0; c<table.getColumnCount(); c++) {
						Object obj = table.getValueAt(selRow, c);
						txt += obj+ ",    ";
					}
					lbl.setText(txt);
				}
			}
		});
		//tableSet();
	}

	public void tableSet() {
		try {	Thread.sleep(3000); }catch(Exception e) {}
			
			//행추가 - 마지막행
			Object[] d = {6,"강감찬","010-8888-1111","nnnnnnn@naver.com"};
			model.addRow(d);
		
		try {	Thread.sleep(2000); }catch(Exception e) {}
		//행 삽입 - 원하는 index에 목록 추가 // 추가된후 원래있던것들은 뒤 index로 밀린다.
		Object[] d2 = {7,"광개토태왕","010-2222-1111","mmmmmmm@naver.com"};
		model.insertRow(2, d2);
		
		try {	Thread.sleep(2000); }catch(Exception e) {}
		// 행이동 - 원하는 위치 여러행 이동
		//           start, end,    to // 3,4,5 가 index 1번위치로 올라왔다 나머지는 뒤로밀린다.
		model.moveRow(3,      5,     1);
		
		try {	Thread.sleep(2000); }catch(Exception e) {}
		//컬럼(열)추가
		model.addColumn("비고");
		
		try {	Thread.sleep(2000); }catch(Exception e) {}
		//행삭제 - 마지막상태에 있는 index가 삭제된다.
		model.removeRow(2);
		
		try {	Thread.sleep(2000); }catch(Exception e) {}
		//컬럼삭제
		table.removeColumn(table.getColumn("비고"));
	
	}
	
	public static void main(String[] args) {
		new JTableTest();

	}

}
