package day21_ex;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 
 * @author user
 *
 */
public class BookApp {
	public static void main(String[] args) {
		BookUI bUI = new BookUI();
		bUI.createUI();
	}
}

class BookUI extends JFrame implements ActionListener {
	BookMgr booklist = new BookMgr(10);
	JButton insert, delete, print, search, exit;
	TextField msg;
	TextArea output;
	Panel p1, p2;
	JLabel jb;
	void createUI() {
		jb = new JLabel("명령 입력");
		p1 = new Panel();
		p1.add(insert = new JButton("입력"));
		p1.add(delete = new JButton("삭제"));
		p1.add(print = new JButton("출력"));
		p1.add(search = new JButton("검색"));
		p1.add(exit = new JButton("EXIT"));
		add(p1, BorderLayout.SOUTH);

		p2 = new Panel();
		p2.add(jb);
		p2.add(msg = new TextField(20));
		add(p2, BorderLayout.NORTH);

		add(output = new TextArea(15, 40));
		output.setFont(new Font(null, 1, 20));

		setSize(600, 300);
		setVisible(true);

		insert.addActionListener(this);
		delete.addActionListener(this);
		print.addActionListener(this);
		search.addActionListener(this);
		exit.addActionListener(this);

		msg.addActionListener(new ActionListener() { // 익명 이너클래스

			@Override
			public void actionPerformed(ActionEvent e) {
				if (msg.getText().trim().equals("Y") || msg.getText().trim().equals("y")) {
					System.exit(0);
				}
				output.append(msg.getText() + "\n");
				msg.setText("");

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "입력":
			JFrame jf = new JFrame();
			Panel p3 = new Panel();
			TextField msg1, msg2;
			JButton put;
			int price = 0;

			p3.add(new JLabel("제목"));
			p3.add(msg1 = new TextField(10));
			p3.add(new JLabel("가격"));
			p3.add(msg2	= new TextField(10));
			p3.add(put = new JButton("입력"));
			jf.add(p3);

			jf.setSize(300, 100);
			jf.setVisible(true);

			put.addActionListener(new ActionListener() { // 익명 이너클래스

				@Override
				public void actionPerformed(ActionEvent e) {
					Book book = new Book(msg1.getText(),Integer.parseInt(msg2.getText()));
					booklist.addBook(book);
					output.append(msg1.getText() + " : " + msg2.getText() + "\n");
					msg1.setText("");
					msg2.setText("");
					jf.setVisible(false);
				}
			});
			output.append(e.getActionCommand() + " 작업을 수행합니다.\n");
			break;
		case "삭제":
			output.append("삭제할 책의 제목을 입력하세요: \n");
			jb.setText("제목");
			msg.addActionListener(new ActionListener() {		//익명 이너클래스
				@Override
				public void actionPerformed(ActionEvent e) {
					booklist.deleteBook(e.getActionCommand());
					msg.setText("");
				}
			});	
			output.append(e.getActionCommand() + " 작업을 수행합니다.\n");
			msg.removeActionListener(this);
			break;
		case "출력":
			output.append("=== 책 목록 ===\n");
			output.append(booklist.printBookList().toString() + "\n");
			output.append("============\n");
			output.append(e.getActionCommand() + " 작업을 수행합니다.\n");
			msg.removeActionListener(this);
			break;
		case "검색":
			output.append("검색할 책의 제목을 입력하세요\n");
			
			msg.addActionListener(new ActionListener() {		//익명 이너클래스
				@Override
				public void actionPerformed(ActionEvent e) {
					if (booklist.searchTitleBook(e.getActionCommand()) == null) {
						output.append("해당하는 책이 없습니다\n");
						return;
					}
					output.append((booklist.searchTitleBook(e.getActionCommand())) + "\n");
					msg.removeActionListener(this);
				}
			});	
			output.append(e.getActionCommand() + " 작업을 수행합니다.\n");
			break;
		case "EXIT":
			output.append("정말 종료하시겠습니까? Y/N\n");
			msg.addActionListener(new ActionListener() {		//익명 이너클래스
				@Override
				public void actionPerformed(ActionEvent e) {
					output.append(msg.getText()+"\n");
					if (e.getActionCommand().equals("Y") ||e.getActionCommand().equals("y")) {
						setVisible(false);
						dispose(); // UI 파괴
						System.exit(0);
					}
					msg.removeActionListener(this);
				}
			});	
			break;
		default:
			msg.removeActionListener(this);
			break;
		}
	}
}