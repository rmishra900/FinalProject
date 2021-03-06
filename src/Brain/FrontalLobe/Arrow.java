package Brain.FrontalLobe;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Represents an arrow displayed on the screen while playing "Flying Arrows"
 * @version 5/22/2017
 */
public class Arrow {
	private int x, y;
	private Color c;
	private int dir, pointingTo; //left = 37, up = 38, right = 39, down = 40
	private Image i,iR,iG,iB;
	private int xV, yV;
	private ImageIcon rl,ru,rr,rd,gl,gu,gr,gd,bl,bu,br,bd;
	private ArrayList<ImageIcon> imgI;
	
	/**
	 * Constructs a new instance of an arrow at location (x, y)
	 * @param xcoord the x-coordinate of the location of the arrow
	 * @param ycoord the y-coordinate of the location of the arrow
	 * @param c the color of this arrow
	 */
	public Arrow(int xcoord, int ycoord, Color c) {
		x = xcoord;
		y = ycoord;
		this.c = c;
		dir = 37;
		xV = 1;
		yV = 1;
		
		i = getRandomImage(c);
		
		iB = new ImageIcon("frontal" + System.getProperty("file.separator") + "BlueLeftArrow.png").getImage();
		iG = new ImageIcon("frontal" + System.getProperty("file.separator") + "GreenLeftArrow.png").getImage();
		iR = new ImageIcon("frontal" + System.getProperty("file.separator") + "RedLeftArrow.png").getImage();
		
		imgI = new ArrayList<ImageIcon>(12);
		
		
		rl = new ImageIcon("frontal" + System.getProperty("file.separator") + "RedLeftArrow.png");
		rl.setDescription("37");
		ru = new ImageIcon("frontal" + System.getProperty("file.separator") + "RedUpArrow.png");
		ru.setDescription("38");
		rr = new ImageIcon("frontal" + System.getProperty("file.separator") + "RedRightArrow.png");
		rr.setDescription("39");
		rd = new ImageIcon("frontal" + System.getProperty("file.separator") + "RedDownArrow.png");
		rd.setDescription("40");
		
		gl = new ImageIcon("frontal" + System.getProperty("file.separator") + "GreenLeftArrow.png");
		gl.setDescription("37");
		gu = new ImageIcon("frontal" + System.getProperty("file.separator") + "GreenUpArrow.png");
		gu.setDescription("38");
		gr = new ImageIcon("frontal" + System.getProperty("file.separator") + "GreenRightArrow.png");
		gr.setDescription("39");
		gd = new ImageIcon("frontal" + System.getProperty("file.separator") + "GreenDownArrow.png");
		gd.setDescription("40");
				
		 
		bl = new ImageIcon("frontal" + System.getProperty("file.separator") + "BlueLeftArrow.png");
		bl.setDescription("37");
		bu = new ImageIcon("frontal" + System.getProperty("file.separator") + "BlueUpArrow.png");
		bu.setDescription("38");
		br = new ImageIcon("frontal" + System.getProperty("file.separator") + "BlueRightArrow.png");
		br.setDescription("39");
		bd = new ImageIcon("frontal" + System.getProperty("file.separator") + "BlueDownArrow.png");
		bd.setDescription("40");
		
		imgI.add(rl);
		imgI.add(ru);
		imgI.add(rr);
		imgI.add(rd);
		imgI.add(gl);
		imgI.add(gu);
		imgI.add(gr);
		imgI.add(gd);
		imgI.add(bl);
		imgI.add(bu);
		imgI.add(br);
		imgI.add(bd);
		
		pointingTo = getOrientation();
	}
	
	/**
	 * Returns the direction the arrow is pointing to
	 * @return 37 if i's pointing left, 38 if it's pointing up, 39 if it's pointing right, and 40 if it's pointing down
	 */
	public int getPointingTo() { return pointingTo; }
	
