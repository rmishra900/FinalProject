package Brain;
import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class Lobe extends JPanel implements ActionListener{
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private JButton menu, back;
	private Image winImage, loseImage;
	private JPanel mainPanel;
	
	/**
	 * Constructs buttons and images that are in all classes that extend this class
	 */
	public Lobe() {
		
		mainPanel = new JPanel();
		
		menu = new JButton();
		menu = new JButton("MENU");
		menu.setBackground(Color.WHITE);
		menu.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		menu.setSize(100, 50);
		menu.setLocation(150, 20);
		
		back = new JButton("BACK");
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Roman Baseline", Font.BOLD, 20));
		back.setSize(100, 50);
		back.setLocation(25, 20);

		mainPanel.add(menu);
		mainPanel.add(back);
			 
		add(back);
		back.addActionListener(this);
		add(menu);
		menu.addActionListener(this);
		
		winImage = new ImageIcon("youWin.gif").getImage();
		loseImage = new ImageIcon("Loser.png").getImage();
	}
	

	/**
	 * Returns button that goes to menu screen when clicked
	 * @return Menu JButton
	 */
	public JButton getMenu() {
		return menu;
	}
	
	/**
	 * Returns back that goes to rules screen of that game
	 * @return Begin Jbutton
	 */
	public JButton getBack() {
		return back;
	}
	
	/**
	 * Returns image representing winning game
	 * @return Image for game when it is won
	 */
	public Image getWinImage() {
		return winImage;
	}
	
	/**
	 * Returns image representing losing game
	 * @return Image for game when it is lost
	 */
	public Image getLoseImage() {
		return loseImage;
	}
	
	/**
	 * Returns x coordinate of menu button
	 * @return x-coordinate of menu button
	 */
	public int getMenuX() {
		return menu.getX();
	}
	
	/**
	 * Returns y coordinate of menu button
	 * @return y-coordinate of menu button
	 */
	public int getMenuY() {
		return menu.getY();
	}
	
	/**
	 * Returns width of menu button
	 * @return width of menu button
	 */
	public int getMenuWidth() {
		return menu.getWidth();
	}
	
	/**
	 * Returns height of menu button
	 * @return height of menu button
	 */
	public int getMenuHeight() {
		return menu.getHeight();
	}
	
	/**
	 * Returns x coordinate of back button
	 * @return x-coordinate of back button
	 */
	public int getBackX() {
		return back.getX();
	}
	
	/**
	 * Returns y coordinate of back button
	 * @return y-coordinate of back button
	 */
	public int getBackY() {
		return back.getY();
	}
	
	/**
	 * Returns width of back button
	 * @return width of back button
	 */
	public int getBackWidth() {
		return back.getWidth();
	}
	
	/**
	 * Returns height of menu button
	 * @return height of menu button
	 */
	public int getBackHeight() {
		return back.getHeight();
	}
	
}
