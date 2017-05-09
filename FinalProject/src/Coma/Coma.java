package Coma;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.OccipitalLobe.OccipitalPanel;

public class Coma extends JFrame {

	JPanel cardPanel;
	
	public Coma(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    OccipitalPanel panel = new OccipitalPanel();
	    panel.setVisible(true);
	    cardPanel.add(panel);
	    
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
	}

}
