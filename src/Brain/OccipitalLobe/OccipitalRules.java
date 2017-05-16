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

public class OccipitalRules extends JPanel implements ActionListener{

	private String text;
	private Image background;
	private JButton begin;
	private JLabel rulesBackground, rules;

	
	/**
	 * Constructs a JPanel with rules of the FlyingArrows and a Begin button to start the game
	 */
	public OccipitalRules() {
		setLayout(null);

		begin = new JButton("BEGIN");
		begin.setFont(new Font("Roman Baseline", Font.BOLD, 20));
	
		begin.setSize(100, 50);
		begin.setLocation(325, 500);
		background = new ImageIcon("frontal" + System.getProperty("file.separator") + "RulesBackground.jpg").getImage();
		
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
		
		rules = "<html>This game tests the Occipital Lobe of the brain which is <br>responsible for visual processing. "
				+ "This game has to do with field of view, which is what an individual can see at any given moement."
				+ "<br><br>To play:<br>A city will be displayed with 1 airplane, multiple helicopters, and a symbol"
				+ "in the sky. The city background will then disappear.<br><br>Use your mouse to find the area where"
				+ "the airplane was. If you are correct, you must then select which symbol you saw. If you are correct"
				+ "again, you receive one point, and move on to another round.<br><br>The game ends when you get any"
				+ "answer incorrect. To win, you must get 10 correct in a row.</html>";
		
	
		return rules;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread("my non EDT thread") {
	            public void run() {
	                //my work
	                new OccipitalMain("Show Me the Light");
	            }
	        };
	        t.start();
	}
}