package Brain.TemporalLobe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Coma.Coma;

/**
 * @author 
 * @version 5/18/17
 */
public class Temporal extends JPanel implements ActionListener {
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	private Coma c;
	
	//private Room[] rooms;
	
	private Room room;
	private Keypad k;

	private JButton back, menu, play, clear;
	private int numCorrect;
	private int panelNumber;
	private int[][] previousCodes;
	//private JLabel buttonsPressed;
	private JTextField buttonsPressed;
	private String buttonsPressedText;
	private JLabel win;
	int counter = 0;

	/**
	 * Creates a new instance of this game. 
	 * @param l the main panel this game belongs to
	 * @param c the overall Coma game this mini game belongs to
	 */
	public Temporal(Coma c) {
		super();
		this.c = c;
		k = new Keypad();
		k.setTemporal(this);
		setLayout(null);
		
		room = new Room("Room0.png", getRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
	//	rooms = new Room[8];
		previousCodes = new int[8][4];

		panelNumber = 0;
		//initializeRooms();
	
		
		buttonsPressed = new JTextField();
 		buttonsPressed.setLocation(300, 530);
 		buttonsPressed.setForeground(Color.BLACK);
 		buttonsPressed.setFont(new Font("Roman Baseline", 0, 18));
  		buttonsPressed.setSize(175,50);
  		buttonsPressed.setBackground(Color.WHITE);
  		buttonsPressed.setEditable(false);
		
  		win = new JLabel();
  		win.setLocation(165,150);
  		win.setSize(500,300);
  		win.setForeground(Color.RED);
  		win.setFont(new Font("Roman Baseline", Font.BOLD, 100));
		
		back = new JButton("BACK");
		back.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		back.setSize(100, 50);
		back.setLocation(25, 0);
		
		menu = new JButton("MENU");
		menu.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		menu.setSize(100, 50);
		menu.setLocation(150, 0);
		
		play = new JButton("PLAY");
		play.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		play.setSize(100, 50);
		play.setLocation(275, 0);
		
		clear = new JButton("CLEAR");
		clear.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		clear.setSize(100, 50);
		clear.setLocation(475, 530);
		
		add(back);
		back.addActionListener(this);
		add(menu);
		menu.addActionListener(this);
		add(play);
		play.addActionListener(this);
		add(clear);
		clear.addActionListener(this);
		
		add(win);
		add(buttonsPressed);
		add(k);
		setVisible(true);
	}
	
	public String addText(String t){
		
		String prev = buttonsPressedText;  
		//buttonsPressed.setText(t);	
		String now = t;
		buttonsPressed.setText(now);
	//	System.out.println("buttonsPressed JTEXTFIELD: "+buttonsPressed.getText());
		buttonsPressedText = now;
		//System.out.println("buttonsPressed STRING: "+buttonsPressedText);

		return buttonsPressedText;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		
		//g.drawImage(rooms[panelNumber].getBackground(), 0, 0, getWidth(), getHeight() , this);
		g.drawImage(room.getBackground(), 0, 0, getWidth(), getHeight(), this);
		
		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;
		        
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);


		if (!c.getWon(4)) {
			if (k.getEntered() != null) {
				buttonsPressed.setText(k.getEntered());
			}
			
			if(buttonsPressed.getText().length()==4) {		
				System.out.println("passcode: "+room.getPasscodeAtIndex(0) +
						room.getPasscodeAtIndex(1)+room.getPasscodeAtIndex(2)+room.getPasscodeAtIndex(3));
				if(winGame(0) && winGame(1) && winGame(2) && winGame(3)) {
					g.drawRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
					remove(k);
					remove(buttonsPressed);
					remove(play);
					win.setText("YOU WIN!");
					c.setWon(4);
					c.changeToOver();
					return;
				}
			}
		}
		
		else {
			g.drawRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
			remove(k);
			remove(buttonsPressed);
			remove(play);
			win.setText("YOU WIN!");
		}
		g2.setTransform(at);
			
	
	}
	
	public boolean winGame(int x) {
		if(room.getPasscodeAtIndex(x).equals(k.getEntered(x))) {
			return true;
		}
		return false;

	}

	
	/**
	 * Sets the number of the room currently shown.
	 * @param x the number of the room that is currently displayed
	 */
	public void setPanelNum(int x) {
		panelNumber = x;
	}
	
	/**
	 * 
	 * @return the number of the room currently displayed
	 */
	public int getPanelNum() {
		return panelNumber;
	}
	
	/**
	 * Iterates the number of the room so that the next room is displayed. 
	 */
	public void reset() {
		panelNumber=0;
		buttonsPressed.setText("");
		buttonsPressedText = "";
		k.setEntered("");
		room = new Room("Room0.png", getUniqueRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
		win.setText("");
		add(buttonsPressed);
		add(play);
		add(k);
	}
	
	/**
	 * 
	 * @return the array of Rooms used in this game
	 */
	public Room getRoom() {
		return room;
	}
	
	/**
	 * @return a random 4-digit code
	 */
	public int[] getRandPasscode() {
		int[]p = new int[4];
		for (int i = 0; i < 4; i++) {
			p[i] = (int)(Math.random()*10);
		}

		return p;
	}
	
	/**
	 * 
	 * @return a random 4-digit code that has not been used yet
	 */
	public int[] getUniqueRandPasscode() {
		int[]p = room.getPasscode();
		
		for (int i = 0; i < 4; i++) {
			p[i] = (int)(Math.random()*10);
		}

		for (int[] code : previousCodes) {
		if (code.equals(p)) {
			while (code[3] == p[3])
				p[3] = (int)(Math.random()*10);
			}
		}

		for (int c = 0; c < 4; c++) {
			previousCodes[panelNumber][c] = p[c];
		}
		
		
		return p;
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == back)
			c.changePanel("14");
		else if (src == menu)
			c.changePanel("3");
		else if(src == play) {
			room.playSound();
		}
		else if(src == clear) {
			buttonsPressed.setText("");
			buttonsPressedText = "";
			k.setEntered("");
		}
	}

}