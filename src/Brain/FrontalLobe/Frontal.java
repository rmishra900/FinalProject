package Brain.FrontalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Brain.Lobe;




public class Frontal extends JPanel implements Runnable{
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private Rectangle screenRect;
	
	//private Arrow arrow;
	private ArrayList<Arrow> arrows;
	  
	private KeyHandler keyControl;
	
	private Image img;
	
	public Frontal() {
		super();
		keyControl = new KeyHandler();
	
		
		setBackground(Color.BLUE);
	
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		
		img = new ImageIcon("Background.jpg").getImage();
		
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
	
	public Image getBackgroundImage() {
		return img;
	}
	
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
	
	public int getRandomX() {
		int xCoord = (int) (Math.random()*DRAWING_WIDTH);
		
		return xCoord;
	}
	
	public int getRandomY() {
		int yCoord = (int) (Math.random()*DRAWING_HEIGHT)+200;
		
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
		   int w = a.getWidth(this)/10;
		   int h = a.getHeight(this)/10;
		   a.moveAcrossScreen();
		   g.drawImage(a.getImage(), a.getX(), a.getY(), w, h, this);
//		  try {
//			       BufferedImage source = ImageIO.read(new File("Background.jpg"));
//			        BufferedImage logo = ImageIO.read(new File("Arrow.png"));
//
//			        g = source.getGraphics();
//			        
//			        g.drawImage(logo, 0, 0, this);
//			       
//			    }
//			   catch (Exception e)
//			    {
//			        e.printStackTrace();
//			    }

	   }
	  
	  
//	    
//	    for (Arrow a : arrows) {
//	    	//a.draw(g2, this);
//	    	g2.drawImage(a.getImage(), a.getX(), a.getY(), a.getWidth(this), a.getHeight(this), this);
//	    }
	  
	   
	    
	    
	    g2.setTransform(at);
	  
	}
	
	@Override
	public void run() {
		
		
		
	}
	
	public KeyHandler getKeyHandler() {
		  return keyControl;
	  }

	
	public class KeyHandler implements KeyListener {
		private ArrayList<Integer> keys;
		
		public KeyHandler() {
			 keys = new ArrayList<Integer>();
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
