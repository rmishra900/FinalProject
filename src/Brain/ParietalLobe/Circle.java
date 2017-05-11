
package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	private double radius;
	
	public Circle(double xCoord, double yCoord, double radius, Color c) {
		super(xCoord, yCoord, c);
		this.radius = radius;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(shapeColor);
		g.drawOval((int)x, (int)y, (int)(radius * 2), (int)(radius * 2));
		g.fillOval((int)x, (int)y, (int)(radius * 2), (int)(radius * 2));
	}
}
