package Coma;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Home extends JPanel implements MouseListener{
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private Rectangle screenRect;
	
	private Coma c;
	private Image background;
	
	public Home(Coma c) {
		super();
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		this.c = c;
		background = new ImageIcon("COMA background.jpg").getImage();
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
		g.drawString("C.O.M.A", 200, 300);
		g.setFont(new Font("SansSerif", 1, 20));
		g.drawString("Click anywhere to begin", 280, 320);
		
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		
		if (e.getButton() == 1)
		{
			c.changePanel("2");
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
