package Brain;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public abstract class Rules extends JPanel implements ActionListener {
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	//private Image greenArrow, blueArrow, redArrow, background;
	private Image background;
	private JButton begin, menu;
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
		
		menu = new JButton("MENU");
		menu.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		menu.setSize(100, 50);
		
		background = new ImageIcon("coma" + System.getProperty("file.separator") + "ruleBackground.jpg").getImage();
		
		rulesBackground = new JLabel();
		
		
		rules = new JLabel(getText());
		rules.setLocation(105, 55);
		rules.setSize(600, 200);
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
		add(menu);
		begin.addActionListener(this);
		menu.addActionListener(this);
		
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
		
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		
		begin.setBounds((int)(325*ratioX),(int)(500*ratioY),(int)(100*ratioX),(int)(50*ratioY));
		menu.setSize(100, 50);
		menu.setBounds((int)(menu.getX()*ratioX),(int)(menu.getY()*ratioY),(int)(100*ratioX),(int)(50*ratioY));
		rulesBackground.setBounds((int)(100*ratioX),(int)(50*ratioY),(int)(600*ratioX),(int)(450*ratioY));
		rules.setBounds((int)(105*ratioX),(int)(55*ratioY),(int)(600*ratioX),(int)(400*ratioY));
		
		//g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

	}
	
	public boolean isMenuPressed() {
		if(menu.getModel().isPressed())
			return true;
		else
			return false;
	}
	
	public JLabel getRules() {
		return rules;
	}
	
	/**
	 * Returns the text representing rules for the game
	 * @return String that represents the rules for FlyingArrows
	 */
	public abstract String getText();

	@Override
	public abstract void actionPerformed(ActionEvent e);
	
	public JButton getBegin() {
		return begin;
	}
	
	public JButton getMenu() {
		return menu;
	}
}