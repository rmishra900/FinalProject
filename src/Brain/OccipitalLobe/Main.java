package Brain.OccipitalLobe;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {
	
	JPanel glass = new JPanel();
	private JLabel score;
	private int numCorrect;
	
	public Main (String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    numCorrect = 0;
	    score = new JLabel("Score: ");
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
	 	    panel.add(score);
	 	    glass.setVisible(false);	
	 	    panel.add(new JLabel("Where was the airplane?"));
	 	    // figure out how to execute the following code only when the mouse is clicked 
	 	    while (panel.getCorrect() == -1) {
	 	    	 try {
	 	 			Thread.sleep(200);
	 	 		} catch (InterruptedException e) {
	 	 			e.printStackTrace();
	 	 		}
	 	    }
	 	    
	 	    if (panel.getCorrect() == 1) {
	 	    	numCorrect++;	
	 	    	score.setText("Score: " + numCorrect );
	 	    }
	 	    else if (panel.getCorrect() == 0){
	 	    	numCorrect = 0;
	 	    	score.setText("Score: " + numCorrect);
	 	    }
	 	    /*panel.setOpaque(false);
	 	    SymbolPanel p = new SymbolPanel();
	 	    p.setTarget(panel.getSymNum());
	    	add(p);
	    	try {
 	 			Thread.sleep(20000);
 	 		} catch (InterruptedException e) {
 	 			e.printStackTrace();
 	 		}*/
	    }
	    while (numCorrect > 0); 
	}

	public static void main(String[] args) {
		Main m = new Main("COMA");
	}

}
