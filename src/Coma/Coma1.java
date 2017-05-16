package Coma;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Brain.OccipitalLobe.Occipital;
import Brain.ParietalLobe.ParietalPanel;
import Brain.ParietalLobe.ParietalRules;
import Brain.FrontalLobe.Frontal;

/**
 * Represents the window that pops up when the user wishes to play "Hole in the Wall"
 * @author Thanh Luong
 * @version 5/15/2017
 */
public class Coma1 extends JFrame {

	JPanel cardPanel;
	
	/**
	 * Constructs a new instance of this game's window. 
	 * @param title the title to be displayed at the top of the game's window. 
	 */
	public Coma1(String title) {
		
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	   // ParietalPanel pp = new ParietalPanel();
	    ParietalRules pp = new ParietalRules();
	    pp.setVisible(true);
	    add(pp); 
	    //addKeyListener(pp);
	    

	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);

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
		Coma1 c = new Coma1("COMA");
		
	}

}