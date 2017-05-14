package Coma;

import java.awt.CardLayout;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Brain.OccipitalLobe.OccipitalPanel;
import Brain.FrontalLobe.Frontal;


public class Coma extends JFrame {

	JPanel cardPanel;
	
	public Coma(String title) {
		
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    Frontal panel = new Frontal();
	
	    
	    addKeyListener(panel.getKeyHandler());
	  
	    cardPanel.add(panel);
	    add(cardPanel);
	    setVisible(true);

	}
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
		
	}

}
