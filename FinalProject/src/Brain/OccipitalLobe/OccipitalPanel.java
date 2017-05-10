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
	  
	private MouseListener mouseControl;
	  
	public OccipitalPanel() {
		super();
		setBackground(Color.CYAN);
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		plane = new Airplane((int) Math.random()*DRAWING_WIDTH, (int) Math.random()*DRAWING_HEIGHT);
		initializeObstacles();
	
	}
	
	private void initializeSymbol() {
		
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
	
	public void paintComponent(Graphics g, ImageObserver io) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint
									// the background
		
		Graphics2D g2 = (Graphics2D) g;
		try {
			g2.drawImage(ImageIO.read(new File("airplane.png")), 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		} // to set the background
		

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		for (FlyingObject f : obstacles) {
			f.draw(g2, io);;
		}
		
		plane.draw(g2, this);

		g2.setTransform(at);
		repaint();
		// TODO Add any custom drawings here
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
