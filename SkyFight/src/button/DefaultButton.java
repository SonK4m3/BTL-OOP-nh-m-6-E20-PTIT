package button;

import activities.*;

public class DefaultButton extends ButtonAbs {
	
	OptionActivity optionActivity;
	
	public DefaultButton(ActivityAbs activity, int xPos, int yPos) {
		this.setAcivity(activity);
		this.xPos = xPos;
		this.yPos = yPos;
		this.myButton();
		this.optionActivity = (OptionActivity) this.getActivity();
	}
	
	public void setDefault() {
		this.optionActivity.resetting();
	}

	@Override
	public void myButton() {
		this.buttonWidth = 150;
		this.buttonHeight = 40;	
		this.isMouseOnButton = false;		
	}
}