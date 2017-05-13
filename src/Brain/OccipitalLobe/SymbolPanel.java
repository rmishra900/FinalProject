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
	private static final int RADIUS = 30;
	ActionListener listener;
	private int correct;
	
	public SymbolPanel() {
		symbols = new JButton[5];
		correct = -1;
		double angleDiff = symbols.length/Math.toRadians(360);
		for (int i = 0; i < symbols.length; i++) {
			symbols[i] = new JButton();
			symbols[i].setIcon(new ImageIcon("Symbol" + (i+1) + ".png"));
			double phi = i*angleDiff; 
			double x = (RADIUS * Math.cos(phi));
	        double y = (RADIUS * Math.sin(phi));
	        symbols[i].setBounds((int)x, (int)y, 3, 3);
	        add(symbols[i]);
	        //symbols[i].setLocation((int)x, (int)y);
	        symbols[i].addActionListener(this);
	        symbols[i].setOpaque(true);
		}
	}
	
	public void setTarget(int tar) {
		targetSymbol = symbols[tar-1];
	}
	
	public void setCorrect() { correct = -1; }
	public int getCorrect() { return correct; }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == targetSymbol) {
			correct = 1;
		} else {
			correct = 0;
		}
	}
}
