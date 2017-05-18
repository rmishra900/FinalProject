package Coma;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Represents the screen displayed when the game is over. 
 * @version 5/15/2017
 *
 */
public class GameOver extends JPanel implements KeyListener{
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private Rectangle screenRect;
	
	private Coma c;
	private JButton home;
	private Image background;
	
	public GameOver(Coma c) {
		super();
		this.c = c;
		background = new ImageIcon("coma" + System.getProperty("file.separator") + "COMA background.jpg").getImage();
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
		
		g.setFont(new Font("SansSerif", 3, 100));
		g.drawString("GAME OVER", 100, 300);
		g.setFont(new Font("SansSerif", 1, 20));
		g.drawString("Press the enter button to go back to home", 200, 320);
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			c.changePanel("1");
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
