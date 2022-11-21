package button;

import activities.ActivityAbs;

public class QuitButton extends ConfirmButton {
	public QuitButton(ActivityAbs activity, int xPos, int yPos) {
		super(activity, xPos, yPos);
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