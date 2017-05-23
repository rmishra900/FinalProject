package Brain.FrontalLobe;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Brain.Rules;
import Coma.Coma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.Color;

public class FrontalRules extends Rules {
	private Coma c;
	private Image green, red, blue;
	
	public FrontalRules( Coma c) {
		super();
		this.c = c;
		green = (new ImageIcon("frontal" + System.getProperty("file.separator") + "GreenUpArrow.png")).getImage();
		red = (new ImageIcon("frontal" + System.getProperty("file.separator") + "RedUpArrow.png")).getImage();
		blue = (new ImageIcon("frontal" + System.getProperty("file.separator") + "BlueUpArrow.png")).getImage();
	}

	@Override
	public String getText() {
		String rules = "";
		
		rules = "<html>This game tests the Frontal Lobe of the brain which is responsible for cognitive thinking "
				+ "including task switching, memory and impulse control.<br>To play:<br>"
				+ "<p style = margin-left:60px>For GREEN, press the arrow key that corresponds to the direction the arrows are moving in.<br><br>"
				+ "For RED, press the arrow key that corresponds to the direction the arrows are pointing.<br><br>"	
				+ "For BLUE, press the arrow key that corresponds to the opposite direction the arrows are moving in.</p><br>"	
				+ "To win, you must reach <b><u>200 points in 30 seconds</b></u>.</html>";
		
	
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
		
		g.drawImage(green, DRAWING_WIDTH/3 - 140, DRAWING_HEIGHT/3 - 25, 35, 55, this);
		g.drawImage(red, DRAWING_WIDTH/3 - 140, DRAWING_HEIGHT / 2 - 50, 35, 55, this);
		g.drawImage(blue, DRAWING_WIDTH/3 - 140, DRAWING_HEIGHT / 2 + 35, 35, 55, this);
		
		g2.setTransform(at);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == getBegin()) {			
			if(	((Frontal)c.getPanel(1)).getWin().getText().equals("") || 
					((Frontal)c.getPanel(1)).getWin().getText().equals("YOU LOSE")) {
				((Frontal)c.getPanel(1)).reset();
			}
//			else if(((Frontal)c.getPanel(1)).getWin().getText().equals("YOU LOSE")) {
//				((Frontal)c.getPanel(1)).reset();	
//			}
		c.changePanel("7");
		}
		else if (src == getMenu())
			c.changePanel("3");
	}
	
}
