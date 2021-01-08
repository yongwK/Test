

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class FrameTest {
	//객체를 이용한 컨테이너 생성
	Frame frm = new Frame();
	Dimension dim = new Dimension(400,300);
	Point pnt = new Point(200,200);
	Rectangle rect = new Rectangle(pnt, dim);
	public FrameTest() {
		frm.setTitle("연습용 프레임");
		
	// 창의 크기 설정
		//frm.setSize(500, 500);
		//frm.setSize(dim);

		//frm.setBounds(100, 100, 500, 500);
		frm.setBounds(rect);		
		
		//frm.pack();
		
	//버튼만들기는 창을 show하기전에 해야한다.
		Button btn1 = new Button("버튼1");
	//컨테이너에다가 생성한 btn1 을 넣어줘야 한다. add(Component com)	
		frm.add(btn1);
		
		Button btn2 = new Button("버튼2");
	// frame 의 기본 방식은 borderLayout방식이라서 방향설정 안하면 중앙에만 생김
	//			BorderLayout.North -> 방향을 설정해줘야한다.
		frm.add("North",btn2);
		frm.add(BorderLayout.EAST, new Button("버튼3"));
		frm.add(BorderLayout.SOUTH, new Button("버튼4"));
		frm.add(BorderLayout.WEST, new Button("버튼5"));
		
		
		
	// 창을 show
		frm.setVisible(true);
		
	//아이콘 생성
		Toolkit kit = Toolkit.getDefaultToolkit();
		// 이미지를 가져와서 img를 사용할수 있게 img에 넣었다
		// img(생성한폴더src랑 동등한위치)/ (안으로 이동) "사진파일명"
		Image img = kit.getImage("img/DSC03092.jfif");
		frm.setIconImage(img);
		
		
	}

	
	public static void main(String[] args) {
		new FrameTest();

	}

}
