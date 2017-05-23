package Brain.OccipitalLobe;



/**
 * Represents a symbol that can appear on the screen.
 * @version 5/15/2017
 */
public class Symbol extends FlyingObject {
	
	/**
	 * The width of a symbol. 
	 */
	public static final int SYMBOL_WIDTH = 40;

	/**
	 * Constructs a new instance of a symbol at location (x, y)
	 * @param filename the name of the image file of each symbol
	 * @param x the x-coordinate of the symbol's location
	 * @param y the y-coordinate of the symbol's location
	 */
	public Symbol(String filename, int x, int y) {
		super("occipital" + System.getProperty("file.separator") + filename, x, y, SYMBOL_WIDTH, SYMBOL_WIDTH);
	}
	
}
