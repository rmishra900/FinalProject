package Brain.FrontalLobe;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.Color;

public class Rules extends JPanel implements ActionListener{

	private String text;
	private Image greenArrow, blueArrow, redArrow, background;
	private JButton begin;
	private JLabel rulesBackground, rules;
//	private FlyingArrows f;
//	private Frontal frontal;
	
//	public static final int DRAWING_WIDTH = 800;
//	public static final int DRAWING_HEIGHT = 600;
	
	
	public Rules() {
		setLayout(null);
//		Zzzz
		begin = new JButton("BEGIN");
		begin.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		//begin.setBounds(325, 500, 100, 50);
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
		
//		Graphics2D g2 = (Graphics2D)g;
//
//	    int width = getWidth();
//	    int height = getHeight();
//	    
//	    double ratioX = (double)width/DRAWING_WIDTH;
//		double ratioY = (double)height/DRAWING_HEIGHT;
//		        
//		AffineTransform at = g2.getTransform();
//		g2.scale(ratioX, ratioY);
//		 
	
	}
	
	public String getText() {
		String rules = "";
		
		rules = "<html>This game tests the Frontal Lobe of the brain which is <br>responsible for cognitive thinking "
				+ "including task switching,<br> memory and impulse control.<br><br>To play:<br>If arrows are green - "
				+ "press arrow key that corresponds to the direction the arrows are moving in."
				+ "<br><br>If arrows are red - press the arrow key that corresponds to the direction the arrows "
				+ "are pointing to.<br><br>If arrows are blue - press the arrow on the keyboard that corresponds "
				+ "to the opposite direction the arrows are pointing to.</html>";
		
	
		return rules;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FrontalMain fm = new FrontalMain("FlyingArrows");
//		if(e.getSource()==begin){
//			f.changePanel("2");
//		}
		
	}
}
