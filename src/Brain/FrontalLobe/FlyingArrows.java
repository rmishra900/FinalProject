package Brain.FrontalLobe;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlyingArrows extends JFrame {

	JPanel cardPanel;
	
	public FlyingArrows(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    
	    FrontalRules r = new FrontalRules();
	    r.setVisible(true);
	    add(r);
	
	    cardPanel.add(r);
	   
	    

	    add(cardPanel);
	    setVisible(true);
	}
	
	
	public static void main(String[] args) {
		FlyingArrows fa = new FlyingArrows("FlyingArrows");
	}


}
