
package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
	private double length;
	private int[] xCoords, yCoords;
	
	public Triangle(double xCoord, double yCoord, double length, Color c) {
		super(xCoord, yCoord);
		this.length = length;
		c = super.getColor();
		
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
	public void act() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawPolygon(xCoords, yCoords, 3);
		g.fillPolygon(xCoords, yCoords, 3);
		g.setColor(super.getColor());
	}
}
