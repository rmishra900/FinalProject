package Brain.TemporalLobe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button implements ActionListener{
	private String text;
	private int x, y, w, h;
	private Sound s;
	private JButton b;
	
	public Button(String text, int x, int y, String filename) {
		this.text = text;
		this.x = x;
		this.y = y;
		s = new Sound(filename);
		w = 50;
		h = 50;
		b = new JButton();
		b.setText(text);
		b.setForeground(Color.BLACK);
		b.setFont(new Font("Roman Baseline", 0, 16));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		s.play();
	}

}
