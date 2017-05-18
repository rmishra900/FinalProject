package Brain.TemporalLobe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

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
		b.setLayout(null);
		b.setText(text);
		b.setForeground(Color.BLACK);
		b.setFont(new Font("Roman Baseline", 0, 16));
		b.setBounds(x, y, w, h);
		b.addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		s.play();
	}
	
	public void setSound(String filename) {
		s = new Sound(filename);
	}
	
	public void setSound(Sound sound) {
		s = sound;
	}
	
	public Sound getSound() {
		return s;
	}
	
	public String getSoundFilename() {
		return s.getFilename();
	}
	
	public int getWidth() {
		return w;
	}
	public void setWidth(int width) {
		w = width;
	}
	
	public int getHeight() {
		return h;
	}
	
	public void setHeight(int height) {
		h = height;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int xcoord) {
		x = xcoord;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int ycoord) {
		y = ycoord;
	}
	
	public void setText(String t) {
		text = t;
		b.setText(t);
	}
	
	public String getText() {
		return text;
	}
	
	public JButton getJButton() {
		return b;
	}
	
	public void setJButton(JButton b) {
		this.b = b;
	}
	

}
