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
	protected static int wins;
	protected boolean frontalWin, occipitalWin, parietalWin, temporalWin;
	
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
	    GameOver panel4 = new GameOver(this);
	    
	    gamePanel.add(panel1, "1");
	    gamePanel.add(panel2, "2");
	    gamePanel.add(panel3, "3");
	    gamePanel.add(panel4, "4");
	    
	    add(gamePanel);
	    addKeyListener(panel1);
	    addMouseListener(panel2);
	    addKeyListener(panel4);
	    
	    frontalWin = false;
	    occipitalWin = false;
	    parietalWin = false;
	    temporalWin = false;
	    
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
	
	public void setWon(int i) {
		wins++;
		if (i == 1)
			frontalWin = true;
		else if (i == 2)
			occipitalWin = true;
		else if (i == 3)
			parietalWin = true;
		else if (i == 4)
			temporalWin = true;
	}
	
	public void resetWins(int i) {
		wins--;
		if (i == 1)
			frontalWin = false;
		else if (i == 2)
			occipitalWin = false;
		else if (i == 3)
			parietalWin = false;
		else if (i == 4)
			temporalWin = false;
	}
	
	public boolean getWon(int i) {
		if (i == 1)
			return frontalWin;
		else if (i == 2)
			return occipitalWin;
		else if (i == 3)
			return parietalWin;
		else if (i == 4)
			return temporalWin;
		else
			return false;
	}
	

}