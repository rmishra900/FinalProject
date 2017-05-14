package Brain.ParietalLobe;
import java.awt.Color;
import java.awt.Font;
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
	private Shape drawS1;
	private int random, numCorrect;
	
	public ParietalPanel() {
		super();
		
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		background = (new ImageIcon("ParietalBackground.gif")).getImage();
		w = new Wall(40, 200, 0, 90, 270); // Wall(x, y, vY, width, height)
		s = new ArrayList<Shape>();
		s.add(new Circle(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 50)), 25, Color.YELLOW));
		s.add(new Triangle(DRAWING_WIDTH - 75, (int)(Math.random() * (DRAWING_HEIGHT - 25)), 50, Color.YELLOW));
		s.add(new Square(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 50)), 50, Color.YELLOW));
		setBackground(Color.WHITE);
		
		numCorrect = 0;
		random = (int)(Math.random() * 3);
		drawS1 = s.get(random);
		
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
		g.setColor(Color.WHITE);
		g.fillRoundRect(DRAWING_WIDTH / 2 - 100, 5, 190, 50, 10, 10);
		g.setColor(Color.BLACK);
		g.drawRoundRect(DRAWING_WIDTH / 2 - 90, 15, 170, 30, 10, 10);
		
		g.setFont(new Font("SansSerif", 3, 24));
		g.drawString("SCORE: " + numCorrect, DRAWING_WIDTH / 2 - 80, 40);
		
		w.draw(g2);

		drawS1.draw(g2);
		
		if (w.passes(drawS1)) {
			numCorrect++;
//			g.drawString("SCORE :" + numCorrect, DRAWING_WIDTH / 2 - 35, 10);
		}
			
		if(drawS1.whichShape() == 0 || drawS1.whichShape() == 2) {
			if (drawS1.x <= w.x) {
				shootShape();
			}
		}
		else {
			Triangle t = (Triangle)drawS1;
			if (t.getXCoords()[1] <= w.x) {
				shootShape();
			}
		}
		
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
	
	public void shootShape() {
		int shape = (int)(Math.random() * 3);
		
		if (shape == 0)
			drawS1 = new Circle(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 50)), 25, Color.YELLOW);
		else if (shape == 1)
			drawS1 = new Triangle(DRAWING_WIDTH - 75, (int)(Math.random() * (DRAWING_HEIGHT - 25)), 50, Color.YELLOW);
		else 
			drawS1 = new Square(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 50)), 50, Color.YELLOW);

		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		drawS1.act();
		w.passes(drawS1);
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