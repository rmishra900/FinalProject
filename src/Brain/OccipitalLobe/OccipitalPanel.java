package Brain.OccipitalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class OccipitalPanel extends JPanel implements MouseListener {

	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	  
	private Rectangle screenRect;
	
	private Airplane plane;
	private ArrayList<Helicopter> obstacles;

	private Symbol sym;
	private int symNum;
	private boolean showObjects;
	private Image background;
	private int correct;

	  
	public OccipitalPanel() {
		setBackground(Color.WHITE);
		background = new ImageIcon("OccipitalBackground.jpg").getImage();
		super.addMouseListener(this);
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		plane = new Airplane(100 + (int) (Math.random()*(DRAWING_WIDTH-150)), 100 + (int) (Math.random()*(DRAWING_HEIGHT-150)));
		correct = -1;
		showObjects = true;
		initializeObstacles();
		initializeSymbol();
		
	}
	
	private void initializeSymbol() {
		symNum = (int)(Math.random()*5) + 1;
		int x = 100 + (int) (Math.random()*(DRAWING_WIDTH-150));
		int y = 100 + (int) (Math.random()*(DRAWING_HEIGHT-150));
		if (!(x == plane.getX() && y == plane.getY()))
			sym = new Symbol("Symbol" + symNum + ".png", x, y);
		else 
			sym = new Symbol("Symbol" + symNum + ".png", x+25, y);
	}
	
	private void initializeObstacles() {
		obstacles = new ArrayList<Helicopter>();
		int randNum = (int) (Math.random() * 9); // number of helicopters - maximum is 9 
		for (int i = 0; i < randNum; i++) {
			int x = (int) (Math.random()*DRAWING_WIDTH);
			int y = (int) (Math.random()*DRAWING_HEIGHT);
			if (!(x == plane.getX() && y == plane.getY()))
				obstacles.add(new Helicopter(x, y));
		}
	}
	
	public int getSymNum() {
		return symNum;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint
									// the background

		Graphics2D g2 = (Graphics2D) g;
		

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;
		

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		g2.setTransform(at);
		
		if (showObjects) {
			g.drawImage(background, 0, 0, (int)(800*ratioX), (int)(600*ratioY), this);
			
			sym.draw(g2, this);
			plane.draw(g2, this);
			for (Helicopter heli : obstacles) {
				heli.draw(g2, this);
			}	
		}
	}
	
	public void setShowObjects(boolean bool) {
		showObjects = bool;
	}
	
	public void setCorrect() { correct = -1; }
	public int getCorrect() { return correct; }
	
	public void mouseClicked(MouseEvent e) {
		if (plane.intersects(e.getX(), e.getY(), plane.PLANE_WIDTH/1.5, plane.PLANE_HEIGHT/1.5)) {
			correct = 1;
		} else {
			correct = 0;
		}	
	}

	public void mousePressed(MouseEvent e) { }

	public void mouseReleased(MouseEvent e) { }

	public void mouseEntered(MouseEvent e) { }

	public void mouseExited(MouseEvent e) { }
}