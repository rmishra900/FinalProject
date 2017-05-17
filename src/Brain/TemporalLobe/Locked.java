package Brain.TemporalLobe;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.FrontalLobe.FlyingArrows;
import Brain.FrontalLobe.FrontalRules;
import Coma.Coma;

public class Locked extends JFrame{

	JPanel cardPanel;
	private Coma c;
	
	public Locked(String title, Coma c) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    
	    TemporalRules r = new TemporalRules(this, c);
	    r.setVisible(true);
	    add(r);
	
	    cardPanel.add(r);

	    add(cardPanel);
	    setVisible(true);
	}
	
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
	
	public static void main(String[] args) {
		Locked c = new Locked("Locked");
	}

}
