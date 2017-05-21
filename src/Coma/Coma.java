package Coma;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.FrontalLobe.FlyingArrows;
import Brain.FrontalLobe.Frontal;
import Brain.FrontalLobe.FrontalRules;
import Brain.OccipitalLobe.Occipital;
import Brain.OccipitalLobe.OccipitalRules;
import Brain.OccipitalLobe.ShowMeTheLight;
import Brain.OccipitalLobe.SymbolPanel;
import Brain.ParietalLobe.Parietal;
import Brain.ParietalLobe.ParietalRules;
import Brain.TemporalLobe.Temporal;
import Brain.TemporalLobe.TemporalRules;

/**
 * Represents the window that the game begins on. 
 * @author Thanh Luong
 * @version 5/15/2017
 */
public class Coma extends JFrame {

	private JPanel gamePanel;
	private static int wins;
	private boolean frontalWin, occipitalWin, parietalWin, temporalWin;
	private Frontal f;
	private Parietal p;
	private Occipital o;
	private Temporal t;
	private Image background;
	
	/**
	 * Constructs a new instance of the game window.
	 * @param title the title displayed at the top of this window
	 */
	public Coma(String title) {
	    super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    background = new ImageIcon("coma" + System.getProperty("file.separator") + "COMAbackground.png").getImage();
		
    
	    gamePanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    gamePanel.setLayout(cl);
    
	    Home panel1 = new Home(this); 
	    StoryScreen panel2 = new StoryScreen(this);
	    Menu panel3 = new Menu(this);
	    GameOver panel4 = new GameOver(this);
	    
	    FlyingArrows fa = new FlyingArrows("Flying Arrows", this);
	    f = new Frontal(fa, this);
	    FrontalRules fr = new FrontalRules(fa, this);
	    
	    ParietalRules pr = new ParietalRules(this);
	    p = new Parietal(this);
	    
	    OccipitalRules or = new OccipitalRules(this);
	    o = new Occipital(this);
	    SymbolPanel sp = o.getSP();
	    
	    TemporalRules tr = new TemporalRules(this);
	    t = new Temporal(this);
	    
	    gamePanel.add(panel1, "1");
	    gamePanel.add(panel2, "2");
	    gamePanel.add(panel3, "3");
	    gamePanel.add(panel4, "4");
	    gamePanel.add(fa, "6");
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
	    addMouseListener(panel2);
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
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		
		
		int width = getWidth();
		int height = getHeight();
//
//		double ratioX = (double) width / DRAWING_WIDTH;
//		double ratioY = (double) height / DRAWING_HEIGHT;

		AffineTransform at = g2.getTransform();
		//g2.scale(ratioX, ratioY);
		
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
	
	public int getWins() {
		return wins;
	}

	
	public void resetWins() {
		frontalWin = false;
		occipitalWin = false;
		parietalWin = false;
		temporalWin = false;
		wins = 0;
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