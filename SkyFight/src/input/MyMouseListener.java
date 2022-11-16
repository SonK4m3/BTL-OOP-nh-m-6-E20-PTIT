package input;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import frame.Screen;

public class MyMouseListener implements MouseListener{
	
	boolean oneClicked = false;
	
	private Screen myScreen;
	
	public MyMouseListener(Screen myScreen) {
		this.myScreen = myScreen;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//1. get position pressed mouse
		// pointerInfor - panel
		int xPressedMouse = MouseInfo.getPointerInfo().getLocation().x - myScreen.getContentPane().getLocationOnScreen().x;
		int yPressedMouse = MouseInfo.getPointerInfo().getLocation().y - myScreen.getContentPane().getLocationOnScreen().y;
		//2. set position to gameControl
		myScreen.setMousePosition(xPressedMouse, yPressedMouse);
		if(e.getButton() == MouseEvent.BUTTON1)
			myScreen.setIsPressedMouse(MouseState.LEFTPRESSED);
		else if(e.getButton() == MouseEvent.BUTTON3)
			myScreen.setIsPressedMouse(MouseState.RIGHTPRESSED);
		
		//debug
		// print position pressed mouse
//		System.out.println(xPressedMouse + " " + yPressedMouse);	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//reset mouse position and state
		myScreen.setMousePosition(-1, -1);
		myScreen.setIsPressedMouse(MouseState.RELEASED);
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
