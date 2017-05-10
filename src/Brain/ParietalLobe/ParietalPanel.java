
package Brain.ParietalLobe;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ParietalPanel extends JPanel implements KeyListener {
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private Wall w;
	private ArrayList<Shape> s;
	
	public ParietalPanel() {
		w = new Wall();
		s = new ArrayList<Shape>();
		setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		w.draw(g);
		System.out.println("x");
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			System.out.println("x");
			w.act(1);
		}
		else if (code == KeyEvent.VK_DOWN) {
			System.out.println("y");
			w.act(-1);
		}
  
		repaint();
	}


	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
