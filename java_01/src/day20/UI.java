package day20;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class UI {
	Frame f;
	Button ok,exit;
	
	UI() {
		f = new Frame();
	
		ok = new Button("Ok");
		exit = new Button("Exit");
		
		Panel p1 = new Panel();
		
		p1.add(ok);
		p1.add(exit);
		
		f.add(p1);
		
		f.setSize(500,500);
		f.setVisible(true);
	}
}
