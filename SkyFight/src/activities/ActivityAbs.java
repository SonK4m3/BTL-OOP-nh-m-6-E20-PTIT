package frame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public abstract class ActivityAbs extends JPanel{

	private static final long serialVersionUID = 1L;
	
	protected int activityWidth;
	protected int activityHeight;
	
	Screen screen;
	
	protected BufferedImage image;
	
	void setScreen(ScreenAbs screenAbs) {
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
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	public abstract int action(int xMouse, int yMouse);
}
