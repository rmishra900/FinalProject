package Brain.TemporalLobe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.JButton;

/**
 * 
 * @author Reet 
 * @version 5/18/17
 * Represents a button on the keypad. 
 */
public class Button implements ActionListener{
	private String text;
	private int x, y, w, h;
	private Sound s;
	private JButton b;
	private boolean pressed;
	
	/**
	 * Creates a new instance of a button on the keypad. 
	 * @param text the text on the button
	 * @param x x-coordinate of the button 
	 * @param y y-coordinate of the button 
	 * @param filename the file name for the sound corresponding to the button
	 */
	public Button(String text, int x, int y, String filename) {
		this.text = text;
		this.x = x;
		this.y = y;
		s = new Sound(filename);
		w = 50;
		h = 50;
		b = new JButton();
		b.setLayout(null);
		b.setText(text);
		b.setForeground(Color.BLACK);
		b.setFont(new Font("Roman Baseline", 0, 16));
		b.setBounds(x, y, w, h);

		b.addActionListener(this);
		pressed = false;
	
	}
	
	public void addActionListener(ActionListener a) {
		b.addActionListener(a);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		s.play();
		pressed = true;
	}
	
	public boolean isPressed() {
		return pressed;
	}
	
	/**
	 * Sets the sound of the button using a file name.
	 * @param filename the file name of the sound
	 */
	public void setSound(String filename) {
		s = new Sound(filename);
	}
	
	/**
	 * Sets the sound of the button.
	 * @param sound button's new sound
	 */
	public void setSound(Sound sound) {
		s = sound;
	}
	
	/**
	 * 
	 * @return the sound of this button
	 */
	public Sound getSound() {
		return s;
	}
	
	/**
	 * 
	 * @return the file name of the sound of this button
	 */
	public String getSoundFilename() {
		return s.getFilename();
	}
	
	/**
	 * 
	 * @return width of this button
	 */
	public int getWidth() {
		return w;
	}
	
	/**
	 * Sets the width of this button
	 * @param width New value for the width of this button
	 */
	public void setWidth(int width) {
		w = width;
	}
	
	/**
	 * 
	 * @return the height of this button
	 */
	public int getHeight() {
		return h;
	}
	
	/**
	 * Sets the height of this button
	 * @return New value for the width of this button
	 */
	public void setHeight(int height) {
		h = height;
	}
	
	/**
	 * 
	 * @return the x-coordinate of this button
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x-coordinate of this button.
	 * @param xcoord the new value for the x-coordinate of this button
	 */
	public void setX(int xcoord) {
		x = xcoord;
	}
	
	/**
	 * 
	 * @return the y-coordinate of this button
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y-coordinate of this button.
	 * @param ycoord the new value for the y-coordinate of this button
	 */
	public void setY(int ycoord) {
		y = ycoord;
	}
	
	/**
	 * Sets the text displayed on this button
	 * @param t text to be displayed on this button
	 */
	public void setText(String t) {
		text = t;
		b.setText(t);
	}
	
	/**
	 * 
	 * @return the text displayed on this button
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * 
	 * @return the swing component of this button
	 */
	public JButton getJButton() {
		return b;
	}
	
	/**
	 * Sets the swing component of this button
	 * @param b JButton to be set
	 */
	public void setJButton(JButton b) {
		this.b = b;
	}
	
//	 public boolean isPressed() {
//	    	if(getJButton().getModel().isPressed()) {
//	    		
//	    		return true;
//	    	}
//	    	else {
//	    		System.out.println("hello");
//	    		return false;
//	    	}
//	    		
//	    }
//	

}
