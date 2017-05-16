package Brain.TemporalLobe;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import Brain.Lobe;


public class Temporal extends JPanel implements MouseListener {
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	ArrayList<NeighborhoodObject> nObjects;
	private Image background;
	
	public Temporal() {
		nObjects = new ArrayList<NeighborhoodObject>();
	}
	
	private void initializeNObjects() {
		
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {

	}

}
