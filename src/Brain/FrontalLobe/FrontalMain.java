package Brain.FrontalLobe;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Brain.OccipitalLobe.Occipital;
/**
 * 
 * @author reetmishra
 *
 */
public class FrontalMain extends JFrame{
	
	JPanel cardPanel;
	
	/**
	 * Contructs a JFrame with a JPanel that represents the FlyingArrows game after the Rules
	 * @param title String representing the title of the JFrame (game)
	 */
	public FrontalMain(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    Frontal fp = new Frontal();
	    fp.setVisible(true);
	    add(fp);
	    addKeyListener(fp.getKeyHandler());

	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);

	    cardPanel.add(fp);
	    add(cardPanel);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		FrontalMain f = new FrontalMain("Flying Arrows");

	}




}
