package Brain;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Lobe extends JPanel implements ActionListener{
	private JButton menu, back;
	
	public Lobe() {
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
		
		add(back);
		back.addActionListener(this);
		add(menu);
		menu.addActionListener(this);
	}
	
	public boolean isMenuPressed() {
		if(menu.getModel().isPressed())
			return true;
		else
			return false;
	}
	
	public JButton getMenu() {
		return menu;
	}
	
	public JButton getBack() {
		return back;
	}
	
}
