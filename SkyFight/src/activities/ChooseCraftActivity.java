package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import button.*;
import control.GameController;
import input.MouseState;
import notification.*;
import player.PlayerState;

public class ChooseCraftActivity extends ActivityAbs {
	SwitchActivityButton backButton;
	SwitchActivityButton flyButton;
	ConfirmButton resetButton;
	ConfirmButton changePlayerButton;
	
	boolean displayButton = false;
	
	int[] rec1 = new int[] {65, 40, 830, 415};
	int[] boardLayout = new int[] {65, 40, 415, 415};
	int[] posBoard = new int[] {122, 93};
	int[] posMessage = new int[] {514, 86, 350, 200};
	int[] posBackButton = new int[] {714, 389};
	int[] posFlyButton = new int[] {714, 321};
	int[] posResetButton = new int[] {516, 321};
	int[] posChangePlayerButton = new int[] {516, 389};
	
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
		changePlayerButton = new ConfirmButton(this, posChangePlayerButton[0], posChangePlayerButton[1]);
		
		gameNotificationHelper = new GameNotificationHelper();
		gameNotificationHelper.setPosSize(posMessage[0], posMessage[1] + 20, posMessage[2], posMessage[3]/5);
	}

	@Override
	public void update() {
		this.backgroundImage = this.screen.getImageController().blueSkyImage; 
		backButton.setImage(this.screen.getImageController().backButtonImage);
		flyButton.setImage(this.screen.getImageController().flyButtonImage);
		resetButton.setImage(this.screen.getImageController().resetButtonImage);
		changePlayerButton.setImage(this.screen.getImageController().nextPlayerButtonImage);
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
		posChangePlayerButton = new int[] {515, 389};
		
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
		posChangePlayerButton = new int[] {677, 543};
		
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
		setButtonSize(changePlayerButton, posChangePlayerButton[0], posChangePlayerButton[1]);
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
			return 1;
		} 
		else if(flyButton.isPressed(xMouse, yMouse) && this.screen.getMouseState() == MouseState.LEFTPRESSED) {
			if(gameController.twoPlayerIsCompletePlaced()) {
//				System.out.println("2 Player fight");
				gameController.changeTurn();
				gameNotificationHelper.setHeadMessage("---- " + gameController.getCurrentPlayer().getPlayerName() + " turn ----");
				return 2;				
			} else {
				gameNotificationHelper.addNotice(gameController.getCurrentPlayer().getPlayerName() + " incompleted place");
			}
		}
		else if(resetButton.isPressed(xMouse, yMouse) && this.screen.getMouseState() == MouseState.LEFTPRESSED) {
			gameController.playerResetAllAircraft();
			String notice = gameController.getCurrentPlayer().getPlayerName() + " reset all ACs";
			gameNotificationHelper.addNotice(notice);				
//			System.out.println("reset aircraft");
		}
		else if(changePlayerButton.isPressed(xMouse, yMouse) && this.screen.getMouseState() == MouseState.LEFTPRESSED) {
			if(gameController.currentPlayerIsCompletedPlaced()) {
				gameController.changeTurn();
				if(!displayButton) {
					changePlayerButton.setImage(this.screen.getImageController().backPlayerButtonImage);				
					displayButton = true;
				}
				else {
					changePlayerButton.setImage(this.screen.getImageController().nextPlayerButtonImage);
					displayButton = false;
				}
//				gameNotificationHelper.initNotice();
//				gameNotificationHelper.addNotice(gameController.getCurrentPlayer().getPlayerName() + " " + "placing");

//				System.out.println("go, back");
			} else {
				gameNotificationHelper.addNotice(gameController.getCurrentPlayer().getPlayerName() + " incompleted place");
			}
		}
		else {
			if(gameController != null) {
				String action_notify = gameController.playerPlaceAircraft(xMouse, yMouse, this.screen.getMouseState());
//				System.out.println(gameController.getCurrentPlayerBoard().getX() + " " + gameController.getCurrentPlayerBoard().getY());
				if(action_notify != null) {
					String notice = gameController.getCurrentPlayer().getPlayerName() + " " + action_notify;
					gameNotificationHelper.addNotice(notice);					
				}
//				gameController.print();
//				gameController.getCurrentPlayer().getAircraft(1).print();
//				gameController.getCurrentPlayer().getAircraft(2).print();
			}
		}
		
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
		changePlayerButton.paint(g);			
		
		// paint neu p1 da dat xong va den p2
		// if gameController != null
		if(this.screen.getGameSize() == 1)
			gameController.getCurrentPlayer().paint1(g);
		else
			gameController.getCurrentPlayer().paint2(g);
		
		gameController.getCurrentPlayerBoard().paint(g);
		gameController.getCurrentPlayer().paintAircraft(g);
	}

}
