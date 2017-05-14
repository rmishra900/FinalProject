package Coma;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Brain.OccipitalLobe.OccipitalMain;
import Brain.FrontalLobe.FrontalMain;


public class HomeScreen extends JPanel implements ActionListener {
	private Coma c;
	JButton occipital;
	JButton frontal;
	JButton parietal;
	JButton temporal;
		
	public HomeScreen() {
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
			OccipitalMain o = new OccipitalMain("Show Me the Light");
		} else if (src == frontal) {
			FrontalMain f = new FrontalMain("Flying Arrows");
		} else if (src == parietal) {
			
		} else if (src == temporal) {
			
		}
	}
}