package Coma;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.OccipitalLobe.Occipital;

import Brain.ParietalLobe.ParietalPanel;
import Brain.FrontalLobe.Frontal;


public class Coma extends JFrame {

	JPanel cardPanel;
	
	public Coma(String title) {
		
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
/*
	    OccipitalPanel op = new OccipitalPanel();
	    op.setVisible(true);
	    add(op);
*/
	    ParietalPanel pp = new ParietalPanel();
	    pp.setVisible(true);
	    add(pp); 
	    addKeyListener(pp);
	    
    
/*	    Frontal fp = new Frontal();
	    fp.setVisible(true);
	    add(fp);
	    addKeyListener(fp.getKeyHandler());
*/	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);

//	    cardPanel.add(fp);
	    cardPanel.add(pp);
	    add(cardPanel);
	    setVisible(true);
	    

//	    ParietalPanel panel0 = new ParietalPanel();
//	    HomeScreen panel1 = new HomeScreen(this);
//	    Menu panel2 = new Menu(this);
//	    Rules panel3 = new Rules(this);
//	    StoryScreen panel4 = new StoryScreen(this);

//	    addKeyListener(panel.getKeyHandler());

//	    gamePanel.add(panel0, "0");
//	    gamePanel.add(panel1, "1");
//	    gamePanel.add(panel2,"2");
//	    gamePanel.add(panel3,"3");
//	    gamePanel.add(panel4, "4");

	 /*   try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Background.jpg")))));
		} catch (IOException e) {
			System.out.println("image doesn't exist");
		}
>>>>>>> branch 'master' of https://github.com/rmishra900/FinalProject.git
	    
<<<<<<< HEAD
	    add(gamePanel);
	    addKeyListener(panel0);
	    addMouseListener(panel1);
	    addMouseListener(panel2);
	    addMouseListener(panel3);
	    addMouseListener(panel4);
//	    addKeyListener(panel4);*/
	    
//	    cardPanel.add(panel);
//	    add(cardPanel);
//
//	    setVisible(true);
//	    

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
<<<<<<< HEAD
	*/
	}
	
	public static void main(String[] args) {
		Coma c = new Coma("COMA");
		
	}

}
