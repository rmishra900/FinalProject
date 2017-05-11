
package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
	private double length;
	private int[] xCoords, yCoords;
	
	public Triangle(double xCoord, double yCoord, double length, Color c) {
		super(xCoord, yCoord, c);
		this.length = length;
		
		xCoords = new int[3];
		xCoords[0] = (int)x;
		xCoords[1] = (int)(x - length / 2);
		xCoords[2] = (int)(x + length / 2);
					
		yCoords = new int[3];
		yCoords[0] = (int)(y - length * Math.sin(Math.PI / 3) / 2);
		yCoords[1] = (int)(y + length * Math.sin(Math.PI / 3) / 2);
		yCoords[2] = (int)(y + length * Math.sin(Math.PI / 3) / 2);
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(shapeColor);
		g.drawPolygon(xCoords, yCoords, 3);
		g.fillPolygon(xCoords, yCoords, 3);
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

	@Override
	public void moveWithWall(int a) {
		vY += 0.85;
		if (a > 0) {
			for (int i = 0; i < yCoords.length; i ++) {
				yCoords[i] -= vY;
			}
		}
		else {
			for (int i = 0; i < yCoords.length; i ++) {
				yCoords[i] += vY;
			}
		}
		
	}
}
