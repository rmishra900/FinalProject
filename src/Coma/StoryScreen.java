package Coma;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class StoryScreen extends JPanel implements MouseListener {
	private Coma c;
	private Image i1, i2, i3;
	
	public StoryScreen(Coma c) {
		super();
		this.c = c;
		setBackground(Color.WHITE);
		
		i1 = new ImageIcon("Rules1.jpg").getImage();
		i2 = new ImageIcon("Rules2.jpg").getImage();
		i3 = new ImageIcon("Rules3.jpg").getImage();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(new Font("Serif", 0, 25));
		g.drawString("Imagine getting in a car accident or slipping on the bathroom floor. The", 30, 50);
		g.drawString("next thing you know (but you actually do not) is that you have fallen into", 30, 75);
		g.drawString("a coma and have damaged your entire brain! This is a major problem", 30, 100);
		g.drawString("because you need your brain for basic abilities such as vision, hearing,", 30, 125);
		g.drawString("cognition, and perception. Your job is to navigate through the four lobes", 30, 150);
		g.drawString("of the brain: the frontal lobe, temporal lobe, occipital lobe, and parietal", 30, 175);
		g.drawString("lobe, all of which are responsible for basic human skills. You will activate", 30, 200);
		g.drawString("these areas by playing games that stimulate each lobe of the brain.", 30, 225);
		g.drawString("Ultimately, COMA strengthens your natural abilities through entertaining", 30, 250);
		g.drawString("mini games and engages your brain by providing an incentive to wake up", 30, 275);
		g.drawString("from a coma.", 30, 300);
		
		g.drawImage(i1, 50, 320, 150, 200, this);
		g.drawImage(i2, 300, 320, 150, 200, this);
		g.drawImage(i3, 550, 320, 150, 200, this);
		
		g.setColor(Color.WHITE);
		g.fillRoundRect(170, 330, 400, 50, 10, 10);
		g.setColor(Color.BLACK);
		g.drawRoundRect(170, 330, 400, 50, 10, 10);
		g.setFont(new Font("SansSerif", 3, 30));
		g.drawString("Click here to continue", 215, 360);
//        a coma and have damaged your entire brain! This is a major problem
//        because you need your brain for basic abilities such as vision, hearing,
//        cognition, and perception. Your job is to navigate through the four lobes of
//        the brain: the frontal lobe, temporal lobe, occipital lobe, and parietal lobe,
//        all of which are responsible for basic human skills. You will activate these
//        areas by playing games that stimulate each lobe of the brain. Ultimately, COMA
//        strengthens your natural abilities through entertaining mini games and engages
//        your brain by providing an incentive to wake up from a coma."", x, y);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		 
		if (e.getButton() == 1)
		{
			if(x >= 180 && x <= 580 && y >= 370 && y <= 420) {
				c.changePanel("3");
			}
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}