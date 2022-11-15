package activities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import button.QuitButton;
import button.SwitchActivityButton;

public class PauseRoll extends ActivityAbs{
	SwitchActivityButton newGameButton;
	SwitchActivityButton homeButton;
	QuitButton quitButton;
	
	FightActivity playActivity;
	
	int[] posHomeButton = new int[] {245, 298};
	int[] posNewGameButton = new int[] {405, 298};
	int[] posQuitButton = new int[] {565, 298}; 
	
	int sizeText = 30;
	int[] posText = new int[] {425, 240};
	
	public PauseRoll(FightActivity playActivity, int x, int y) {
		this.playActivity = playActivity;
		this.xPos = x;
		this.yPos = y;
		this.myActivity();
		this.init();
	}
	
	public void setPosSize1() {
		this.xPos = 230;
		this.yPos = 123;
		this.activityWidth = 500;
		this.activityHeight = 250;
		posHomeButton = new int[] {245, 298};
		posNewGameButton = new int[] {405, 298};
		posQuitButton = new int[] {565, 298};
		posText = new int[] {425, 240};
		sizeText = 30;
		resetButton();
	}
	
	public void setPosSize2() {
		this.xPos = 340;
		this.yPos = 171;
		this.activityWidth = 600;
		this.activityHeight = 350;
		posHomeButton = new int[] {375, 430};
		posNewGameButton = new int[] {565, 430};
		posQuitButton = new int[] {755, 430};
		posText = new int[] {554, 330};
		sizeText = 50;
		resetButton();
	}
	
	void resetButton() {
		this.setButtonSize(homeButton, posHomeButton[0], posHomeButton[1]);
		this.setButtonSize(newGameButton, posNewGameButton[0], posNewGameButton[1]);
		this.setButtonSize(quitButton, posQuitButton[0], posQuitButton[1]);
	}
	
	
	@Override
	public void myActivity() {
		this.activityWidth = 500;
		this.activityHeight = 250;
	}

	@Override
	public void init() {
		homeButton = new SwitchActivityButton(this, posHomeButton[0], posHomeButton[1]);
		newGameButton = new SwitchActivityButton(this, posNewGameButton[0], posNewGameButton[1]);
		quitButton = new QuitButton(this, posQuitButton[0], posQuitButton[1]);

	}
	
	@Override
	public void update() {		
		
		this.setBackgroundImage(playActivity.getScreen().getImageController().endGame1Image);
		homeButton.setImage(playActivity.getScreen().getImageController().homeButtonImage);
		newGameButton.setImage(playActivity.getScreen().getImageController().newGameButtonImage);
		quitButton.setImage(playActivity.getScreen().getImageController().quitButtonImage);
	}
	
	@Override
	public void setTheme1() {
		this.setBackgroundImage(playActivity.getScreen().getImageController().endGame1Image);
		
	}

	@Override
	public void setTheme2() {
		this.setBackgroundImage(playActivity.getScreen().getImageController().endGame2Image);
	}

	public boolean isPressed(int xMouse, int yMouse) {
		if(xPos < xMouse && xMouse < xPos + activityWidth && yPos < yMouse && yMouse < yPos + activityHeight)
			return true;
		return false;
	}

	@Override
	public int action(int xMouse, int yMouse) {
		if(homeButton.isPressed(xMouse, yMouse)) {
			return 1;
		} else if(newGameButton.isPressed(xMouse, yMouse)) {
			return 2;
		} else if(quitButton.isPressed(xMouse, yMouse)) {
			quitButton.action();
		}
		return 0;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		// 1. set font and size of text
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Monospaced", Font.BOLD, sizeText));
        
        g2.setColor(Color.black);
		g2.drawString(this.playActivity.winnerName() + " WIN", posText[0], posText[1]);
        
		homeButton.paint(g);
		newGameButton.paint(g);
		quitButton.paint(g);
	}
}
