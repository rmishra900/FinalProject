package Brain.TemporalLobe;

import java.awt.Image;

//import javax.media.j3d.Sound;

public class NeighborhoodObject {
	
	private Image image; 
	private NeighborhoodSound sound;
	
	public NeighborhoodObject(Image img, String soundFilename) {
		image = img;
		sound = new NeighborhoodSound(soundFilename);
	}
	
	
	

}
