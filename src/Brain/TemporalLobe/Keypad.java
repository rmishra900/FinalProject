package Brain.TemporalLobe;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 * Represents the keypad for the user to click a passcode on. 
 * @version 5/18/17
 */
public class Keypad extends JPanel implements ActionListener {
	
	  private Button[] buttons;  
	  private Sound[] sounds;
	  private final int x, y, width, height;
	  private boolean isPressed;
	  private String passcodeEntered;
	  private Temporal temporal=null;
	  

	/**
     * Creates a default instance of a keypad. 
	 */
    public Keypad() {
    	width = 400;
    	height = 450;
    	x = 200;
    	y = 80;
    	setLayout(null);
//    	
    	setOpaque(true);
    	
    	setBounds(x, y, width, height);

		passcodeEntered = "";

    	buttons = new Button[10];
    	sounds = new Sound[10];
    	initializeSounds();
        initializeButtons();
        
       for(Button b: buttons) {
    	  b.getJButton().setLayout(null);
    	  b.getJButton().setOpaque(true);
    	  add(b.getJButton());
    	  b.addActionListener(this);
       }      
   	
    }

    /**
     * Initializes the 10 buttons for the keypad.              
     */
    private void initializeButtons() {
    	int a = y;
    	int b = x-width/2 + 70;
    	 buttons[1] = new Button("1", b+5, a, sounds[0].getFilename());
    	 buttons[2] = new Button("2", b+105, a, sounds[1].getFilename());
    	 buttons[3] = new Button("3", b+205, a, sounds[2].getFilename());
    	 buttons[4] = new Button("4", b+5, a+100, sounds[3].getFilename());
    	 buttons[5] = new Button("5", b+105, a+100, sounds[4].getFilename());
    	 buttons[6] = new Button("6", b+205, a+100, sounds[5].getFilename());
    	 buttons[7] = new Button("7", b+5, a+200, sounds[6].getFilename());
    	 buttons[8] = new Button("8", b+105, a+200, sounds[7].getFilename());
    	 buttons[9] = new Button("9", b+205, a+200, sounds[8].getFilename());
    	 buttons[0] = new Button("0", b+105, a+300, sounds[9].getFilename()); 	
    	
                  
    }
    
    /**
     * Initializes the array of sounds that correspond to the buttons.
     */
    private void initializeSounds() {
    
    		sounds[1] = new Sound("temporal" + System.getProperty("file.separator") + "C.wav");
    		sounds[2] = new Sound("temporal" + System.getProperty("file.separator") + "C#.wav");
    		sounds[3] = new Sound("temporal" + System.getProperty("file.separator") + "D.wav");
    		sounds[4] = new Sound("temporal" + System.getProperty("file.separator") + "E.wav");
    		sounds[5] = new Sound("temporal" + System.getProperty("file.separator") + "F.wav");
    		sounds[6] = new Sound("temporal" + System.getProperty("file.separator") + "G.wav");
    		sounds[7] = new Sound("temporal" + System.getProperty("file.separator") + "G#.wav");
    		sounds[8] = new Sound("temporal" + System.getProperty("file.separator") + "A.wav");
    		sounds[9] = new Sound("temporal" + System.getProperty("file.separator") + "A#.wav");
    		sounds[0] = new Sound("temporal" + System.getProperty("file.separator") + "B.wav");
    		
    }
    
    
    /**
     * 
     * @return an array of sounds that correspond to the buttons
     */
    public Sound[] getSounds() {
    	return sounds;
    }
    
    /**
     * 
     * @return an array of buttons on the keypad
     */
    public Button[] getButtons() {
    	return buttons;
    }
    
    /**
     * Returns the sound of a button at a specific index.
     * @param x index of the button
     * @return sound of the button at index x 
     */
    public Sound getSound(int x) {
    	return sounds[x];
    }
    
    /**
     * Returns the button at a specific index
     * @param x the index of the button
     * @return button at index x
     */
    public Button getButton(int x) {
    	return buttons[x];
    }
    

    /**
     * Resets the passcode the user entered.
     */
    public void resetEntered() {
    	passcodeEntered = ""; 
    }
    
    /**
     * 
     * @return the passcode String the user entered
     */
    public String getEntered() {
    	return passcodeEntered;
    }
    
    /**
     * Returns the passcode entered as a String. 
     * @param x the passcode 
     * @return a string containing the digits of x, the passcode
     */
    public String getEntered(int x) {
    	String s = "";
    	for (int i = 0; i<passcodeEntered.length(); i++) {
    		if(i==x) {

    			return Character.toString(passcodeEntered.charAt(i));
    		}
    	}
    	return s;
    }
   
    /**
     * 
     * @param p the String to set to what has been entered
     */
    public void setEntered(String p) {
    	passcodeEntered = p;
    }

    /**
     * 
     * @param temp the Temporal object this keypad gets assigned to
     */
    public void setTemporal(Temporal temp) {
    	temporal = temp;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (passcodeEntered.length() == 4)
			resetEntered();
		passcodeEntered += e.getActionCommand();
		setEntered(passcodeEntered);
		
		if (temporal != null) {
			temporal.repaint();
		}
	}

  
}
