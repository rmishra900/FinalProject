package Brain.FrontalLobe;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Coma.Coma;
import Coma.Home;
import Coma.Menu;
import Coma.StoryScreen;

public class FlyingArrows extends JFrame {

	private JPanel cardPanel;
	private Coma c;
	
	public FlyingArrows(String title, Coma c) {
		super(title);
		this.c = c;
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    
	    FrontalRules panel1 = new FrontalRules(this, c);
	    Frontal panel2 = new Frontal(this, c);

	    cardPanel.add(panel1, "1");
	    cardPanel.add(panel2, "2"); 
	    add(cardPanel);
	    
	    addKeyListener(panel2.getKeyHandler());
	    setVisible(true);
	}
	
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
	}

	/**
	 * Changes what panel is displayed on the screen. 
	 * @param name the name of the panel to be displayed
	 */
	public void changePanel(String name) {
		
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}

}
