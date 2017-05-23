package Brain.FrontalLobe;

import java.awt.Color;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.Timer;

import Brain.Lobe;
import Coma.Coma;

import java.awt.event.ActionListener;

/**
 * The class that represents all the Arrow objects into the screen for the game
 * @version 5/22/2017
 *
 */
public class Frontal extends Lobe {
	
	private Coma coma;
	
	private Arrow arrow;
	private ArrayList<Arrow> arrows;
	
	private JButton back, menu;
	private KeyHandler keyControl;
	
	private Image img, winImage;
	private JLabel timer, win, score;
	
	private int prevX, direction, pointingTo, correct, threshold, seconds;
	private Timer t;
	private Color c;
	private boolean won;
	
	
	/**
	 * Contructs a timer, Jlabels for winning and losing, keyHandler, and initializes the arrows onto the screen
	 * @param coma the game that this Frontal screen is for
	 */
	public Frontal(Coma coma) {
		super();
		setLayout(null);
		this.coma = coma;
		prevX = -1;
		direction = 37;
		pointingTo = 37;
		
		correct = 0;
		c = null;
		threshold = 200;
		
		seconds = 30;
	
		win = new JLabel();
		win.setLocation(DRAWING_WIDTH / 2 - 250, DRAWING_HEIGHT / 2 - 50);
		win.setSize(500, 100);
		win.setForeground(Color.BLACK);
		win.setFont(new Font("Roman Baseline", 3, 100));
		add(win);
	
		setLayout(null);
	
		back = getBack();
		menu = getMenu();

		keyControl = new KeyHandler();
	
		arrow = new Arrow(0,0,Color.BLUE);

		img = new ImageIcon("frontal" + System.getProperty("file.separator") + "sky.png").getImage();
		winImage = getWinImage();
		initializeArrows();
		won = false;
		
		score = new JLabel("SCORE: "+correct);
		score.setForeground(Color.WHITE);
		score.setLocation(350, 20);
		score.setSize(150,30);
		score.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		add(score);
	
		timer = new JLabel("0:"+seconds);
		timer.setLocation(600,20);
		timer.setSize(150, 30);
		timer.setForeground(Color.WHITE);
		timer.setFont(new Font("Roman Baseline", Font.BOLD, 30));
		
		t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seconds--;
				timer.setText(format(seconds/60)+":"+format(seconds%60));
				if(seconds == 0 || winGame()==true) {
					Timer x = (Timer) e.getSource();
					x.stop();
				}
			}
			
		});
		
		add(timer);
	}
	
	/**
	 * Returns a formatted String that represents time
	 * @param i integer needed to format
	 * @return formatted String
	 */
	private String format(int i) {
		String result = String.valueOf(i);
		if(result.length()==1) {
			result = "0"+result;
		}
		return result;
	}
	

	/**
	 * Initializes all arrows (with a random color and image) onto the screen in random locations
	 */
	private void initializeArrows() {
		arrows = new ArrayList<Arrow>();
		
		Color c = getRandomColor();
		Image random = arrow.getRandomImage(c);
		
		for(int i = 0; i < 100; i++) {
			int xcoord = getRandomX();
			int ycoord = getRandomY();
			arrows.add(new Arrow(xcoord, ycoord, c));
			arrows.get(i).setImage(random);
			
			
		}
		
	}
	
	/**
	 * Returns integer that represents score of user
	 * @return integer that corresponds to the number of correct presses that user has
	 */
	public int getCorrect() { return correct; }
	
	/**
	 * Sets the score of the user
	 * @param c integer representing score
	 */
	public void setCorrect(int c) { correct = c; }
	
	/**
	 * Returns arrayList of arrows on screen
	 * @return arrayList of arrows
	 */
	public ArrayList<Arrow> getArrows() {
		return arrows;
	}
	
	/**
	 * Sets the JLabel representing the score of the user
	 * @param s the JLabel to display the user's score
	 */
	public void setScore(JLabel s) { score = s; }
	
	/**
	 * Returns JLabel representing score of user
	 * @return JLabel for user's score
	 */
	public JLabel getScore() { return score; }
	
	/**
	 * Returns Winning JLabel
	 * @return JLabel with winning text
	 */
	public JLabel getWin() {
		return win; 
	}
	
	/**
	 * Sets text of Jlabel used for diplaying win
	 * @param w text to write in JLabel
	 */
	public void setWinText(String w) {
		win.setText(w);
	}
	
	/**
	 * Increments scoreCount of user and sets JLabel representing score
	 */
	public void someoneScored()
	{
	  correct+=10;
	  if(correct<=threshold)
		  score.setText("SCORE: " + correct);
	}
	
	/**
	 * Decreases scoreCount of user and sets JLabel representing score
	 */
	public void someoneLostPoints() {
		
		if(correct<=threshold && correct>0) {
			correct-=10;
			score.setText("SCORE: "+correct);
		}
	}
	
	/**
	 * Assigns each arrow in frontal random locations
	 */
	public void putArrowInRandomLocations() {
		for(Arrow a: arrows) {
			int xcoord = getRandomX();
			int ycoord = getRandomY();
			a.setX(xcoord);
			a.setY(ycoord);
		}
	}
	
	/**
	 * Returns background image of the flying arrows screen
	 * @return background image of game
	 */
	public Image getBackgroundImage() { return img; }
	
	/**
	 * Returns a random color that is either red, green, or blue
	 * @return random color
	 */
	public Color getRandomColor() {
		Color c;
		int randCol = (int) (Math.random()*3);
		if(randCol == 0) {
			c = new Color(255,0,0); //red
		}
		else if(randCol==1) {
			c = new Color(0,255,0); //green
		}
		else {
			c = new Color(0,0,255); //blue
		}
		return c;
	}
	
	/**
	 * Returns random x-coordinate 
	 * @return integer representing an x-coordinate
	 */
	public int getRandomX() {
		int xCoord = (int) (Math.random()*DRAWING_WIDTH);
		return xCoord;
	}
	
	/**
	 * Returns random y-coordinate
	 * @return integer representing an y-coordinate
	 */
	public int getRandomY() {
		int yCoord = (int) (Math.random()*(DRAWING_HEIGHT-250))+150;
		return yCoord;
	}
	
	/**
	 * Returns random direction not including the current direction.
	 * If it returns 37, then the direction is left.
	 * If it returns 38, then the direction is up. 
	 * If it returns 39, then the direction is down.
	 * If it returns 40, then the direction is down.
	 * @param x current direction of arrows
	 * @return random direction other than current direction
	 */
	public int getRandomDirection(int x) {
		int dir = (int) (Math.random()*4);
		
		while(x==dir+37) {
			dir = (int) (Math.random()*4);
		}
		
		return dir+37;
	}
	
	/**
	 * Moves all arrows across the screen in a certain direction
	 * @param direction direction to move arrows 
	 * 			If it returns 37, then the direction is left.
	 * 			If it returns 38, then the direction is up. 
	 * 			If it returns 39, then the direction is down.
	 * 			If it returns 40, then the direction is down.
	 * @param a the arrow that needs to be moved
	 */
	public void moveAcrossScreen(int direction, Arrow a) { 
		   if(direction == 37) {
			   a.move(-5,0);
			   if(a.getX()<1) {
				   a.setX(DRAWING_WIDTH-5);
				   a.move(-5,0);
			   }
		   }
		   else if(direction == 38) {
			   a.move(0,-5);
			   if(a.getY()<150) {
				   a.setY(DRAWING_HEIGHT-100+4);
				   a.move(0, -5);
			   }
		   }
		   else if(direction == 39) {
			   a.move(5,0);
			   if(a.getX()>getWidth()-25) {
				   a.setX(-4);
				   a.move(5,0);
			   }
		   }
		   else {
			   a.move(0, 5);
			   if(a.getY()>DRAWING_HEIGHT-100+4) {
				   a.setY(150);
				   a.move(0, 5);
			   }
		   }
	}
	
	
	/**
	 * Returns whether user won the game or not. To win, the number correct needs to be greater than the
	 * threshold in the time limit
	 * @return true if wins, and false if loses
	 */
	public boolean winGame() {
		if(correct >= threshold && seconds>0) 
			return true;
		else if(seconds==0 && correct<threshold)
			return false;
		else
			return false;
	}
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		
		g.drawImage(img, 0, 0, getWidth(), getHeight() , this);
		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;
		        
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		menu.setBounds((int)(150*ratioX), (int)(20*ratioY), (int)(100*ratioX), (int)(50*ratioY));
		back.setBounds((int)(25*ratioX), (int)(20*ratioY), (int)(100*ratioX), (int)(50*ratioY));
		
		score.setBounds((int)(350*ratioX), (int)(20*ratioY), (int)(150*ratioX), (int)(30*ratioY));
		timer.setBounds((int)(600*ratioX), (int)(20*ratioY), (int)(150*ratioX), (int)(30*ratioY));
	
		
	   for(Arrow a: arrows) {
		   a.setPointingTo(pointingTo);
		   a.setDirection(direction);
		 		  
		   int w = a.getWidth(this)/8;
		   int h = a.getHeight(this)/8;
		  
		   a.draw(g, a.getImage(), a.getX(), a.getY(), w, h, this);
	
		   	moveAcrossScreen(direction,  a);
			direction = a.getDirection();
			c = a.getColor();
			pointingTo = a.getOrientation();
	   }
	
	   if(isCorrect(c,direction,pointingTo) == true) {
		   someoneScored();
		   changeImage();
		   int orientation = changeOrientation();
		   pointingTo = orientation;
		   direction = getRandomDirection(direction);
	      }
	   
	   
	   if(winGame()) {
		   score.setForeground(Color.BLACK);
		   timer.setForeground(Color.BLACK);
		   g.setColor(Color.WHITE);
		   g.fillRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
		
		   g.setColor(Color.BLACK);
		   g.setFont(new Font("Roman Baseline", 3, 100));
		  
		   g.drawImage(winImage, 0, 0, getWidth(), getHeight(), this);
		   g.drawString("YOU WIN!", DRAWING_WIDTH / 2 - 250, DRAWING_HEIGHT / 2 - 50);
		 
		 
		   if(!coma.getWon(1)) {
			   coma.setWon(1);
		   }
		   return;
	   }
	   else if(seconds == 0 && correct<threshold) {
		   score.setForeground(Color.BLACK);
		   timer.setForeground(Color.BLACK);
		   g.setColor(Color.WHITE);
		   g.fillRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
		 
		   g.setColor(Color.RED);
		   g.setFont(new Font("Roman Baseline", 3, 100));
		   
		  
		   g.drawImage(getLoseImage(), 0, 0, DRAWING_WIDTH, DRAWING_HEIGHT, this);
		   g.drawString("YOU LOSE", DRAWING_WIDTH / 2 - 270, DRAWING_HEIGHT / 2 - 50);
		   return;
	   }
	   
	   if(correct>threshold) {
		   return;
	   }
	 
	  
	   t.start();
	   repaint();
	   
	   try {
		Thread.sleep(10);
	   } catch (InterruptedException e) {
		e.printStackTrace();
	   }
	    g2.setTransform(at); 
	}
	
	/**
	 * Changes orientation of arrows to a random orientation.
	 * @return integer representing new orientation of arrows
	 * If it returns 37, then the orientation is left.
	 * If it returns 38, then the orientation is up. 
	 * If it returns 39, then the orientation is down.
	 * If it returns 40, then the orientation is down.
	 */
	public int changeOrientation()  {
		Arrow arr = arrows.get(0);
		Image img = arr.getRandomOrientation(arr.getColor());
		for(Arrow a: arrows) {
			a.setImage(img);
			pointingTo = a.getOrientation();
		}
		return pointingTo;
	}
	
	/**
	 * Determines if the user pressed the correct key that corresponds to arrows based on the rules
	 * @param c the Color of the arrows
	 * @param direction integer representing the direction of the arrows
	 * @param pointingTo integer representing the orientation of the arrows
	 * @return true if user pressed correct key depending on arrows, false otherwise
	 */
	public boolean isCorrect(Color c, int direction, int pointingTo) {
		if(c == Color.GREEN) {
			if((keyControl.isPressed(KeyEvent.VK_LEFT) && direction == 37) ||
					   (keyControl.isPressed(KeyEvent.VK_UP) && direction == 38) ||
					   (keyControl.isPressed(KeyEvent.VK_RIGHT)&& direction == 39) ||
					   (keyControl.isPressed(KeyEvent.VK_DOWN) && direction == 40)) 
				   {
						return true;
				   }
			else {
				return false;
			}
		}
		else if(c == Color.RED) {
			if((keyControl.isPressed(KeyEvent.VK_LEFT) && pointingTo == 37) ||
			   (keyControl.isPressed(KeyEvent.VK_UP) && pointingTo == 38) ||
			   (keyControl.isPressed(KeyEvent.VK_RIGHT)&& pointingTo == 39) ||
			   (keyControl.isPressed(KeyEvent.VK_DOWN) && pointingTo == 40)) 
			{
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if((keyControl.isPressed(KeyEvent.VK_LEFT) && direction == 39) ||
					   (keyControl.isPressed(KeyEvent.VK_UP) && direction == 40) ||
					   (keyControl.isPressed(KeyEvent.VK_RIGHT)&& direction == 37) ||
					   (keyControl.isPressed(KeyEvent.VK_DOWN) && direction == 38)) 
				   {
						return true;
				   }
			else {
				return false;
			}
		}
	}
	
	/**
	 * Randomly changes image of arrows (red, green, or blue)
	 */
	public void changeImage() {
		 int x = (int) (Math.random()*3);
		  
		   while(prevX == x) {
			   x = (int) (Math.random()*3);
		   }	  
		 
		   for(Arrow a: arrows) {
			   
			  Image green = a.getGreenImage();   
			  Image red = a.getRedImage();
			  Image blue = a.getBlueImage();
			
			  if(x == 0) {
				  a.setImage(green);
				  a.setcolor(Color.GREEN);
			  }
			  else if(x==1) {
				  a.setImage(red);
				  a.setcolor(Color.RED);
			  }
			  else {
				  a.setImage(blue);
				  a.setcolor(Color.BLUE);
			  }
			   
			 
		   }
		   prevX = x;  
	}
	
	/**
	 * Returns keyHandler used
	 * @return KeyHandler used to check if the correct key is pressed
	 */
	public KeyHandler getKeyHandler() {
		  return keyControl;
	  }

	
	/**
	 * Resets game panel to be counting down from 45 seconds.
	 * 
	 */
	public void reset() {
		seconds = 30;
		correct = 0;
		initializeArrows();
		timer.setText(format(seconds/60)+":"+format(seconds%60));
		
		score.setText("SCORE: " + correct);
		win.setText("");
	}
	
	
	public class KeyHandler implements KeyListener {
		private ArrayList<Integer> keys;
		
		public KeyHandler() {
			 keys = new ArrayList<Integer>();
		}
		
		 public boolean isPressed(int code) {
			  return keys.contains(code);
		  }

		@Override
		public void keyPressed(KeyEvent e) {
			keys.add(e.getKeyCode());
			
			if(arrows.get(0).getColor()==Color.GREEN) {
				if(direction != 37 && isPressed(KeyEvent.VK_LEFT)
						|| direction!=38 && isPressed(KeyEvent.VK_UP)
						|| direction!=39 && isPressed(KeyEvent.VK_RIGHT)
						|| direction!=40 && isPressed(KeyEvent.VK_DOWN)) {
					someoneLostPoints();
				}
					
			}
			else if(arrows.get(0).getColor()==Color.BLUE) {
				if(direction != 39 && isPressed(KeyEvent.VK_LEFT)
						|| direction!=40 && isPressed(KeyEvent.VK_UP)
						|| direction!=37 && isPressed(KeyEvent.VK_RIGHT)
						|| direction!=38 && isPressed(KeyEvent.VK_DOWN)) {
					someoneLostPoints();
				}
			}
			
			else {
				if((isPressed(KeyEvent.VK_LEFT) && pointingTo != 37) 
						|| (isPressed(KeyEvent.VK_UP) && pointingTo != 38) 
						|| (isPressed(KeyEvent.VK_RIGHT)&& pointingTo != 39)
						|| (keyControl.isPressed(KeyEvent.VK_DOWN) && pointingTo != 40)) {
					someoneLostPoints();
				}
			}
	
		}

		@Override
		public void keyReleased(KeyEvent e) {
			Integer code = e.getKeyCode();
			while(keys.contains(code)) {
				keys.remove(code);
			}
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == back) {
			if (coma.getOver()) {
				coma.changePanel("4");
			}
			else {
				coma.changePanel("8");
			}
		}
			
		else if (src == menu) {
			if (coma.getOver()) {
				coma.changePanel("4");
			}
			else {
				coma.changePanel("3");
			}
		}
	}
}
