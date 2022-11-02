package button;

import activities.*;

public class SaveButton extends SwitchActivityButton{

	public SaveButton(ActivityAbs activity, int xPos, int yPos) {
		super(activity, xPos, yPos);
	}
	
	@Override
	public void action() {
		super.action();
		this.getActivity().setSize(1280, 720);
	}
}
