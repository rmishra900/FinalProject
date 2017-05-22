package Coma;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Represents the screen that the user sees when they start playing the game. 
 * @author 
 * @version 5/15/2017
 *
 */
public class Home extends JPanel implements KeyListener{
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private Rectangle screenRect;
	
	private Coma c;
	private Image background;
	
	/**
	 * Constructs a new instance of this home screen. 
	 * @param c the game that this home screen is for 
	 */
	public Home(Coma c) {
		super();
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		this.c = c;
		background = new ImageIcon("coma" + System.getProperty("file.separator") + "comaBackground.jpg").getImage();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		
		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Roman Baseline", 3, 100));
		g.drawString("C.O.M.A", 200, 100);
		g.setFont(new Font("Roman Baseline", 1, 25));
		g.drawString("Press the space bar to begin", 230, 540);
		
		repaint();
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			c.changePanel("2");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
