package Coma;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Represents the window that the game begins on. 
 * @author Thanh Luong
 * @version 5/15/2017
 */
public class Coma extends JFrame {

	private JPanel gamePanel;
	
	/**
	 * Constructs a new instance of the game window.
	 * @param title the title displayed at the top of this window
	 */
	public Coma(String title) {
	    super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
	    gamePanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    gamePanel.setLayout(cl);
    
	    Home panel1 = new Home(this); 
	    StoryScreen panel2 = new StoryScreen(this);
	    Menu panel3 = new Menu(this);
	    
	    gamePanel.add(panel1, "1");
	    gamePanel.add(panel2, "2");
	    gamePanel.add(panel3, "3");
	    
	    add(gamePanel);
	    addMouseListener(panel1);
	    addMouseListener(panel2);
	    
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		Coma coma = new Coma("COMA");
	}
	
	/**
	 * Allows to change what is displayed on the screen. 
	 * @param name the name of the panel to be displayed
	 */
	public void changePanel(String name) {
		
		((CardLayout)gamePanel.getLayout()).show(gamePanel, name);
		requestFocus();
	}
	

}