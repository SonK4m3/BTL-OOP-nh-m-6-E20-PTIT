package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import button.ConfirmButton;
import control.AudioController;
import figure.OxyCoor;
import notification.GameNotificationHelper;

public class FightActivity extends PlayActivity {
	ConfirmButton backButton;
	ConfirmButton changePlayerButton;

	BufferedImage hitHeadImage;
	BufferedImage hitImage;
	BufferedImage missImage;

	Roll label = new Roll(this, 230, 123);
	PauseRoll pause = new PauseRoll(this, 230, 123);
	
	boolean isGameFinished = false;
	boolean isClickedBackButton = false;
		
	int[] posBackButton = new int[] {714, 389};
	AudioController audioController = new AudioController();
	Color rec1Color = new Color(117,213,227);
	Color boardLayoutColor = new Color(250,252,144);
	
	public FightActivity() {
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
		changePlayerButton = new ConfirmButton(this, posChangePlayerButton[0], posChangePlayerButton[1]);

		gameNotificationHelper = new GameNotificationHelper();
		gameNotificationHelper.setPosSize(posMessage[0], posMessage[1] + 20, posMessage[2], posMessage[3]/5);
	}

	@Override
	public void update() {
		this.backgroundImage = this.screen.getImageController().blueSkyImage; 
		backButton.setImage(this.screen.getImageController().backButtonImage);
		changePlayerButton.setImage(this.screen.getImageController().nextPlayerButtonImage);

		hitHeadImage = this.screen.getImageController().headShootImage;
		hitImage = this.screen.getImageController().partShootImage;
		missImage = this.screen.getImageController().missShootImage;
		
		label.update();
		pause.update();
	}
	
	@Override
	public void setSize1() {
		super.setSize1();
		
		posBackButton = new int[] {714, 389};
		posChangePlayerButton = new int[] {515, 389};

		if(gameNotificationHelper != null) {
			gameNotificationHelper.setPosSize(posMessage[0], posMessage[1] + 20, posMessage[2], posMessage[3]/5);
			gameNotificationHelper.setNumberMessage(4);
			gameNotificationHelper.setPosHeadMessage1();
		}
		
		label.setPosSize1();
		pause.setPosSize1();
		resetButton();
	}
	
//	@Override
	public void setSize2() {
		super.setSize2();
		
		posBackButton = new int[] {977, 543};
		posChangePlayerButton = new int[] {677, 543};

		if(gameNotificationHelper != null) {
			System.out.println(posMessage[0]);
			gameNotificationHelper.setPosSize(posMessage[0], posMessage[1] + 30, posMessage[2] - 1, posMessage[3]/6);
			gameNotificationHelper.setNumberMessage(5);
			gameNotificationHelper.setPosHeadMessage2();
		}
		
		label.setPosSize2();
		pause.setPosSize2();
		resetButton();
	}
	
	void resetButton() {
		setButtonSize(backButton, posBackButton[0], posBackButton[1]);
		setButtonSize(changePlayerButton, posChangePlayerButton[0], posChangePlayerButton[1]);
	}
	
	@Override
	public void setTheme1() {
		this.backgroundImage = this.screen.getImageController().blueSkyImage; 
		rec1Color = new Color(117,213,227);
		boardLayoutColor = new Color(250,252,144);
		this.gameNotificationHelper.setTheme1();
		label.setTheme1();
		pause.setTheme1();
	}

	@Override
	public void setTheme2() {
		this.backgroundImage = this.screen.getImageController().nightSkyImage; 
		rec1Color = new Color(72,52,117);
		boardLayoutColor = new Color(36,40,70);
		this.gameNotificationHelper.setTheme2();
		label.setTheme2();
		pause.setTheme2();
	}
	
