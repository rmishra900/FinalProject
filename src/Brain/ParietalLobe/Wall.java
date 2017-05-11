package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Wall extends Rectangle2D.Double {

	private double vY;
	
	public Wall(int x, int y, double vY, int width, int height) {
		super(x, y, width, height);
		this.vY = vY;
	}
	
	public void act(int x) {
		vY += 0.8;
		if (x > 0) {
			y -= vY;
		}
		else {
			y += vY;
		}
	}
	
	public double getVelocity() {
		return vY;
	}
	
	 public void draw(Graphics g) {
		 g.setColor(new Color(219,108,121));
		 g.drawRoundRect((int)x, (int)y, (int)width, (int)height, 10, 10);
		 g.setColor(new Color(241,125,149));
		 g.fillRoundRect((int)x+1, (int)y+1, (int)width-1, (int)height-1, 10, 10);
//		 g.fillRect((int)x, (int)y, (int)width, (int)height);

	 }
	    
	 public boolean passes() {
		 return false;
	 }

}
