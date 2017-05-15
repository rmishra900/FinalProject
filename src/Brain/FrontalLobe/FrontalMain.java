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
	    
//	    Rules r = new Rules();
//	    r.setVisible(true);
//	    add(r);
//	    
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);

	    cardPanel.add(fp);
	 //   cardPanel.add(r);
	    add(cardPanel);
	    setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		FrontalMain f = new FrontalMain("Flying Arrows");

	}




}
