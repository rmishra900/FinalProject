package Brain.OccipitalLobe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.sun.prism.paint.Color;

public class SymbolPanel extends JPanel implements ActionListener {
	
	private JButton[] symbols;
	private JButton targetSymbol;
	private static final int RADIUS = 40;
	ActionListener listener;
	
	public SymbolPanel() {
		symbols = new JButton[5];
		double angleDiff = symbols.length/Math.toRadians(360);
		for (int i = 0; i < symbols.length; i++) {
			symbols[i] = new JButton();
			symbols[i].setIcon(new ImageIcon("Symbol" + (i+1) + ".png"));
			double phi = i*angleDiff; 
			double x = (RADIUS * Math.cos(phi));
	        double y = (RADIUS * Math.sin(phi));
	        //symbols[i].setBounds(x, y, SIDE, SIDE);
	        add(symbols[i]);
	        symbols[i].setLocation((int)x, (int)y);
	        symbols[i].addActionListener(this);
		}
	}
	
	public void setTarget(int tar) {
		targetSymbol = symbols[tar-1];
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == targetSymbol) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
