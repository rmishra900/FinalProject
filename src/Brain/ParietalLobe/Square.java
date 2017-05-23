package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a 2D square. 
 * @version 5/15/2017
 *
 */
public class Square extends Shape{
	private double length;
	private double vY;
	
	/**
	 * Constructs a new instance of this square. 
	 * @param xCoord the x-coordinate of the top left corner of the square
	 * @param yCoord the y-coordinate of the top left corner of the square
	 * @param distance between coordinates
	 * @param length the side length of the square
	 * @param c the color of this circle
	 */
	public Square(double xCoord, double yCoord, double length, double distance, Color c) {
		super(xCoord, yCoord, distance, c);
		this.length = length;
		
	}

	/**
	 * Draws an instance of this square.
	 * @param g the Graphics object that draws this square
	 */
	public void draw(Graphics g) {
		g.setColor(shapeColor);
		g.drawRect((int)x, (int)y, (int)length, (int)length);
		g.fillRect((int)x, (int)y, (int)length, (int)length);
	}
	
	/**
	 * Moves this square to the left by decreasing its x-coordinate by a certain velocity.
	 */
	public void act() {
		x -= move;
//		System.out.println(move);
	}

	/**
	 * Moves this circle with the wall by increasing or decreasing its y-coordinate, depending on the arrow key pressed.
	 * @param a the integer that determines which arrow key is being pressed, a is greater than 0 if the up arrow key is 
	 * pressed and a is less than 0 if the down arrow key is pressed
	 */
	public void moveWithWall(int a) {
//		vY += 0.5;
		
		if (a > 0) {
			y -= 15;
		}
		else {
			y += 15;
		}
	}

	
	public double getHeight() {
		return length;
	}

	/**
	 * Returns an integer determining the shape this is, out of a circle, square, or triangle
	 * depending on its order in the main array (constructed in the ParietalPanel class)
	 * @return the integer 2 since this is a square and is the second index in the main array
	 */
	public int whichShape() {
		return 2;
	}
}	