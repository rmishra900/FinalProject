package Brain.OccipitalLobe;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

/**
 * Represents a symbol that can appear randomly on the screen.
 * @author Anisha
 * @version 5/15/2017
 */
public class Symbol extends FlyingObject {
	private Image image;
	public static final int SYMBOL_WIDTH = 40;

	/**
	 * Constructs a new instance of a symbol at location (x, y)
	 * @param filename the name of the image file of each symbol
	 * @param x the x-coordinate of the symbol's location
	 * @param y the y-coordinate of the symbol's location
	 */
	public Symbol(String filename, int x, int y) {
		super(filename, x, y, SYMBOL_WIDTH, SYMBOL_WIDTH);
	}
}