	/**
	 * Sets direction arrow is pointing to
	 * @param p 37 if i's pointing left, 38 if it's pointing up, 39 if it's pointing right, and 40 if it's pointing down
	 */
	 
	public void setPointingTo(int p) {
		if(p>40 || p<37) {
			System.out.println("value has to be either 37, 38, 39, or 40");
			return;
		}
		pointingTo = p;
	}
	
	/**
	 * Returns the direction of this arrow
	 * @return an integer that represents the direction this arrow faces
	 */
	public int getDirection() { return dir; }
	
	public void setDirection(int d) {
		if(d>40 || d<37) {
			System.out.println("value has to be either 37, 38, 39, or 40");
			return;
		}
		dir = d;
	}
	
	/**
	 * Returns the x-coordinate of this arrow
	 * @return an integer that represents the x-coordinate of arrow
	 */
	public int getX() { return x; }
	
	/**
	 * Sets the x-coordinate of this arrow
	 * @param xC integer to set x-coordinate to
	 */
	public void setX(int xC) { x = xC; }
	
	/**
	 * Returns the y-coordinate of this arrow
	 * @return an integer that represents the y-coordinate of arrow
	 */
	public int getY() { return y; }
	
	/**
	 * Sets the y-coordinate of this arrow
	 * @param yC integer to set y-coordinate to
	 */
	public void setY(int yC) { y = yC; }
	
	/**
	 * Returns color of arrow
	 * @return a color that represents the color of the arrow
	 */
	public Color getColor() { return c; }
	
	/**
	 * Sets the color of the arrow
	 * @param color to set arrow to
	 */
	public void setcolor(Color color) { c = color; }
	
	public void draw(Graphics g, Image img, int x, int y, int width, int height, ImageObserver io) {
		g.drawImage(img, x, y,width, height, io);
	}

	/**
	 * Returns image of blue arrow
	 * @return the image of blue arrow initially pointing to left
	 */
	public Image getBlueImage() { return iB; }
	
	/**
	 * Returns width of blue arrow
	 * @param io ImageObserver used
	 * @return integer representing width of blue arrow
	 */
	public int getBlueWidth(ImageObserver io) { return iB.getWidth(io); }
	
	/**
	 * Returns height of blue arrow
	 * @param io ImageObserver used
	 * @return integer representing height of blue arrow
	 */
	public int getBlueHeight(ImageObserver io) { return iB.getHeight(io); }
	
	/**
	 * Returns image of red arrow
	 * @return the image of red arrow initially pointing to left
	 */
	public Image getRedImage() { return iR; }
	
	/**
	 * Returns width of red arrow
	 * @param io ImageObserver used
	 * @return integer representing width of red arrow
	 */
	public int getRedWidth(ImageObserver io) { return iR.getWidth(io); }

	/**
	 * Returns height of red arrow
	 * @param io ImageObserver used
	 * @return integer representing height of red arrow
	 */
	public int getRedHeight(ImageObserver io) { return iR.getHeight(io); }
	
	/**
	 * Returns image of green arrow
	 * @return the image of green arrow initially pointing to left
	 */
	public Image getGreenImage() { return iG; }
	
	/**
	 * Returns width of green arrow
	 * @param io ImageObserver used
	 * @return integer representing width of green arrow
	 */
	public int getGreenWidth(ImageObserver io) { return iG.getWidth(io); }
	
	/**
	 * Returns height of green arrow
	 * @param io ImageObserver used
	 * @return integer representing height of green arrow
	 */
	public int getGreenHeight(ImageObserver io) { return iG.getHeight(io); }

	/**
	 * Returns current image of arrow (blue, red or green)
	 * @return the image of the arrow currently
	 */
	public Image getImage() {return i; }
	
	/**
	 * Sets current image of arrow (blue, red or green)
	 * @param img the image of the arrow to set
	 */
	public void setImage(Image img) { i = img; }
	
	/**
	 * Returns width of current image
	 * @param io ImageObserver used
	 * @return integer representing width of current image
	 */
	public int getWidth(ImageObserver io) {	return i.getWidth(io); }
	

