package Coma;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents the screen displayed when the game is over. 
 * @version 5/15/2017
 *
 */
public class GameOver extends JPanel implements KeyListener{
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private Rectangle screenRect;
	
	private Coma c;
	private JButton home;
	private Image background;
	private JLabel gameOver;
	private JLabel text;
	
	public GameOver(Coma c) {
		super();
		this.c = c;
		setLayout(null);
		background = new ImageIcon("coma" + System.getProperty("file.separator") + "comaBackground.jpg").getImage();
		gameOver = new JLabel("GAME OVER");
		gameOver.setFont(new Font("Roman Baseline", 3, 100));
		gameOver.setVisible(true);
		setBackground(Color.WHITE);
		gameOver.setForeground(Color.WHITE);
		add(gameOver);
		
		text = new JLabel();
		text.setLocation(0, 500);
		text.setSize(800, 50);
		text.setFont(new Font("Roman Baseline", 1, 25));
		text.setForeground(Color.WHITE);
		text.setHorizontalAlignment(0);
		text.setText("<html>Congratulations! You've unlocked all four lobes of your brain!<br> You are out of your coma!<br> Now, you can"
				+ "enjoy life!</html>");
		add(text);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); 


		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;
		        
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		g2.setTransform(at);
	}
	  
	public void endGame() {
		//c.changePanel("3");
		repaint();
		add(gameOver);
	}
	
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			c.changePanel("1");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}