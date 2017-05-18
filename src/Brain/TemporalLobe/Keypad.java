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
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



/**
 *
 * @author reetmishra
 */
public class Keypad extends JPanel{
	
	  private Button[] buttons;  
	  private Sound[] sounds;
	  private final int x, y, width, height;
	  private boolean isPressed;

 
    public Keypad() {
    	width = 400;
    	height = 450;
    	x = 200;
    	y = 80;
    	setLayout(null);
    	setOpaque(true);
    	setBackground(Color.WHITE);
    	setBounds(x, y, width, height);
   		
		isPressed = false;

    	buttons = new Button[10];
    	sounds = new Sound[10];
    	initializeSounds();
        initializeButtons();
        
       for(Button b: buttons) {
    	  b.getJButton().setLayout(null);
    	  b.getJButton().setOpaque(true);
    	  add(b.getJButton());
       }
    }

                         
    private void initializeButtons() {
    	int a = y;
    	int b = x-width/2 + 70;
    	 buttons[0] = new Button("1", b+5, a, sounds[0].getFilename());
    	 buttons[1] = new Button("2", b+105, a, sounds[1].getFilename());
    	 buttons[2] = new Button("3", b+205, a, sounds[2].getFilename());
    	 buttons[3] = new Button("4", b+5, a+100, sounds[3].getFilename());
    	 buttons[4] = new Button("5", b+105, a+100, sounds[4].getFilename());
    	 buttons[5] = new Button("6", b+205, a+100, sounds[5].getFilename());
    	 buttons[6] = new Button("7", b+5, a+200, sounds[6].getFilename());
    	 buttons[7] = new Button("8", b+105, a+200, sounds[7].getFilename());
    	 buttons[8] = new Button("9", b+205, a+200, sounds[8].getFilename());
    	 buttons[9] = new Button("0", b+105, a+300, sounds[9].getFilename()); 	
    	
                  
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
    
    public Sound[] getSounds() {
    	return sounds;
    }
    
    public Button[] getButtons() {
    	return buttons;
    }
    
    public Sound getSound(int x) {
    	return sounds[x];
    }
    
    public Button getButton(int x) {
    	return buttons[x];
    }
    public boolean isPressed(Button b) {
    	if(b.getJButton().getModel().isPressed())
    		return true;
    	else
    		return false;
    }
    
    public ArrayList<Button> getButtonsPressed(Button[] buttons) {
    	ArrayList<Button> pressed = new ArrayList<Button>();
    	for(Button b: buttons) {
    		if(b.getJButton().getModel().isPressed()) {
    			pressed.add(b);
    		}
    	}
    	
    	
    	//Button[] p = (Button[])pressed.toArray();
    	
    	return  pressed;
    }
    
    
             
}
