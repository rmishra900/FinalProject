package Coma;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.OccipitalLobe.OccipitalMain;

public class Coma2 extends JFrame {
	private JPanel home;
	
	public Coma2(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		home = new HomeScreen();
		add(home);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Coma2 coma = new Coma2("COMA");
	}

}
