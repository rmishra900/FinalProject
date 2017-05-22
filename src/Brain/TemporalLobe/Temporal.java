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
import Brain.Lobe;

import Coma.Coma;

/**
 * @author 
 * @version 5/18/17
 */
public class Temporal extends Lobe{
	
	private Coma c;
	
	private Room room;
	private Keypad k;

	private JButton back, menu, play, clear;

	private int numCorrect;
	private int panelNumber;
	
	private int[] previousCodes;
	//private JLabel buttonsPressed;

	private JTextField buttonsPressed;
	private String buttonsPressedText;
	private JLabel win;
	private Image winImage;
	private Image winBackground;
//	int counter = 0;

	
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
		
		room = new Room("temporalBackground.jpg", getRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
		previousCodes = new int[4];
		winBackground = new ImageIcon("temporal" + System.getProperty("file.separator") + "temporalWin.jpg").getImage();
	
		buttonsPressed = new JTextField();
 		buttonsPressed.setLocation(300, 530);
 		buttonsPressed.setForeground(Color.BLACK);
 		buttonsPressed.setFont(new Font("Roman Baseline", 0, 18));
  		buttonsPressed.setSize(175,50);
  		buttonsPressed.setBackground(Color.WHITE);
  		buttonsPressed.setEditable(false);
		
  		win = new JLabel();
  		win.setLocation(DRAWING_WIDTH / 2 - 250, DRAWING_HEIGHT / 2 - 50);
		win.setSize(500, 100);
  		win.setForeground(Color.BLACK);
  		win.setFont(new Font("Roman Baseline", Font.BOLD, 100));
  		
  		winImage = getWinImage();

  		
  		back = getBack();
  		menu = getMenu();
  		
		play = new JButton("PLAY");
		play.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		play.setSize(100, 50);
		play.setLocation(275, 20);
		
		clear = new JButton("CLEAR");
		clear.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		clear.setSize(100, 50);
		clear.setLocation(475, 530);
		

		add(play);
		play.addActionListener(this);
		add(clear);
		clear.addActionListener(this);
		
		add(win);
		add(buttonsPressed);
		add(k);
		setVisible(true);
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
					remove(k);
					remove(buttonsPressed);
					remove(play);
					remove(clear);
					win.setText("YOU WIN!");
					g.drawImage(winImage, 0, 0, getWidth(), getHeight(), this);
					c.setWon(4);
					c.changeToOver();
					return;
				}
			}
		}
		
		else {
			g.drawRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
			remove(k);
			remove(buttonsPressed);
			remove(play);
			remove(clear);
			g.drawImage(winImage, 0, 0, getWidth(), getHeight(), this);
			win.setText("YOU WIN!");
		}
		
		g2.setTransform(at);

			
		repaint();
	}
	
	public boolean winGame(int x) {
		if(room.getPasscodeAtIndex(x).equals(k.getEntered(x))) {
			return true;
		}
		return false;

	}

	
	/**
	 * Iterates the number of the room so that the next room is displayed. 
	 */
	public void reset() {
		buttonsPressed.setText("");
		buttonsPressedText = "";
		k.setEntered("");
		room = new Room("temporalBackground.jpg", getUniqueRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
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
		int[] p = room.getPasscode();
		
		for (int i = 0; i < 4; i++) {
			p[i] = (int)(Math.random()*10);
		}

		for (int code : previousCodes) {
			while (code == p[3])
				p[3] = (int)(Math.random()*10);
		}

		for (int c = 0; c < 4; c++) {
			previousCodes[c] = p[c];
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