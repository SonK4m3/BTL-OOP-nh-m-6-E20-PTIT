package button;

import activities.*;

public class SaveButton extends SwitchActivityButton{

	public SaveButton(ActivityAbs activity, int xPos, int yPos) {
		super(activity, xPos, yPos);
	}
	
	
	public void save(int theme, int size, int air, int board) {
		this.getActivity().getScreen().setTheme(theme);
		this.getActivity().getScreen().setGameSize(size);
		this.getActivity().getScreen().setAircraftType(air);
		this.getActivity().getScreen().setBoardType(board);
	}
}
