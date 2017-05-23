package Brain.OccipitalLobe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.*;
import Brain.Lobe;

import Coma.Coma;

/**
 * The class that represents the drawn background with all its FlyingObjects. 
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
	private boolean lost;
	private Image background, winImage;
	private int correct;
	
	private JPanel glass = new JPanel();
	private JLabel score, win;

	/**
	 * Constructs a new instance of the background with all the FlyingObjects on it. 
	 * @param c the game that this Occipital screen is for.
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
		
	
		back = getBack();
		menu = getMenu();
		winImage = getWinImage();
		
		add(back);
		back.addActionListener(this);
		add(menu);
		menu.addActionListener(this);
		
		win = new JLabel();
		win.setLocation(DRAWING_WIDTH / 2 - 250, DRAWING_HEIGHT / 2 - 50);
		win.setFont(new Font("Roman Baseline",3, 90));
		win.setSize(500, 100);
		
		score = new JLabel(); 
		score.setForeground(Color.BLACK);
		score.setLocation(400, 20);
		score.setSize(150,30);
		score.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		add(score);
		
		setVisible(true);
		
	}
	
	private void initializeObstacles() {
		plane = new Airplane(100 + (int) (Math.random()*(DRAWING_WIDTH-150)), 100 + (int) (Math.random()*(DRAWING_HEIGHT-150)));
		symNum = (int)(Math.random()*6) + 1;
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
	
	/**
	 * Returns the number used to identify the symbol on this JPanel. 
	 * @return the number used to identify the symbol on this JPanel. 
	 */
	public int getSymNum() {
		return symNum;
	}
	
	/**
	 * 
	 * @return the SymbolPanel associated with this game
	 */
	public SymbolPanel getSP() {
		return sp;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 		
		
		Graphics2D g2 = (Graphics2D) g;
		
		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;
		
		menu.setBounds((int)(150*ratioX), (int)(20*ratioY), (int)(100*ratioX), (int)(50*ratioY));
		back.setBounds((int)(25*ratioX), (int)(20*ratioY), (int)(100*ratioX), (int)(50*ratioY));
		
		
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		g2.setTransform(at);
		
		
		score.setBounds((int)(400*ratioX),(int)(20*ratioY),(int)(150*ratioX),(int)(30*ratioY));
		win.setBounds((int)((DRAWING_WIDTH / 2 - 250)*ratioX),(int)((DRAWING_HEIGHT / 2 - 50)*ratioY),(int)(500*ratioX),(int)(100*ratioY));
		if (showObjects) {
			g.drawImage(background, 0, 0, (int)(getWidth()), (int)(getHeight()), this);
			
			int sw = (int) (sym.SYMBOL_WIDTH*ratioX);
			int sh = (int) (sym.SYMBOL_WIDTH*ratioY);
			
			sym.draw(g2, sym.getImage(), (int)sym.getX(), (int)sym.getY(), sw, sh, this);
			
			int pw = (int) (plane.PLANE_WIDTH*ratioX);
			int ph = (int) (plane.PLANE_HEIGHT*ratioY);
			
			plane.draw(g2, plane.getImage(), (int)plane.getX(), (int) plane.getY(), pw, ph, this);
		
			
			for (Helicopter heli : obstacles) {
				
				int hw = (int) (heli.COPTER_WIDTH*ratioX);
				int hh = (int) (heli.COPTER_HEIGHT*ratioY);

				heli.draw(g2, heli.getImage(), (int)heli.getX(), (int) heli.getY(), hw, hh, this);
			}	
		}
		
		if(c.getWon(2)) {
			g.drawImage(winImage, 0, 0, getWidth(), getHeight(), this);
			score.setForeground(Color.BLACK);
		} 
		
		if(lost) {
			g.drawImage(getLoseImage(), 0, 0, DRAWING_WIDTH, DRAWING_HEIGHT, this);
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
		if (src == back) {
			if (c.getOver()) {
				c.changePanel("4");
			}
			c.changePanel("11");
		}
		else if (src == menu) {
			if (c.getOver()) {
				c.changePanel("4");
			}
			c.changePanel("3");
		}
	}
	
	/**
	 * Displays the game on the screen, handles score, winning/losing, and ends it when needed.
	 */
	public void act() {
		remove(win);
		lost = false;
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
	 	    	lost = true;
	 	    	score.setForeground(Color.BLACK);
	 	    	win.setForeground(Color.RED);
	 	    	win.setLocation(DRAWING_WIDTH / 2 - 250, DRAWING_HEIGHT / 2 - 50);
	 	    	win.setSize(750,100);
	 	    	win.setText("YOU LOSE");
	 	    	add(win);
	 	    	sp.setScore(0);
	 	    	sp.getScoreLabel().setText("Score: " + sp.getScore());
	 	    	initializeObstacles();
	 	    	break;
	 	    } else if (correct == 1) {
	 	    	sp.setScore(sp.getScore()+10);
	    		sp.getScoreLabel().setText("Score: " + sp.getScore());
	 	    	score.setText("Score: " + sp.getScore());
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
	    		sp.setScore(sp.getScore()+10);
	    		sp.getScoreLabel().setText("Score: " + sp.getScore());
	 	    	score.setText("Score: " + sp.getScore());
	 	    }
	    	
	 	    else if (sp.getCorrect() == 0) {
	 	    	c.changePanel("12");
	 	    	lost = true;
	 	    	setBackground(Color.WHITE);
	 	    	score.setForeground(Color.BLACK);
	 	    	win.setForeground(Color.RED);
	 	    	win.setLocation(DRAWING_WIDTH / 2 - 250, DRAWING_HEIGHT / 2 - 50);
	 	    	win.setSize(400,100);
	 	    	win.setText("YOU LOSE");
	 	    	lost = true;
	 	    	add(win);
	 	    	sp.setScore(0);
	 	    	sp.getScoreLabel().setText("Score: " + sp.getScore());
	 	    	initializeObstacles();
	 	    	break;
	 	    }
	    	sp.setCorrect();
	    	if (sp.getScore() == 200) {
	    		c.changePanel("12");
	    		showObjects = false;
	    		setBackground(Color.WHITE);
	    		score.setForeground(Color.BLACK);
	 	    	win.setForeground(Color.BLACK);
	    		win.setVisible(true);
	 		    win.setText("YOU WIN");
	 		    add(win);
 	    		c.setWon(2);
 	    		break;
	    	}
	    	initializeObstacles();
		} while (sp.getScore() > 0);
		sp.setCorrect();
	}
}