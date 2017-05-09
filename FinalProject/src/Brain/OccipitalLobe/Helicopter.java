package Brain.OccipitalLobe;

public class Helicopter extends FlyingObject {
	
	public static final int COPTER_WIDTH = 40;
	public static final int COPTER_HEIGHT = 60;
	
	public Helicopter(int x, int y) {
		super("helicopter.png", x, y, COPTER_WIDTH, COPTER_HEIGHT);
	}
	
}
