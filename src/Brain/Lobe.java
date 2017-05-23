package Brain;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Lobe extends JPanel implements ActionListener{
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private JButton menu, back;
	private Image winImage, loseImage;
	private JPanel mainPanel;
	
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
		
		//add(mainPanel);
		 
		add(back);
		back.addActionListener(this);
		add(menu);
		menu.addActionListener(this);
		
		winImage = new ImageIcon("youWin.gif").getImage();
		loseImage = new ImageIcon("Loser.png").getImage();
	}
	
	public boolean isMenuPressed() {
		if(menu.getModel().isPressed()) {
			//System.out.println("true");
			return true;
		}
		
		else {
			//System.out.println("false");
			return false;
		}
	}
	
	public JButton getMenu() {
		return menu;
	}
	
	public JButton getBack() {
		return back;
	}
	
	
	public Image getWinImage() {
		return winImage;
	}
	
	public Image getLoseImage() {
		return loseImage;
	}
	
	public int getMenuX() {
		return menu.getX();
	}
	
	public int getMenuY() {
		return menu.getY();
	}
	
	public int getMenuWidth() {
		return menu.getWidth();
	}
	
	public int getMenuHeight() {
		return menu.getHeight();
	}
	
	public int getBackX() {
		return back.getX();
	}
	
	public int getBackY() {
		return back.getY();
	}
	
	public int getBackWidth() {
		return back.getWidth();
	}
	
	public int getBackHeight() {
		return back.getHeight();
	}
	
}
