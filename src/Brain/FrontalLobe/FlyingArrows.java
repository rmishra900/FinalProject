package Brain.FrontalLobe;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Coma.Home;
import Coma.Menu;
import Coma.StoryScreen;

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
	    Frontal fp = new Frontal();
	    fp.setVisible(true);
	    add(fp);
	    addKeyListener(fp.getKeyHandler());

	    cardPanel.add(r, "1");
	    cardPanel.add(fp, "2");   
	    

	    add(cardPanel);
	    setVisible(true);
	}
	
	
	public static void main(String[] args) {
		FlyingArrows fa = new FlyingArrows("FlyingArrows");
	}

	/**
	 * Allows to change what is displayed on the screen. 
	 * @param name the name of the panel to be displayed
	 */
	public void changePanel(String name) {
		
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}

}
