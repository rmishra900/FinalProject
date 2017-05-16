package Brain.ParietalLobe;

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

import Brain.FrontalLobe.FrontalMain;

/**
 * This class represents the rules of the FlyingArrows game
 * @author Thanh Luong
 * @version 5/15/17
 *
 */
public class Rules extends JPanel implements ActionListener{

	private String text;
	private Image background;
	private JButton begin;
	private JLabel rulesBackground, rules;

	
	/**
	 * Constructs a JPanel with rules of the FlyingArrows and a Begin button to start the game
	 */
	public Rules() {
		setLayout(null);

		begin = new JButton("BEGIN");
		begin.setFont(new Font("Roman Baseline", Font.BOLD, 20));
	
		begin.setSize(100, 50);
		begin.setLocation(325, 500);
		background = new ImageIcon("RulesBackground.jpg").getImage();
		
		rulesBackground = new JLabel();
		
		
		rules = new JLabel(getText());
		rules.setLocation(105, 55);
		rules.setSize(600,400);
		rules.setForeground(Color.WHITE);
		rules.setFont(new Font("Roman Baseline", 0, 20));
		add(rules);
		
		int alpha = 50;
		Color c = new Color(0,0,0, alpha);
	
		rulesBackground.setBackground(c);
		rulesBackground.setLocation(100, 50);
		rulesBackground.setSize(600,450);
		
		rulesBackground.setOpaque(true);
		add(rulesBackground);
		
		add(begin);
		begin.addActionListener(this);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	
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
		FrontalMain fm = new FrontalMain("FlyingArrows");
	}
	
}
