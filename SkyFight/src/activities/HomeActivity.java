package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import button.*;
import frame.*;

public class HomeActivity extends ActivityAbs implements ActivityImp{
	
	SwitchActivityButton startButton;
	SwitchActivityButton optionButton;
	QuitButton quitButton;
	
	public HomeActivity() {
		this.myActivity();
		this.init();
	}

	@Override
	public void myActivity() {
		this.activityWidth = 960;
		this.activityHeight = 540;
		
	}

	@Override
	public void init() {
		this.setPreferredSize(new Dimension(this.activityWidth, this.activityHeight));
		this.setBackground(new Color(255,255,255));
		
		startButton = new SwitchActivityButton(this, 415, 312);
		optionButton = new SwitchActivityButton(this, 415, 358);
		quitButton = new QuitButton(this, 415, 404);
		
//		quitButton.setImage(this.getScreen().getImageController().quitButtonImage);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int action(int xMouse, int yMouse) {
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
		return -1;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.gray);
		g.fillRect(200, 50, 560, 230);
		
		startButton.paint(g);
		optionButton.paint(g);
		quitButton.paint(g);
	}
}
