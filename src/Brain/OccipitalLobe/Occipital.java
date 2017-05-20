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

import Coma.Coma;

/**
 * The class that represents the drawn background with all its FlyingObjects. 
 * @author Anisha
 * @version 5/15/2017
 *
 */
public class Occipital extends JPanel implements MouseListener, ActionListener {
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private ShowMeTheLight s;
	private Coma c;
	
	private JButton back, menu;
	private Airplane plane;
	private ArrayList<Helicopter> obstacles;

	private Symbol sym;
	private SymbolPanel sp;
	private int symNum;
	private boolean showObjects;
	private Image background;
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
		
		back = new JButton("BACK");
		back.setBackground(Color.YELLOW);
		back.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		back.setSize(100, 50);
		back.setLocation(25, 0);
		
		menu = new JButton("MENU");
		menu.setBackground(Color.YELLOW);
		menu.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		menu.setSize(100, 50);
		menu.setLocation(150, 0);
		
		add(back);
		back.addActionListener(this);
		add(menu);
		menu.addActionListener(this);
		
		win = new JLabel();
		win.setLocation(270, 45);
		win.setForeground(Color.WHITE);
		win.setSize(300, 100);
		add(win);
		
		score = new JLabel("SCORE: " + sp.getScore());
		score.setForeground(Color.WHITE);
		score.setLocation(10, 20);
		score.setSize(150,30);
		score.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		add(score);
		
		setVisible(true);
		
	}
	
	private void initializeSymbol() {
		symNum = (int)(Math.random()*5) + 1;
		int x = 100 + (int) (Math.random()*(DRAWING_WIDTH-150));
		int y = 100 + (int) (Math.random()*(DRAWING_HEIGHT-150));
		if (!(x == plane.getX() && y == plane.getY()))
			sym = new Symbol("Symbol" + symNum + ".png", x, y);
		else 
			sym = new Symbol("Symbol" + symNum + ".png", x+25, y);
	}
	
	private void initializeObstacles() {
		plane = new Airplane(100 + (int) (Math.random()*(DRAWING_WIDTH-150)), 100 + (int) (Math.random()*(DRAWING_HEIGHT-150)));
		obstacles = new ArrayList<Helicopter>();
		int randNum = (int) (Math.random() * 8) + 3; // number of helicopters - minimum is 3, maximum is 10 
		for (int i = 0; i < randNum; i++) {
			int x = (int) (Math.random()*DRAWING_WIDTH);
			int y = (int) (Math.random()*DRAWING_HEIGHT);
			if (!(x == plane.getX() && y == plane.getY()))
				obstacles.add(new Helicopter(x, y));
		}
	}
	
	public void reset() {
		initializeObstacles();
		initializeSymbol();
		showObjects = true;
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
			g.drawImage(background, 0, 0, (int)(800*ratioX), (int)(600*ratioY), this);
			
			sym.draw(g2, this);
			plane.draw(g2, this);
			for (Helicopter heli : obstacles) {
				heli.draw(g2, this);
			}	
		}
	}
	
	/**
	 * Decides whether or not the JPanel should display anything at all. 
	 * @param bool If true, then show FlyingObjects. If false, do not show anything. 
	 */
	public void setShowObjects(boolean bool) {
		showObjects = bool;
	}
	
	/**
	 * Resets the JPanel's history of correctness. 
	 */
	public void setCorrect() { correct = -1; }
	
	/**
	 * Returns the value that determines if the user answered correctly or not. 
	 * @return the value that determines if the user answered correctly or not. 
	 */
	public int getCorrect() { return correct; }
	
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
		else if (src == menu)
			c.changePanel("3");
		
	}
	
	public void act() {
		do {
			c.changePanel("12");

	 	    this.setOpaque(false);
	 	    glass.setOpaque(false);
	 	    
	 	    glass.addMouseListener(new MouseAdapter() {});
	 	    glass.addMouseMotionListener(new MouseAdapter() {});
	 	    
	 	    glass.setFocusCycleRoot(true);
	 	    c.setGlassPane(glass); 
	 	    glass.setVisible(true);
	 	    
	 	    this.setOpaque(true);
	 	    try {
	 			Thread.sleep(2000);
	 		} catch (InterruptedException e) {
	 			e.printStackTrace();
	 		}
	 	    this.setShowObjects(false);
	 	    glass.setVisible(false);	
	 	    
	 	    while (this.getCorrect() == -1) {
	 	    	 try {
	 	 			Thread.sleep(200);
	 	 		} catch (InterruptedException e) {
	 	 			e.printStackTrace();
	 	 		}
	 	    }
	 	    
	 	    if (this.getCorrect() == 0) {
	 	    	break;
	 	    }
	 	    this.setCorrect();
	 	    
	 	    sp.setTarget(this.getSymNum());
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
	 	    	score.setText("Score: " + sp.getScore());
	 	    }
	 	    else if (sp.getCorrect() == 0){
	 	    	score.setText("YOU LOSE! Score: " + sp.getScore());
	 	    	sp.setVisible(false);
	 	    	break;
	 	    }
	    	sp.setCorrect();
	    	sp.setVisible(false);
	    	if (sp.getScore() == 10) {
	    		win.setText("YOU WIN");
	 		    win.setFont(new Font("Roman Baseline", Font.BOLD, 50));
 	    		c.setWon(2);
 	    		break;
	    	}
	    	reset();
		} while (sp.getScore() > 0);
	}
}