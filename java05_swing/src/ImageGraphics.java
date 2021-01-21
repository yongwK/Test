import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageGraphics extends JFrame implements ActionListener{
	
	JPanel pane = new JPanel();
		JButton btn1 = new JButton("원본그리기");
		JButton btn2 = new JButton("축소그리기");
		JButton btn3 = new JButton("확대그리기");
		JButton btn4 = new JButton("좌우뒤집기");
		JButton btn5 = new JButton("상하뒤집기");
		JButton btn6 = new JButton("일부그리기");
	MyCanvas mc = new MyCanvas();
	
	//현재 선택된 버튼 라벨
	String selBtn = "";
	Image img;
	public ImageGraphics() {
		pane.add(btn1); pane.add(btn2); pane.add(btn3); pane.add(btn4); pane.add(btn5); pane.add(btn6);
		add("North",pane);
		add("Center",mc);
		
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		selBtn = e.getActionCommand();
		//paint() 메서드 호출
		mc.repaint();
	}
	
	
	class MyCanvas extends Canvas{
		int w;
		int h;
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/Lighthouse.jpg");
		}
		
		public void paint(Graphics g) {
			//이미지의 폭과 높이를 구한다.
			// ==>>무조건 paint메서드 내에서 구해야 한다.
			//drawImage(Image img, int dx1, int dy1, int dx2, int dy2, [그림그릴 cavas 사이즈영역]
			//             int sx1, int sy1, int sx2, int sy2, [이미지의 그림의 사이즈]
			// 				ImageObserver observer[this로 통칭])
			w = img.getWidth(this);
			h = img.getHeight(this);					

			//이미지를 그림으로 그리기 
			
			if(selBtn.equals("원본그리기")) {
				// 					Canvas		image
				g.drawImage(img, 0, 0, w, h,      0, 0, w, h, this);
				
			}else if(selBtn.equals("축소그리기")) {
				// Canvas 의 크기를 줄이면 Image가 작아진다. (Canvas는 작게 Image는 그대로)
				g.drawImage(img, 0, 0, w/2, h/2,      0, 0, w, h, this);
				
			}else if(selBtn.equals("확대그리기")) {
				//캔버스 크기만큼 만 확대해서 그리기 ==> 캔버스크기를 구해야한다.
				int cW = getWidth();
				int cH = getHeight();
				g.drawImage(img, 0, 0, cW, cH,      0, 0, w, h, this);
				
			}else if(selBtn.equals("좌우뒤집기")) {
				//캔버스사이즈  //이미지사이즈		이  캔
				// 1   2        1   2       (1->2)
				// 3   4        3   4		(3->4)
				g.drawImage(img, w, 0, 0, h,      0, 0, w, h, this);
				
			}else if(selBtn.equals("상하뒤집기")) {
				g.drawImage(img, 0, 0, w, h,     0, h, w, 0, this);
				//g.drawImage(img, 0, 0, w, h,      w, h, 0, 0, this); 상하좌우뒤집기
			
			}else if(selBtn.equals("일부그리기")) {
				g.drawImage(img, 0, 0, 300, 300,     200, 200, 500, 500, this);
			}
			//다음거를 그리면 원래거는 사라지는 상태 
		}
	}
	
	
	
	public static void main(String[] args) {
		new ImageGraphics();

	}

}
