
package Brain.ParietalLobe;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	protected double x,y;
	private double width, height;
	private Color shapeColor;
	
	public Shape(double xCoord, double yCoord) {
		x = xCoord;
		y = yCoord;
		width = 0;
		height = 0;
		shapeColor = Color.WHITE;
		
	}
	
	public abstract void act();
	
	public abstract void paintComponent(Graphics g);
	
	public Color getColor() {
		return shapeColor;
	}
	
	public void changeColor() {
		int red = (int)(Math.random() * 256);
    	int green = (int)(Math.random() * 256);
    	int blue = (int)(Math.random() * 256);
    	Color randomColor = new Color(red, green, blue);
		shapeColor = randomColor;
	}
}
