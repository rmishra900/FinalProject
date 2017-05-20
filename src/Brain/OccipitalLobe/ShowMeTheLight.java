package Brain.OccipitalLobe;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Coma.Coma;

public class ShowMeTheLight extends JFrame {

	private JPanel cardPanel;
	private JPanel glass = new JPanel();
	private OccipitalRules r;
	private Occipital panel;
	private SymbolPanel sp;
	
	private Coma c;
	
	private int numCorrect;
	
	public ShowMeTheLight(String title, Coma c) {
		super(title);
		this.c = c;
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    r = new OccipitalRules(c);
	    //add(r);
	    panel = new Occipital(c);
	    panel.setVisible(true);

	    sp = new SymbolPanel(c);
	
	    cardPanel.add(r, "1");
	    cardPanel.add(panel, "2");
	    cardPanel.add(sp, "3");

	    add(cardPanel);
	    setVisible(true);
	}
	
	/*public void act() {
		do {
			changePanel("2");

	 	    panel.setOpaque(false);
	 	    glass.setOpaque(false);
	 	    
	 	    glass.addMouseListener(new MouseAdapter() {});
	 	    glass.addMouseMotionListener(new MouseAdapter() {});
	 	    
	 	    glass.setFocusCycleRoot(true);
	 	    setGlassPane(glass);
	 	    glass.setVisible(true);
	 	    
	 	    panel.setOpaque(true);
	 	    try {
	 			Thread.sleep(2000);
	 		} catch (InterruptedException e) {
	 			e.printStackTrace();
	 		}
	 	    panel.setShowObjects(false);
	 	    glass.setVisible(false);	
	 	    
	 	    while (panel.getCorrect() == -1) {
	 	    	 try {
	 	 			Thread.sleep(200);
	 	 		} catch (InterruptedException e) {
	 	 			e.printStackTrace();
	 	 		}
	 	    }
	 	    
	 	    if (panel.getCorrect() == 0) {
	 	    	break;
	 	    }
	 	    panel.setCorrect();
	 	    
	 	    changePanel("3");
	 	    sp.setTarget(panel.getSymNum());
	    	
	 	    try {
	 			Thread.sleep(2000);
	 		} catch (InterruptedException e) {
	 			e.printStackTrace();
	 		}	
	    	
	    	while (sp.getCorrect() == -1) {
	    		try {
	 	 			Thread.sleep(2000);
	 	 		} catch (InterruptedException e) {
	 	 			e.printStackTrace();
	 	 		}
	    	}
	    	if (sp.getCorrect() == 1) {	
	    		numCorrect++;
	 	    	score.setText("Score: " + numCorrect );
	 	    }
	 	    else if (sp.getCorrect() == 0){
	 	    	score.setText("YOU LOSE! Score: " + numCorrect);
	 	    	sp.setVisible(false);
	 	    	break;
	 	    }
	    	sp.setCorrect();
	    	sp.setVisible(false);
	    	if (numCorrect == 10) {
	    		win.setText("YOU WIN");
	 		    win.setFont(new Font("Roman Baseline", Font.BOLD, 50));
 	    		c.setWon(2);
 	    		break;
	    	}
	    	panel.reset();
		} while (numCorrect > 0);
		
	}*/
	
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
	
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
	}

}
