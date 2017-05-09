package Brain.OccipitalLobe;

public class Airplane extends FlyingObject {
	
	public static final int PLANE_WIDTH = 40;
	public static final int PLANE_HEIGHT = 60;
	
	public Airplane(int x, int y) {
		super("airplane.png", x, y, PLANE_WIDTH, PLANE_HEIGHT);
	}
	
}
