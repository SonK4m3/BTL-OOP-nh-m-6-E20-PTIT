package button;

import javax.swing.JLabel;

import frame.ActivityAbs;

public abstract class ButtonAbs extends JLabel{
	
	private ActivityAbs activity;
	
	protected int xPos;
	protected int yPos;
	protected int buttonWidth;
	protected int buttonHeight;
	protected boolean isMouseOnButton;
	
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
	
	public boolean isPressed(int xPos, int yPos) {
		if(xPos >= this.xPos && xPos <= (this.xPos + this.buttonWidth) && 
				yPos >= this.yPos && yPos <= (this.yPos + this.buttonHeight)) {
			return true;
		}
		return false;
	}
	
	protected void setAcivity(ActivityAbs newActivity) {
		this.activity = newActivity;
	}
	
	protected ActivityAbs getActivity() {
		return this.activity;
	}
}
