package Brain.TemporalLobe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import Brain.Rules;
import Coma.Coma;

/**
 * Represents the rules for "Locked"
 * @author 
 * @version 5/18/17
 */
public class TemporalRules extends Rules{
	private Coma c;
	private Image play, clear;

	/**
	 * Constructs a JPanel with rules of the Locked and a Begin button to start the game
	 * @param c the overall Coma game the rules of this mini game belongs to
	 */
	public TemporalRules(Coma c) {
		super();
		this.c = c;
		play = (new ImageIcon("temporal" + System.getProperty("file.separator") + "playLocked.png")).getImage();
		clear = (new ImageIcon("temporal" + System.getProperty("file.separator") + "clearLocked.png")).getImage();
	}

	
	/**
	 * Returns the text representing rules for the game
	 * @return String that represents the rules for Locked
	 */
	public String getText() {
		String rules;
		rules = "<html>This lobe of the brain coordinates auditory information. <br><br>"
				+ "You are locked inside of a jail cell but provided with a keypad. To get "
				+ "out, listen to the music representing the passcode by pressing the play "
				+ "button. <br><br>The numbers on the keypad will correspond with these sounds. "
				+ "Find the correct <b><u>4-digit passcode combination</b></u> to unlock the cell and escape. "
				+ "<br><br>Use the clear button whenever you need to clear the passcode you have "
				+ "displayed.";
		
		
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
		g2.setTransform(at);
		
		g.drawImage(play, DRAWING_WIDTH / 3, DRAWING_HEIGHT / 2 - 100, 100, 40, this);
		g.drawImage(clear, DRAWING_WIDTH / 2 - 100, DRAWING_HEIGHT - 190, 100, 40, this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == getBegin()) {
			((Temporal)c.getPanel(4)).reset();
			c.changePanel("15");
		}
		else if (src == getMenu())
			c.changePanel("3");
	}

}