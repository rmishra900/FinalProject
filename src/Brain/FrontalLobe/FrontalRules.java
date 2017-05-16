package Brain.FrontalLobe;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Brain.Rules;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class FrontalRules extends Rules {
	private FlyingArrows flying;
	
	public FrontalRules() {
		super();
		flying = new FlyingArrows("FlyingArrows");
	}

	@Override
	public String getText() {
		String rules = "";
		
		rules = "<html>This game tests the Frontal Lobe of the brain which is <br>responsible for cognitive thinking "
				+ "including task switching,<br> memory and impulse control.<br><br>To play:<br>If arrows are green - "
				+ "press arrow key that corresponds to the direction the arrows are moving in."
				+ "<br><br>If arrows are red - press the arrow key that corresponds to the direction the arrows "
				+ "are pointing to.<br><br>If arrows are blue - press the arrow on the keyboard that corresponds "
				+ "to the opposite direction the arrows are moving.</html>";
		
	
		return rules;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//FrontalMain fm = new FrontalMain("FlyingArrows");
		flying.changePanel("2");
	}
	
}
