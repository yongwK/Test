

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;

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
		//frm.setBounds(100, 100, 500, 500);
		//frm.setSize(dim);
		frm.setBounds(rect);
		
		
		// 창을 show
		frm.setVisible(true);
	}

	
	public static void main(String[] args) {
		new FrameTest();

	}

}
