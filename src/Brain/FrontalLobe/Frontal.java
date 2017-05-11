package Brain.FrontalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import sun.awt.image.OffScreenImage;
import sun.java2d.opengl.OGLDrawImage;
import Brain.Lobe;




public class Frontal extends JPanel implements Runnable{
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	//Timer t;
	
	private Rectangle screenRect;
	
	private Arrow arrow;
	private ArrayList<Arrow> arrows;
	
	  
	private KeyHandler keyControl;
	
	private Image img;
	
	private int prevX = -1;
	
	public Frontal() {
		super();
		keyControl = new KeyHandler();
		//Timer t = new Timer(5,(ActionListener) this);
		arrow = new Arrow(0,0,Color.BLUE);
		
		setBackground(Color.BLUE);
	
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		
		img = new ImageIcon("FrontalBackground.jpg").getImage();
		
		initializeArrows();
	}

	private void initializeArrows() {
		arrows = new ArrayList<Arrow>();
		
		Color c = getRandomColor();

		for(int i = 0; i < 100; i++) {
			int xcoord = getRandomX();
			int ycoord = getRandomY();
			arrows.add(new Arrow(xcoord, ycoord, c));
			
		}
		
	}
	
	public void putArrowInRandomLocations() {
		
		for(Arrow a: arrows) {
			int xcoord = getRandomX();
			int ycoord = getRandomY();
			a.setX(xcoord);
			a.setY(ycoord);
			
		}
	}
	
	public Image getBackgroundImage() {
		return img;
	}
	
	public Color getRandomColor() {
		Color c;
		
		int randCol = (int) (Math.random()*3);
		
		if(randCol == 0) {
			System.out.println("red");
			c = new Color(255,0,0); //red
		}
		else if(randCol==1) {
			System.out.println("green");
			c = new Color(0,255,0); //green
		}
		else {
			System.out.println("black");
			c = new Color(0,0,255); //blue
		}
		
		return c;
	}
	
	public int getRandomX() {
		int xCoord = (int) (Math.random()*DRAWING_WIDTH);
		
		return xCoord;
	}
	
	public int getRandomY() {
		int yCoord = (int) (Math.random()*(DRAWING_HEIGHT-250))+150;
		
		return yCoord;
	}
	
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background
		
		g.drawImage(img, 0, 0, getWidth(), getHeight() , this);
		
		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/DRAWING_WIDTH;
	    double ratioY = (double)height/DRAWING_HEIGHT;
	    
	   
	    
	    AffineTransform at = g2.getTransform();
	    g2.scale(ratioX, ratioY);
	    
	    

	   for(Arrow a: arrows) {
		   int w = a.getWidth(this)/8;
		   int h = a.getHeight(this)/8;
		  
		   a.draw(g, a.getImage(), a.getX(), a.getY(), w, h, this);
		  
		  // a.moveAcrossScreen();
		  
		
			  // initializeArrows();
			   putArrowInRandomLocations();
		
		/*
		 *  if(keyControl.isPressed(KeyEvent.VK_LEFT)) {
		   
			  
		   
		   
		   System.out.println("left");
		   
		   Color col = getRandomColor();
		   System.out.println(col);
		   if(col == Color.GREEN) {
			   a.setImage(a.getGreenImage());
			   System.out.println("g: "+a.getImage());
		   }
		   else if(col == Color.RED) {
			   a.setImage(a.getRedImage());
			   System.out.println("r: "+a.getImage());
		   }
//		   else {
//			   a.setImage(a.getImage());
//			   System.out.println("b: "+a.getImage());
//		   }
//	return;
		//   g2.drawImage(a.getImage(), a.getX(), a.getY()+h, w, -h,this); 
		  
		 //a.getImage().getSource();
		/*   
		   g2.rotate(Math.toRadians(90));
		   g2.drawImage(a.getImage(), a.getX(), a.getY(), w, h,this); 
		   
		  // a.draw(g2, a.getImage(), a.getX(), a.getY()+h, w, -h, this);
		  
		// a.setDirection(37);
		
		 //a.draw(g, a.getX(), a.getY(), w, h, this);
	   }
		*/ 
	}
		   
	  //int prevX = -1;
	   
	  
	   if(keyControl.isPressed(KeyEvent.VK_LEFT)) {
		  changeColor();
		    
		 
//		   else {
//			   a.setImage(a.getImage());
//			   System.out.println("b: "+a.getImage());
//		   }
//	return;
		//   g2.drawImage(a.getImage(), a.getX(), a.getY()+h, w, -h,this); 
		  
		 //a.getImage().getSource();
		/*   
		   g2.rotate(Math.toRadians(90));
		   g2.drawImage(a.getImage(), a.getX(), a.getY(), w, h,this); 
		   */
		  // a.draw(g2, a.getImage(), a.getX(), a.getY()+h, w, -h, this);
		  
		// a.setDirection(37);
		
		 //a.draw(g, a.getX(), a.getY(), w, h, this);
	   }

	   repaint();
	   
	   try {
		Thread.sleep(150);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	    g2.setTransform(at);
	  
	}
	
	public void changeColor() {
		 int x = (int) (Math.random()*3);
		  
		   while(prevX == x) {
			   x = (int) (Math.random()*3);
		   }
		   
			  
		   for(Arrow a: arrows) {
			   
			  Image green = a.getGreenImage();   
			  Image red = a.getRedImage();
			  Image black = a.getBlackImage();
			  
			System.out.println(x);
			  if(x == 0) {
				  a.setImage(green);
			  }
			  else if(x==1) {
				  a.setImage(red);
			  }
			  else {
				  a.setImage(black);
			  }
			   
			 
		   }
		   prevX = x;  
	}
	
	@Override
	public void run() {
		System.out.println("while");
		while (true) { // Modify this to allow quitting
			long startTime = System.currentTimeMillis();
			
				
				if (keyControl.isPressed(KeyEvent.VK_SPACE)) {
					System.out.println("keyPressssed");
					arrow.setX(100);
					arrow.setY(200);
					
				}
					
				  	repaint();
			
			
		  	
		  	long waitTime = 17 - (System.currentTimeMillis()-startTime);
		  	try {
		  		if (waitTime > 0)
		  			Thread.sleep(waitTime);
		  		else
		  			Thread.yield();
		  	} catch (InterruptedException e) {}
		}
		
	}
	
	public KeyHandler getKeyHandler() {
		  return keyControl;
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
	
	
}
