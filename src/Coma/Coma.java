package Coma;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.FrontalLobe.FlyingArrows;
import Brain.FrontalLobe.Frontal;
import Brain.FrontalLobe.FrontalRules;
import Brain.OccipitalLobe.ShowMeTheLight;
import Brain.ParietalLobe.HoleInTheWall;
import Brain.ParietalLobe.Parietal;
import Brain.ParietalLobe.ParietalRules;
import Brain.TemporalLobe.Locked;
import Brain.TemporalLobe.Temporal;
import Brain.TemporalLobe.TemporalRules;

/**
 * Represents the window that the game begins on. 
 * @author Thanh Luong
 * @version 5/15/2017
 */
public class Coma extends JFrame {

	private JPanel gamePanel;
	protected static int wins;
	protected boolean frontalWin, occipitalWin, parietalWin, temporalWin;
	private Frontal f;
	private Temporal t;
	private Parietal p;
	
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
	    
	    
	//    ShowMeTheLight smtl = new ShowMeTheLight("Show Me The Light",this);
	    FlyingArrows fa = new FlyingArrows("Flying Arrows", this);
	    f = new Frontal(fa, this);
	    FrontalRules fr = new FrontalRules(fa, this);
	    gamePanel.add(fa, "6");
	    gamePanel.add(f,"7");
	    gamePanel.add(fr, "8");
	   
	
	    Locked l = new Locked("Locked", this);
	    t = new Temporal(l, this);
	    TemporalRules tr = new TemporalRules(l,this);
	    gamePanel.add(l, "9");
	    gamePanel.add(t,"10");
	    gamePanel.add(tr, "11");
	    
	    HoleInTheWall hitw = new HoleInTheWall("Hole In The Wall", this);
	    p = new Parietal(hitw, this);
	    ParietalRules pr = new ParietalRules(hitw, this);
	    gamePanel.add(hitw, "12");
	    gamePanel.add(p, "13");
	    gamePanel.add(pr, "14");
	//    gamePanel.add(smtl, "5");
	   
	  //  gamePanel.add(hitw, "7");
	  //  gamePanel.add(l, "8");
//	    
	   // panel3.add(smtl);
	 //   panel3.add(fa);
	   // panel3.add(hitw);
	   // panel3.add(l);
	    
	    add(gamePanel);
	    addKeyListener(panel1);
	    addMouseListener(panel2);
	    addKeyListener(panel4);
	    addKeyListener(f.getKeyHandler());
	    addKeyListener(p);
	    
	    frontalWin = false;
	    occipitalWin = false;
	    parietalWin = false;
	    temporalWin = false;
	    
	  
	    
	    
	    setVisible(true);
	}
	
	public Frontal getFrontalPanel() {
		return f;
	}
	
	public Temporal getTemporalPanel() {
		return t;
	}
	
	public Parietal getParietalPanel() {
		return p;
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