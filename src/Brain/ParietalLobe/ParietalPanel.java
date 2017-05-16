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

/**
 * Represents the panel of the parietal lobe game with the drawn background and objects needed. 
 * @author Thanh Luong
 * @version 5/15/2017
 *
 */
public class ParietalPanel extends Lobe implements KeyListener{ //, ActionListener {
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private Rectangle screenRect;
	
	private Image background;
	private Wall w;
	private ArrayList<Shape> s;
	private Shape drawS1;
//	private JLabel timer;
	private int random, numCorrect, seconds, threshold;
	private boolean continueGame;
	
	/**
	 * Constucts a new instance of this panel.
	 */
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
		seconds = 30;
		random = (int)(Math.random() * 3);
		drawS1 = s.get(random);
		continueGame = true;
		threshold = 700;
		
		Timer clock1 = new Timer(7, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (continueGame) {
					drawS1.act();
					w.passes(drawS1);
				}
			}
		});
		Timer clock2 = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seconds--;
//				timer.setText(format(seconds/60)+":"+format(seconds%60));
				if(seconds == 0 || numCorrect >= threshold && seconds > 0) {
					Timer x = (Timer) e.getSource();
					x.stop();
				}
			}
		});
		
//		add(timer);
		clock1.start();
		clock2.start();
	}
	
	/**
	 * Returns a formatted String that represents the time in seconds
	 * @param i integer needed to be formatted
	 * @return formatted string
	 */
	private String format(int i) {
		String result = String.valueOf(i);
		if(result.length()==1) {
			result = "0"+result;
		}
		return result;
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
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font("SansSerif", 3, 50));
		g.drawString("00:" + format(seconds % 60), 600, 50);
		
		w.draw(g2);
		drawS1.draw(g2);
		
		if (w.passes(drawS1) && continueGame) {
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
		
		if(numCorrect >= threshold && seconds > 0) {
			continueGame = false;
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
			g.setColor(Color.YELLOW);
			g.setFont(new Font("SansSerif", 3, 100));
			g.drawString("YOU WIN", 200, 300);
			g.setColor(Color.WHITE);
			g.fillRoundRect(DRAWING_WIDTH / 2 - 100, 5, 190, 50, 10, 10);
			g.setColor(Color.BLACK);
			g.drawRoundRect(DRAWING_WIDTH / 2 - 90, 15, 170, 30, 10, 10);
			
			g.setFont(new Font("SansSerif", 3, 24));
			g.drawString("SCORE: " + numCorrect, DRAWING_WIDTH / 2 - 80, 40);
		
			g.setColor(Color.YELLOW);
			g.setFont(new Font("SansSerif", 3, 50));
			g.drawString(format(seconds/60) + ":" + format(seconds % 60), 600, 50);
			return;
		}
		else if(seconds == 0 && numCorrect < threshold) {
			continueGame = false;
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
			g.setColor(Color.YELLOW);
			g.setFont(new Font("SansSerif", 3, 100));
			g.drawString("YOU LOSE", 150, 300);
			g.setColor(Color.WHITE);
			g.fillRoundRect(DRAWING_WIDTH / 2 - 100, 5, 190, 50, 10, 10);
			g.setColor(Color.BLACK);
			g.drawRoundRect(DRAWING_WIDTH / 2 - 90, 15, 170, 30, 10, 10);
			
			g.setFont(new Font("SansSerif", 3, 24));
			g.drawString("SCORE: " + numCorrect, DRAWING_WIDTH / 2 - 80, 40);
			
			g.setColor(Color.YELLOW);
			g.setFont(new Font("SansSerif", 3, 50));
			g.drawString(format(seconds/60) + ":" + format(seconds % 60), 600, 50);
			return;
		}
		 
		repaint(); 	
	}
	
	/**
	 * Redraws an instance of a wall to wrap around the screen once it disappeared out of view.
	 */
	public void redrawWall() {
		if (w.getY() + w.getWidth() >= DRAWING_HEIGHT)
			w = new Wall((int)w.getX(), (int)-w.getHeight(), 0, (int)w.getWidth(), (int)w.getHeight());
		else
			w = new Wall((int)w.getX(), DRAWING_HEIGHT, 0, (int)w.getWidth(), (int)w.getHeight());
	}
	
	/**
	 * Creates a new instance of a shape at the far right side of the screen once the current shape has passed
	 * or collided into the wall.
	 */
	public void shootShape() {
		int shape = (int)(Math.random() * 3);
		
		if (shape == 0)
			drawS1 = new Circle(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 50)), 25, Color.YELLOW);
		else if (shape == 1)
			drawS1 = new Triangle(DRAWING_WIDTH - 75, (int)(Math.random() * (DRAWING_HEIGHT - 25)), 50, Color.YELLOW);
		else 
			drawS1 = new Square(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 50)), 50, Color.YELLOW);
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