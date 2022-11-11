package frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import activities.ActivityAbs;
import input.MouseState;
import input.MyMouseListener;

public abstract class ScreenAbs extends JFrame{
	int screenWidth = 200;
	int screenHeight = 200;
	
	protected int xMouse;
	protected int yMouse;
	
	protected MouseState mouseState;
	
	protected MyMouseListener myMouseListener;
	
	ActivityAbs currentActivity;
	
	//setter & getter
	public int getXMouse() {
		return xMouse;
	}

	public int getYMouse() {
		return yMouse;
	}
	
	public void setMousePosition(int x, int y) {
		this.xMouse = x;
		this.yMouse = y;
	}

	public void setIsPressedMouse(MouseState pressed) {
		this.mouseState = pressed;
	}

	public MouseState getMouseState() {
		return mouseState;
	}
	
	/*
	 * 	switch activity
	 * 	reset currentActivity
	 * 
	 */
	public void addActivity(ActivityAbs activity) {
		this.remove(this.currentActivity);
		this.add(activity, BorderLayout.CENTER);
		this.setSize(activity.getPreferredSize());
		this.revalidate();
		this.currentActivity = activity;
		currentActivity.setScreen(this);
	}
	
	public ActivityAbs getCurrentActivity() {
		return currentActivity;
	}
}
