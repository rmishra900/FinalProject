package Brain.OccipitalLobe;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	public Main (String title){
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    OccipitalPanel panel = new OccipitalPanel();
	    add(panel);
	    setVisible(true);
	}

	public static void main(String[] args) {
		Main m = new Main("COMA");
	}

}
