package Brain.OccipitalLobe;

import java.awt.Color;
import java.awt.Dimension;
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
	private BufferedImage background;
	private int numCorrect;
	private MouseListener mouseControl;

	  
	public OccipitalPanel() {
		try {
			background = ImageIO.read(new File("OccipitalBackground.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		plane = new Airplane((int) Math.random()*DRAWING_WIDTH, (int) Math.random()*DRAWING_HEIGHT);
		numCorrect = 0;
		
		initializeObstacles();
		initializeSymbol();
	}
	
	private void initializeSymbol() {
		int randNum = (int)(Math.random()*5) + 1;
		int x = (int) Math.random()*DRAWING_WIDTH;
		int y = (int) Math.random()*DRAWING_HEIGHT;
		if (!(x == plane.getX() && y == plane.getY()))
			sym = new Symbol("Symbol" + randNum + ".gif", x, y, 30, 30);
		else 
			sym = new Symbol("Symbol" + randNum + ".gif", x+50, y, 30, 30);
	}
	
	private void initializeObstacles() {
		obstacles = new ArrayList<Helicopter>();
		int randNum = (int) (Math.random() * 10); // number of helicopters - maximum is 9 
		for (int i = 0; i < randNum; i++) {
			int x = (int) Math.random()*DRAWING_WIDTH;
			int y = (int) Math.random()*DRAWING_HEIGHT;
			if (!(x == plane.getX() && y == plane.getY()))
				obstacles.add(new Helicopter(x, y));
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint
									// the background

		Graphics2D g2 = (Graphics2D) g;
		

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;
		
		g.drawImage(background, 0, 0, (int)(800*ratioX), (int)(600*ratioY), this);

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		plane.draw(g2, this);
		for (Helicopter heli : obstacles) {
			heli.draw(g2, this);
		}
		
		g2.setTransform(at);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (plane.intersects(e.getX(), e.getY(), plane.width, plane.height)) {
			numCorrect++;
		} else {
			numCorrect = 0;
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
