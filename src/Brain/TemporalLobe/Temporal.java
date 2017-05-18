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


public class Temporal extends JPanel implements ActionListener {
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	private Locked l;
	private Coma c;
	
	private Room[] rooms;
	private Keypad k;

	private JButton back, menu, play;
	private int numCorrect;
	private int panelNumber;
	private int[][] previousCodes;
	private JTextField buttonsPressed;
	

	public Temporal(Locked l, Coma c) {
		super();
		this.l = l;
		this.c = c;
		k = new Keypad();
		setLayout(null);
		
		
		rooms = new Room[8];
		previousCodes = new int[8][4];

		panelNumber = 0;
		initializeRooms();
		buttonsPressed = new JTextField();
		buttonsPressed.setLocation(350, 550);
		buttonsPressed.setForeground(Color.BLACK);
		buttonsPressed.setFont(new Font("Roman Baseline", 0, 18));
		buttonsPressed.setSize(150,50);
		buttonsPressed.setBackground(Color.WHITE);
		buttonsPressed.setEditable(false);
		
		
	
		
		back = new JButton("BACK");
		back.setBackground(Color.YELLOW);
		back.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		back.setSize(100, 50);
		back.setLocation(25, 0);
		
		menu = new JButton("MENU");
		menu.setBackground(Color.YELLOW);
		menu.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		menu.setSize(100, 50);
		menu.setLocation(150, 0);
		
		play = new JButton("PLAY");
		play.setBackground(Color.YELLOW);
		play.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		play.setSize(100, 50);
		play.setLocation(275, 0);
		
		
		add(back);
		back.addActionListener(this);
		add(menu);
		menu.addActionListener(this);
		add(play);
		play.addActionListener(this);
		
		add(buttonsPressed);
		add(k);
		setVisible(true);
	}
	
	public String getText() {
//		
//		ArrayList<Button> arr = k.getButtonsPressed(k.getButtons());
//		
//		String text = "";
//		for(Button b : arr) {
//			text+=b.getText();
//		}
//		return text;
		
		String text = "";
	
		for(int i = 0; i< k.getButtons().length; i++) {
		
			if(k.isPressed(k.getButton(i))) {
				System.out.println(k.getButtons().length);
				text+= k.getButton(i).getText();
			}
			System.out.println(k.isPressed(k.getButton(i)));
		}
		System.out.println("text: "+text);
		return text;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		
		g.drawImage(rooms[panelNumber].getBackground(), 0, 0, getWidth(), getHeight() , this);
		
		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;
		        
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
//		
//		if(buttonsPressed.getText().length()==4) {
//			buttonsPressed.setText("");
//		}
//		else {
		
			buttonsPressed.setText(getText());
			System.out.println(getText());
	//	}
		
	}
	
	public void setPanelNum(int x) {
		panelNumber = x;
	}
	
	public int getPanelNum() {
		return panelNumber;
	}
	
	public void reset() {
		panelNumber++;
	}
	
	public Room[] getRooms() {
		return rooms;
	}
	
	public int[] getRandPasscode() {
		int[]p = new int[4];
		for (int i = 0; i < 4; i++) {
			p[i] = (int)(Math.random()*10);
		}
		return p;
	}
	
	public int[] getUniqueRandPasscode() {
		int[] p = rooms[getPanelNum()].getPasscode();

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
	
	private void initializeRooms() {
		rooms[0] = new Room("Room0.png", getRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
		rooms[1] = new Room("Room1.png", getUniqueRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
		rooms[2] = new Room("Room2.png", getUniqueRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
		rooms[3] = new Room("Room3.png", getUniqueRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
		rooms[4] = new Room("Room4.png", getUniqueRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
		rooms[5] = new Room("Room5.png", getUniqueRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
		rooms[6] = new Room("Room6.png", getUniqueRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
		rooms[7] = new Room("Room7.png", getUniqueRandPasscode(), DRAWING_WIDTH, DRAWING_HEIGHT);
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == back)
			l.changePanel("1");
		else if (src == menu)
			c.changePanel("3");
		else if(src == play) {
			rooms[getPanelNum()].playSound();
		}
			
	}

}