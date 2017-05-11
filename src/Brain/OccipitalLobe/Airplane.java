package Brain.OccipitalLobe;

public class Airplane extends FlyingObject {
	
	public static final int PLANE_WIDTH = 70;
	public static final int PLANE_HEIGHT = 43;
	
	public Airplane(int x, int y) {
		super("Airplane.jpg", x, y, PLANE_WIDTH, PLANE_HEIGHT);
	}
	
}
