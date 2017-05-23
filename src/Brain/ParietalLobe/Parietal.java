package Brain.ParietalLobe;
import java.awt.Color;

import Brain.Lobe;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.*;

import Coma.Coma;

/**
 * Represents the panel of the parietal lobe game with the drawn background and objects needed. 
 * @version 5/15/2017
 *
 */
public class Parietal extends Lobe implements KeyListener{
	private Rectangle screenRect;
	private Coma c;
	
	private JButton back, menu;
	private Image background, winImage;
	private Wall w;
	private ArrayList<Shape> s;
	private Shape drawS1;
	private int random, numCorrect, seconds, threshold;
	private boolean continueGame;
	private Timer clock1, clock2;
	
	/**
	 * Constucts a new instance of this panel.
	 * @param c the game that this Parietal screen is for.
	 */
	public Parietal(Coma c) {
		super();
		setLayout(null);
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		background = (new ImageIcon("parietal" + System.getProperty("file.separator") + "ParietalBackground.gif")).getImage();
		w = new Wall(40, 200, 90, 270); // Wall(x, y, vY, width, height)
		s = new ArrayList<Shape>();
		s.add(new Circle(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 150)), 23, DRAWING_WIDTH / 400, Color.YELLOW));
		s.add(new Triangle(DRAWING_WIDTH - 75, (int)(Math.random() * (DRAWING_HEIGHT - 150)), 45, DRAWING_WIDTH / 400, Color.YELLOW));
		s.add(new Square(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 150)), 45, DRAWING_WIDTH / 400, Color.YELLOW));
		setBackground(Color.WHITE);
		this.c = c;
		
		back = getBack();
		menu = getMenu();
		winImage = getWinImage();
		

		numCorrect = 0;
		seconds = 45;
		random = (int)(Math.random() * 3);
		drawS1 = s.get(random);
		continueGame = true;
		threshold = 1000;
		
		clock1 = new Timer(7, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (continueGame) {
					drawS1.act();
					w.passes(drawS1);
				}
			}
		});
		clock2 = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seconds--;
//				timer.setText(format(seconds/60)+":"+format(seconds%60));
				if(seconds == 0 || numCorrect >= threshold && seconds > 0) {
					Timer x = (Timer) e.getSource();
					x.stop();
				}
			}
		});
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

		menu.setBounds((int)(150*ratioX), (int)(20*ratioY), (int)(100*ratioX), (int)(50*ratioY));
		back.setBounds((int)(25*ratioX), (int)(20*ratioY), (int)(100*ratioX), (int)(50*ratioY));
		
		if (!c.getWon(3)) {
			if (continueGame) {
				g.drawImage(background, 0, 0, DRAWING_WIDTH, DRAWING_HEIGHT, this);
				
				g.setColor(Color.WHITE);
				g.setFont(new Font("Roman Baseline", 1, 24));
				g.drawString("SCORE: " + numCorrect, DRAWING_WIDTH / 2 - 80, 40);
				
				g.setFont(new Font("Roman Baseline", 1, 50));
				g.drawString("00:" + format(seconds % 60), 600, 50);
				
				w.draw(g2);
				drawS1.draw(g2);
				
				if (w.passes(drawS1))
					numCorrect += 1 * 10;
					
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
				
				if(numCorrect >= threshold && seconds > 0 || seconds == 0) {
					//c.setWon(3);
					continueGame = false;
					clock1.stop();
					clock2.stop();
				}
			}
			else {
				clock1.stop();
				clock2.stop();
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setColor(Color.RED);
				g.setFont(new Font("Roman Baseline", 1, 100));
				
				if(numCorrect >= threshold && seconds > 0) {
					c.setWon(3);
					g.drawImage(winImage, 0, 0, getWidth(), getHeight(), this);
					g.drawString("YOU WIN", DRAWING_WIDTH / 2 - 220, DRAWING_HEIGHT / 2);	
	//				c.changeToOver();
				}

				else if (seconds == 0) {
					g.setColor(Color.BLACK);
					g.drawImage(getLoseImage(), 0, 0, DRAWING_WIDTH, DRAWING_HEIGHT, this);
					g.drawString("YOU LOSE", DRAWING_WIDTH / 2 - 300, DRAWING_HEIGHT / 2);
				}
				
				g.setColor(Color.BLACK);

				g.setFont(new Font("Roman Baseline", 1, 24));
				g.drawString("SCORE: " + numCorrect, getWidth() / 2 - 80, 40);

			
				g.setFont(new Font("Roman Baseline", 3, 50));
				g.drawString(format(seconds/60) + ":" + format(seconds % 60), 600, 50);
				return;
			}
		}
		else {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.BLACK);
			g.setFont(new Font("Roman Baseline", 3, 100));
			g.drawImage(winImage, 0, 0, getWidth(), getHeight(), this);
			g.drawString("YOU WIN", DRAWING_WIDTH / 2 - 220, DRAWING_HEIGHT / 2);
			
			
		}
		
		clock1.start();
		clock2.start();
		g2.setTransform(at);
		repaint(); 	
	}
	
	/**
	 * Redraws an instance of a wall to wrap around the screen once it disappears out of view.
	 */
	public void redrawWall() {
		if (w.getY() + w.getWidth() >= DRAWING_HEIGHT)
			w = new Wall((int)w.getX(), (int)-w.getHeight(), (int)w.getWidth(), (int)w.getHeight());
		else
			w = new Wall((int)w.getX(), DRAWING_HEIGHT, (int)w.getWidth(), (int)w.getHeight());
	}
	
	/**
	 * Creates a new instance of a shape at the far right side of the screen once the current shape has passed
	 * or collided into the wall.
	 */
	public void shootShape() {
		int shape = (int)(Math.random() * 3);
		if (shape == 0)
			drawS1 = new Circle(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 50)), 23, (getWidth() + 18) / 400, Color.YELLOW);
		else if (shape == 1)
			drawS1 = new Triangle(DRAWING_WIDTH - 75, (int)(Math.random() * (DRAWING_HEIGHT - 25)), 45, (getWidth() + 18) / 400, Color.YELLOW);
		else 
			drawS1 = new Square(DRAWING_WIDTH - 100, (int)(Math.random() * (DRAWING_HEIGHT - 50)), 45, (getWidth() + 18) / 400, Color.YELLOW);
	}
	
	/**
	 * Resets game panel to be counting down from 45 seconds.
	 * 
	 */
	public void reset() {
		seconds = 45;
		numCorrect = 0;
		w = new Wall(40, 200, 90, 270);
	}

	public void keyPressed(KeyEvent e) {
		long lastPressProcessed = 0;
		
		if(System.currentTimeMillis() - lastPressProcessed > 500) {
			int code = e.getKeyCode();
			if (code == KeyEvent.VK_UP) {
				w.act(1);
			}
			else if (code == KeyEvent.VK_DOWN) {
				w.act(-1);
			}
            lastPressProcessed = System.currentTimeMillis();
            repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == back) {
			if (c.getOver()) {
				c.changePanel("4");
			}
			else {
				c.changePanel("9");
				if (!c.getWon(3))
					continueGame = true;
			}
		}
		else if (src == menu) {
			if (c.getOver()) {
				c.changePanel("4");
			}
			else {
				c.changePanel("3");
				if (!c.getWon(3))
					continueGame = true;
			}
			
		}
	}

}