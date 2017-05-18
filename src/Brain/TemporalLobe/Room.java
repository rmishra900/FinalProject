package Brain.TemporalLobe;

import java.awt.Graphics;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.applet.Main;

import java.awt.Image;

//import javax.media.j3d.Sound;

//import javax.media.j3d.Sound;
import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.applet.Main;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

import java.awt.image.ImageObserver;

//import javax.media.j3d.Sound;

//import javax.media.j3d.Sound;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

import java.awt.image.ImageObserver;

//import javax.media.j3d.Sound;
import javax.swing.ImageIcon;

/**
 * Represents a room with a different image and passcode. 
 * @author anisha
 * @version 5/18/17
 *
 */
public class Room extends Rectangle2D.Double {
	
	private Image background; 
	private Keypad k;
	private int[] passcode;
	
	/**
	 * Creates a new instance of a Room with an image and passcode.
	 * @param img the background of the room
	 * @param p the passcode needed to go to the next room
	 */
	public Room(Image img, int[] p) {
		background = img;
		passcode = p;
	}
	
	/**
	 * Creates a new instance of a room with an image and passcode.
	 * @param imgFilename the file name of the image of the room
	 * @param passcode the passcode needed to go to the next room
	 * @param w the width of the room
	 * @param h the height of the room
	 */
	public Room(String imgFilename, int[] passcode, int w, int h) {
		background = new ImageIcon("temporal" + System.getProperty("file.separator") + imgFilename).getImage();
		this.passcode = passcode;
		k = new Keypad();
		this.width = w;
		this.height = h;
	}
	
	/**
	 * Sets the passcode to a new passcode.
	 * @param x the array of integers of the new passcode
	 */
	public void setPasscode(int[] x) {
		passcode = x;
	}
	
	/**
	 * 
	 * @return the passcode of this room
	 */
	public int[] getPasscode() {
		return passcode;
	}
	
	/**
	 * Returns a specific digit of the passcode.
	 * @param x the index of the digit
	 * @return digit of passcode at index x
	 */
	public int getPasscodeDigit(int x) {
		for(int i = 0; i<passcode.length; i++) {
			if(i==x) {
				return passcode[x];
			}
		}
		return -1;
	}
	
	public String getPasscodeIndex(int x) {
		String s = "";
		
		for(int i = 0; i<passcode.length; i++) {
			if(i==x) {
				return Integer.toString(passcode[x]);
			}
		}
		
		return s;
	}

	public void draw(Graphics g, Image img, double width, double height, ImageObserver io) {
		g.drawImage(background, 0, 0, (int)width, (int)height, io);
	}
	
	/**
	 * 
	 * @return the background image of this room 
	 */
	public Image getBackground() {
		return background;
	}

	/**
	 * Plays the sound of this room that the user needs to enter a passcode for.
	 */
	public void playSound() {
		for(int i =0; i<passcode.length; i++) {
			k.getButton(passcode[i]).getSound().play();
		}
		
		
	}
	
	


	/*
	public static synchronized void playSound(final String url) {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          Main.class.getResourceAsStream("/path/to/sounds/" + url));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
	*/
}
