package day21;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.stream.Stream;

import javax.swing.JFrame;

public class Test06 {
	public static void main(String[] args) {
		new DrawImg();
	}
}

class DrawImg extends JFrame {
	Image im;
	
	DrawImg() {
		im = Toolkit.getDefaultToolkit().getImage("C://img//safe_image.gif");
		
		String[] fontlist = Toolkit.getDefaultToolkit().getFontList();//api중에 선이 그어진것은 디프리케이티드된 api라는 의미다(예전엔 썻으나 지금은 쓰지마라)
		Stream.of(fontlist).forEach(i -> System.out.println(i));
		
		setSize(500,500);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint(); //paint메소드가 시스템내에서 일해준다.
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();  //UI 파괴
				System.exit(0);
			}
		});	
	}

	public void paint(Graphics g) {
		g.drawImage(im, 20, 20, this);
	}
	
}

