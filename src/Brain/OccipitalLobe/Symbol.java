package Brain.OccipitalLobe;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Symbol extends FlyingObject {
	private Image image;
	public static final int SYMBOL_WIDTH = 40;

	public Symbol(String filename, int x, int y) {
		super(filename, x, y, SYMBOL_WIDTH, SYMBOL_WIDTH);
	}
}