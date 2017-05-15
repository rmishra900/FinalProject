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
		s.add(new Circle(x + 15, y + 20, 30, Color.WHITE));
		s.add(new Triangle((x * 2 + width) / 2, y + 120, 70, Color.WHITE));
		s.add(new Square(x + 15, y + height - 90, 60, Color.WHITE));
	}
	
	public void act(int x) {
//		vY += 0.85;
		if (x > 0) {
			y -= 15;
		}
		else {
			y += 15;
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
	    
	 public boolean passes(Shape shape) {
		 if (shape.whichShape() == 0 || shape.whichShape() == 2) {
			 Shape s1 = s.get(shape.whichShape());
			 if (shape.y >= s1.y && shape.y + shape.getHeight() <= s1.y + s1.getHeight()) {
				 if(shape.x < x + width) {
					 s1.changeColor();
					 return true;
				 }
			 }
		 }
		 else {
			 Triangle t1 = (Triangle)s.get(1);
			 Triangle tri = new Triangle(shape.x, shape.y, 60, Color.BLACK);
			 if (tri.getYCoords()[0] >= t1.getYCoords()[0] - 5 && tri.getYCoords()[0] + tri.getHeight() <= t1.getYCoords()[0] + t1.getHeight() + 5) {
//				 System.out.println(tri.getLeftP() + " < " + (t1.getXCoords()[1] + t1.getHeight()));
//				 if(tri.getLeftP() < t1.getXCoords()[1] + t1.getHeight()) {
					 //BUG 
					 t1.changeColor(); 
					 return true;
//				 }
				
			 }
		 }
		 return false;
	 }

}