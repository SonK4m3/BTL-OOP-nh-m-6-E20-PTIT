package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import button.*;
import control.GameController;
import input.MouseState;
import notification.*;

public class ChooseCraftActivity extends ActivityAbs {
	SwitchActivityButton backButton;
	SwitchActivityButton flyButton;
	ConfirmButton resetButton;
	ConfirmButton backPlayerButton;
	
	int[] rec1 = new int[] {65, 40, 830, 415};
	int[] boardLayout = new int[] {65, 40, 415, 415};
	int[] posBoard = new int[] {122, 93};
	int[] posMessage = new int[] {514, 86, 350, 200};
	int[] posBackButton = new int[] {714, 389};
	int[] posFlyButton = new int[] {714, 321};
	int[] posResetButton = new int[] {516, 321};
	int[] posBackPlayerButton = new int[] {516, 389};
	
	Color rec1Color = new Color(117,213,227);
	Color boardLayoutColor = new Color(250,252,144);
	
	GameController gameController;
	public GameNotificationHelper gameNotificationHelper;
	
	public ChooseCraftActivity() {
		this.myActivity();
		this.init();	
	}
	
	@Override
	public void myActivity() {
		this.setSize1();
	}
	
	@Override
	public void init() {
		this.setPreferredSize(new Dimension(activityWidth, activityHeight));
		this.setBackground(new Color(255,255,255));			
		backButton = new SwitchActivityButton(this, posBackButton[0], posBackButton[1]);
		flyButton = new SwitchActivityButton(this, posFlyButton[0], posFlyButton[1]);
		resetButton = new ConfirmButton(this, posResetButton[0], posResetButton[1]);
		backPlayerButton = new ConfirmButton(this, posBackPlayerButton[0], posBackPlayerButton[1]);
		
		gameNotificationHelper = new GameNotificationHelper();
		gameNotificationHelper.setPosSize(posMessage[0], posMessage[1] + 20, posMessage[2], posMessage[3]/5);
	}

	@Override
	public void update() {
		this.backgroundImage = this.screen.getImageController().blueSkyImage; 
		backButton.setImage(this.screen.getImageController().backButtonImage);
		flyButton.setImage(this.screen.getImageController().flyButtonImage);
		resetButton.setImage(this.screen.getImageController().resetButtonImage);
		backPlayerButton.setImage(this.screen.getImageController().backPlayerButtonImage);
	}
	
	@Override
	public void setSize1() {
		super.setSize1();
		rec1 = new int[] {65, 40, 830, 415};
		boardLayout = new int[] {65, 40, 415, 415};
		posBoard = new int[] {122, 93};
		posMessage = new int[] {514, 86, 350, 200};
		posBackButton = new int[] {714, 389};
		posFlyButton = new int[] {714, 321};
		posResetButton = new int[] {516, 321};
		posBackPlayerButton = new int[] {515, 389};
		
		if(gameNotificationHelper != null) {
			gameNotificationHelper.setPosSize(posMessage[0], posMessage[1] + 20, posMessage[2], posMessage[3]/5);
			gameNotificationHelper.setNumberMessage(4);
		}
		resetButton();
	}
	
	@Override
	public void setSize2() {
		super.setSize2();
		rec1 = new int[] {115, 86, 1050, 520};
		boardLayout = new int[] {190, 121, 450, 450};
		posBoard = new int[] {260, 191};
		posMessage = new int[] {677, 146, 450, 300};
		posBackButton = new int[] {977, 543};
		posFlyButton = new int[] {977,475};
		posResetButton = new int[] {677, 474};
		posBackPlayerButton = new int[] {677, 543};
		
		if(gameNotificationHelper != null) {
			gameNotificationHelper.setPosSize(posMessage[0], posMessage[1] + 30, posMessage[2] - 1, posMessage[3]/6);
			gameNotificationHelper.setNumberMessage(5);
		}
		resetButton();
	}
	
	void resetButton() {
		setButtonSize(backButton, posBackButton[0], posBackButton[1]);
		setButtonSize(flyButton, posFlyButton[0], posFlyButton[1]);
		setButtonSize(resetButton, posResetButton[0], posResetButton[1]);
		setButtonSize(backPlayerButton, posBackPlayerButton[0], posBackPlayerButton[1]);
	}
	
	@Override
	public void setTheme1() {
		this.backgroundImage = this.screen.getImageController().blueSkyImage; 
		rec1Color = new Color(117,213,227);
		boardLayoutColor = new Color(250,252,144);
		this.gameNotificationHelper.setTheme1();
	}

	@Override
	public void setTheme2() {
		this.backgroundImage = this.screen.getImageController().nightSkyImage; 
		rec1Color = new Color(72,52,117);
		boardLayoutColor = new Color(36,40,70);
		this.gameNotificationHelper.setTheme2();
	}
	
	@Override
	public int action(int xMouse, int yMouse) {
		if(backButton.isPressed(xMouse, yMouse) && this.screen.getMouseState() == MouseState.LEFTPRESSED) {
			System.out.println("Back to Home Activity");
			return 3;
		} else {
			if(gameController != null) {
				gameController.playerPlaceAircraft(xMouse, yMouse);
			}
		}
		// if ....
		
		return -1;
	}
	
	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(rec1Color);
		g.fillRect(rec1[0], rec1[1], rec1[2], rec1[3]);
		
		g.setColor(boardLayoutColor);
		g.fillRect(boardLayout[0],boardLayout[1],boardLayout[2],boardLayout[3]);
		
		g.setColor(Color.gray);
		g.fillRect(posMessage[0], posMessage[1], posMessage[2], posMessage[3]);
		
		gameNotificationHelper.paint(g);
		
		backButton.paint(g);
		flyButton.paint(g);
		resetButton.paint(g);
		
		// paint neu p1 da dat xong va den p2
		backPlayerButton.paint(g);
		// if gameController != null
		gameController.getCurrentPlayerBoard().paint(g);
		gameController.getCurrentPlayer().paintAircraft(g);
	}

}
