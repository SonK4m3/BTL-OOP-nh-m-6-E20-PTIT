package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import button.*;
import frame.*;
import input.MouseState;

public class HomeActivity extends ActivityAbs {
	
	SwitchActivityButton startButton;
	SwitchActivityButton optionButton;
	QuitButton quitButton;
	
	int[] posLogo = new int[] {200, 50, 560, 230};
	
	int[] posStartButton = new int[] {415, 312};
	int[] posOptionButton = new int[] {415, 358};
	int[] posQuitButton = new int[] {415, 404};
	
	public HomeActivity() {
		this.myActivity();
		this.init();
	}

	@Override
	public void myActivity() {
		this.setSize1();
	}

	@Override
	public void init() {
		this.setPreferredSize(new Dimension(this.activityWidth, this.activityHeight));
		this.setBackground(new Color(255,255,255));
		
		startButton = new SwitchActivityButton(this, 415, 312);
		optionButton = new SwitchActivityButton(this, 415, 358);
		quitButton = new QuitButton(this, 415, 404);
	}
	
	/*
	 *  function to get image from imageController
	 *
	 */
	@Override
	public void update() {
		this.backgroundImage = this.screen.getImageController().blueSkyImage; 
		startButton.setImage(this.screen.getImageController().startButtonImage);
		optionButton.setImage(this.screen.getImageController().optionButtonImage);
		quitButton.setImage(this.screen.getImageController().quitButtonImage);
	}
	
	@Override
	public void setSize1() {
		super.setSize1();
		posLogo = new int[] {200, 50, 560, 230};
		posStartButton = new int[] {415, 312};
		posOptionButton = new int[] {415, 358};
		posQuitButton = new int[] {415, 404};
		resetButton();
	}
	
	@Override
	public void setSize2() {
		super.setSize2();
		posLogo = new int[] {360, 130, 560, 230};
		posStartButton = new int[] {565, 410};
		posOptionButton = new int[] {565, 476};
		posQuitButton = new int[] {565, 542};
		resetButton();
	}
	
	void resetButton() {
		setButtonSize(startButton, posStartButton[0], posStartButton[1]);
		setButtonSize(optionButton, posOptionButton[0], posOptionButton[1]);
		setButtonSize(quitButton, posQuitButton[0], posQuitButton[1]);
	}
	
	@Override
	public void setTheme1() {
		this.backgroundImage = this.screen.getImageController().blueSkyImage; 	
	}

	@Override
	public void setTheme2() {
		this.backgroundImage = this.screen.getImageController().nightSkyImage; 		
	}
	
	@Override
	public int action(int xMouse, int yMouse) {
		if(this.screen.getMouseState() == MouseState.LEFTPRESSED) {	
			if(startButton.isPressed(xMouse, yMouse)) {
				System.out.println("Go to Select Activity");
				return 1;
			}
			if(optionButton.isPressed(xMouse, yMouse)) {
				System.out.println("Go to Option Activity");
				return 2;
			}
			if(quitButton.isPressed(xMouse, yMouse)) {
				System.out.println("Game is quitting now...");
				return 3;
			}
		}
		return -1;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(this.screen.getImageController().logo, posLogo[0], posLogo[1], null);
		
		startButton.paint(g);
		optionButton.paint(g);
		quitButton.paint(g);	
	}
}
