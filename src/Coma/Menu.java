package Coma;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import Brain.OccipitalLobe.Occipital;
import Brain.OccipitalLobe.ShowMeTheLight;
import Brain.OccipitalLobe.SymbolPanel;
import Brain.ParietalLobe.HoleInTheWall;
import Brain.TemporalLobe.Locked;
import Brain.FrontalLobe.FlyingArrows;

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
	FlyingArrows f = new FlyingArrows("Flying Arrows", c);
		
	/**
	 * Constructs a new instance of this menu screen. 
	 * @param c the game that this menu is for
	 */
	public Menu(Coma c) {
		super();
		setLayout(null);
		this.c = c;
		setBackground(Color.WHITE);
		occipital = new JButton("Show Me the Light");
		occipital.setFont(new Font("Roman Baseline", Font.BOLD, 12));
		occipital.setSize(175, 50);
		occipital.setLocation(25, 10);
		
		frontal = new JButton("Flying Arrows");
		frontal.setFont(new Font("Roman Baseline", Font.BOLD, 16));
		frontal.setSize(150, 50);
		frontal.setLocation(225, 10);
		
		parietal = new JButton("Hole in the Wall");
		parietal.setFont(new Font("Roman Baseline", Font.BOLD, 12));
		parietal.setSize(175, 50);
		parietal.setLocation(400, 10);
		
		temporal = new JButton("Locked");
		temporal.setFont(new Font("Roman Baseline", Font.BOLD, 16));
		temporal.setSize(150, 50);
		temporal.setLocation(600, 10);
		
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
		System.out.println(c.getWins());
		if(c.getWins() == 4)
			c.changePanel("4");
		
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == occipital) {
			ShowMeTheLight s = new ShowMeTheLight("Show Me the Light", c);
		} else if (src == frontal) {	
			//add(f);
			//FlyingArrows fa = new FlyingArrows("FlyingArrows", c);
			c.changePanel("8");
			//f.setVisible(true);
		//	f.setEnabled(true);
	//		f.setVisible(true);
			//c.changePanel("6");
			//add(f);
		} else if (src == parietal) {
			HoleInTheWall p = new HoleInTheWall("Hole in the Wall", c);
		} else if (src == temporal) {
			Locked l = new Locked("Locked", c);
		} else if (src == home) {
			c.changePanel("1");
		}
	}
}