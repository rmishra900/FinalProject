package Brain.TemporalLobe;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



/**
 *
 * @author reetmishra
 */
public class Keypad extends JPanel {
	
	  private Button[] buttons;  
	  private Sound[] sounds;
	  private final int x, y, width, height;

 
    public Keypad() {
    	width = 400;
    	height = 450;
    	x = 200;
    	y = 80;
    	setLayout(null);
    	setOpaque(true);
    	setBackground(Color.WHITE);
    	setBounds(200, 80, 400, 450);
   		
		/*JPanel back = new JPanel();
		back.setLayout(null);
		back.setBackground(new Color(255,255,255, 127));
		back.setOpaque(true);
		back.setBounds(30, 100, 400, 400);
		add(back);*/
 
    

    	buttons = new Button[10];
    	sounds = new Sound[10];
    	initializeSounds();
        initializeButtons();
        
       for(Button b: buttons) {
    	  
    	   b.getJButton().setOpaque(true);
    	   add(b.getJButton());
       }
    }

                         
    private void initializeButtons() {

    	int m = 5;
    	int a = y+10;
    	
    	 buttons[0] = new Button("1", x+5, a, sounds[0].getFilename());
    	 buttons[1] = new Button("2", x+10, a, sounds[1].getFilename());
    	 buttons[2] = new Button("3", x+15, a, sounds[2].getFilename());
    	 buttons[3] = new Button("4", x+m, a+10, sounds[3].getFilename());
    	 buttons[4] = new Button("5", x+(2*m), a+10, sounds[4].getFilename());
    	 buttons[5] = new Button("6", x+(3*m), a+10, sounds[5].getFilename());
    	 buttons[6] = new Button("7", x+m, a+20, sounds[6].getFilename());
    	 buttons[7] = new Button("8", x+(2*m), a+20, sounds[7].getFilename());
    	 buttons[8] = new Button("9", x+(3*m), a+20, sounds[8].getFilename());
    	 buttons[9] = new Button("0", x+(2*m), a+30, sounds[9].getFilename()); 	
                  
    }
    
    private void initializeSounds() {
    
    		sounds[0] = new Sound("temporal" + System.getProperty("file.separator") + "C#.wav");
    		sounds[1] = new Sound("temporal" + System.getProperty("file.separator") + "E.wav");
    		sounds[2] = new Sound("temporal" + System.getProperty("file.separator") + "A.wav");
    		sounds[3] = new Sound("temporal" + System.getProperty("file.separator") + "D.wav");
    		sounds[4] = new Sound("temporal" + System.getProperty("file.separator") + "G.wav");
    		sounds[5] = new Sound("temporal" + System.getProperty("file.separator") + "A#.wav");
    		sounds[6] = new Sound("temporal" + System.getProperty("file.separator") + "B.wav");
    		sounds[7] = new Sound("temporal" + System.getProperty("file.separator") + "G#.wav");
    		sounds[8] = new Sound("temporal" + System.getProperty("file.separator") + "F.wav");
    		sounds[9] = new Sound("temporal" + System.getProperty("file.separator") + "C.wav");
    		
    }
    
//    public void paintComponent(Graphics g) {
//    	super.paintComponent(g);
//    //	g.drawImage(img, 0, 0, getWidth(), getHeight() , this);
//		
//    	Graphics2D g2 = (Graphics2D)g;
//
//	    int w = getWidth();
//	    int h = getHeight();
//	    
//	    double ratioX = (double)w/width;
//		double ratioY = (double)h/height;
//		        
//		AffineTransform at = g2.getTransform();
//		g2.scale(ratioX, ratioY);
//		
//		
//    	
//    }
    
    public void scale(Graphics g) {
    	Graphics2D g2 = (Graphics2D)g;

	    int w = getWidth();
	    int h = getHeight();
	    
	    double ratioX = (double)w/width;
		double ratioY = (double)h/height;
		        
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

    }
 
             
}
