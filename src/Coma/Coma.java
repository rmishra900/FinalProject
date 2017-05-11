package Coma;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Brain.OccipitalLobe.OccipitalPanel;
import Brain.FrontalLobe.Frontal;
import Brain.FrontalLobe.FrontalPanel;

public class Coma extends JFrame {

	JPanel cardPanel;
	
	public Coma(String title) {
		
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	   // setBackground(Color.BLACK);
	    Frontal panel = new Frontal();
	    
	    addKeyListener(panel.getKeyHandler());
	    
	   
	 /*   try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Background.jpg")))));
		} catch (IOException e) {
			System.out.println("image doesn't exist");
		}
	    
	  */  
	    cardPanel.add(panel);
	    add(cardPanel);
	    setVisible(true);
	    
	    
//	    cardPanel = new JPanel();
//	   // CardLayout cl = new CardLayout();
//	   // cardPanel.setLayout(cl);
//	    //OccipitalPanel panel = new OccipitalPanel();
//	   FrontalPanel panel1 = new FrontalPanel();
//	    panel1.setVisible(true);
//	  //  getContentPane().add(panel1, null);
//	    panel1.setVisible(true);
//	  //  cardPanel.add(panel);
//	    cardPanel.add(panel1);
//	    setVisible(true);
//	    
//	    
	    /*
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    setBackground(Color.BLACK);
		FrontalPanel panel1 = new FrontalPanel();    
	    
	    //addKeyListener(panel1.getKeyHandler());
	
	    cardPanel.add(panel1,"1");
	    //cardPanel.add(panel2,"2");
	    
	    add(cardPanel);
	
	    setVisible(true);
	    */
	}
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
	}

}
