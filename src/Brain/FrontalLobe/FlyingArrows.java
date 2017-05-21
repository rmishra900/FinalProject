package Brain.FrontalLobe;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Brain.ParietalLobe.Parietal;
import Coma.Coma;
import Coma.Home;
import Coma.Menu;
import Coma.StoryScreen;

public class FlyingArrows extends JPanel {

	private JPanel cardPanel;
	private Coma c;
	private Frontal panel2;
	private JLabel title;
	
	public FlyingArrows(String t, Coma c) {
		//super(title);
		setBounds(0, 0, 800, 600);
//		this.title = new JLabel(t);
//		title.setLocation(0, 0);
//		title.setSize(800,600);
//		title.setFont(new Font("Roman Baseline", 0,20));
//		
		this.c = c;
		
	    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    
	    FrontalRules panel1 = new FrontalRules(this, c);
	    panel2 = new Frontal(this, c);

	    cardPanel.add(panel1, "1");
	    cardPanel.add(panel2, "2"); 
	  //  add(cardPanel);
	    
	    addKeyListener(panel2.getKeyHandler());
	    setVisible(true);
	}
	
	
//	public static void main(String[] args) {
//		Coma c = new Coma("COMA");
//	}

	/**
	 * Changes what panel is displayed on the screen. 
	 * @param name the name of the panel to be displayed
	 */
	public void changePanel(String name) {
		
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
	
	public Frontal getPanel() {
		return panel2;
	}

}
