package Brain.OccipitalLobe;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OccipitalMain extends JFrame {
	
	JPanel glass = new JPanel();
	JPanel symbolGlass = new JPanel();
	private JLabel score;
	private int numCorrect;
	
	public OccipitalMain (String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    numCorrect = 0;
	    score = new JLabel();
		score.setText("Score: " + numCorrect);
		add(score);
		setVisible(true);
	    
	    do {
	    	OccipitalPanel panel = new OccipitalPanel();
	    	
	 	    panel.setOpaque(false);
	 	    
	 	    glass.setOpaque(false);
	 	    glass.add(panel);
	 	    
	 	    glass.addMouseListener(new MouseAdapter() {});
	 	    glass.addMouseMotionListener(new MouseMotionAdapter() {});
	 	    
	 	    glass.setFocusCycleRoot(true);
	 	    setGlassPane(glass);
	 	    glass.setVisible(true);
	 	    add(panel);
	 	    
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
	 	    
	 	    if (panel.getCorrect() == 0){
	 	    	numCorrect = 0;
	 	    	score.setText("Score: " + numCorrect);
	 	    	break;
	 	    }
	 	    panel.setCorrect();
	 	    panel.setVisible(false);
	 	    
	 	    SymbolPanel sp = new SymbolPanel();
	 	    sp.setTarget(panel.getSymNum());
	    	
	    	sp.setOpaque(false);
	 	    
	    	symbolGlass.setOpaque(false);
	    	symbolGlass.add(sp);

	    	symbolGlass.setFocusCycleRoot(true);
	    	setGlassPane(symbolGlass);
	    	symbolGlass.setVisible(true);
	    	add(sp);

	    	sp.setOpaque(true);
	 	    try {
	 			Thread.sleep(2000);
	 		} catch (InterruptedException e) {
	 			e.printStackTrace();
	 		}
	 	    symbolGlass.setVisible(false);	
	    	
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
	 	    	numCorrect = 0;
	 	    	score.setText("Score: " + numCorrect);
	 	    	sp.setVisible(false);
	 	    	break;
	 	    }
	    	sp.setCorrect();
	    	sp.setVisible(false);
	  
	    }
	    while (numCorrect > 0); 
	}

	public static void main(String[] args) {
		OccipitalMain m = new OccipitalMain("COMA");
	}

}