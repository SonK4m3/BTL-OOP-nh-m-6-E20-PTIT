package button;

import activities.ActivityAbs;

public class ConfirmButton extends ButtonAbs implements ButtonImp{
	
	// Class Activity ac
	
	public ConfirmButton(ActivityAbs activity, int x, int y) {
		this.setAcivity(activity);
		this.xPos = x;
		this.yPos = y;
		myButton();
		//ac = (Class Activity) activity;
	}
	@Override
	public void myButton() {
		this.buttonWidth = 150;
		this.buttonHeight = 40;	
		this.isMouseOnButton = false;		
	}

	/*
	 * co the dung tiep ham nay hoac tao ham moi
	 */
	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}
}
