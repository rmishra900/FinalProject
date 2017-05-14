
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

	@Override
	public boolean collides(Wall w) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void act() {
		vX += 0.01;
		x -= vX;
	}

	public void moveWithWall(int a) {
//		vY += 0.85;
		if (a > 0) {
			y -= 5;
		}
		else {
			y += 5;
		}
	}

	public double getHeight() {
		return radius * 2;
	}

	@Override
	public int whichShape() {
		return 0;
	}
}
