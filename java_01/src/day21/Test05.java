package day21;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test05 {
	public static void main(String[] args) {
		new UI_5().createUI();
		;
	}
}

class UI_5 extends JFrame implements ActionListener {
	JButton red, blue, exit;
	TextField msg;
	TextArea output;

	Panel p1, p2;

	void createUI() {
		super.setTitle("awt UI Test ~~");
//		String[] fontlist = Toolkit.getDefaultToolkit().getFontList();
//		Stream.of(fontlist).forEach(i -> System.out.println(i));

		p1 = new Panel();
		p1.add(red = new JButton("RED"));
		p1.add(blue = new JButton("BLUE"));
		p1.add(exit = new JButton("EXIT"));
		add(p1, BorderLayout.SOUTH);

		p2 = new Panel();
		p2.add(new JLabel("메세지창"));
		p2.add(msg = new TextField(20));
		add(p2,BorderLayout.NORTH);
		
		add(output = new TextArea(15,40));
		output.setFont(new Font(null, 1, 20));
		
		setSize(300, 300);
		setVisible(true);

		red.addActionListener(this);
		blue.addActionListener(this);
		exit.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 클릭시 윈도창 종료 JFrame에서만 가능
		
		msg.addActionListener(new ActionListener() {		//익명 이너클래스
			@Override
			public void actionPerformed(ActionEvent e) {
				output.append(msg.getText()+"\n");
				msg.setText("");
			}
		});	
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "RED":
			p1.setBackground(Color.RED);
			break;
		case "BLUE":
			p1.setBackground(Color.BLUE);
			break;
		case "EXIT":
			setVisible(false);
			dispose(); // UI 파괴
			System.exit(0);
			break;
		default:
			break;
		}

	}

}
