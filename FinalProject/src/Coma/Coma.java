package Coma;

<<<<<<< HEAD
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
=======
public class Coma {

	public static void main(String[] args) {
		

>>>>>>> branch 'master' of https://github.com/rmishra900/FinalProject.git
	}

}
