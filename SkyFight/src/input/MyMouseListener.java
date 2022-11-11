package input;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import frame.Screen;


public class MyMouseListener implements MouseListener{
	
	private Screen myScreen;
	
	boolean oneClicked = false;
	
	public MyMouseListener(Screen myScreen) {
		this.myScreen = myScreen;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1 && !oneClicked) {
			//1. get position pressed mouse
			// pointerInfor - panel
			int xPressedMouse = MouseInfo.getPointerInfo().getLocation().x - myScreen.getContentPane().getLocationOnScreen().x;
			int yPressedMouse = MouseInfo.getPointerInfo().getLocation().y - myScreen.getContentPane().getLocationOnScreen().y;
			
			myScreen.setMousePosition(xPressedMouse, yPressedMouse);
			myScreen.setIsPressedMouse(MouseState.LEFTPRESSED);
			//2. set position to gameControl
			//debug
			// print position pressed mouse
//			System.out.println(xPressedMouse + " " + yPressedMouse);	
			oneClicked = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(oneClicked) {	
			myScreen.setMousePosition(-1, -1);
			myScreen.setIsPressedMouse(MouseState.RELEASED);
			oneClicked = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		myScreen.setIsPressedMouse(MouseState.RELEASED);

	}

	@Override
	public void mouseExited(MouseEvent e) {
//		myScreen.setIsPressedMouse(MouseState.RELEASED);

	}

}
