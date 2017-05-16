package Brain.TemporalLobe;

import java.awt.Image;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.applet.Main;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

//import javax.media.j3d.Sound;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

//import javax.media.j3d.Sound;
import javax.swing.ImageIcon;

public class NeighborhoodObject extends Rectangle2D.Double {
	
	private Image image; 
	private NeighborhoodSound sound;
	
	public NeighborhoodObject(String imgFilename, String soundFilename, int x, int y, int w, int h) {
		this((new ImageIcon(imgFilename)).getImage(), soundFilename, x,y,w,h);
	}
	
	public NeighborhoodObject(Image img, String soundFilename, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
		sound = new NeighborhoodSound(soundFilename);
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
