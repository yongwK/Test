import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarSwing extends JFrame implements ItemListener, ActionListener{ // 이벤트 인터페이스 추가
	//달력 폰트 객체 생성
	Font fnt = new Font("굴림체", Font.BOLD, 20);
	
	//상단
	JPanel selectPane = new JPanel();
		JButton prevBtn = new JButton("◀");
		JButton nextBtn = new JButton("▶");
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		JLabel yearLbl = new JLabel("년");
		JLabel monthLbl = new JLabel("월");
	
	//가운데	// 가운데 패널안에 2개의 패널을 넣는데 1개는 북쪽에 1개는 중앙에 넣을거임
	JPanel centerPane = new JPanel(new BorderLayout());
		// 요일은 고정된다.
		JPanel titlePane = new JPanel(new GridLayout(1,7));
			String[] title = {"일","월","화","수","목","금","토"};
		//0행 -->  행의 제한은 두지 않고 7열은 제한을 두겠다.
		JPanel dayPane = new JPanel(new GridLayout(0,7));
		
		
		
		
	//달력관련 데이터
	Calendar date;
	int year;
	int month;	
	
	
		public CalendarSwing() {
		super("달력");
		//현재의 날짜 시간 객체 생성
		date = Calendar.getInstance();
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH)+1;
		
		
		//상단 버튼추가 및 배경색 지정
		selectPane.setBackground(new Color(150,200,200));
		selectPane.add(prevBtn); 		prevBtn.setFont(fnt);
		selectPane.add(yearCombo);		yearCombo.setFont(fnt);
		selectPane.add(yearLbl); 		yearLbl.setFont(fnt);
		selectPane.add(monthCombo); 	monthCombo.setFont(fnt);
		selectPane.add(monthLbl); 		monthLbl.setFont(fnt);
		selectPane.add(nextBtn); 		nextBtn.setFont(fnt);
		
		add("North", selectPane);
		//년월셋팅
		setYear();
		setMonth();
		
		//타이틀 셋팅
		setCalendarTitle();
		centerPane.add(titlePane, "North");
		add(centerPane);
		
		
		
		//날짜 만들기
		centerPane.add(dayPane);
		setDay();
		
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		// 년월 이벤트 등록
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		
		// 버튼 이벤트 등록
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		
		
		
	
	}
	
	public void actionPerformed(ActionEvent ae) {	
		Object obj = ae.getSource();
		if(obj == prevBtn) { // 이전월 눌렀을때
			prevMonth();
		}else if(obj == nextBtn) { // 다음월
			nextMonth();
		}
	}
	
	
	//////////////////////////
	public void setDayReset() {
		//이벤트제거 -> 년월 셋팅 -> 기존 날자 제거 후 -> 날자 셋팅 -> 이벤트 등록
		//년월 콤보박스 이벤트 등록해제
		yearCombo.removeItemListener(this);
		monthCombo.removeItemListener(this);
		
		//년도랑 월을 셋팅한다
		yearCombo.setSelectedItem(year); // 이벤트를 제거했기떄문에 이벤트가 발생하지 않고 년도만 셋팅됨
		monthCombo.setSelectedItem(month); // 이벤트를 제거했기떄문에 이벤트가 발생하지 않고 월만 셋팅됨
		
		
		dayPane.setVisible(false);	// 기존에 있던 day를 삭제 해주고 
		dayPane.removeAll();		//
		setDay();					// 세로운 day를 셋팅
		dayPane.setVisible(true);
		
		
		// 이벤트 다시등록 
		yearCombo.addItemListener(this); // 다시 이벤트 등록
		monthCombo.addItemListener(this);
	}
	public void nextMonth() {
		
		if(month == 12) {//월이 12월인경우 다음해로 넘어가면 1월로 바꿔주고 년을 1더해줌
			year++;
			month = 1;
		}else {// 12월이 아닌경우 월말 + 시켜준다.
			month++;
		}
		
		setDayReset(); // 바뀐 날짜로 셋팅
	}
	
	public void prevMonth() {
		if(month == 1) { // 월이 1월인경우 12월로 바뀌고 년이 -된다. 
			year--;
			month = 12;
		}else { // 1월이 아닌경우 달만 - 해준다.
			month--;
		}
		setDayReset();


	}
		
	public void itemStateChanged(ItemEvent ie) {
		year = (int)yearCombo.getSelectedItem();     // year콤보박스에서 선택한 년도를 year로 가져온다.
		month = (int)monthCombo.getSelectedItem();   // month콤보박스에서 선택한 월을 month로 가져온다.
		
		dayPane.setVisible(false);			// day를 새로 찍어주려면 기존에 있던 day를 삭제후 해야한다.
		dayPane.removeAll();				// visible(false) 시키고 removeall()해준다.
		setDay(); // 날짜 처리 함수 호출			// 다시 셋팅
		dayPane.setVisible(true);			// 다시 화면에 출력 setvisible(true);
	}
		
	//날짜 셋팅
	public void setDay() {
		//요일
		date.set(year, month-1, 1); //날짜를 셋팅해준다.
		int week = date.get(Calendar.DAY_OF_WEEK); //
		//마지막날
		int lastDay = date.getActualMaximum(Calendar.DATE);
		//공백
		for(int s = 1; s<week; s++) {
			JLabel lbl = new JLabel(" ");
			dayPane.add(lbl);
		}
		for(int day = 1; day<=lastDay; day++) {
			JLabel lbl = new JLabel(String.valueOf(day), JLabel.CENTER); //  int-> String 으로 변환
			lbl.setFont(fnt);
			//출력하는 날짜에 대한 요일 
			date.set(Calendar.DATE, day); // 
			int w = date.get(Calendar.DAY_OF_WEEK); //day를 일(1) ~ 토(7) int값으로 바꾸고 w따라 글자색 변환 
			if(w==1) lbl.setForeground(Color.red);	// 일요일마다 빨간색 글씨 색 바꾸기
			if(w==7) lbl.setForeground(Color.blue);  // 토요일마다 파란색으로 글씨색 바꾸기
			dayPane.add(lbl);
		}
	}
		
		
		
		
	//년도 셋팅
	public void setYear() { // 콤보박스에  년도 데이터  셋팅 
		for(int i = year-50; i<year+20; i++) {
			yearCombo.addItem(i);
		}
		yearCombo.setSelectedItem(year);
	}
		
		
	//월셋팅
	public void setMonth() { // 콤보박스에 월 데이터 셋팅
		for(int i = 1; i<=12; i++) {
			monthCombo.addItem(i);
		}
		monthCombo.setSelectedItem(month);
	}
	
	//월화수목 타이틀 셋팅
	public void setCalendarTitle() { // 배열로 들어가있는 일~토 for문으로 대입 / font와 글짜색 같이 변경 후 / 패널에추가
		for(int i = 0; i<title.length; i++) {
			JLabel lbl = new JLabel(title[i], JLabel.CENTER);
			lbl.setFont(fnt);
			if(i==0) lbl.setForeground(Color.red);
			if(i==6) lbl.setForeground(Color.blue);
			titlePane.add(lbl);
		}
	}
	
	
	public static void main(String[] args) {
		new CalendarSwing();

	}

}
