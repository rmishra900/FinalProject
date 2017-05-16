package Brain.TemporalLobe;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.media.j3d.Sound;
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
	
	

}
