
package Brain.ParietalLobe;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape{
	private double width, length;
		
		public Square(double xCoord, double yCoord, double width, double length, Color c) {
			super(xCoord, yCoord);
			this.width = width;
			this.length = length;
			c = super.getColor();
		}
	
		@Override
		public void act() {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void paintComponent(Graphics g) {
			g.drawRect((int)x, (int)y, (int)width, (int)length);
		}
}	
