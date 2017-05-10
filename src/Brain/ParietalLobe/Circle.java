
package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	private double radius;
	
	public Circle(double xCoord, double yCoord, double radius, Color c) {
		super(xCoord, yCoord);
		this.radius = radius;
		c = super.getColor();
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawOval((int)x, (int)y, (int)(radius * 2), (int)(radius * 2));
	}
}
