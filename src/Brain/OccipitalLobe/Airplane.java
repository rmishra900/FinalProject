package Brain.OccipitalLobe;
/**
 * 
 * @author Anisha
 * @version 5/15/2017
 * A class that represents an airplane in the sky. 
 */
public class Airplane extends FlyingObject {
	
	public static final int PLANE_WIDTH = 70;
	public static final int PLANE_HEIGHT = 40;
	
	/**
	 * Creates a new instance of an Airplane object, with location (x,y) and default width and height.
	 * @param x the x-coordinate of the location of the Airplane
	 * @param y the y-coordinate of the location of the Airplane
	 */
	public Airplane(int x, int y) {
		super("occipital" + System.getProperty("file.separator") + "Airplane.jpg", x, y, PLANE_WIDTH, PLANE_HEIGHT);
	}
	
}