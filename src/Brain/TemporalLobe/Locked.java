package Brain.TemporalLobe;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.FrontalLobe.FlyingArrows;
import Brain.FrontalLobe.FrontalRules;
import Coma.Coma;

public class Locked extends JFrame{

	private JPanel cardPanel;
	private Coma c;
	private Keypad k;
	
	public Locked(String title, Coma c) {
		super(title);

		this.c = c;
//		k = new Keypad();
//		add(k);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.c = c;
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    TemporalRules r = new TemporalRules(this, c);
	    r.setVisible(true);
	    add(r);
	    
	    Temporal panel = new Temporal(this, c);
	    panel.setVisible(true);
	    add(panel);

	    cardPanel.add(r, "1");
	    cardPanel.add(panel, "2");

	    add(cardPanel);
	 
	    setVisible(true);
	}
	
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
	}

}
