package Coma;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//import Brain.FrontalLobe.FlyingArrows;

/**
 * Represents the screen displayed for the user to select a game to play. 
 * @author 
 * @version 5/15/2017
 */
public class Menu extends JPanel implements ActionListener {
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
		background = new ImageIcon("coma" + System.getProperty("file.separator") + "MenuBrain.png").getImage();
		occipitalImg = new ImageIcon("coma" + System.getProperty("file.separator") + "Occipital.png").getImage();
		frontalImg = new ImageIcon("coma" + System.getProperty("file.separator") + "Frontal.png").getImage();
		parietalImg = new ImageIcon("coma" + System.getProperty("file.separator") + "Parietal.png").getImage();
		temporalImg = new ImageIcon("coma" + System.getProperty("file.separator") + "Temporal.png").getImage();
		
		occipital = new JButton("Show Me the Light");
		occipital.setFont(new Font("Roman Baseline", Font.BOLD, 12));
		occipital.setSize(175, 50);
		occipital.setLocation(600, 500);
		//occipital.setIcon(new ImageIcon("coma" + System.getProperty("file.separator") + "Symbol" + (i+1) + ".png"));
		
		frontal = new JButton("Flying Arrows");
		frontal.setFont(new Font("Roman Baseline", Font.BOLD, 16));
		frontal.setSize(150, 50);
		frontal.setLocation(20, 10);
		
		parietal = new JButton("Hole in the Wall");
		parietal.setFont(new Font("Roman Baseline", Font.BOLD, 12));
		parietal.setSize(175, 50);
		parietal.setLocation(600, 10);
		
		temporal = new JButton("Locked");
		temporal.setFont(new Font("Roman Baseline", Font.BOLD, 16));
		temporal.setSize(150, 50);
		temporal.setLocation(20, 500);
		
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
		
		g.drawImage(background, 200, 100, 400, 368, this);

		if(c.getWins() == 4)
			c.changePanel("4");
		
		if (c.getWon(1)) 
			g.drawImage(frontalImg, 200, 100, 223, 204, this);
		if (c.getWon(2))
			g.drawImage(occipitalImg, 475, 175, 123, 210, this);
		if (c.getWon(3))
			g.drawImage(parietalImg, 375, 100, 211, 150, this);
		if (c.getWon(4)) 
			g.drawImage(temporalImg, 295, 230, 246, 238, this);
		repaint();
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