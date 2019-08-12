package day24_ex;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;
import javafx.scene.layout.BorderImage;

/**
 * 
 * @author user
 *
 */
public class BookApp {
	public static void main(String[] args) {
		BookMgr manager = new BookMgr();
		Gui bUI = new Gui(manager);
		T t1 = new T(manager);
		Thread autoSave = new Thread(t1,"자동저장");
		autoSave.start();
	}
}

class Gui extends JFrame {
	static int num = 0;

	JButton add, list, delete, search, exit;
	TextField title, price, isbn;
	TextArea output;
	BookMgr mgr;

	public Gui(BookMgr mgr) {
		ImageIcon icon = new ImageIcon("C:\\img\\facebook.gif");
//		ImageIcon icon = new ImageIcon("C:\\img\\다운로드.png");
		Image img = icon.getImage();
		Image nimg = img.getScaledInstance(500, 200, img.SCALE_DEFAULT);
		ImageIcon nicon = new ImageIcon(nimg);
		this.mgr = mgr;
		
		
		JLabel imgLbl = new JLabel(nicon);
		Panel p1 = new Panel();
		p1.add(add = new JButton("ADD"));
		p1.add(list = new JButton("List"));
		p1.add(delete = new JButton("DELETE"));
		p1.add(search = new JButton("SEARCH"));
		p1.add(exit = new JButton("EXIT"));
		add(p1, BorderLayout.SOUTH);

		Panel p2 = new Panel();

		p2.setLayout(new GridLayout(3, 2));
		p2.add(new JLabel("Isbn"));
		p2.add(isbn = new TextField(20));
		p2.add(new JLabel("Title"));
		p2.add(title = new TextField(20));
		p2.add(new JLabel("Price"));
		p2.add(price = new TextField(20));

		Panel p3 = new Panel();
		p3.add(imgLbl);

		Panel p4 = new Panel();
		p4.setPreferredSize(new Dimension(500, 300));
		p4.setLayout(new FlowLayout());
		p4.add(p3);
		p4.add(p2);
		add(p4, BorderLayout.NORTH);

		add(output = new TextArea(10, 20));
		output.setFont(new Font(null, 1, 20));

		pack(); // 니가 알아서 동작하게 해줘.
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		this.addWindowListener();
		
		exit.addActionListener(e -> {
//			mgr.save();
			System.exit(0);
		});
		
		list.addActionListener(e -> {
			output.setText("BookList \n");
			mgr.getBooklist().forEach(i -> {
				output.append(i + "\n");
			});
		});
		
		add.addActionListener(e -> {
			try {
				mgr.add(new Book(title.getText(), Integer.parseInt(price.getText())));
				
			} catch (Exception e2) {
				output.append("잘못된 형식\n");
				
			}
			title.setText("");
			price.setText("");
		});

		delete.addActionListener(e -> {
			if(mgr.delete(title.getText())) {
				output.append("삭제되었습니다\n");
			} else {
				output.append("삭제되지 않았습니다\n");				
			}
			title.setText("");
		});
		
		search.addActionListener(e -> {
			List<Book> list = null;
			output.append("검색결과\n");				
			mgr.search(title.getText()).forEach(i -> output.append(i.toString() + "\n"));	
			title.setText("");
		});
	}

}

class T implements Runnable {
	BookMgr mgr;
	
	public T() {}

	public T(BookMgr mgr) {
		this.mgr = mgr;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {		
				mgr.save();
				System.out.println("저장완료");
			}
			
		}
	}
	
}