	@Override
	public int action(int xMouse, int yMouse) {
		// win game roll
		if(isGameFinished) {
			return label.action(xMouse, yMouse);
		}
		// pause game roll
		if(isClickedBackButton) {
			return pause.action(xMouse, yMouse);
		}
		
		if(backButton.isPressed(xMouse, yMouse) && this.screen.mouseStateIsLeftPressed()) {
			if(!isClickedBackButton) {
				isClickedBackButton = true;
			}
		} 
		else if(changePlayerButton.isPressed(xMouse, yMouse) && this.screen.mouseStateIsLeftPressed()) {
			// change player phrase
			gameController.changeTurn();
			if(!displayButton) {
				changePlayerButton.setImage(this.screen.getImageController().nextPlayerButtonImage);				
				displayButton = true;
			}
			else {
				changePlayerButton.setImage(this.screen.getImageController().backPlayerButtonImage);
				displayButton = false;
			}
		}
		else {		
			// player shoot
			String notify = gameController.shootingStage(xMouse, yMouse, gameController.getCurrentPlayer());
			if(notify != null) {
				gameNotificationHelper.addNotice(notify);			
				this.displayHeadMessage();
			} else {
				audioController.playError();
				gameNotificationHelper.addNotice("is not your turn");
			}		
		}
		
		return -1;
	}
	
	public String winnerName() {
		return gameController.getwinner().getPlayerName();
	}
	
	public void setLabel(boolean bool) {
		this.isGameFinished = bool;
	}
	
	public boolean isLabelOn() {
		return this.isGameFinished;
	}
	
	public void setIsClickedBackButton(boolean bool) {
		this.isClickedBackButton = bool;
	}
	
	public boolean getIsClickedBackButton() {
		return this.isClickedBackButton;
	}
	
	public void displayHeadMessage() {
		gameNotificationHelper.setHeadMessage("---- " + gameController.getPlayerIsShooting().getPlayerName() + " turn ----");
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
		changePlayerButton.paint(g);
		// draw turn player notification
		if(this.screen.getGameSize() == 1)
			gameController.getCurrentPlayer().paint1(g);
		else
			gameController.getCurrentPlayer().paint2(g);
		// draw board
		gameController.getWaitingPlayerBoard().paint(g);
		for(int i = 0; i < 10; i ++) {
			for(int j = 0; j < 10; j++) {
				// draw cell state
				if(gameController.getWaitingPlayerBoard().getMatrix()[i][j].isShooted()) {
					OxyCoor xy = gameController.getWaitingPlayerBoard().convertCellToPixel(
							gameController.getWaitingPlayerBoard().getX(), 
							gameController.getWaitingPlayerBoard().getY(), 
							gameController.getWaitingPlayerBoard().getMatrix()[i][j]);
					if(gameController.getWaitingPlayerBoard().getMatrix()[i][j].stateIsMiss())
						g.drawImage(missImage, xy.getX(), xy.getY(),null);
					else if(gameController.getWaitingPlayerBoard().getMatrix()[i][j].stateIsPart())
						g.drawImage(hitImage, xy.getX(), xy.getY(),null);
					else if(gameController.getWaitingPlayerBoard().getMatrix()[i][j].stateIsHead())
						g.drawImage(hitHeadImage, xy.getX(), xy.getY(),null);
				}
			}
		}
		Graphics2D g2 = (Graphics2D) g;
		
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Monospaced", Font.BOLD, 25));
                
        g2.setColor(Color.gray);
        // draw index of board
		for(int i = 0; i < 10; i++) {
			g2.drawString(Integer.toString(i + 1), posBoard[0] - 30, posBoard[1] + 23 + i * 31);			
		}
		for(int i = 0; i < 10; i++) {
			g2.drawString(Integer.toString(i + 1), posBoard[0] + 6 + i * 31, posBoard[1] + 25 + 310);			
		}
		// draw win game roll
		if(isGameFinished) {
			label.paint(g);
		}
		// draw pause game
		if(isClickedBackButton) {
			pause.paint(g);
		}
	}

}
