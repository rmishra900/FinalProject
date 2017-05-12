
package Brain.ParietalLobe;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.*;

import Brain.Lobe;

public class ParietalPanel extends Lobe implements KeyListener, ActionListener {
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private Rectangle screenRect;
	
	private Image background;
	private Wall w;
	private ArrayList<Shape> s;
	private int random;
	
	public ParietalPanel() {
		super();
		
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		background = (new ImageIcon("ParietalBackground.gif")).getImage();
		w = new Wall(40, 200, 0, 90, 270); // Wall(x, y, vY, width, height)
		s = new ArrayList<Shape>();
		s.add(new Circle(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 50)), 25, Color.MAGENTA));
		s.add(new Triangle(DRAWING_WIDTH - 75, (int)(Math.random() * (DRAWING_HEIGHT - 25)), 50, Color.BLACK));
		s.add(new Square(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 50)), 50, Color.YELLOW));
		setBackground(Color.WHITE);
		
		random = (int)(Math.random() * 3);
		
		Timer clock = new Timer(7, this);
		clock.start();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		g.drawImage(background, 0, 0, DRAWING_WIDTH, DRAWING_HEIGHT, this);
		w.draw(g);
		
		s.get(random).draw(g2);
		
		if (!screenRect.intersects(w))
	  		redrawWall();
		
		g2.setTransform(at);
		repaint();
	  	
	}
	
	public void redrawWall() {
		if (w.getY() + w.getWidth() >= DRAWING_HEIGHT)
			w = new Wall((int)w.getX(), (int)-w.getHeight(), 0, (int)w.getWidth(), (int)w.getHeight());
		else
			w = new Wall((int)w.getX(), DRAWING_HEIGHT, 0, (int)w.getWidth(), (int)w.getHeight());
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Shape cur = s.get(random);
		cur.act();
		if (cur.getX() < 0)
			cur = null;

		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			w.act(1);
		}
		else if (code == KeyEvent.VK_DOWN) {
			w.act(-1);
		}
  
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
