package button;

import activities.*;

public class DefaultButton extends ConfirmButton {
	
	OptionActivity optionActivity;
	
	public DefaultButton(ActivityAbs activity, int xPos, int yPos) {
		super(activity, yPos, yPos);
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