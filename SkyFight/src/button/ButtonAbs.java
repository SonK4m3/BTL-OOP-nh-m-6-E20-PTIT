package button;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import activities.ActivityAbs;

public abstract class ButtonAbs extends JLabel{
	
	protected int xPos;
	protected int yPos;
	protected int buttonWidth;
	protected int buttonHeight;
	protected boolean isMouseOnButton;
	
	BufferedImage buttonImage = null;
	
	private ActivityAbs activity;
	
	public void setPos(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	/*
	 * initial properties of this button
	 */
	abstract void myButton();
	/*
	 * click button and action
	 */
	public void action() {
		System.out.println("this button");
	};
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getButtonWidth() {
		return buttonWidth;
	}
	
	public int getButtonHeight() {
		return buttonHeight;
	}
	
	public void setImage(BufferedImage image){
		this.buttonImage = image;
	}
	
	protected void setAcivity(ActivityAbs newActivity) {
		this.activity = newActivity;
	}
	
	protected ActivityAbs getActivity() {
		return this.activity;
	}
	/*
	 * check button is pressed
	 */
	public boolean isPressed(int xPos, int yPos) {
		if(xPos >= this.xPos && xPos <= (this.xPos + this.buttonWidth) && 
				yPos >= this.yPos && yPos <= (this.yPos + this.buttonHeight)) {
			return true;
		}
		return false;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(buttonImage != null)
			g.drawImage(buttonImage, xPos, yPos, null);
	}
}
