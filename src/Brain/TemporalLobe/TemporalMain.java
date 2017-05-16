package Brain.TemporalLobe;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TemporalMain extends JFrame {
	JPanel cardPanel;
	
	
	public TemporalMain(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    Temporal t = new Temporal();
	    t.setVisible(true);
	    add(t);
	    addMouseListener(new MouseAdapter() {});
 	    addMouseMotionListener(new MouseMotionAdapter() {});


	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);

	    cardPanel.add(t);
	    add(cardPanel);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		TemporalMain f = new TemporalMain("In The Neighborhood");

	}
}
