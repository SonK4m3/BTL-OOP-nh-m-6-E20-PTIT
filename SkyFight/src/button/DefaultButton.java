package button;

import activities.*;

public class DefaultButton extends SwitchActivityButton{

	public DefaultButton(ActivityAbs activity, int xPos, int yPos) {
		super(activity, xPos, yPos);
	}

	@Override
	public void action() {
		super.action();
		this.getActivity().setSize(960, 540);
	}
}
