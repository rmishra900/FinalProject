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
import Brain.OccipitalLobe.OccipitalMain;
import Brain.OccipitalLobe.SymbolPanel;
import Brain.ParietalLobe.HoleInTheWall;
import Brain.TemporalLobe.InTheNeighborhood;
import Brain.FrontalLobe.FlyingArrows;

/**
 * Represents the screen displayed for the user to select a game to play. 
 * @author 
 * @version 5/15/2017
 */
public class Menu extends JPanel implements ActionListener {
	private Coma c;
	JButton occipital;
	JButton frontal;
	JButton parietal;
	JButton temporal;
		
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
		temporal = new JButton("In the Neighborhood");
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
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == occipital) {
			Thread t = new Thread("my non EDT thread") {
	            public void run() {
	                //my work
	                new OccipitalMain("Show Me the Light");
	            }
	        };
	        t.start();
		} else if (src == frontal) {
			FlyingArrows f = new FlyingArrows("Flying Arrows");
		} else if (src == parietal) {
			HoleInTheWall p = new HoleInTheWall("Hole in the Wall");
		} else if (src == temporal) {
			InTheNeighborhood n = new InTheNeighborhood("InTheNeighborHood");
		}
	}
}