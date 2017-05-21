package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Represents a 2D rectangle to act as a wall containing three holes of the three shapes (circle, triangle, square). 
 * @author Thanh Luong
 * @version 5/15/2017
 *
 */
public class Wall extends Rectangle2D.Double {

	private ArrayList<Shape> s;
	private double vY;
	
	/**
	 * Constructs an instance of this wall containing the holes of the three shapes.
	 * @param x the x-coordinate of the top left corner of the wall
	 * @param y the y-coordinate of the top left corner of the wall
	 * @param vY the velocity of the wall object in the y-direction
	 * @param width the width of the wall
	 * @param height the height of the wall
	 */
	public Wall(int x, int y, int width, int height) {
		super(x, y, width, height);
		s = new ArrayList<Shape>();
		s.add(new Circle(x + 15, y + 20, 30, Color.WHITE));
		s.add(new Triangle((x * 2 + width) / 2, y + 120, 70, Color.WHITE));
		s.add(new Square(x + 15, y + height - 90, 60, Color.WHITE));
		vY = 0;
	}
	
	/**
	 * Moves this wall up or down by decreasing its x-coordinate by a certain velocity.
	 */
	public void act(int x) {
		vY += 0.5;
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
	
	/**
	 * Draws an instance of this wall.
	 * @param g the Graphics object that draws this wall
	 */
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
	  
	/**
	 * Tests if the shape object successfully passes through the holes of the wall.
	 * @param shape the shape to be tested against the wall
	 * @return true if the shape passes through the wall with no collision, false otherwise
	 */
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
			Triangle tri = (Triangle)shape;
			if (tri.getYCoords()[0] >= t1.getYCoords()[0] - 5 && tri.getYCoords()[0] + tri.getHeight() <= t1.getYCoords()[0] + t1.getHeight() + 5) {
				if(tri.getXCoords()[1] >= x && tri.getXCoords()[2] <= x + width) {
					t1.changeColor(); 
				return true;
				}
			}
		}
		return false;
	 }
}