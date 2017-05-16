package Brain.TemporalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;


import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Temporal extends JPanel implements MouseListener {
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private NeighborhoodObject[] nObjects;

	private Image background;
	private NeighborhoodObject n;
	

	
	public Temporal() {
		super();
		nObjects = new NeighborhoodObject[20];
		super.addMouseListener(this);
		background = new ImageIcon("TemporalBackground.png").getImage();
		initializeNObjects();
		
		n = nObjects[1];	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		
		g.drawImage(background, 0, 0, getWidth(), getHeight() , this);
		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;
		        
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		JPanel back = new JPanel();
		back.setLayout(null);
		back.setBackground(new Color(255,255,255, 127));
		back.setOpaque(true);
		back.setBounds(30, 100, 400, 400);
		add(back);
		
			
		n.draw(g, n.getImage(), n.getX(), n.getY(), n.getWidth(), n.getHeight(), this);
		
	}
	
	private void initializeNObjects() {
		n = new NeighborhoodObject("Dog1.png", "Dog1.wav", 50, 50, 200, 200);
		//nObjects[2] = new NeighborhoodObject()
	}

	public void mouseClicked(MouseEvent e) {
		if(n.intersects(e.getX(), e.getY(), n.getWidth(), n.getHeight())) {
			n.getSound().play();
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {

	}

}
