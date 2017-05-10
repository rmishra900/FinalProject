package Brain.OccipitalLobe;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Symbol extends FlyingObject {
	
	public static final int SYMBOL_WIDTH = 40;
	public static final int SYMBOL_HEIGHT = 60;
	
	public Symbol(int x, int y) {
		super("helicopter.png", x, y, SYMBOL_WIDTH, SYMBOL_HEIGHT);
	}

}
