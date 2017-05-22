package Brain.OccipitalLobe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import Brain.Lobe;

import Coma.Coma;

/**
 * The class that represents the drawn background with all its FlyingObjects. 
 * @author Anisha
 * @version 5/15/2017
 *
 */
public class Occipital extends Lobe implements MouseListener, ActionListener {
	
	private Coma c;
	
	private JButton back, menu;
	private Airplane plane;
	private ArrayList<Helicopter> obstacles;

	private Symbol sym;
	private SymbolPanel sp;
	private int symNum;
	private boolean showObjects;
	private Image background, winImage;
	private int correct;
	
	private JPanel glass = new JPanel();
	private JLabel score, win;

	/**
	 * Constructs a new instance of the background with all the FlyingObjects on it. 
	 */
	public Occipital(Coma c) {
		super();
		setLayout(null);
		
		this.c = c;
		setBackground(Color.WHITE);
		background = new ImageIcon("occipital" + System.getProperty("file.separator") + "OccipitalBackground.jpg").getImage();
		super.addMouseListener(this);
		
		sp = new SymbolPanel(c);
		
		correct = -1;
		showObjects = true;
		initializeObstacles();
		initializeSymbol();
		
	
		back = getBack();
		menu = getMenu();
		winImage = getWinImage();
		
		add(back);
		back.addActionListener(this);
		add(menu);
		menu.addActionListener(this);
		
		win = new JLabel();
		win.setLocation(DRAWING_WIDTH / 2 - 250, DRAWING_HEIGHT / 2 - 50);
		win.setFont(new Font("Roman Baseline",3, 100));
		win.setSize(500, 100);
		
		score = new JLabel(); 
		score.setForeground(Color.WHITE);
		score.setLocation(400, 20);
		score.setSize(150,30);
		score.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		add(score);
		
		setVisible(true);
		
	}
	
	private void initializeSymbol() {
		
	}
	
	private void initializeObstacles() {
		
		plane = new Airplane(100 + (int) (Math.random()*(DRAWING_WIDTH-150)), 100 + (int) (Math.random()*(DRAWING_HEIGHT-150)));
		symNum = (int)(Math.random()*5) + 1;
		int x1 = 100 + (int) (Math.random()*(DRAWING_WIDTH-150));
		int y1 = 100 + (int) (Math.random()*(DRAWING_HEIGHT-150));
		if (!(x1 == plane.getX() && y1 == plane.getY()))
			sym = new Symbol("Symbol" + symNum + ".png", x1, y1);
		else 
			sym = new Symbol("Symbol" + symNum + ".png", x1+25, y1);
		
		obstacles = new ArrayList<Helicopter>();
		int randNum = (int) (Math.random() * 8) + 3; // number of helicopters - minimum is 3, maximum is 10 
		for (int i = 0; i < randNum; i++) {
			int x2 = (int) (Math.random()*DRAWING_WIDTH);
			int y2 = (int) (Math.random()*DRAWING_HEIGHT);
			if (!(x2 == plane.getX() && y2 == plane.getY()) && !(x2 == sym.getX() && y2 == sym.getY()))
				obstacles.add(new Helicopter(x2, y2));
		}
	}
	
	public void reset() {
		initializeObstacles();
		initializeSymbol();
	}
	
	/**
	 * Returns the number used to identify the symbol on this JPanel. 
	 * @return the number used to identify the symbol on this JPanel. 
	 */
	public int getSymNum() {
		return symNum;
	}
	
	public SymbolPanel getSP() {
		return sp;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint
									// the background

		Graphics2D g2 = (Graphics2D) g;
		
		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;
		
		
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		g2.setTransform(at);
		
		if (showObjects) {
			g.drawImage(background, 0, 0, (int)(getWidth()), (int)(getHeight()), this);
			
			int sw = (int) (sym.SYMBOL_WIDTH*ratioX);
			int sh = (int) (sym.SYMBOL_WIDTH*ratioY);
			
			sym.draw(g2, sym.getImage(), (int)sym.getX(), (int)sym.getY(), sw, sh, this);
	//		sym.draw(g2, this);
			
			int pw = (int) (plane.PLANE_WIDTH*ratioX);
			int ph = (int) (plane.PLANE_HEIGHT*ratioY);
//			
			plane.draw(g2, plane.getImage(), (int)plane.getX(), (int) plane.getY(), pw, ph, this);
		
//			plane.draw(g2, this);
			
			for (Helicopter heli : obstacles) {
				
				int hw = (int) (heli.COPTER_WIDTH*ratioX);
				int hh = (int) (heli.COPTER_HEIGHT*ratioY);
//				
//				heli.draw(g2, this);
				heli.draw(g2, heli.getImage(), (int)heli.getX(), (int) heli.getY(), hw, hh, this);
			}	
		}
		
		if(c.getWon(2)) {
			g.drawImage(winImage, 0, 0, getWidth(), getHeight(), this);
			score.setForeground(Color.BLACK);
		}
		repaint();
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if (plane.intersects(e.getX(), e.getY(), plane.PLANE_WIDTH/1.5, plane.PLANE_HEIGHT/1.5)) {
			correct = 1;
		} else {
			correct = 0;
		}	
	}

