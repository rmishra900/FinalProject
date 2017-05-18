
package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a 2D circle. 
 * @author Thanh Luong
 * @version 5/15/2017
 *
 */
public class Circle extends Shape {
	private double radius;
	
	/**
	 * Constructs a new instance of this circle. 
	 * @param xCoord the x-coordinate of the top left corner of the imaginary rectangle that this circle is inscribed in
	 * @param yCoord the y-coordinate of the top left corner of the imaginary rectangle that this circle is inscribed in
	 * @param radius the radius of the circle
	 * @param c the color of this circle
	 */
	public Circle(double xCoord, double yCoord, double radius, Color c) {
		super(xCoord, yCoord, c);
		this.radius = radius;
	}

	/**
	 * Draws an instance of this circle.
	 * @param g the Graphics object that draws this circle
	 */
	public void draw(Graphics g) {
		g.setColor(shapeColor);
		g.drawOval((int)x, (int)y, (int)(radius * 2), (int)(radius * 2));
		g.fillOval((int)x, (int)y, (int)(radius * 2), (int)(radius * 2));
	}
	
	/**
	 * Moves this circle to the left by decreasing its x-coordinate by a certain velocity.
	 */
	public void act() {
		x -= 2.5;
	}

	/**
	 * Moves this circle with the wall by increasing or decreasing its y-coordinate, depending on the arrow key pressed.
	 * @param a the integer that determines which arrow key is being pressed, a > 0 if the up arrow key is pressed and a < 0
	 * 			if the down arrow key is pressed
	 */
	public void moveWithWall(int a) {
//		vY += 0.85;
		if (a > 0) {
			y -= 20;
		}
		else {
			y += 20;
		}
	}

	public double getHeight() {
		return radius * 2;
	}

	/**
	 * Returns an integer determining the shape this is, out of a circle, square, or triangle
	 * depending on its order in the main array (constructed in the ParietalPanel class)
	 * @return the integer 0 since this is a circle and is the zeroth index in the main array
	 */
	public int whichShape() {
		return 0;
	}
}