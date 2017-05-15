package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
	private double length, leftP;
	private double[] xCoords, yCoords;
	
	public Triangle(double xCoord, double yCoord, double length, Color c) {
		super(xCoord, yCoord, c);
		this.length = length;
		
		xCoords = new double[3];
		xCoords[0] = x;
		xCoords[1] = x - length / 2;
		xCoords[2] = x + length / 2;
					
		yCoords = new double[3];
		yCoords[0] = y - length * Math.sin(Math.PI / 3) / 2;
		yCoords[1] = y + length * Math.sin(Math.PI / 3) / 2;
		yCoords[2] = y + length * Math.sin(Math.PI / 3) / 2;
		
		leftP = xCoords[1];
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(shapeColor);
		int[] xC = new int[3];
		int[] yC = new int[3];
		
		for(int i = 0; i < xCoords.length; i++) {
			xC[i] = (int)xCoords[i];
			yC[i] = (int)yCoords[i];
		}
		
		g.drawPolygon(xC, yC, 3);
		g.fillPolygon(xC, yC, 3);
	}

	@Override
	public boolean collides(Wall w) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void act() {
		vX += 0.05;
		leftP -= vX;
		for (int i = 0; i < xCoords.length; i ++) {
			xCoords[i] -= vX;
		}
	}

	@Override
	public void moveWithWall(int a) {
//		vY += 0.85;
		if (a > 0) {
			for (int i = 0; i < yCoords.length; i ++) {
				yCoords[i] -= 5;
			}
		}
		else {
			for (int i = 0; i < yCoords.length; i ++) {
				yCoords[i] += 5;	
			}
		}
		
	}

	@Override
	public double getHeight() {
		return length * Math.sin(Math.PI / 3);
	}
	
	public double[] getXCoords() {
		return xCoords;
	}
	
	public double[] getYCoords() {
		return yCoords;
	}

	@Override
	public int whichShape() {
		return 1;
	}
	
	public double getLeftP() {
		return leftP;
	}
}