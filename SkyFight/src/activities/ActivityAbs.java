package activities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import frame.*;

public abstract class ActivityAbs extends JPanel{

	private static final long serialVersionUID = 1L;
	
	protected int activityWidth;
	protected int activityHeight;
	
	Screen screen;
	
	protected BufferedImage image;
	
	public void setScreen(ScreenAbs screenAbs) {
		this.screen = (Screen) screenAbs;
	}
	
	public Screen getScreen() {
		return screen;
	}
	
	public int getActivityWidth() {
		return activityWidth;
	}
	
	public int getActivityHeight() {
		return activityHeight;
	}
	
	public void setSize(int width, int height) {
		this.activityWidth = width;
		this.activityHeight = height;
	}
	
	public void reSize(int width, int height) {
		this.setSize(width, height);
		this.setPreferredSize(new Dimension(this.activityWidth, this.activityHeight));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	public abstract int action(int xMouse, int yMouse);
}
