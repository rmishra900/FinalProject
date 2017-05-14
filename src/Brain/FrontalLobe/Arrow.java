package Brain.FrontalLobe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
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
	private ImageIcon rl,ru,rr,rd,gl,gu,gr,gd,bl,bu,br,bd;
	private ArrayList<ImageIcon> imgI;
	
	public Arrow(int xcoord, int ycoord, Color c) {
		x = xcoord;
		y = ycoord;
		this.c = c;
		dir = 37;
		hasRotated = false;
		xV = 1;
		yV = 1;
		
		i = getRandomImage();
		
		iB = new ImageIcon("BlueLeftArrow.png").getImage();
		iG = new ImageIcon("GreenLeftArrow.png").getImage();
		iR = new ImageIcon("RedLeftArrow.png").getImage();
		
		imgI = new ArrayList<ImageIcon>(12);
		
		
		
		rl = new ImageIcon("RedLeftArrow.png");
		rl.setDescription("37");
		ru = new ImageIcon("RedUpArrow.png");
		ru.setDescription("38");
		rr = new ImageIcon("RedRightArrow.png");
		rr.setDescription("39");
		rd = new ImageIcon("RedDownArrow.png");
		rd.setDescription("40");
		
		gl = new ImageIcon("GreenLeftArrow.png");
		gl.setDescription("37");
		gu = new ImageIcon("GreenUpArrow.png");
		gu.setDescription("38");
		gr = new ImageIcon("GreenRightArrow.png");
		gr.setDescription("39");
		gd = new ImageIcon("GreenDownArrow.png");
		gd.setDescription("40");
				
		 
		bl = new ImageIcon("BlueLeftArrow.png");
		bl.setDescription("37");
		bu = new ImageIcon("BlueUpArrow.png");
		bu.setDescription("38");
		br = new ImageIcon("BlueRightArrow.png");
		br.setDescription("39");
		bd = new ImageIcon("BlueDownArrow.png");
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
		
	}

	public Image getBlueImage() {
		return iB;
	}
	
	public int getBlueWidth(ImageObserver io) {
		return iB.getWidth(io);
	}
	
	public int getBlueHeight(ImageObserver io) {
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
	
//	public String getImageFilename() {
//		return i.
//	}
	
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
	
	
	public void move(int xDir, int yDir) {
		
		setX(getX()+xDir);
		setY(getY()+yDir);
	
}
	
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
	
	public Image getRandomOrientation(Color c) {
	
		int r = (int) (Math.random()*4);
		
		//0=left, 1=up, 2=right, 3=down
		
		String filename = "";
		if(c == Color.RED) {
			if(r == 0) {
				filename = "RedLeftArrow.png";
				setPointingTo(37);
			}
			else if(r==1) {
				filename = "RedUpArrow.png";
				setPointingTo(38);
			}
			else if(r==2) {
				filename = "RedRightArrow.png";
				setPointingTo(39);
			}
			else {
				filename = "RedDownArrow.png";
				setPointingTo(40);
			}
		}
		else if(c == Color.GREEN) {
			if(r == 0) {
				filename = "GreenLeftArrow.png";
				setPointingTo(37);
			}
			else if(r==1) {
				filename = "GreenUpArrow.png";
				setPointingTo(38);
			}
			else if(r==2) {
				filename = "GreenRightArrow.png";
				setPointingTo(39);
			}
			else {
				filename = "GreenDownArrow.png";
				setPointingTo(40);
			}
		}
		else {
			if(r == 0) {
				filename = "BlueLeftArrow.png";
				setPointingTo(37);
			}
			else if(r==1) {
				filename = "BlueUpArrow.png";
				setPointingTo(38);
			}
			else if(r==2) {
				filename = "BlueRightArrow.png";
				setPointingTo(39);
			}
			else {
				filename = "BlueDownArrow.png";
				setPointingTo(40);
			}
		}
		
		return  new ImageIcon(filename).getImage();
	}
	
	public Image getRandomImage() {
		Color c;
		
		int randCol = (int) (Math.random()*3);
		
		if(randCol == 0) {
			c = new Color(255,0,0); //red
		}
		else if(randCol==1) {
			c = new Color(0,255,0); //green
		}
		else {
			c = new Color(0,0,255); //blue
		}
		
		
		Image randomImage = getRandomOrientation(c);
		
		
		return randomImage;
		
		
		
		
		
		
		
		
		/*
		//Image green = getGreenImage();   
		//Image red = getRedImage();
		//Image blue = getBlueImage();
		  
		int x = (int)(Math.random()*4);
	
		if(x == 0) {
			  setImage(iG);
			  setcolor(Color.GREEN);
			  return iG;
		  }
		  else if(x==1) {
			  setImage(iR);
			  setcolor(Color.RED);
			  return iR;
		  }
		  else {
			  setImage(iB);
			  setcolor(Color.BLUE);
			  return iB;
		  }
		  */
		   
	}
}
