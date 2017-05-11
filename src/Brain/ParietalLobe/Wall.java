package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Wall extends Rectangle2D.Double {

	private double vY;
	private ArrayList<Shape> s;
	
	public Wall(int x, int y, double vY, int width, int height) {
		super(x, y, width, height);
		this.vY = vY;
		s = new ArrayList<Shape>();
		s.add(new Circle(super.x + 13, super.y + 20, 25, Color.WHITE));
		s.add(new Triangle((super.x * 2 + width) / 2, super.y + 120, 50, Color.WHITE));
		s.add(new Square(super.x + 13, super.y + height - 70, 50, Color.WHITE));
	}
	
	public void act(int x) {
		vY += 0.85;
		if (x > 0) {
			y -= vY;
		}
		else {
			y += vY;
		}
		
		for (Shape sh: s) {
			sh.moveWithWall(x);
		}
	}
	
	public double getVelocity() {
		return vY;
	}
	
	 public void draw(Graphics g) {
//		 g.setColor(new Color(219,108,121));
//		 g.setColor(new Color(241,125,149));
		 
		 g.setColor(Color.BLUE);
		 g.drawRoundRect((int)x, (int)y, (int)width, (int)height, 10, 10);
		 g.fillRoundRect((int)x+1, (int)y+1, (int)width-1, (int)height-1, 10, 10);
		 
		 for (Shape sh: s) {
			 sh.draw(g);
		 }


	 }
	    
	 public boolean passes() {
		 return false;
	 }

}
