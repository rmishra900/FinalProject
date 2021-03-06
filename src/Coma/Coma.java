package Coma;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.FrontalLobe.Frontal;
import Brain.FrontalLobe.FrontalRules;
import Brain.OccipitalLobe.Occipital;
import Brain.OccipitalLobe.OccipitalRules;
import Brain.OccipitalLobe.SymbolPanel;
import Brain.ParietalLobe.Parietal;
import Brain.ParietalLobe.ParietalRules;
import Brain.TemporalLobe.Temporal;
import Brain.TemporalLobe.TemporalRules;

/**
 * Represents the window that the game begins on. 
 * @version 5/15/2017
 */
public class Coma extends JFrame {

	private JPanel gamePanel;
	private static int wins;
	private static boolean isOver;
	private boolean frontalWin, occipitalWin, parietalWin, temporalWin;
	private Frontal f;
	private Parietal p;
	private Occipital o;
	private Temporal t;
	private Image background;
	private FrontalRules fr;
	private ParietalRules pr;
	private OccipitalRules or;
	private SymbolPanel sp;
	private TemporalRules tr;
	
	
	/**
	 * Constructs a new instance of the game window.
	 * @param title the title displayed at the top of this window
	 */
	public Coma(String title) {
	    super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(true);
	    setMinimumSize(new Dimension(200, 150));
	    background = new ImageIcon("coma" + System.getProperty("file.separator") + "COMAbackground.png").getImage();
    
	    wins = 0;
	    isOver = false;
	    
	    gamePanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    gamePanel.setLayout(cl);
    
	    Home panel1 = new Home(this); 
	    StoryScreen panel2 = new StoryScreen(this);
	    Menu panel3 = new Menu(this);
	    GameOver panel4 = new GameOver(this);
	    
	    fr = new FrontalRules(this);
	    f = new Frontal(this);
	    
	    pr = new ParietalRules(this);
	    p = new Parietal(this);
	    
	    or = new OccipitalRules(this);
	    o = new Occipital(this);
	    sp = o.getSP();
	    
	    tr = new TemporalRules(this);
	    t = new Temporal(this);
	    
	    gamePanel.add(panel1, "1");
	    gamePanel.add(panel2, "2");
	    gamePanel.add(panel3, "3");
	    gamePanel.add(panel4, "4");
	    gamePanel.add(f,"7");
	    gamePanel.add(fr, "8");
	    gamePanel.add(pr, "9");
	    gamePanel.add(p, "10");
	    gamePanel.add(or, "11");
	    gamePanel.add(o, "12");
	    gamePanel.add(sp, "13");
	    gamePanel.add(tr, "14");
	    gamePanel.add(t, "15");
	    
	    add(gamePanel);
	    addKeyListener(panel1);
	    addKeyListener(panel4);
	    addKeyListener(p);
	    addKeyListener(f.getKeyHandler());
	    addKeyListener(p);
	    
	    frontalWin = false;
	    occipitalWin = false;
	    parietalWin = false;
	    temporalWin = false;
	    
	    setVisible(true);
	}
	

	/**
	 * Returns a panel of a specific game depending on the number parameter. 
	 * @param i the number of the panel corresponding to a specific game
	 * @return the JPanel of the game corresponding to the parameter integer
	 */
	public JPanel getPanel(int i) {
		if (i == 1)
			return f;
		else if(i == 2)
			return p;
		else if (i == 3)
			return o;
		else if (i == 4)
			return t;
		else
			return null;
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
	
	/**
	 * 
	 * @return true if the game is over, false if otherwise
	 */
	public boolean getOver() {
		return isOver;
	}
	
	/**
	 * Sets a specific game based on an integer value to won.
	 * @param i the integer corresponding to a specific game
	 */
	public void setWon(int i) {
		wins++;
		if(wins == 4) {
			isOver = true;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			changePanel("4");
		}
		if (i == 1)
			frontalWin = true;
		else if (i == 2)
			occipitalWin = true;
		else if (i == 3)
			parietalWin = true;
		else if (i == 4)
			temporalWin = true;
	}
	
	/**
	 * 
	 * @return the number of mini games won
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * Reset each mini game to not won.
	 */
	public void resetWins() {
		frontalWin = false;
		occipitalWin = false;
		parietalWin = false;
		temporalWin = false;
		wins = 0;
	}
	
	/**
	 * Reset a specific mini game to not won. 
	 * @param i the integer corresponding to a particular mini game
	 */
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
	
	/**
	 * 
	 * @param i the integer corresponding to a specific mini game
	 * @return true if the mini game corresponding to a particular integer has been won, false if otherwise
	 */
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