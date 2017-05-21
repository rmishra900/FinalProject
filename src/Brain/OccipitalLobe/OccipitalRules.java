package Brain.OccipitalLobe;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

import Brain.Rules;
import Coma.Coma;

public class OccipitalRules extends Rules {
	
	private Coma c;

	/**
	 * Constructs a JPanel with rules of the FlyingArrows and a Begin button to start the game
	 */
	public OccipitalRules(Coma c) {
		super();
		this.c = c;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	/**
	 * Returns the text representing rules for the game
	 * @return String that represents the rules for FlyingArrows
	 */
	public String getText() {
		String rules = "";
		
		rules = "<html>This game tests the Occipital Lobe of the brain which is <br>responsible for visual processing. "
				+ "This game has to do with field of view, which is what an individual can see at any given moment."
				+ "<br><br>To play:<br>A city will be displayed with 1 airplane, multiple helicopters, and a symbol"
				+ " in the sky. The city will then disappear.<br>Use your mouse to find the area where"
				+ " the airplane was. If you are correct, you must then select which symbol you saw. If you are correct"
				+ " again, you receive one point, and move on to another round.<br><br>The game ends when you get any"
				+ " answer incorrect. To win, you must get 10 correct in a row.</html>";
		
	
		return rules;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
		if (src == begin) {
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
		else if (src == back)
			c.changePanel("3");
	}
}