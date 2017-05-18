package Brain.OccipitalLobe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Brain.Rules;
import Brain.ParietalLobe.HoleInTheWall;
import Coma.Coma;

public class OccipitalRules extends Rules{
	private ShowMeTheLight s;
	private Coma c;

	/**
	 * Constructs a JPanel with rules of the FlyingArrows and a Begin button to start the game
	 */
	public OccipitalRules(ShowMeTheLight s, Coma c) {
		super();
		this.s = s;
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
		ShowMeTheLight game = new ShowMeTheLight("Show Me the Light", c);
		Thread t = new Thread("my non EDT thread") {
	            public void run() {
	                //my work
	               game.act();
	            }
	        };
	        t.start();
        Object src = e.getSource();
		if (src == begin)
			s.changePanel("2");
		else if (src == back)
			c.changePanel("3");
			
	}
}