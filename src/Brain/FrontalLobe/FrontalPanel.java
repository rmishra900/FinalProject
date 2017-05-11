package Brain.FrontalLobe;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import Brain.OccipitalLobe.FlyingObject;


public class FrontalPanel extends JPanel implements Runnable, KeyListener{

	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private ArrayList<Arrow> arrows;
	private int r, b, g;
	private Color c;
	private Arrow a;
	private Rectangle screen;
	private int xV, yV;
	private int key;	//VK_LEFT = 37, VK_UP = 38, VK_RIGHT = 39, VK_DOWN = 40
	
	public FrontalPanel() {
		super();
		System.out.println("frontal");
		setBackground(Color.RED);
		r = 0;
		b = 1;
		g = 2;
		c = new Color(255,0,0);
		screen = new Rectangle(DRAWING_WIDTH, DRAWING_HEIGHT);
		arrows = new ArrayList<Arrow>();
		initializeArrows();
		xV = 1;
		yV = 1;
		key = 37;
		 new Thread(this).start();
	}
	
	private void initializeArrows() {
		
		int randomC = (int) (Math.random()*3); //0, 1, or 2
		
		if(randomC == 0) {
			c = Color.RED;
		}
		else if(randomC == 1) {
			c = Color.BLUE;
		}
		else {
			c =  Color.GREEN;
		}
	
		for(int i =0; i<100; i++) {	//can change total number depending on size of screen
			int randomX = (int) (Math.random()*800);
			int randomY = (int) (Math.random()*600);
			a = new Arrow(randomX, randomY, c);
			
			arrows.add(a);
			
			if(!isArrowInsideScreen(a)) {
				int d = a.getDirection();
				if(d==0) {
					a.setY(DRAWING_HEIGHT);
				}
				else if(d==1) {
					a.setX(0);
				}
				else if(d==2) {
					a.setY(0);
				}
				else {
					a.setX(DRAWING_WIDTH);
				}
			}
			a.moveAcrossScreen();
		}
		
	}
	
	
	private boolean isArrowInsideScreen(Arrow arr) {
		if(arr.getX()<DRAWING_WIDTH && arr.getY()<DRAWING_HEIGHT) {
			return true;
		}
		return false;
	}
	
	public void paintComponent(Graphics g, ImageObserver io) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint
									// the background

		Graphics2D g2 = (Graphics2D) g;
		
		
		
		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		for (Arrow a : arrows) {
			if(!(a.getX()<ratioX && a.getY()<ratioY)) {
				a.setX(0);
				a.setY(0);
			}
			a.draw(g2, this);
			a.moveAcrossScreen();
		}
		

		g2.setTransform(at);

		// TODO Add any custom drawings here
	}
	
	public void run() {
		boolean isCorrect = true;
		while(isCorrect) {
			System.out.println("*********************************");
			System.out.println("inside while");
				
			System.out.println(a.getColor().toString());
			System.out.println("key: "+key);
			System.out.println("direction: "+a.getDirection());
			System.out.println("pointingTo: "+a.getPointingTo());
			
			int rand = (int) (Math.random()*4 + 37);
			
			
			if(a.getColor() == Color.GREEN) {
				if(a.getDirection() != key) {
					System.out.println(false);
					isCorrect = false;
				}
				else {
					System.out.println("green");
				}
				
			}
			else if(a.getColor()==Color.RED) {
				if(a.getPointingTo() != key) {
					System.out.println(false);
					isCorrect = false;
				}
				else {
					System.out.println("red");
				}
			}
			
			else {
				if(Math.abs(a.getPointingTo()-key)!=2) {
					System.out.println(false);
					isCorrect = false;
				}
				else {
					System.out.println("blue");
				}
			}
			
		if(isCorrect == false) {
			
			initializeArrows();
		}
		repaint();
		  	
		  	
		}
		
		System.out.println("ended game");
			
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
	


