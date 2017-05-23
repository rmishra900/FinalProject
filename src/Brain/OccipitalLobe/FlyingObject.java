package Brain.OccipitalLobe;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

/**
 * 
 * @author Anisha
 * @version 5/15/2017
 */

public class FlyingObject extends Rectangle2D.Double {
	
	private Image image;
	
	/**
	 * Create a new instance of a FlyingObject. 
	 * @param filename the name of the image representing the FlyingObject on the screen
	 * @param x the x-coordinate of the location of the FlyingObject
	 * @param y the y-coordinate of the location of the FlyingObject
	 * @param w the width of the FlyingObject
	 * @param h the height of the FlyingObject
	 */
	public FlyingObject(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	/**
	 * Create a new instance of a FlyingObject. 
	 * @param img the image representing the FlyingObject on the screen
	 * @param x the x-coordinate of the location of the FlyingObject
	 * @param y the y-coordinate of the location of the FlyingObject
	 * @param w the width of the FlyingObject
	 * @param h the height of the FlyingObject
	 */
	public FlyingObject(Image img, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
	}
	
	/**
	 * Draws this FlyingObject onto the screen. 
	 * @param g Graphics used to draw the FlyingObject
	 * @param io ImageObserver used to draw the image of the FLyingObject
	 */
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image,(int)x,(int)y,(int)(width),(int)(height),io);
	}
	
	/**
	 * Draws this FlyingObject onto the screen. 
	 * @param g Graphics used to draw the FlyingObject
	 * @param img The image to be drawn. 
	 * @param x the x-coordinate of the location of the FlyingObject
	 * @param y the y-coordinate of the location of the FlyingObject
	 * @param w the width of the FlyingObject
	 * @param h the height of the FlyingObject
	 * @param io ImageObserver used to draw the image of the FLyingObject
	 */
	public void draw(Graphics g, Image img, int x, int y, int w, int h, ImageObserver io) {
		g.drawImage(image, x, y,w, h, io);
	}
	
	/**
	 * 
	 * @return the Image of the FlyingObject
	 */
	public Image getImage() {
		return image;
	}
}