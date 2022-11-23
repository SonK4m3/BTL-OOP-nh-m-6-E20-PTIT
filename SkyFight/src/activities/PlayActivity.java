package activities;

import java.awt.Color;

import button.ConfirmButton;
import control.GameController;
import notification.GameNotificationHelper;

public abstract class PlayActivity extends ActivityAbs{
	ConfirmButton changePlayerButton;
	GameController gameController;
	public GameNotificationHelper gameNotificationHelper;
	
	boolean displayButton = false;
	
	int[] rec1 = new int[] {65, 40, 830, 415};
	int[] boardLayout = new int[] {65, 40, 415, 415};
	int[] posBoard = new int[] {122, 93};
	int[] posMessage = new int[] {514, 86, 350, 200};
	int[] posChangePlayerButton = new int[] {516, 389};
	
	Color rec1Color = new Color(117,213,227);
	Color boardLayoutColor = new Color(250,252,144);
	
	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}
	
	@Override
	public void setSize1() {
		super.setSize1();
		rec1 = new int[] {65, 40, 830, 415};
		boardLayout = new int[] {65, 40, 415, 415};
		posBoard = new int[] {122, 93};
		posMessage = new int[] {514, 86, 350, 200};
		posChangePlayerButton = new int[] {515, 389};
	}
	
	@Override
	public void setSize2() {
		super.setSize2();
		rec1 = new int[] {115, 86, 1050, 520};
		boardLayout = new int[] {190, 121, 450, 450};
		posBoard = new int[] {260, 191};
		posMessage = new int[] {677, 146, 450, 300};
		posChangePlayerButton = new int[] {677, 543};
	}
	
}
