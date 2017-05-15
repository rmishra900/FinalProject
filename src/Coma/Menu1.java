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


public class Menu1 extends JPanel implements ActionListener, MouseListener {
	private Coma c;
	JButton occipital;
	JButton frontal;
	JButton parietal;
	JButton temporal;
		
	public Menu1(Coma c) {
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
			Coma1 p = new Coma1("Hole in the Wall");
		} else if (src == temporal) {
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}