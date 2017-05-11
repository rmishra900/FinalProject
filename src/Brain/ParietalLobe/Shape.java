package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Shape {
	protected double x,y;
	private double width, height;
	protected Color shapeColor;
	
	public Shape(double xCoord, double yCoord, Color c) {
		x = xCoord;
		y = yCoord;
		shapeColor = c;
		width = 0;
		height = 0;
		
		
	}
	
	public abstract void draw(Graphics g);
	
	public void act() {
		
	}
	
	public void changeColor() {
		int red = (int)(Math.random() * 256);
    	int green = (int)(Math.random() * 256);
    	int blue = (int)(Math.random() * 256);
    	Color randomColor = new Color(red, green, blue);
		shapeColor = randomColor;
	}
}
