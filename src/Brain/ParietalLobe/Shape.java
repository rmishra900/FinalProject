package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Shape {
	protected double x, y, vX;
	private double width, height;
	protected Color shapeColor;
	
	public Shape(double xCoord, double yCoord, Color c) {
		x = xCoord;
		y = yCoord;
		vX = 0;
		shapeColor = c;
		width = 0;
		height = 0;
		
		
	}
	
	public abstract void draw(Graphics g);
	public abstract boolean collides(Wall w);
	
	public void act() {
		vX += 0.01;
		x -= vX;
	}
	
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
