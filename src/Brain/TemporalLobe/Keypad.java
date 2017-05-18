package Brain.TemporalLobe;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;

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

    /**
     * Creates new form ButtonPanel
     */
    public Keypad() {
    	setLayout(null);
    	setOpaque(true);
    	setBackground(Color.BLUE);
    	setBounds(250, 150, 300, 300);
    	setFocusCycleRoot(true);
    	
		/*JPanel back = new JPanel();
		back.setLayout(null);
		back.setBackground(new Color(255,255,255, 127));
		back.setOpaque(true);
		back.setBounds(30, 100, 400, 400);
		add(back);*/
    	
    
    	buttons = new Button[10];
    	sounds = new Sound[10];
        initializeButtons();
    }

                         
    private void initializeButtons() {
        
    	for(Button b: buttons) {
    		
    	}
                                    
    }
 
             
}
