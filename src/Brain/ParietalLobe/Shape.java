package Brain.ParietalLobe;

import java.awt.Color;

import java.awt.Graphics;


/**
 * Represents an abstract class of a shape object. 
 * @version 5/15/2017
 *
 */
public abstract class Shape {
	protected double x, y, move;
	protected Color shapeColor;
	
	/**
	 * Constructs an instance of a shape object
	 * @param xCoord the x-coordinate of the top left corner of the shape
	 * @param yCoord the y-coordinate of the top left corner of the shape
	 * @param c the color of the shape
	 * @param move the amount the shape can move by
	 */
	public Shape(double xCoord, double yCoord, double move, Color c) {
		x = xCoord;
		y = yCoord;
		this.move = move;
		shapeColor = c;
	}
	
	/**
	 * Draws an instance of a type of shape object.
	 * @param g the Graphics object used to draw this shape
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * Moves a shape object to the left by decreasing the x-values by
	 * a certain velocity.
	 */
	public abstract void act();
	
	/**
	 *  Moves this shape with the wall by increasing or decreasing its y-coordinate, depending on the arrow key pressed.
	 * @param x the integer that determines which arrow key is being pressed, a is greater than 0 if the up arrow key is pressed and a is less than 0
	 * 			if the down arrow key is pressed
	 */
	public abstract void moveWithWall(int x);

	public abstract double getHeight();
	
	/**
	 * Returns an integer determining the shape this is, out of a circle, square, or triangle
	 * depending on its order in the main array (constructed in the ParietalPanel class)
	 * @return the integer 0, 1, or 2 to determine its index in the array
	 */
	public abstract int whichShape();
	
	public void setX(double xC) {
		x = xC;
	}
	
	public void setY(double yC) {
		y = yC;
	}
	
	public void changeColor() {
		int red = (int)(Math.random() * 256);
    	int green = (int)(Math.random() * 256);
    	int blue = (int)(Math.random() * 256);
    	Color randomColor = new Color(red, green, blue);
		shapeColor = randomColor;
	}
}