package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import button.ButtonAbs;
import button.ButtonImp;
import button.DefaultButton;
import button.SaveButton;
import button.SwitchActivityButton;
import frame.*;

public class OptionActivity extends ActivityAbs implements ActivityImp{

	SwitchActivityButton backButton;
	DefaultButton defaultSettingButton;
	SaveButton saveSettingButton;
	
	public OptionActivity() {
		this.myActivity();
		this.init();
	}
	
	@Override
	public void myActivity() {
		this.activityHeight = 540;
		this.activityWidth = 960;		
	}

	@Override
	public void init() {
		this.setPreferredSize(new Dimension(this.activityWidth, this.activityHeight));
		this.setBackground(new Color(255,255,255));	
		
		backButton = new SwitchActivityButton(this, 170, 390);
		defaultSettingButton = new DefaultButton(this, 405, 390);
		saveSettingButton = new SaveButton(this, 640, 390);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int action(int xMouse, int yMouse) {
		if(backButton.isPressed(xMouse, yMouse)) {
			System.out.println("Back to Home Activity");
			return 1;
		}
		else if(defaultSettingButton.isPressed(xMouse, yMouse)) {
			System.out.println("Return default option and back to Home Activity");
			defaultSettingButton.action();
			this.getScreen().resizeAllActivities();
			return 2;
		}
		else if(saveSettingButton.isPressed(xMouse, yMouse)) {
			System.out.println("Save option and back to Home Activity");
			saveSettingButton.action();
			this.getScreen().resizeAllActivities();
			return 3;
		}
		return -1;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.gray);
		g.fillRect(170, 50, 620, 300);
		
		backButton.paint(g);
		defaultSettingButton.paint(g);
		saveSettingButton.paint(g);
	}
}
