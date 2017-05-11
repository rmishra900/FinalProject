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
	 	    setVisible(true);
	 	    panel.setOpaque(true);
	 	    try {
	 			Thread.sleep(3000);
	 		} catch (InterruptedException e) {
	 			e.printStackTrace();
	 		}
	 	    panel.setShowObjects(false);
	 	    panel.add(score);
	 	    glass.setVisible(false);	
	 	    panel.add(new JLabel("Where was the airplane?"));
	 	    // figure out how to execute the following code only when the mouse is clicked 
	 	    
	 	    if (panel.getCorrect()) {
	 	    	numCorrect++;	
	 	    	score.setText("Score: " + numCorrect);
	 	    }
	 	    else {
	 	    	numCorrect = 0;
	 	    	score.setText("Score: " + numCorrect);
	 	    }
	    }
	    while (numCorrect > 0); 
	}

	public static void main(String[] args) {
		Main m = new Main("COMA");
	}

}
