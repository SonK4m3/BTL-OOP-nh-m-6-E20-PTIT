package frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import activities.ActivityAbs;
import input.MouseState;
import input.MyMouseListener;

public abstract class ScreenAbs extends JFrame{
	int xMouse;
	int yMouse;
	int screenWidth = 200;
	int screenHeight = 200;
	
	protected MouseState mouseState;
	protected MyMouseListener myMouseListener;
	protected ActivityAbs currentActivity;
	
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
	
	public boolean mouseStateIsLeftPressed() {
		return this.mouseState == MouseState.LEFTPRESSED;
	}
	
	public boolean mouseStateIsRightPressed() {
		return this.mouseState == MouseState.RIGHTPRESSED;
	}
	
	/*
	 * 	switch activity
	 * 	reset currentActivity
	 * 	move current activity and add new one
	 */
	public void addActivity(ActivityAbs activity) {
		this.remove(this.currentActivity);
		this.add(activity, BorderLayout.CENTER);
		this.setSize(activity.getPreferredSize());
		this.revalidate();
		this.currentActivity = activity;
	}
	
	public ActivityAbs getCurrentActivity() {
		return currentActivity;
	}
	
	/*
	 *  function to initial properties and components
	 */
	abstract void init();
	/*
	 * function to set up frame
	 */
	abstract void setUp();
}
