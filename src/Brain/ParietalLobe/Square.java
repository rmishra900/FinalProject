package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape{
	private double length;
		
		public Square(double xCoord, double yCoord, double length, Color c) {
			super(xCoord, yCoord, c);
			this.length = length;
		}

		@Override
		public void draw(Graphics g) {
			g.setColor(shapeColor);
			g.drawRect((int)x, (int)y, (int)length, (int)length);
			g.fillRect((int)x, (int)y, (int)length, (int)length);
		}

		@Override
		public boolean collides(Wall w) {
			// TODO Auto-generated method stub
			return false;
		}
		
		public void act() {
			vX += 0.02;
			x -= vX;
		}

		@Override
		public void moveWithWall(int a) {
//			vY += 0.85;
			if (a > 0) {
				y -= 15;
			}
			else {
				y += 15;
			}	
		}

		@Override
		public double getHeight() {
			return length;
		}

		@Override
		public int whichShape() {
			return 2;
		}
}	