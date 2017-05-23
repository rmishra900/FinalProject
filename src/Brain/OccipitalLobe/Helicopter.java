package Brain.OccipitalLobe;
/**
 * 
 * @author Anisha
 * @version 5/15/2017
 * A class that represents a helicopter in the sky. 
 */
public class Helicopter extends FlyingObject {
	
	/**
	 * The width of the helicopter. 
	 */
	public static final int COPTER_WIDTH = 70;
	
	/**
	 * The height of the helicopter. 
	 */
	public static final int COPTER_HEIGHT = 40;
	
	/**
	 * Creates a new instance of a Helicopter object, with location (x,y) and default width and height.
	 * @param x the x-coordinate of the location of the Helicopter
	 * @param y the y-coordinate of the location of the Helicopter
	 */
	public Helicopter(int x, int y) {
		super("occipital" + System.getProperty("file.separator") + "Helicopter.jpg", x, y, COPTER_WIDTH, COPTER_HEIGHT);
	}
}
