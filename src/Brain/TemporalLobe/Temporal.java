package Brain.TemporalLobe;

import java.awt.BorderLayout;
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

import Coma.Coma;


public class Temporal extends JPanel {
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private Locked l;
	private Coma c;
	private Room[] rooms;
	private Keypad k;

	int numCorrect;
	int panelNumber;
	
	public Temporal(Locked l, Coma c) {
		super();
		this.l = l;
		this.c = c;
		k = new Keypad();
		setLayout(null);
		add(k);
		
		rooms = new Room[8];
		initializeRooms();
		//add(k);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		
		//g.drawImage(rooms[panelNumber].getBackground(), 0, 0, getWidth(), getHeight() , this);
		
		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;
		        
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

//		JPanel back = new JPanel();
//		back.setLayout(null);
//		back.setBackground(new Color(255,255,255, 127));
//		back.setOpaque(true);
//		back.setBounds(30, 100, 400, 400);
//		add(back);
	}
	
	public void setPanelNum(int x) {
		panelNumber = x;
	}
	
	public int getPanelNum() {
		return panelNumber;
	}
	
	public void switchRooms() {
		panelNumber++;
	}
	
	public Room[] getRooms() {
		return rooms;
	}
	
	private void initializeRooms() {
//		rooms[0] = new Room("Room0.png", "Room0.wav", DRAWING_WIDTH, DRAWING_HEIGHT);
//		rooms[1] = new Room("Room1.png", "Room1.wav", DRAWING_WIDTH, DRAWING_HEIGHT);
//		rooms[2] = new Room("Room2.png", "Room2.wav", DRAWING_WIDTH, DRAWING_HEIGHT);
//		rooms[3] = new Room("Room3.png", "Room3.wav", DRAWING_WIDTH, DRAWING_HEIGHT);
//		rooms[4] = new Room("Room4.png", "Room4.wav", DRAWING_WIDTH, DRAWING_HEIGHT);
//		rooms[5] = new Room("Room5.png", "Room5.wav", DRAWING_WIDTH, DRAWING_HEIGHT);
//		rooms[6] = new Room("Room6.png", "Room6.wav", DRAWING_WIDTH, DRAWING_HEIGHT);
//		rooms[7] = new Room("Room7.png", "Room7.wav", DRAWING_WIDTH, DRAWING_HEIGHT);
	}
	
	

}
