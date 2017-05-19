package Brain.ParietalLobe;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Coma.Coma;

public class HoleInTheWall extends JFrame {
	
	private JPanel gamePanel;
	private Coma c; 
	private  Parietal panel2;
	
	
	public HoleInTheWall(String title, Coma c) {
		super(title);
		this.c = c;
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    gamePanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    gamePanel.setLayout(cl);
	    
//	    ParietalRules panel1 = new ParietalRules(this, c);
//	    panel2 = new Parietal(this, c);

//	    gamePanel.add(panel1, "1");
//	    gamePanel.add(panel2, "2");
//	    add(gamePanel);
	    
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
	
	public Parietal getPanel() {
		return panel2;
	}

}
