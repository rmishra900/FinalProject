package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Shape {
	protected double x, y, vX, vY;
	protected Color shapeColor;
	
	public Shape(double xCoord, double yCoord, Color c) {
		x = xCoord;
		y = yCoord;
		vX = 0;
		vY = 0;
		shapeColor = c;
		
	}
	
	public abstract void draw(Graphics g);
	public abstract boolean collides(Wall w);
	public abstract void act();
	public abstract void moveWithWall(int x);
	
	public double getX() {
		return x;
	}
	
	public void setX(double xC) {
		x = xC;
	}
	
	public double getY() {
		return y;
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
