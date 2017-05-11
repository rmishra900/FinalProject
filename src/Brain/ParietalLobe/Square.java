
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
}	
