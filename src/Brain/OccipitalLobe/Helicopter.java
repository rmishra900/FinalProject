package Brain.OccipitalLobe;

public class Helicopter extends FlyingObject {
	
	public static final int COPTER_WIDTH = 70;
	public static final int COPTER_HEIGHT = 40;
	
	public Helicopter(int x, int y) {
		super("Helicopter.jpg", x, y, COPTER_WIDTH, COPTER_HEIGHT);
	}
}