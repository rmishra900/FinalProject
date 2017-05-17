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
	
	private Dog[] dogs;

	private Image background;
	private Dog selectedDog;
	
	public Temporal() {
		super();
		dogs = new Dog[8];
		super.addMouseListener(this);
		background = new ImageIcon("TemporalBackground.png").getImage();
		initializeDogs();
		selectedDog = dogs[(int)(Math.random()*8)];
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
	
			
		selectedDog.draw(g, selectedDog.getImage(), selectedDog.getX(), selectedDog.getY(), selectedDog.getWidth(), 
				selectedDog.getHeight(), this);
		
		
	}
	
	private void initializeDogs() {
		dogs[0] = new Dog("Dog0.png", "Dog0.wav", 50, 50, 150, 150);
		dogs[1] = new Dog("Dog1.png", "Dog1.wav", 200, 50, 150, 150);
		dogs[2] = new Dog("Dog2.png", "Dog2.wav", 350, 50, 150, 150);
		dogs[3] = new Dog("Dog3.png", "Dog3.wav", 500, 50, 150, 150);
		dogs[4] = new Dog("Dog4.png", "Dog4.wav", 50, 200, 150, 150);
		dogs[5] = new Dog("Dog5.png", "Dog5.wav", 200, 200, 150, 150);
		dogs[6] = new Dog("Dog6.png", "Dog6.wav", 350, 200, 150, 150);
		dogs[7] = new Dog("Dog7.png", "Dog7.wav", 500, 200, 150, 150);
	}

	public void mouseClicked(MouseEvent e) {
		if(selectedDog.intersects(e.getX(), e.getY(), selectedDog.getWidth(), selectedDog.getHeight())) {
			selectedDog.getSound().play();
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
