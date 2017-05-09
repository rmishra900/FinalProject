package Brain.FrontalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Arrow {
	private int x, y;
	private Color c;
	private int dir; //0 = up, 1 = right, 2 = down, 3 = left
	private Image i;
	private int xV, yV;
	private int pointingTo; //0 = up, 1 = right, 2 = down, 3 = left
	
	public Arrow(int xcoord, int ycoord, Color c) {
		x = xcoord;
		y = ycoord;
		this.c = c;
		dir = 0;
		i = new ImageIcon("Arrow.gif").getImage();
		xV=1;
		yV=1;
	}
	
	public int getPointingTo() {
		return pointingTo;
	}
	
	public void setPointingTo(int p) {
		pointingTo = p;
	}
	
	public int getDirection() {
		return dir;
	}
	
	public void setDirection(int d) {
		dir = d;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int xC) {
		x = xC;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int yC) {
		y = yC;
	}
	
	public Color getColor() {
		return c;
	}
	
	public void setcolor(Color color) {
		c = color;
	}
	
	public void draw(Graphics g, ImageObserver io) {
		moveAcrossScreen();
		g.drawImage(i, x, y, io);
	}
	
	public void moveAcrossScreen() {
		
		if(dir == 0) {
			yV--;
		}
		else if(dir == 1) {
			xV++;
		}
		else if(dir == 2) {
			yV++;
		}
		else {
			xV--;
		}
	
		setX(x+xV);
		setY(y+yV);
	}
}
