package Brain.OccipitalLobe;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.FrontalLobe.FlyingArrows;
import Brain.FrontalLobe.Rules;

public class ShowMeTheLight extends JFrame {

	JPanel cardPanel;
	
	public ShowMeTheLight(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    
	    OccipitalRules r = new OccipitalRules();
	    r.setVisible(true);
	    add(r);
	
	    cardPanel.add(r);
	   

	    add(cardPanel);
	    setVisible(true);
	}
	
	
	public static void main(String[] args) {
		ShowMeTheLight luz = new ShowMeTheLight("Show Me the Light");
	}

}
