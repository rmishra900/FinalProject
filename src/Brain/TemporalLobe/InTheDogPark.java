package Brain.TemporalLobe;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.FrontalLobe.FlyingArrows;
import Brain.FrontalLobe.FrontalRules;
import Coma.Coma;

public class InTheDogPark extends JFrame{

	private JPanel cardPanel;
	private Coma c;
	
	public InTheDogPark(String title, Coma c) {
		super(title);
		this.c = c;
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    TemporalRules r = new TemporalRules(this, c);
	    Temporal t = new Temporal(this, c);
	
	    cardPanel.add(r, "1");
	    cardPanel.add(t, "2");
	    add(cardPanel);
	    
	    addMouseListener(t);
	    setVisible(true);
	}
	
	/**
	 * Changes what panel is displayed on the screen
	 * @param name the name of the panel to be displayed
	 */
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
	}

}
