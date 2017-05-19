package Brain.OccipitalLobe;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Coma.Coma;

public class ShowMeTheLight extends JFrame {

	private JPanel cardPanel;
	private JPanel glass = new JPanel();
	private Occipital panel;
	private SymbolPanel sp;
	
	private Coma c;
	
	private JLabel score;
	private JLabel win;
	private int numCorrect;
	
	public ShowMeTheLight(String title, Coma c) {
		super(title);
		this.c = c;
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    score = new JLabel("Score: " + numCorrect);
	    score.setVisible(true);
	    win = new JLabel();
		win.setLocation(270, 45);
		win.setForeground(Color.WHITE);
		win.setSize(300, 100);
		add(win);
		
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    OccipitalRules panel1 = new OccipitalRules(this, c);
	    panel = new Occipital(this, c);
	    panel.add(score);
	    panel.setVisible(true);
	    sp = new SymbolPanel(this, c);
	    sp.add(score);
	
	    cardPanel.add(panel1, "1");
	    cardPanel.add(panel, "2");
	    cardPanel.add(sp, "3");

	    add(cardPanel);
	    setVisible(true);
	}
	
	public void act() {
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
	 	    	if (numCorrect < 10)
	 	    		score.setText("YOU LOSE! Score: " + numCorrect);
	 	    	else
	 	    		score.setText("YOU WIN! Score: " + numCorrect);
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
	 	    	if (numCorrect < 10)
	 	    		score.setText("YOU LOSE! Score: " + numCorrect);
	 	    	else {
	 	    		score.setText("YOU WIN! Score: " + numCorrect);
	 	    		c.setWon(2);
	 	    	}
	 	    	sp.setVisible(false);
	 	    	break;
	 	    }
	    	sp.setCorrect();
	    	sp.setVisible(false);
	    	panel.reset();
		} while (numCorrect > 0);
		
	}
	
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
	
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
	}

}
