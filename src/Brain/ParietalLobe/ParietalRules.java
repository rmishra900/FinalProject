package Brain.ParietalLobe;


import java.awt.event.ActionEvent;

import Brain.Rules;

/**
 * This class represents the rules of the FlyingArrows game
 * @author Thanh Luong
 * @version 5/15/17
 *
 */
public class ParietalRules extends Rules{
	
	private HoleInTheWall h;
	/**
	 * Constructs a JPanel with rules of the FlyingArrows and a Begin button to start the game
	 */
	public ParietalRules(HoleInTheWall h) {
		super();
		this.h = h;
	}
	
	
	/**
	 * Returns the text representing rules for the game
	 * @return String that represents the rules for FlyingArrows
	 */
	public String getText() {
		String rules = "";
		
		rules = "<html>This game tests the Parietal Lobe of the brain which is <br>responsible for cognitive thinking "
				+ "including task switching,<br> memory and impulse control.<br><br>To play:<br>If arrows are green - "
				+ "press arrow key that corresponds to the direction the arrows are moving in."
				+ "<br><br>If arrows are red - press the arrow key that corresponds to the direction the arrows "
				+ "are pointing to.<br><br>If arrows are blue - press the arrow on the keyboard that corresponds "
				+ "to the opposite direction the arrows are moving.</html>";
		
	
		return rules;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Parietal p = new Parietal(h);
		p.setVisible(true);
	    add(p); 
		addKeyListener(p);
	}
	
}
