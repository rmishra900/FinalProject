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
	private int dir; //left = 37, up = 38, right = 39, down = 40
	private Image i;
	private int xV, yV;
	private int pointingTo; //left = 37, up = 38, right = 39, down = 40
	
	public Arrow(int xcoord, int ycoord, Color c) {
		x = xcoord;
		y = ycoord;
		this.c = c;
		dir = 37;
		i = new ImageIcon("Arrow.png").getImage();
		xV=1;
		yV=1;
		pointingTo = 37;
	}
	
	public int getPointingTo() {
		return pointingTo;
	}
	
	public void setPointingTo(int p) {
		if(p>40 || p<37) {
			System.out.println("value has to be either 37, 38, 39, or 40");
			return;
		}
		pointingTo = p;
	}
	
	public void rotate() {
		if(pointingTo==40){
			pointingTo=37;
		}
		else {
			pointingTo++;
		}
	}
	
	
	public int getDirection() {
		return dir;
	}
	
	public void setDirection(int d) {
		if(d>40 || d<37) {
			System.out.println("value has to be either 37, 38, 39, or 40");
			return;
		}
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
		g.drawImage(i, x, y,i.getWidth(io), i.getHeight(io), io);
	}
	
	public Image getImage() {
		return i;
	}
	
	public int getWidth(ImageObserver io) {
		return i.getWidth(io);
	}
	
	public int getHeight(ImageObserver io) {
		return i.getHeight(io);
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
