package Brain.OccipitalLobe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import Brain.Rules;
import Coma.Coma;

/**
 * Describes rules for the game, “Sightseeing”.
 *
 */
public class OccipitalRules extends Rules {
	
	private Coma c;
	private Image cursor, screenshot1, screenshot2, symbols, next;
	
	/**
	 * Constructs a JPanel with rules of Sightseeing and a Begin button to start the game
	 * @param c the overall Coma game the rules of this mini game belongs to
	 */
	public OccipitalRules(Coma c) {
		super();
		this.c = c;
		cursor = (new ImageIcon("occipital" + System.getProperty("file.separator") + "cursorSight.png")).getImage();
		screenshot1 = (new ImageIcon("occipital" + System.getProperty("file.separator") + "Sightseeing.png")).getImage();
		screenshot2 = (new ImageIcon("occipital" + System.getProperty("file.separator") + "blankSight.png")).getImage();
		symbols = (new ImageIcon("occipital" + System.getProperty("file.separator") + "SP.png")).getImage();
		next = (new ImageIcon("occipital" + System.getProperty("file.separator") + "next.png")).getImage();
	}
	
	/**
	 * Returns the text representing rules for the game
	 * @return String that represents the rules for Sightseeing
	 */
	public String getText() {
		String rules = "";
		
		rules = "<html>This game tests the occipital lobe for field of view, which is <br>what an individual can see"
				+ " at any given moment.<br><br>To play:<br>A city will be displayed with 1 airplane, multiple "
				+ "helicopters, and a symbol in the sky. The city will then disappear. Use your mouse to click on where"
				+ " the airplane was. Then, select the symbol you saw. <br><br>The game ends when you get any"
				+ " answer incorrect. To win, you must get <b><u>200 points</b></u>.</html>";
		
	
		return rules;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();

	    double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;
		        
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		g.drawImage(screenshot1, DRAWING_WIDTH / 2 - 270, DRAWING_HEIGHT - 200, 140, 90, this);
		g.drawImage(screenshot2, DRAWING_WIDTH / 2 - 90, DRAWING_HEIGHT - 230, 200, 120, this);
		g.drawImage(cursor, DRAWING_WIDTH / 2 - 75, DRAWING_HEIGHT - 180, 40, 60, this);
		g.drawImage(symbols, DRAWING_WIDTH / 2 + 140, DRAWING_HEIGHT - 230, 150, 115,this);
		g.drawImage(cursor, DRAWING_WIDTH / 2 + 160, DRAWING_HEIGHT - 200, 40, 60, this);
		g.drawImage(next, DRAWING_WIDTH / 2 - 150, DRAWING_HEIGHT - 190, 70, 30, this);
		g.drawImage(next, DRAWING_WIDTH / 2 + 80, DRAWING_HEIGHT - 190, 70, 30, this);
		
		g2.setTransform(at);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
		if (src == getBegin()) {
			c.changePanel("12");
			if (!c.getWon(2)) {
				Thread t = new Thread("my non EDT thread") {
		            public void run() {
		                //my work
		               ((Occipital) c.getPanel(3)).act();
		            }
				};
		        t.start();		
			}
		}
		else if (src == getMenu())
			c.changePanel("3");
	}
}