package Brain.TemporalLobe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
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
 * Sets the scene for the Locked game
 * @author Anisha and Reet
 * @version 5/18/17
 */
public class Temporal extends Lobe{
	
	private Coma c;

	private Keypad k;

	private JButton back, menu, play, clear;
	private Image background;


	private JTextField buttonsPressed;
	private JLabel win;
	private Image winImage;
	private Image winBackground;
	
	private int[] passcode;


	
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
		
		passcode = getRandPasscode();
		background = new ImageIcon("temporal" + System.getProperty("file.separator") + "temporalBackground.jpg").getImage();
		

		winBackground = new ImageIcon("temporal" + System.getProperty("file.separator") + "temporalWin.jpg").getImage();
	
		buttonsPressed = new JTextField();
 		buttonsPressed.setLocation(250, 530);
 		buttonsPressed.setForeground(Color.BLACK);
 		buttonsPressed.setFont(new Font("Roman Baseline", 0, 18));
  		buttonsPressed.setSize(175,50);
  		buttonsPressed.setBackground(Color.WHITE);
  		buttonsPressed.setEditable(false);
		
  		win = new JLabel();
  		win.setLocation(DRAWING_WIDTH / 2 - 250, DRAWING_HEIGHT / 2 - 50);
		win.setSize(500, 100);
  		win.setForeground(Color.BLACK);
  		win.setFont(new Font("Roman Baseline", 3, 100));
  		
  		winImage = getWinImage();

  		
  		back = getBack();
  		menu = getMenu();
  		
		play = new JButton("PLAY");
		play.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		play.setSize(100, 50);
		play.setLocation(275, 20);
		
		clear = new JButton("CLEAR");
		clear.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		clear.setSize(150, 50);
		clear.setLocation(475, 530);
		

		add(play);
		play.addActionListener(this);
		add(clear);
		clear.addActionListener(this);
		
		add(win);
		add(buttonsPressed);
		add(k);
		k.setVisible(true);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		
		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;
		        
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		menu.setBounds((int)(150*ratioX), (int)(20*ratioY), (int)(100*ratioX), (int)(50*ratioY));
		back.setBounds((int)(25*ratioX), (int)(20*ratioY), (int)(100*ratioX), (int)(50*ratioY));
		play.setBounds((int)(275*ratioX), (int)(20*ratioY), (int)(100*ratioX), (int)(50*ratioY));
		clear.setBounds((int)(475*ratioX), (int)(530*ratioY), (int)(100*ratioX), (int)(50*ratioY));
		
		buttonsPressed.setBounds((int)(300*ratioX), (int)(530*ratioY), (int)(175*ratioX), (int)(50*ratioY));
		
		for(Button b: k.getButtons()) {
			b.getJButton().setBounds((int)(b.getX()*ratioX), (int)(b.getY()*ratioY), (int)(50*ratioX), (int)(50*ratioY));
		}
	
		k.setBounds((int)(200*ratioX), (int)(80*ratioY), (int)(400*ratioX), (int)(450*ratioY));
		
		if (!c.getWon(4)) {
			if (k.getEntered() != null) {
				buttonsPressed.setText(k.getEntered());
			}
			
			if(buttonsPressed.getText().length()==4) {		
				System.out.println("passcode: "+ passcode[0] +
						passcode[1]+passcode[2]+passcode[3]);
				if(winGame(0) && winGame(1) && winGame(2) && winGame(3)) {
					remove(k);
					remove(buttonsPressed);
					remove(play);
					remove(clear);
					
					g.drawImage(winImage, 0, 0, getWidth(), getHeight(), this);
					g.setFont(new Font("Roman Baseline", 3, 100));
					g.setColor(Color.BLACK);
					g.drawString("YOU WIN!", DRAWING_WIDTH / 2 - 250, DRAWING_HEIGHT / 2 - 50);
					c.setWon(4);
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
			g.setFont(new Font("Roman Baseline", 3, 100));
			g.setColor(Color.BLACK);
			g.drawString("YOU WIN!", DRAWING_WIDTH / 2 - 250, DRAWING_HEIGHT / 2 - 50);
		}
		
		g2.setTransform(at);

			
		repaint();
	}
	
	/**
	 * Returns a boolean for whether this game has been won or not. 
	 * @param x the passcode needed to win the game.
	 * @return true if the game was won, false if otherwise
	 */
	public boolean winGame(int x) {
		if(Integer.toString(passcode[x]).equals(k.getEntered(x))) {
			return true;
		}
		return false;

	}

	
	/**
	 * Iterates the number of the room so that the next room is displayed. 
	 */
	public void reset() {
		buttonsPressed.setText("");
		k.setEntered("");
		passcode = getRandPasscode();
		win.setText("");
		add(buttonsPressed);
		add(play);
		add(k);
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
	 * Plays the sound of this room that the user needs to enter a passcode for.
	 */
	public void playSound() {
		for(int i =0; i<passcode.length; i++) {
			k.getButton(passcode[i]).getSound().play();
		}
	}
	

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == back) {
			if (c.getOver()) {
				c.changePanel("4");
			}
			c.changePanel("14");
		}
		else if (src == menu) {
			if (c.getOver()) {
				c.changePanel("4");
			}
			c.changePanel("3");
		}	
		else if(src == play) {
			playSound();
		}
		else if(src == clear) {
			buttonsPressed.setText("");
			k.setEntered("");
		}
	}

}