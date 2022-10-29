package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import activities.ActivityAbs;
import activities.ActivityImp;
import button.ButtonAbs;
import button.QuitButton;

public class HomeScreen extends ActivityAbs implements ActivityImp{
	
	ButtonAbs homeButton;
	ButtonAbs optionButton;
	ButtonAbs quitButton;
	
	public HomeScreen() {
		this.myActivity();
		this.init();
	}
	
	@Override
	public void myActivity() {
		this.activityHeight = 500;
		this.activityWidth = 886;
		this.homeButton = new SwitchScreenButton(this, 378, 313);
		this.optionButton = new SwitchScreenButton(this, 378, 349);
		this.quitButton = new QuitButton(this, 378, 385);
	}

	@Override
	public void init() {
		this.setPreferredSize(new Dimension(activityWidth, activityHeight));
		this.setBackground(new Color(255,255,255));
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int action(int xMouse, int yMouse) {
		if(homeButton.isPressed(xMouse, yMouse)) {
			System.out.println("home button");
			return 1;
		}
		else if(optionButton.isPressed(xMouse, yMouse)) {
			System.out.println("option button");
			return 2;
		}
		else if(quitButton.isPressed(xMouse, yMouse)) {
			System.out.println("quit button");
			System.exit(0);
		}
		return -1;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		homeButton.paint(g);
		optionButton.paint(g);
		quitButton.paint(g);
	}
}
