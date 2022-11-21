package activities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import button.ButtonAbs;
import frame.*;

public abstract class ActivityAbs extends JPanel{
	
	public static int WIDTH1 = 960;
	public static int HEIGHT1 = 540;
	
	public static int WIDTH2 = 1280;
	public static int HEIGHT2 = 720;
	
	int xPos = 0;
	int yPos = 0;
	int activityWidth;
	int activityHeight;
		
	BufferedImage backgroundImage;
	
	protected Screen screen;
	
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
	
	public void setSize1() {
		this.activityWidth = WIDTH1;
		this.activityHeight = HEIGHT1;
		this.setPreferredSize(new Dimension(this.activityWidth, this.activityHeight));
		if(this.screen != null) {
			this.screen.setSize(WIDTH1, HEIGHT1);
			this.screen.centreWindow();
		}
	}
	
	public void setSize2() {
		this.activityWidth = WIDTH2;
		this.activityHeight = HEIGHT2;
		this.setPreferredSize(new Dimension(this.activityWidth, this.activityHeight));
		if(this.screen != null) {
			this.screen.setSize(WIDTH2, HEIGHT2);
			this.screen.centreWindow();			
		}
	}
	
	void setButtonSize(ButtonAbs button, int x, int y) {
		if(button != null) {
			button.setPos(x, y);
		}
	}
	
	public abstract void setTheme1();
	
	public abstract void setTheme2();
	
	public void setBackgroundImage(BufferedImage image) {
		this.backgroundImage = image;
	}
	/*
	 * return event of player in this activity
	 */
	public abstract int action(int xMouse, int yMouse);
	/*
	 * initial properties and components
	 */
	public abstract void myActivity();
	/*
	 * setup this panel
	 */
	public abstract void init();
	/*
	 * update image
	 */
	public abstract void update();
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(backgroundImage != null) {
			g.drawImage(backgroundImage, xPos, yPos, this.activityWidth, this.activityHeight, null);
		}
	}

}