	public void mousePressed(MouseEvent e) { }

	public void mouseReleased(MouseEvent e) { }

	public void mouseEntered(MouseEvent e) { }

	public void mouseExited(MouseEvent e) { }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == back)
			c.changePanel("11");
		else if (src == menu) {
			c.changePanel("3");
		}
	}
	
	public void act() {
		remove(win);
		score.setText("Score: " + sp.getScore());
		setBackground(Color.WHITE);
		do {
			correct = -1;
			showObjects = true;
			c.changePanel("12");

	 	    setOpaque(false);
	 	    glass.setOpaque(false);
	 	    
	 	    glass.addMouseListener(new MouseAdapter() {});
	 	    glass.addMouseMotionListener(new MouseAdapter() {});
	 	    
	 	    glass.setFocusCycleRoot(true);
	 	    c.setGlassPane(glass); 
	 	    glass.setVisible(true);
	 	    
	 	    setOpaque(true);
	 	    
	 	    try {
	 			Thread.sleep(2000);
	 		} catch (InterruptedException e) {
	 			e.printStackTrace();
	 		}
	 	    
	 	    showObjects = false;
	 	    glass.setVisible(false);	
	 	    
	 	    while (correct == -1) {
	 	    	 try {
	 	 			Thread.sleep(200);
	 	 		} catch (InterruptedException e) {
	 	 			e.printStackTrace();
	 	 		}
	 	    }
	 	    
	 	    if (correct == 0) {
	 	    	c.changePanel("12");
	 	    	setBackground(Color.WHITE);
	 	    	score.setForeground(Color.BLACK);
	 	    	win.setForeground(Color.RED);
	 	    	win.setLocation(DRAWING_WIDTH / 2 - 270, DRAWING_HEIGHT / 2 - 50);
	 	    	win.setSize(550,100);
	 	    	win.setText("YOU LOSE");
	 	    	add(win);
	 	    	sp.setScore(0);
	 	    	sp.getScoreLabel().setText("Score: " + sp.getScore());
	 	    	reset();
	 	    	break;
	 	    }
	 	    correct = -1;
	 	    
	 	    sp.setTarget(getSymNum());
	 	    c.changePanel("13");
	    	
	 	    try {
	 			Thread.sleep(2000);
	 		} catch (InterruptedException e) {
	 			e.printStackTrace();
	 		}	
	    	
	    	while (sp.getCorrect() == -1) {
	    		try {
	 	 			Thread.sleep(2000);
	 	 		} catch (InterruptedException e) {
	 	 			e.printStackTrace();
	 	 		}
	    	}
	    	
	    	if (sp.getCorrect() == 1) {	
	    		sp.setScore(sp.getScore()+1);
	    		sp.getScoreLabel().setText("Score: " + sp.getScore());
	 	    	score.setText("Score: " + sp.getScore());
	 	    }
	    	
	 	    else if (sp.getCorrect() == 0) {
	 	    	c.changePanel("12");
	 	    	setBackground(Color.WHITE);
	 	    	score.setForeground(Color.BLACK);
	 	    	win.setForeground(Color.RED);
	 	    	win.setLocation(DRAWING_WIDTH / 2 - 270, DRAWING_HEIGHT / 2 - 50);
	 	    	win.setSize(550,100);
	 	    	win.setText("YOU LOSE");
	 	    	add(win);
	 	    	sp.setScore(0);
	 	    	sp.getScoreLabel().setText("Score: " + sp.getScore());
	 	    	reset();
	 	    	break;
	 	    }
	    	sp.setCorrect();
	    	if (sp.getScore() == 10) {
	    		c.changePanel("12");
	    		showObjects = false;
	    		setBackground(Color.WHITE);
	    		score.setForeground(Color.BLACK);
	 	    	win.setForeground(Color.RED);
	    		win.setVisible(true);
	 		    win.setText("YOU WIN");
	 		    add(win);
 	    		c.setWon(2);
 	    		
 	    		c.changeToOver();
 	    		break;
	    	}
	    	reset();
		} while (sp.getScore() > 0);
		sp.setCorrect();
	}
}