package Brain.OccipitalLobe;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;


import javax.swing.*;

import Brain.Lobe;
import Coma.Coma;

import java.awt.Font;

import java.awt.Color;


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
	
	private int numCorrect;
	private JLabel score;
	
	private Coma c;
	/**
	 * Constructs a new instance of SymbolPanel by initializing all buttons. 
	 */
	public SymbolPanel(Coma c) {
		this.c = c;
		symbols = new JButton[6];
		correct = -1;
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		for (int i = 0; i < symbols.length; i++) {
			symbols[i] = new JButton();
			symbols[i].setIcon(new ImageIcon("occipital" + System.getProperty("file.separator") + "Symbol" + (i+1) + ".png"));
	        add(symbols[i]);
	        symbols[i].addActionListener(this);
	        symbols[i].setEnabled(true);
	        symbols[i].setSize(250, 250);
		}

		layout.setHorizontalGroup(
				   layout.createSequentialGroup()
				   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
				   .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				           .addComponent(symbols[0], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				           .addComponent(symbols[5], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				           .addComponent(symbols[1], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				           .addComponent(symbols[3], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				           .addComponent(symbols[2], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				           .addComponent(symbols[4], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
				layout.setVerticalGroup(
				   layout.createSequentialGroup()
				      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.PREFERRED_SIZE+100, Short.MAX_VALUE)
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				           .addComponent(symbols[0], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				           .addComponent(symbols[1], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				           .addComponent(symbols[2], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				           .addComponent(symbols[3], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				           .addComponent(symbols[4], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				           .addComponent(symbols[5], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				      
				);
		
		score = new JLabel("SCORE: " + numCorrect);
		score.setForeground(Color.BLACK);
		score.setLocation(400, 20);
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
	
	/**
	 * Sets the field correct to the value passed in. 
	 * @param x the new value to indicate if the user is correct or not
	 */
	public void setCorrect(int x) { correct = x; }
	
	/**
	 * Returns the value that determines if the user got the answer correct. 
	 * @return the value that determines if the user got the answer correct. 
	 */
	public int getCorrect() { 
		return correct; 
	}
	
	/**
	 * 
	 * @return the number of points the user has
	 */
	public int getScore() { 
		return numCorrect; 
	}
	
	/**
	 * Sets the number of points the user has. 
	 * @param score the new number of points the user has
	 */
	public void setScore(int score) {
		numCorrect = score;
	}
	
	/**
	 * 
	 * @return the JLabel for the points the user has
	 */
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
		if (src == getBack()) {
			correct = 2;
			c.changePanel("11");
		}
		else if (src == getMenu()) {
			correct = 2;
			c.changePanel("3");	
		}
	}
}