package Brain.OccipitalLobe;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Symbol extends Rectangle2D.Double {
	private Image image;

	public Symbol(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}

	public Symbol(Image img, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
	}

	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image, (int) x, (int) y, (int) width, (int) height, io);
	}
}
