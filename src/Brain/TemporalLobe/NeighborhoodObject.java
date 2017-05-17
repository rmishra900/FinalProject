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

public class NeighborhoodObject extends Rectangle2D.Double {
	
	private Image image; 
	private NeighborhoodSound sound;
	
	public NeighborhoodObject(Image img, String soundFilename) {
		image = img;
		sound = new NeighborhoodSound(soundFilename);
	}
	
	
	public NeighborhoodObject(String imgFilename, String soundFilename, int x, int y, int w, int h) {
		image = new ImageIcon(imgFilename).getImage();
		sound = new NeighborhoodSound(soundFilename);
		
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}


	public void draw(Graphics g, Image img, double x, double y, double width, double height, ImageObserver io) {
		g.drawImage(img, (int)x, (int)y,(int)width, (int)height, io);
	}
	
	public Image getImage() {
		return image;
	}

	public NeighborhoodSound getSound() {
		return sound;
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
