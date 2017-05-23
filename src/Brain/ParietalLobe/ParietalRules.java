package Brain.ParietalLobe;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import Brain.Rules;
import Coma.Coma;

/**
 * This class represents the rules of the FlyingArrows game
 * @version 5/15/17
 *
 */
public class ParietalRules extends Rules{
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private Coma c;
	private Image upArrow, downArrow, wall;
	/**
	 * Constructs a JPanel with rules of the Hole In The Wall and a Begin button to start the game
	 * @param c the overall Coma game the rules of this mini game belongs to
	 */
	public ParietalRules(Coma c) {
		super();
		this.c = c;
		getRules().setLocation(105, 25);
		upArrow = (new ImageIcon("parietal" + System.getProperty("file.separator") + "upArrow.png")).getImage();
		downArrow = (new ImageIcon("parietal" + System.getProperty("file.separator") + "downArrow.png")).getImage();
		wall = (new ImageIcon("parietal" + System.getProperty("file.separator") + "wallParietal.png")).getImage();
	}
	
	
	/**
	 * Returns the text representing rules for the game
	 * @return String that represents the rules for Hole In The Wall
	 */
	public String getText() {
		String rules = "";
		
		rules = "<html>This game tests the Parietal Lobe of the brain which is responsible for sensory perception "
				+ "and integration.<br><br>To play:<br> "
				+ "Use the up and down arrow keys on your keyboard to control the blue wall on the left. "
				+ "Match up the shapes that are shot out from the left side of the screen to the shapes on the wall. You will "
				+ "have <b><u>45 seconds</b></u> to complete the game and you must reach <b><u>1000 points</b></u> to win.</html>";
		
	
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
		
		g.drawImage(upArrow, DRAWING_WIDTH / 2 - 20, DRAWING_HEIGHT - 215, 50, 50, this);
		g.drawImage(downArrow, DRAWING_WIDTH / 2 - 20, DRAWING_HEIGHT - 155, 50, 50, this);
		g.drawImage(wall, DRAWING_WIDTH / 2 - 120, DRAWING_HEIGHT - 230, 50, 125,this);
		
		g2.setTransform(at);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == getBegin()) {
			((Parietal)c.getPanel(2)).reset();
			c.changePanel("10");
		}
		else if (src == getMenu()) {
			c.changePanel("3");
		}
	}
	
}