import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class PackMan extends JFrame {
	Image img;
	MyCanvas mc;
	
	/////////////////
	
	Dimension frameSize;
	Dimension canvasSize;
	int x, y;
	int p = 0;
	public PackMan() {
		img = Toolkit.getDefaultToolkit().getImage("img/팩맨.jpg");
		
		mc = new MyCanvas();
		add(BorderLayout.CENTER, mc);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// JFrame, Canvas크기
		//시작좌표
		getPackManSize();
		System.out.println(canvasSize.getWidth());
		x = (int)canvasSize.getWidth()/2-25;
		y = (int)canvasSize.getHeight()/2-25;
		
		mc.addKeyListener(new CanvasKeyEvent());
		
		//포커스가 컴퍼스에 맞춰짐
		mc.setFocusable(true);
		while(true) {
			try { Thread.sleep(200); } catch(Exception e) {}
			// 이미지변환
			if(p%2 ==0) p++;
			else 		p--;
			
			//방향바꾸기
			if(p==0 || p==1) { // 왼쪽방향
				x-=5;
				if(x<=-50) 									{x = (int)canvasSize.getWidth();}
				
			}else if(p==2||p==3) { //오른쪽 방향
				x+=5;
				if(x>=(int)canvasSize.getWidth())		    {x=-50;}
				
			}else if(p==4||p==5) {
				y-=5;
				if( y<=-50 )   								{ y = (int)canvasSize.getHeight();}
			}else if(p==6 || p==7) {
				y+=5;
				if(y>=(int)canvasSize.getHeight()) 		    { y=-50; }
			}
			
			mc.repaint();		
			
			
		}
	
	}

	
	public class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			g.drawImage(img, x, y, x+50, y+50,     p*50,0,p*50+50,50,this);
		}
	}
	
	public class CanvasKeyEvent extends KeyAdapter{
		public void keyReleased(KeyEvent ke) {
			int key = ke.getKeyCode();
			if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
				p=0;
			}else if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
				p=2;
			}else if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
				p=4;
			}else if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
				p=6;
			}
		}
	}
	
	
	
	public void getPackManSize() {
		// JFrame, Canvas크기
		frameSize = getSize();
		canvasSize = mc.getSize();
	}
	
	
	
	public static void main(String[] args) {
		new PackMan();
	}
}
