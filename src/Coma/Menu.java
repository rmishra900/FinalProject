package Coma;
import java.awt.Color;
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
		
	/**
	 * Constructs a new instance of this menu screen. 
	 * @param c the game that this menu is for
	 */
	public Menu(Coma c) {
		super();
		this.c = c;
		setBackground(Color.WHITE);
		occipital = new JButton("Show Me the Light");
		frontal = new JButton("Flying Arrows");
		parietal = new JButton("Hole in the Wall");
		temporal = new JButton("Locked");
		add(occipital);
		occipital.addActionListener(this);
		add(frontal);
		frontal.addActionListener(this);
		add(parietal);
		parietal.addActionListener(this);
		add(temporal);
		temporal.addActionListener(this);
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(c.wins == 4)
			c.changePanel("4");
		
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == occipital) {
			ShowMeTheLight s = new ShowMeTheLight("Show Me the Light", c);
		} else if (src == frontal) {
			FlyingArrows f = new FlyingArrows("Flying Arrows", c);
		} else if (src == parietal) {
			HoleInTheWall p = new HoleInTheWall("Hole in the Wall", c);
		} else if (src == temporal) {
			Locked l = new Locked("Locked", c);
		}
	}
}