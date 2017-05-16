package Brain.OccipitalLobe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.sun.prism.paint.Color;

/**
 * Represents the screen displayed for the user to select a symbol.
 * @author Anisha
 * @version 5/15/2017
 */
public class SymbolPanel extends JPanel implements ActionListener {
	
	private JButton[] symbols;
	private JButton targetSymbol;
	private static final int RADIUS = 30;
	ActionListener listener;
	private int correct;
	
	/**
	 * Constructs a new instance of SymbolPanel by intializing all buttons. 
	 */
	public SymbolPanel() {
		symbols = new JButton[5];
		correct = -1;
		double angleDiff = symbols.length/Math.toRadians(360);
		for (int i = 0; i < symbols.length; i++) {
			symbols[i] = new JButton();
			symbols[i].setIcon(new ImageIcon("occipital" + System.getProperty("file.separator") + "Symbol" + (i+1) + ".png"));
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
	
	/**
	 * Sets the target symbol that the user needs to click on this SymbolPanel. 
	 * @param tar the number that represents the symbol the user must click
	 */
	public void setTarget(int tar) {
		targetSymbol = symbols[tar-1];
	}
	
	/**
	 * Resets the symbolPanel for the next time the user sees it. 
	 */
	public void setCorrect() { correct = -1; }
	
	/**
	 * Returns the value that determines if the user got the answer correct. 
	 * @return the value that determines if the user got the answer correct. 
	 */
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