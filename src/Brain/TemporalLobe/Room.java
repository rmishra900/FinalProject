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

public class Room extends Rectangle2D.Double {
	
	private Image background; 
	private Keypad k;
	private int[] passcode;
	
	public Room(Image img, int[] p) {
		background = img;
		passcode = p;
	}
	
	
	public Room(String imgFilename, int[] passcode, int w, int h) {
		background = new ImageIcon("temporal" + System.getProperty("file.separator") + imgFilename).getImage();
		this.passcode = passcode;
		k = new Keypad();
		this.width = w;
		this.height = h;
		initializeSounds();
	}
	
	private void initializeSounds() {
		
	}

	public void setPasscode(int[] x) {
		passcode = x;
	}
	
	public int[] getPasscode() {
		return passcode;
	}
	
	public int getPasscodeDigit(int x) {
		for(int i = 0; i<passcode.length; i++) {
			if(i==x) {
				return passcode[x];
			}
		}
		return -1;
	}

	public void draw(Graphics g, Image img, double width, double height, ImageObserver io) {
		g.drawImage(background, 0, 0, (int)width, (int)height, io);
	}
	
	public Image getBackground() {
		return background;
	}

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
