package button;

import activities.ActivityAbs;

public class ConfirmButton extends ButtonAbs {
		
	public ConfirmButton(ActivityAbs activity, int x, int y) {
		this.setAcivity(activity);
		this.xPos = x;
		this.yPos = y;
		myButton();
	}
	
	@Override
	public void myButton() {
		this.buttonWidth = 150;
		this.buttonHeight = 40;	
		this.isMouseOnButton = false;		
	}
}
