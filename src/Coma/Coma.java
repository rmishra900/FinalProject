package Coma;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.OccipitalLobe.OccipitalMain;

public class Coma extends JFrame {
//	private JPanel menu;
	private JPanel gamePanel;
	
	public Coma(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    gamePanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    gamePanel.setLayout(cl);
//	    
	    Home panel1 = new Home(this); 
	    StoryScreen panel2 = new StoryScreen(this);
	    Menu panel3 = new Menu(this);
	    
	    gamePanel.add(panel1, "1");
	    gamePanel.add(panel2, "2");
	    gamePanel.add(panel3, "3");
	    
	    add(gamePanel);
	    addMouseListener(panel1);
	    addMouseListener(panel2);
	    addMouseListener(panel3);
	    
	    setVisible(true);
	    
//	    card
//		menu = new Menu();
//		add(menu);
//		setVisible(true);
	}
	
	public static void main(String[] args) {
		Coma coma = new Coma("COMA");
	}
	
	public void changePanel(String name) {
		
		((CardLayout)gamePanel.getLayout()).show(gamePanel, name);
		requestFocus();
	}
	

}