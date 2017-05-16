package Brain.OccipitalLobe;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Brain.FrontalLobe.FlyingArrows;
import Brain.FrontalLobe.Rules;

public class ShowMeTheLight extends JFrame {

	JPanel cardPanel;
	
	public ShowMeTheLight(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    
	    OccipitalRules r = new OccipitalRules();
	    r.setVisible(true);
	    Occipital panel = new Occipital();
	    SymbolPanel sp = new SymbolPanel();
	    //add(r);
	
	    cardPanel.add(r, "1");
	    cardPanel.add(panel, "2");
	    cardPanel.add(sp, "3");
	   

	    add(cardPanel);
	    setVisible(true);
	    
	    numCorrect = 0;
	    score = new JLabel();
		score.setText("Score: " + numCorrect);
		add(score);
		setVisible(true);
		
		win = new JLabel();
		win.setLocation(270, 45);
		win.setForeground(Color.WHITE);
		win.setSize(300, 100);
		add(win);
	    
	}
	
	public void act() {
		
	}
	
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
	
	
	public static void main(String[] args) {
		ShowMeTheLight luz = new ShowMeTheLight("Show Me the Light");
	}

}
