package Brain.FrontalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Arrow {
	private int x, y;
	private Color c;
	private int dir; //left = 37, up = 38, right = 39, down = 40
	private Image i;
	private Image iR,iG,iB;
	//private BufferedImage bi;
	private int xV, yV;
	private int pointingTo; //left = 37, up = 38, right = 39, down = 40
	private boolean hasRotated;
	
	public Arrow(int xcoord, int ycoord, Color c) {
		x = xcoord;
		y = ycoord;
		this.c = c;
		dir = 39;
		i = new ImageIcon("Arrow.png").getImage();
		iB = new ImageIcon("Arrow.png").getImage();
		iG = new ImageIcon("ArrowGreen.png").getImage();
		iR = new ImageIcon("ArrowRed.png").getImage();
	//	i = new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB);
		xV=1;
		yV=1;
		pointingTo = 39;
		hasRotated = false;
		/*
		try {
			bi = ImageIO.read(new File("Arrow.gif"));
			
		} catch (IOException e) {
			System.out.println("Exception caught with bufferedImage");
			e.printStackTrace();
		}
		*/
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
	
	public void rotate(Graphics g) {
	
		
		if(pointingTo==40){
			pointingTo=37;
		}
		else {
			pointingTo++;
		}
		hasRotated = true;
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
	
	public void draw(Graphics g, Image img, int x, int y, int width, int height, ImageObserver io) {
	
		g.drawImage(img, x, y,width, height, io);
		//System.out.println("here");
	
		/*
		if(hasRotated==true) {
		//	System.out.println("hasrotated==true");
			double rotationRequired = Math.toRadians(90);
			double locationX = i.getWidth(io)/2;
			double locationY = i.getHeight(io)/2;
			AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
			//g.drawImage(op.filter((BufferedImage) i, null), x, y, null);
		}
		*/
	}
/*	
	public BufferedImage getBufferedImage() {
		return bi;
	}
	
	public void setBufferedImage(BufferedImage bimg) {
		bi = bimg;
	}
*/	
	public Image getBlackImage() {
		return iB;
	}
	
	public int getBlackWidth(ImageObserver io) {
		return iB.getWidth(io);
	}
	
	public int getBlackHeight(ImageObserver io) {
		return iB.getHeight(io);
	}
	
	public Image getRedImage() {
		return iR;
	}
	
	public int getRedWidth(ImageObserver io) {
		return iR.getWidth(io);
	}
	
	public int getRedHeight(ImageObserver io) {
		return iR.getHeight(io);
	}
	
	public Image getGreenImage() {
		return iG;
	}
	
	public int getGreenWidth(ImageObserver io) {
		return iG.getWidth(io);
	}
	
	public int getGreenHeight(ImageObserver io) {
		return iG.getHeight(io);
	}
	
	
	public Image getImage() {
		return i;
	}
	
	public void setImage(Image img) {
		i = img;
	}
	
	public int getWidth(ImageObserver io) {
		return i.getWidth(io);
	}
	
	public int getHeight(ImageObserver io) {
		return i.getHeight(io);
	}
	
	public void moveAcrossScreen() {
	//	xV++;
	//	setX((x+xV));
		
		if(dir == 38) {
			yV--;
		}
		else if(dir == 39) {
			xV++;
		}
		else if(dir == 40) {
			yV++;
		}
		else {
			xV--;
		}
	
		setX(x+xV);
		setY(y+yV);
	
	}
}
