package Brain.FrontalLobe;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrontalMain extends JFrame{
	
	JPanel cardPanel;
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
