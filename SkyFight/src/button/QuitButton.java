package button;

import activities.ActivityAbs;

public class QuitButton extends ButtonAbs {
	public QuitButton(ActivityAbs activity, int xPos, int yPos) {
		this.setAcivity(activity);
		this.xPos = xPos;
		this.yPos = yPos;
		this.myButton();
	}
	
	@Override
	public void myButton() {
		this.buttonWidth = 150;
		this.buttonHeight = 40;
		this.isMouseOnButton = false;
	}

	@Override
	public void action() {		
		System.exit(0);
	}
}