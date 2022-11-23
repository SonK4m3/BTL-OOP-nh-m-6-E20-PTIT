package activities;

import java.awt.Graphics;

import button.*;

public class PauseRoll extends RollActivity{
	ConfirmButton continueButton;
	ConfirmButton newGameButton;
	ConfirmButton homeButton;
		
	int[] posContinueButton = new int[] {405, 161}; 
	int[] posNewGameButton = new int[] {405, 226};
	int[] posHomeButton = new int[] {405, 291};
	
	public PauseRoll(FightActivity playActivity, int x, int y) {
		super(playActivity, x, y);
		this.myActivity();
		this.init();
	}
	
	@Override
	public void setPosSize1() {
		this.xPos = 230;
		this.yPos = 123;
		this.activityWidth = 500;
		this.activityHeight = 250;
		posContinueButton = new int[] {405, 161}; 
		posNewGameButton = new int[] {405, 226};
		posHomeButton = new int[] {405, 291};
	
		resetButton();
	}
	
	@Override
	public void setPosSize2() {
		this.xPos = 340;
		this.yPos = 171;
		this.activityWidth = 600;
		this.activityHeight = 350;
		posContinueButton = new int[] {565, 238}; 
		posNewGameButton = new int[] {565, 328};
		posHomeButton = new int[] {565, 418};
	
		resetButton();
	}
	
	void resetButton() {
		this.setButtonSize(continueButton, posContinueButton[0], posContinueButton[1]);
		this.setButtonSize(newGameButton, posNewGameButton[0], posNewGameButton[1]);
		this.setButtonSize(homeButton, posHomeButton[0], posHomeButton[1]);
	}
	
	
	@Override
	public void myActivity() {
		this.activityWidth = 500;
		this.activityHeight = 250;
	}

	@Override
	public void init() {
		continueButton = new ConfirmButton(this, posContinueButton[0], posContinueButton[1]);
		newGameButton = new ConfirmButton(this, posNewGameButton[0], posNewGameButton[1]);
		homeButton = new ConfirmButton(this, posHomeButton[0], posHomeButton[1]);
	}
	
	@Override
	public void update() {		
		
		this.setBackgroundImage(playActivity.getScreen().getImageController().pause1Image);
		continueButton.setImage(playActivity.getScreen().getImageController().continueButtonImage);
		newGameButton.setImage(playActivity.getScreen().getImageController().newGameButtonImage);
		homeButton.setImage(playActivity.getScreen().getImageController().homeButtonImage);
	}
	
	@Override
	public void setTheme1() {
		this.setBackgroundImage(playActivity.getScreen().getImageController().pause1Image);
		
	}

	@Override
	public void setTheme2() {
		this.setBackgroundImage(playActivity.getScreen().getImageController().pause2Image);
	}

	public boolean isPressed(int xMouse, int yMouse) {
		if(xPos < xMouse && xMouse < xPos + activityWidth && yPos < yMouse && yMouse < yPos + activityHeight)
			return true;
		return false;
	}

	@Override
	public int action(int xMouse, int yMouse) {
		if(continueButton.isPressed(xMouse, yMouse)) {
			return 1;
		}
		else if(newGameButton.isPressed(xMouse, yMouse)) {
			return 2;
		}
		else if(homeButton.isPressed(xMouse, yMouse)) {
			return 3;
		} 
		
		return -1;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		continueButton.paint(g);
		newGameButton.paint(g);
		homeButton.paint(g);
	}
}
