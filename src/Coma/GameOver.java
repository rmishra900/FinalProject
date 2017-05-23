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
	
	/**
	 * Constructs a new instance of this game over screen. 
	 * @param c the game that this game over screen is for.
	 */
	public GameOver(Coma c) {
		super();
		this.c = c;
		setLayout(null);
		background = new ImageIcon("coma" + System.getProperty("file.separator") + "Full.png").getImage();
		gameOver = new JLabel("GAME OVER");
		gameOver.setFont(new Font("Roman Baseline", 3, 100));
		gameOver.setLocation(80, -50);
		gameOver.setSize(800,200);
		gameOver.setVisible(true);
		setBackground(Color.BLACK);
		gameOver.setForeground(Color.WHITE);
		add(gameOver);
		
		text = new JLabel();
		text.setLocation(100, 430);
		text.setSize(800, 200);
		text.setFont(new Font("Roman Baseline", 1, 25));
		text.setForeground(Color.WHITE);
		text.setText("<html><div style='text-align: center;'>"+"Congratulations! <br>You've unlocked all four lobes of your brain.<br> You are out of your coma.<br> Now, you can "
				+ "enjoy life!</div></html>");
		add(text);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); 


		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;
		        
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		g.drawImage(background, 200, 100, DRAWING_WIDTH / 2, DRAWING_HEIGHT - 250, this);
		
		gameOver.setBounds((int)(80*ratioX), (int)(-50*ratioY), (int)(800*ratioX), (int)(200*ratioX));
		text.setBounds((int)(100*ratioX), (int)(400*ratioY), (int)(800*ratioX), (int)(200*ratioY));
		
		g2.setTransform(at);
	}
	  
	/**
	 * Adds the words "Game Over" to this JPanel. 
	 */
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