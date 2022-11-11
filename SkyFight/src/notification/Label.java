package notification;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import activities.ActivityAbs;

public class Label extends JLabel{
	int x;
	int y;
	int width;
	int height;
	Color color;
	
	private ActivityAbs activity;
	
	public Label(ActivityAbs activity, int x, int y, int width, int height, Color color) {
		this.activity = activity;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.setBounds(x, y, width, height);
		this.setBackground(color);
		this.setOpaque(true);
		
		this.setHorizontalAlignment(JLabel.CENTER);
		this.activity.add(this);
		
	}
	
	public void addLabel(String text) {
		this.setText(text);
	}
}
