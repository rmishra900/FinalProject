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
	    
	    
	    Rules r = new Rules();
	    r.setVisible(true);
	    add(r);
	    
	  
	    
	   // Frontal fp = new Frontal();
	   // fp.setVisible(true);
	   // add(fp);
	   // addKeyListener(fp.getKeyHandler());
	    
	   // cardPanel.add(r,"1");
	   // cardPanel.add(fp,"2");
	    
	    cardPanel.add(r);
	   
	    

	    add(cardPanel);
	    setVisible(true);
	}
	
	
	public static void main(String[] args) {
		FlyingArrows fa = new FlyingArrows("FlyingArrows");
	}
	
//	public void changePanel(String name) {
//		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
//		requestFocus();
//	}

}
