package Brain.OccipitalLobe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Brain.Lobe;
import Coma.Coma;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Color.*;

/**
 * Represents the screen displayed for the user to select a symbol.
 * @author Anisha
 * @version 5/15/2017
 */
public class SymbolPanel extends Lobe implements ActionListener {
	
	private JButton[] symbols;
	private JButton targetSymbol;

	ActionListener listener;
	private int correct;
	private JButton back, menu;
	
	private int numCorrect;
	private JLabel score, win;
	
	private Coma c;
	/**
	 * Constructs a new instance of SymbolPanel by initializing all buttons. 
	 */
	public SymbolPanel(Coma c) {
		this.c = c;
		symbols = new JButton[5];
		correct = -1;
		setLayout(null);
		for (int i = 0; i < symbols.length; i++) {
			symbols[i] = new JButton();
			symbols[i].setIcon(new ImageIcon("occipital" + System.getProperty("file.separator") + "Symbol" + (i+1) + ".png"));
	        add(symbols[i]);
	        symbols[i].addActionListener(this);
	        symbols[i].setEnabled(true);
	        symbols[i].setSize(250, 250);
		}
		symbols[0].setLocation(0, 70);
		symbols[1].setLocation(263, 70);
		symbols[2].setLocation(526, 70);
		symbols[3].setLocation(131, 320);
		symbols[4].setLocation(394, 320);
		
	
		
		score = new JLabel("SCORE: " + numCorrect);
		score.setForeground(Color.BLACK);
		score.setLocation(600, 20);
		score.setSize(150,30);
		score.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		add(score);	
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
	
	public void setCorrect(int x) { correct = x; }
	
	/**
	 * Returns the value that determines if the user got the answer correct. 
	 * @return the value that determines if the user got the answer correct. 
	 */
	public int getCorrect() { 
		return correct; 
	}
	
	public int getScore() { 
		return numCorrect; 
	}
	
	public void setScore(int score) {
		numCorrect = score;
	}
	
	public JLabel getScoreLabel() {
		return score;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == targetSymbol) {
			correct = 1;
		} else {
			correct = 0;
		}
		if (src == back)
			c.changePanel("11");
		else if (src == menu) {
			correct = -1;
			c.changePanel("3");	
		}
	}
}