package day23_ex;

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
import java.io.File;

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
		Gui bUI1 = new Gui();
	}
}

class Gui extends JFrame {
	static int num = 0;
	BookMgr mgr;
	JButton add, list, delete, search, exit, save;
	TextField title, price, isbn;
	TextArea output;
	SaveLoad sl;
	public Gui() {
//		ImageIcon icon = new ImageIcon("C:\\img\\facebook.gif");
		ImageIcon icon = new ImageIcon(".\\src\\day23_ex\\facebook.gif");
//		ImageIcon icon = new ImageIcon("C:\\img\\다운로드.png");
		Image img = icon.getImage();
		Image nimg = img.getScaledInstance(500, 200,img.SCALE_DEFAULT);
		ImageIcon nicon = new ImageIcon(nimg);
		mgr = new BookMgr();
		sl = new SaveLoad();
		File f = new File("c:\\lib\\Booklist.txt");
		if(f.isFile()) {
			sl.loadListBook(mgr.booklist);
		}
		
		JLabel imgLbl = new JLabel(nicon);
		Panel p1 = new Panel();
		p1.add(save = new JButton("SAVE"));
		p1.add(add = new JButton("ADD"));
		p1.add(list = new JButton("LIST"));
		p1.add(delete = new JButton("DELETE"));
		p1.add(search = new JButton("SEARCH"));
		p1.add(exit = new JButton("EXIT"));
		
		add(p1,BorderLayout.SOUTH);
		
		Panel p2 = new Panel();
		
		p2.setLayout(new GridLayout(3,2));
		p2.add(new JLabel("Isbn"));
		p2.add(isbn = new TextField(20));
		p2.add(new JLabel("Title"));
		p2.add(title = new TextField(20));
		p2.add(new JLabel("Price"));
		p2.add(price = new TextField(20));
		//add(p2,BorderLayout.NORTH);
		
		Panel p3 = new Panel();
		p3.add(imgLbl);
		//add(p3,BorderLayout.NORTH);
		
		Panel p4 = new Panel();
		p4.setPreferredSize(new Dimension(500,300));
		p4.setLayout(new FlowLayout());
		p4.add(p3);
		p4.add(p2);
		add(p4,BorderLayout.NORTH);
		
		add(output = new TextArea(10,20));
		output.setFont(new Font(null,1,20));
		
		pack(); //니가 알아서 동작하게 해줘.
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		list.addActionListener(			
			e -> {
				output.append("=== 책 목록 ===\n");
				mgr.booklist.forEach(i -> output.append(i+"\n"));
				output.append("============\n");
				output.append(e.getActionCommand()+"작업 수행\n");
			});
		
		add.addActionListener(			
			e -> { 
				int p = 0;
				try {
				p = Integer.parseInt(price.getText());
				} catch (Exception e1) {
					output.setText("등록실패 \n");
					output.append("가격에 문자가 포함되면 안됩니다. \n");
					output.append(e1.getMessage() + "\n");
					return;
				}
				mgr.addBook(new Book(++num,title.getText(),p));
				output.append(e.getActionCommand()+"작업 수행\n");
				title.setText("");
				price.setText("");
			}
		);
		delete.addActionListener(			
			(e) -> {
					Boolean result = mgr.deleteBook(title.getText());
					if (result == true) {
						output.append(e.getActionCommand()+"작업 수행\n");						
					} else if(result == false) {
						output.append("삭제가 실행되지 않았습니다\n");
					}
					

			}
		);
		search.addActionListener(			
			(e) -> {
				mgr.searchTitleBook(title.getText()).forEach(i -> output.append(i+"\n"));
				output.append(e.getActionCommand()+"작업 수행\n");
			}
		);
		save.addActionListener((e) -> {
			sl.saveListBook(mgr.booklist);
			output.append(e.getActionCommand()+"작업 수행\n");
			
		});
		
		exit.addActionListener((e) -> {
			sl.saveListBook(mgr.booklist);
			System.exit(0);
		});
	}
//	public void paint(Graphics g) {
//		g.drawImage(img, 2000, 2000, this);
//	}

}