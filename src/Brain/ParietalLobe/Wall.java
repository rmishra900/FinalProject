package Brain.ParietalLobe;

import java.awt.Graphics;

public class Wall {
	private double x, y;
	private double vY;
	
	public Wall() {
		x = 20;
		y = 300;
		vY = 0;
	}
	
	public void act(int x) {
		vY += 0.7;
		if (x > 0) {
			y -= vY;
		}
		else {
			y += vY;
		}
	}
	
	 public void draw(Graphics g) {
		 g.drawRect((int)x, (int)y, 20, 300);

	 }
	    
	
	public boolean passes() {
		return false;
	}
}
