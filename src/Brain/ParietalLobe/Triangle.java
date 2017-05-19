package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a 2D three-pointed equal-sided polygon, or equilateral triangle. 
 * @author Thanh Luong
 * @version 5/15/2017
 *
 */
public class Triangle extends Shape {
	private double length;
	private double[] xCoords, yCoords;
	
	/**
	 * Constructs a new instance of this triangle. 
	 * @param xCoord the x-coordinate of the center of the triangle
	 * @param yCoord the y-coordinate of the center of the triangle
	 * @param length the side length of the triangle
	 * @param c the color of this circle
	 */
	public Triangle(double xCoord, double yCoord, double length, Color c) {
		super(xCoord, yCoord, c);
		this.length = length;
		
		xCoords = new double[3];
		xCoords[0] = x;
		xCoords[1] = x - length / 2;
		xCoords[2] = x + length / 2;
					
		yCoords = new double[3];
		yCoords[0] = y - length * Math.sin(Math.PI / 3) / 2;
		yCoords[1] = y + length * Math.sin(Math.PI / 3) / 2;
		yCoords[2] = y + length * Math.sin(Math.PI / 3) / 2;
	}

	/**
	 * Draws an instance of this triangle.
	 * @param g the Graphics object that draws this triangle
	 */
	public void draw(Graphics g) {
		g.setColor(shapeColor);
		int[] xC = new int[3];
		int[] yC = new int[3];
		
		for(int i = 0; i < xCoords.length; i++) {
			xC[i] = (int)xCoords[i];
			yC[i] = (int)yCoords[i];
		}
		
		g.drawPolygon(xC, yC, 3);
		g.fillPolygon(xC, yC, 3);
	}
	
	/**
	 * Moves this triangle to the left by decreasing its x-coordinate by a certain velocity.
	 */
	public void act() {
		for (int i = 0; i < xCoords.length; i ++) {
			xCoords[i] -= 3;
		}
	}

	/**
	 * Moves this triangle with the wall by increasing or decreasing its y-coordinate, depending on the arrow key pressed.
	 * @param a the integer that determines which arrow key is being pressed, a > 0 if the up arrow key is pressed and a < 0
	 * 			if the down arrow key is pressed
	 */
	public void moveWithWall(int a) {
//		vY += 0.85;
		if (a > 0) {
			for (int i = 0; i < yCoords.length; i ++) {
				yCoords[i] -= 20;
			}
		}
		else {
			for (int i = 0; i < yCoords.length; i ++) {
				yCoords[i] += 20;	
			}
		}
		
	}

	/**
	 * Returns the distance of the perpendicular line from the vertex of the triangle to the opposite side
	 * @return double of the height of the triangle
	 */
	public double getHeight() {
		return length * Math.sin(Math.PI / 3);
	}
	
	public double[] getXCoords() {
		return xCoords;
	}
	
	public double[] getYCoords() {
		return yCoords;
	}

	/**
	 * Returns an integer determining the shape this is, out of a circle, square, or triangle
	 * depending on its order in the main array (constructed in the ParietalPanel class)
	 * @return the integer 1 since this is a triangle and is the first index in the main array
	 */
	public int whichShape() {
		return 1;
	}
}