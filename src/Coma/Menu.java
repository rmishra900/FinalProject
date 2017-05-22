package Coma;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import Brain.FrontalLobe.FlyingArrows;

/**
 * Represents the screen displayed for the user to select a game to play. 
 * @author 
 * @version 5/15/2017
 */
public class Menu extends JPanel implements ActionListener {
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private Coma c;
	private JButton occipital;
	private JButton frontal;
	private JButton parietal;
	private JButton temporal;
	private JButton home;
	private Image background, occipitalImg, frontalImg, parietalImg, temporalImg;
	
	//FlyingArrows f = new FlyingArrows("Flying Arrows", c);
		
	/**
	 * Constructs a new instance of this menu screen. 
	 * @param c the game that this menu is for
	 */
	public Menu(Coma c) {
		super();
		setLayout(null);
		this.c = c;
		setBackground(Color.WHITE);
		background = new ImageIcon("coma" + System.getProperty("file.separator") + "MenuBrain.png").getImage();
		occipitalImg = new ImageIcon("coma" + System.getProperty("file.separator") + "Occipital.png").getImage();
		frontalImg = new ImageIcon("coma" + System.getProperty("file.separator") + "Frontal.png").getImage();
		parietalImg = new ImageIcon("coma" + System.getProperty("file.separator") + "Parietal.png").getImage();
		temporalImg = new ImageIcon("coma" + System.getProperty("file.separator") + "Temporal.png").getImage();
		
		occipital = new JButton();
		occipital.setSize(195, 141);
		occipital.setLocation(600, 375);
		occipital.setIcon(new ImageIcon("coma" + System.getProperty("file.separator") + "occipitalScreenshot.png"));
		
		JLabel oLabel = new JLabel();
		oLabel.setFont(new Font("Roman Baseline", 3, 16));
		oLabel.setLocation(600, 510);
		oLabel.setText("Sightseeing");
		oLabel.setForeground(Color.BLACK);
		oLabel.setSize(150, 30);
		add(oLabel);
		
		frontal = new JButton("Flying Arrows");
		frontal.setSize(190, 136);
		frontal.setLocation(20, 10);
		frontal.setIcon(new ImageIcon("coma" + System.getProperty("file.separator") + "frontalScreenshot.png"));
		
		JLabel fLabel = new JLabel();
		fLabel.setFont(new Font("Roman Baseline", 3, 16));
		fLabel.setLocation(20, 140);
		fLabel.setText("Flying Arrows");
		fLabel.setForeground(Color.BLACK);
		fLabel.setSize(150, 30);
		add(fLabel);
		
		parietal = new JButton("Hole in the Wall");
		parietal.setSize(195, 141);
		parietal.setLocation(600, 10);
		parietal.setIcon(new ImageIcon("coma" + System.getProperty("file.separator") + "parietalScreenshot.png"));
		
		JLabel pLabel = new JLabel();
		pLabel.setFont(new Font("Roman Baseline", 3, 16));
		pLabel.setLocation(600, 145);
		pLabel.setText("Hole in the Wall");
		pLabel.setForeground(Color.BLACK);
		pLabel.setSize(150, 30);
		add(pLabel);
		
		temporal = new JButton("Locked");
		temporal.setSize(190, 138);
		temporal.setLocation(20, 375);
		temporal.setIcon(new ImageIcon("coma" + System.getProperty("file.separator") + "temporalScreenshot.png"));
		
		JLabel tLabel = new JLabel();
		tLabel.setFont(new Font("Roman Baseline", 3, 16));
		tLabel.setLocation(20, 510);
		tLabel.setText("Locked");
		tLabel.setForeground(Color.BLACK);
		tLabel.setSize(150, 30);
		add(tLabel);
		
		add(occipital);
		occipital.addActionListener(this);
		add(frontal);
		frontal.addActionListener(this);
		add(parietal);
		parietal.addActionListener(this);
		add(temporal);
		temporal.addActionListener(this);
		
		home = new JButton("HOME");
		home.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		home.setSize(100, 50);
		home.setLocation(325, 500);
		
		add(home);
		home.addActionListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;
		        
		AffineTransform at = g2.getTransform();
		
		g2.scale(ratioX, ratioY);
		
		g.drawImage(background, 200, 100, 400, 368, this);
		
		
		
//		occipital.setBounds((int)(600*ratioX),(int)(375*ratioY),(int)(195*ratioX),(int)(141*ratioY));
//		frontal.setBounds((int)(20*ratioX),(int)(10*ratioY),(int)(190*ratioX),(int)(136*ratioY));
//		parietal.setBounds((int)(600*ratioX),(int)(10*ratioY),(int)(195*ratioX),(int)(141*ratioY));
//		temporal.setBounds((int)(20*ratioX),(int)(375*ratioY),(int)(190*ratioX),(int)(138*ratioY));
//		
	//	g2.translate(-(int)(frontal.getWidth()/20*ratioX), -(int)(frontal.getHeight()/20*ratioY));
	//	occipital.setLocation((2*occipital.getWidth())+(int)(occipital.getWidth()*ratioX), (2*occipital.getHeight())-45+(int)(occipital.getHeight()*ratioY));
	
		if(c.getWins() == 4)
			c.changePanel("4");
		if (c.getWon(1)) 
			g.drawImage(frontalImg, 205, 100, 223, 204, this);
		if (c.getWon(2))
			g.drawImage(occipitalImg, 475, 178, 123, 210, this);
		if (c.getWon(3))
			g.drawImage(parietalImg, 375, 100, 211, 150, this);
		if (c.getWon(4)) 
			g.drawImage(temporalImg, 294, 225, 246, 238, this);
		
		g2.setTransform(at);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == occipital) {
			c.changePanel("11");
		} else if (src == frontal) {	
			c.changePanel("8");
		} else if (src == parietal) {
			c.changePanel("9");
		} else if (src == temporal) {
			c.changePanel("14");
		} else if (src == home) {
			c.changePanel("1");
		}
	}

}