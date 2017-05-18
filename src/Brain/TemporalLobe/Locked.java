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
	private Keypad k;
	
	public Locked(String title) {
		super(title);
		k = new Keypad();
		add(k);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    
//	    TemporalRules r = new TemporalRules(this, c);
//	    r.setVisible(true);
//	    add(r);
//	    
	    Temporal panel = new Temporal();
	    panel.setVisible(true);
	    add(panel);
	
	 //   cardPanel.add(r);
	    cardPanel.add(panel);
	    

	    add(cardPanel);
	    setVisible(true);
	}
	
	
	public static void main(String[] args) {
		//Coma c = new Coma("COMA");
		Locked l = new Locked("LOCKED");
	}

}
