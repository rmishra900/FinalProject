package Brain.ParietalLobe;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Brain.Rules;
import Coma.Coma;

/**
 * This class represents the rules of the FlyingArrows game
 * @author Thanh Luong
 * @version 5/15/17
 *
 */
public class ParietalRules extends Rules{
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private HoleInTheWall h;
	private Coma c;
	private Image upArrow, downArrow, wall;
	/**
	 * Constructs a JPanel with rules of the FlyingArrows and a Begin button to start the game
	 */
	public ParietalRules(HoleInTheWall h, Coma c) {
		super();
		this.h = h;
		this.c = c;
		rules.setLocation(105, 25);
		upArrow = (new ImageIcon("parietal" + System.getProperty("file.separator") + "upArrow.png")).getImage();
		downArrow = (new ImageIcon("parietal" + System.getProperty("file.separator") + "downArrow.png")).getImage();
		wall = (new ImageIcon("parietal" + System.getProperty("file.separator") + "wallParietal.png")).getImage();
	}
	
	
	/**
	 * Returns the text representing rules for the game
	 * @return String that represents the rules for FlyingArrows
	 */
	public String getText() {
		String rules = "";
		
		rules = "<html>This game tests the Parietal Lobe of the brain which is <br>responsible for sensory perception "
				+ "and integration, including the management of taste, hearing, sigh, touch, and smell.<br><br> You will "
				+ "have 45 seconds to complete the game and you must <br>reach 1000 points to win. <br><br>To play, "
				+ "use the up and down arrow keys on your keyboard to control the blue panel on the left called the wall. "
				+ "Match up the shapes that are shot out from the left side of the screen to the shapes on the wall</html>";
		
	
		return rules;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(upArrow, DRAWING_WIDTH / 2 - 50, DRAWING_HEIGHT - 215, 50, 50, this);
		g.drawImage(downArrow, DRAWING_WIDTH / 2 - 50, DRAWING_HEIGHT - 155, 50, 50, this);
		g.drawImage(wall, DRAWING_WIDTH / 2 - 150, DRAWING_HEIGHT - 230, 50, 125,this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == begin)
			h.changePanel("2");
		else if (src == back)
			c.changePanel("3");
		
	}
	
}
