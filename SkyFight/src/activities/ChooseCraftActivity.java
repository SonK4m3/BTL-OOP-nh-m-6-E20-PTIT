package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import button.*;
import input.MouseState;
import notification.*;

public class ChooseCraftActivity extends PlayActivity {
	ConfirmButton backButton;
	ConfirmButton flyButton;
	ConfirmButton resetButton;
	
	int[] posBackButton = new int[] {714, 389};
	int[] posFlyButton = new int[] {714, 321};
	int[] posResetButton = new int[] {516, 321};
	
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
		backButton = new ConfirmButton(this, posBackButton[0], posBackButton[1]);
		flyButton = new ConfirmButton(this, posFlyButton[0], posFlyButton[1]);
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
		
		posBackButton = new int[] {714, 389};
		posFlyButton = new int[] {714, 321};
		posResetButton = new int[] {516, 321};
		
		if(gameNotificationHelper != null) {
			gameNotificationHelper.setPosSize(posMessage[0], posMessage[1] + 20, posMessage[2], posMessage[3]/5);
			gameNotificationHelper.setNumberMessage(4);
		}
		
		resetButton();
	}
	
	@Override
	public void setSize2() {
		super.setSize2();
		
		posBackButton = new int[] {977, 543};
		posFlyButton = new int[] {977,475};
		posResetButton = new int[] {677, 474};
		
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
			// back to home activity
//			System.out.println("Back to Home Activity");
			return 1;
		} 
		else if(flyButton.isPressed(xMouse, yMouse) && this.screen.getMouseState() == MouseState.LEFTPRESSED) {
			// go to fight activity
			if(gameController.twoPlayerIsCompletePlaced()) {
				gameController.changeTurn();
				// show player turn
				gameNotificationHelper.setHeadMessage("---- " + gameController.getCurrentPlayer().getPlayerName() + " turn ----");
				return 2;				
			} else {
				gameNotificationHelper.addNotice("Incompleted place");
			}
		}
		else if(resetButton.isPressed(xMouse, yMouse) && this.screen.getMouseState() == MouseState.LEFTPRESSED) {
			// reset aircraft player
			gameController.playerResetAllAircraft();
			String notice = gameController.getCurrentPlayer().getPlayerName() + " reset all ACs";
			gameNotificationHelper.addNotice(notice);				
		}
		else if(changePlayerButton.isPressed(xMouse, yMouse) && this.screen.getMouseState() == MouseState.LEFTPRESSED) {
			// change player phrase
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
			} else {
				gameNotificationHelper.addNotice(gameController.getCurrentPlayer().getPlayerName() + " not enough ACs");
			}
		}
		else {
			// place aircraft
			if(gameController != null) {
				String action_notify = gameController.playerPlaceAircraft(xMouse, yMouse, this.screen.getMouseState());
				if(action_notify != null) {
					String notice = gameController.getCurrentPlayer().getPlayerName() + " " + action_notify;
					gameNotificationHelper.addNotice(notice);					
				}
			}
		}
		
		return -1;
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
		
		// if gameController != null
		if(this.screen.getGameSize() == 1)
			gameController.getCurrentPlayer().paint1(g);
		else
			gameController.getCurrentPlayer().paint2(g);
		
		gameController.getCurrentPlayerBoard().paint(g);
		gameController.getCurrentPlayer().paintAircraft(g);
		
		Graphics2D g2 = (Graphics2D) g;
		// draw index of board
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Monospaced", Font.BOLD, 25));
                
        g2.setColor(Color.gray);
		for(int i = 0; i < 10; i++) {
			g2.drawString(Integer.toString(i + 1), posBoard[0] - 30, posBoard[1] + 23 + i * 31);			
		}
		for(int i = 0; i < 10; i++) {
			g2.drawString(Integer.toString(i + 1), posBoard[0] + 6 + i * 31, posBoard[1] + 25 + 310);			
		}
	}

}
