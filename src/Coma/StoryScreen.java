package Coma;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Represents the screen before the user plays the game to introduce the user to the objectives of the game. 
 * @author
 * @version 5/15/2017
 */
public class StoryScreen extends JPanel implements ActionListener {
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private Coma c;
	private Image comic1, comic2, comic3, comic4;
	private JButton home, menu;
	
	/**
	 * Constructs a new instance of a story screen.
	 * @param c the game that this story screen is for
	 */
	public StoryScreen(Coma c) {
		super();
		setLayout(null);
		this.c = c;
		setBackground(Color.WHITE);
		comic1 = (new ImageIcon("coma" + System.getProperty("file.separator") + "comic1.png")).getImage();
		comic2 = (new ImageIcon("coma" + System.getProperty("file.separator") + "comic2.png")).getImage();
		comic3 = (new ImageIcon("coma" + System.getProperty("file.separator") + "comic3.png")).getImage();
		comic4 = (new ImageIcon("coma" + System.getProperty("file.separator") + "comic4.png")).getImage();
		
		home = new JButton();
		home = new JButton("HOME");
		home.setBackground(Color.WHITE);
		home.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		home.setSize(100, 50);
		home.setLocation(25, 10);
		
		menu = new JButton();
		menu = new JButton("MENU");
		menu.setBackground(Color.WHITE);
		menu.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		menu.setSize(100, 50);
		menu.setLocation(DRAWING_WIDTH - 140, 10);
		
		add(home);
		home.addActionListener(this);
		add(menu);
		menu.addActionListener(this);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		g.drawImage(comic1, 0, 0, DRAWING_WIDTH / 2, DRAWING_HEIGHT / 2, this);
		g.drawImage(comic2, DRAWING_WIDTH / 2, 0, DRAWING_WIDTH / 2, DRAWING_HEIGHT / 2, this);
		g.drawImage(comic3, 0, DRAWING_HEIGHT / 2, DRAWING_WIDTH / 2, DRAWING_HEIGHT / 2, this);
		g.drawImage(comic4, DRAWING_WIDTH / 2, DRAWING_HEIGHT / 2, DRAWING_WIDTH / 2, DRAWING_HEIGHT / 2, this);
		
		g2.setTransform(at);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == home)
			c.changePanel("1");
		else if(src == menu)
			c.changePanel("3");
	}
}