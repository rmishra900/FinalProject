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
	
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
	
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
	}

}
