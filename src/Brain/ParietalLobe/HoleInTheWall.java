package Brain.ParietalLobe;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Coma.Coma;

public class HoleInTheWall extends JFrame {
	
	private JPanel gamePanel;
	
	public HoleInTheWall(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    gamePanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    gamePanel.setLayout(cl);
	    
	    ParietalRules panel1 = new ParietalRules(this);
	    Parietal panel2 = new Parietal(this);

	    gamePanel.add(panel1, "1");
	    gamePanel.add(panel2, "2");
	    add(gamePanel);
	    
	    addKeyListener(panel2);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
		
	}
	
	/**
	 * Changes what panel is displayed on the screen
	 * @param name the name of the panel to be displayed
	 */
	public void changePanel(String name) {
		
		((CardLayout)gamePanel.getLayout()).show(gamePanel, name);
		requestFocus();
	}

}