	/**
	 * Returns height of current image
	 * @param io ImageObserver used
	 * @return integer representing height of current image
	 */
	public int getHeight(ImageObserver io) { return i.getHeight(io); }
	
	/**
	 * Returns an integer representing the orientation of the arrow.
	 * If it returns 37, then the orientation is left.
	 * If it returns 38, then the orientation is up. 
	 * If it returns 39, then the orientation is down.
	 * If it returns 40, then the orientation is down.
	 * @return integer representing orientation of arrow
	 */
	public int getOrientation() {
		//left = 37, up = 38, right = 39, down = 40
		int o = 0;
		
		for(ImageIcon icon : imgI) {
			if(icon.getImage().equals(i)) {
				o = Integer.parseInt(icon.getDescription());
			}
		}
		return o;
	}
	
	
	/**
	 * Moves arrow to specified location
	 * @param xDir amount want to move in x-axis
	 * @param yDir amount want to move in y-axis
	 */
	public void move(int xDir, int yDir) {
		
		setX(getX()+xDir);
		setY(getY()+yDir);
	}
	
	/**
	 * Moves arrow across the screen depending on the direction of the arrow.
	 */
	public void moveAcrossScreen() {
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
	
	/**
	 * Returns an image with a random orientation (left, right, up or down) of any colored arrow
	 * @param c the color of the arrow
	 * @return image with random orientation of the colored arrow
	 */
	public Image getRandomOrientation(Color c) {
	
		int r = (int) (Math.random()*4);
		
		//0=left, 1=up, 2=right, 3=down
		
		String filename = "";
		if(c == Color.RED) {
			if(r == 0) {
				filename = "frontal" + System.getProperty("file.separator") + "RedLeftArrow.png";
				setPointingTo(37);
			}
			else if(r==1) {
				filename = "frontal" + System.getProperty("file.separator") + "RedUpArrow.png";
				setPointingTo(38);
			}
			else if(r==2) {
				filename = "frontal" + System.getProperty("file.separator") + "RedRightArrow.png";
				setPointingTo(39);
			}
			else {
				filename = "frontal" + System.getProperty("file.separator") + "RedDownArrow.png";
				setPointingTo(40);
			}
		}
		else if(c == Color.GREEN) {
			if(r == 0) {
				filename = "frontal" + System.getProperty("file.separator") + "GreenLeftArrow.png";
				setPointingTo(37);
			}
			else if(r==1) {
				filename = "frontal" + System.getProperty("file.separator") + "GreenUpArrow.png";
				setPointingTo(38);
			}
			else if(r==2) {
				filename = "frontal" + System.getProperty("file.separator") + "GreenRightArrow.png";
				setPointingTo(39);
			}
			else {
				filename = "frontal" + System.getProperty("file.separator") + "GreenDownArrow.png";
				setPointingTo(40);
			}
		}
		else {
			if(r == 0) {
				filename = "frontal" + System.getProperty("file.separator") + "BlueLeftArrow.png";
				setPointingTo(37);
			}
			else if(r==1) {
				filename = "frontal" + System.getProperty("file.separator") + "BlueUpArrow.png";
				setPointingTo(38);
			}
			else if(r==2) {
				filename = "frontal" + System.getProperty("file.separator") + "BlueRightArrow.png";
				setPointingTo(39);
			}
			else {
				filename = "frontal" + System.getProperty("file.separator") + "BlueDownArrow.png";
				setPointingTo(40);
			}
		}
		
		return  new ImageIcon(filename).getImage();
	}
	
	/**
	 * Returns a random image of a colored arrow (red, green, or blue) with a random orientation.
	 * @param c the color to set this image to                  
	 * @return colored image of arrow
	 */
	public Image getRandomImage(Color c) {
		setcolor(c);
		Image randomImage = getRandomOrientation(c);
		
		
		return randomImage;
	}
}
