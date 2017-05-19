package Coma;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Represents the screen before the user plays the game to introduce the user to the objectives of the game. 
 * @author
 * @version 5/15/2017
 */
public class StoryScreen extends JPanel implements MouseListener {
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private Coma c;
	private Image i1, i2, i3;
	private int x, y, w, h;
	private int x1, y1, w1, h1;
	
	/**
	 * Constructs a new instance of a story screen.
	 * @param c the game that this story screen is for
	 */
	public StoryScreen(Coma c) {
		super();
		this.c = c;
		setBackground(Color.WHITE);
		
		i1 = new ImageIcon("coma" + System.getProperty("file.separator") + "Rules1.jpg").getImage();
		i2 = new ImageIcon("coma" + System.getProperty("file.separator") + "Rules2.jpg").getImage();
		i3 = new ImageIcon("coma" + System.getProperty("file.separator") + "Rules3.jpg").getImage();
	
		x = 175;
		y = 330;
		w = 400;
		h = 50;
		
		x1 = 25;
		y1 = DRAWING_HEIGHT - 60;
		w1 = 100;
		h1 = 50;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		g.setFont(new Font("Roman Baseline", 0, 18));
		int xcoord = 47;
		int ycoord = 50;
		g.drawString("Imagine getting in a car accident or slipping on the bathroom floor. The", xcoord, ycoord);
		g.drawString("next thing you know (but you actually do not) is that you have fallen into", xcoord, ycoord+25);
		g.drawString("a coma and have damaged your entire brain! This is a major problem", xcoord, ycoord+(2*25));
		g.drawString("because you need your brain for basic abilities such as vision, hearing,", xcoord, ycoord+(3*25));
		g.drawString("cognition, and perception. Your job is to navigate through the four lobes", xcoord, ycoord+(4*25));
		g.drawString("of the brain: the frontal lobe, temporal lobe, occipital lobe, and parietal", xcoord, ycoord+(5*25));
		g.drawString("lobe, all of which are responsible for basic human skills. You will activate", xcoord, ycoord+(6*25));
		g.drawString("these areas by playing games that stimulate each lobe of the brain.", xcoord, ycoord+(7*25));
		g.drawString("Ultimately, COMA strengthens your natural abilities through entertaining", xcoord, ycoord+(8*25));
		g.drawString("mini games and engages your brain by providing an incentive to wake up", xcoord, ycoord+(9*25));
		g.drawString("from a coma.", xcoord, ycoord+(10*25));
		
		g.drawImage(i1, 50, 320, 150, 200, this);
		g.drawImage(i2, 300, 320, 150, 200, this);
		g.drawImage(i3, 550, 320, 150, 200, this);
		
		g.setColor(Color.WHITE);
		g.fillRoundRect(x, y, w, h, 10, 10);
		g.fillRoundRect(x1, y1, w1, h1, 10, 10);
		g.setColor(Color.BLACK);
		g.drawRoundRect(x, y, w, h, 10, 10);
		g.drawRoundRect(x1, y1, w1, h1, 10, 10);
		g.setFont(new Font("Roman Baseline", 3, 30));
		g.drawString("Click here to continue", 220, 360);
		g.drawString("Home", 35, 575);
//        a coma and have damaged your entire brain! This is a major problem
//        because you need your brain for basic abilities such as vision, hearing,
//        cognition, and perception. Your job is to navigate through the four lobes of
//        the brain: the frontal lobe, temporal lobe, occipital lobe, and parietal lobe,
//        all of which are responsible for basic human skills. You will activate these
//        areas by playing games that stimulate each lobe of the brain. Ultimately, COMA
//        strengthens your natural abilities through entertaining mini games and engages
//        your brain by providing an incentive to wake up from a coma."", x, y);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		double xC = e.getX() * 800.0 / getWidth();
		double yC = e.getY() * 600.0 / getHeight();
		 
		if (e.getButton() == 1)
		{
			if(xC >= x && xC <= x + w && yC >= y && yC <= y + h + 40) {
				c.changePanel("3");
			}
			else if(xC >= x1 && xC <= x1 + w1 && yC >= y1 && yC <= y1 + h1 + 40) {
				c.changePanel("1");
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}