package Coma;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.FrontalLobe.FrontalPanel;
import Brain.OccipitalLobe.OccipitalPanel;

public class Coma extends JFrame {

	JPanel gamePanel;
	
	public Coma(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    gamePanel = new JPanel();
	    CardLayout c = new CardLayout();
	    gamePanel.setLayout(c);
	    
	    HomeScreen panel1 = new HomeScreen(this);
	    Menu panel2 = new Menu(this);
	    Rules panel3 = new Rules(this);
	    StoryScreen panel4 = new StoryScreen(this);
	    
	    gamePanel.add(panel1, "1");
	    gamePanel.add(panel2,"2");
	    gamePanel.add(panel3,"3");
	    gamePanel.add(panel4, "4");
	    
	    add(gamePanel);
	    addMouseListener(panel1);
	    addMouseListener(panel2);
	    addMouseListener(panel3);
	    addMouseListener(panel4);
//	    addKeyListener(panel4);
	    
//	    OccipitalPanel panel = new OccipitalPanel();
	    //gamePanel.add(panel);
//	    panel.setVisible(true);
//	    add(panel);
	    
	    setVisible(true);
	}
	
	public void changePanel(String name) {
		((CardLayout)gamePanel.getLayout()).show(gamePanel, name);
		requestFocus();
	}
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
	}

}
