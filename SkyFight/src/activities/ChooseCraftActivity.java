package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import button.*;

public class ChooseCraftActivity extends ActivityAbs implements ActivityImp{
	SwitchActivityButton backButton;
	
	public ChooseCraftActivity() {
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
		this.setPreferredSize(new Dimension(activityWidth, activityHeight));
		this.setBackground(new Color(255,255,255));			
		backButton = new SwitchActivityButton(this, 734, 400);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int action(int xMouse, int yMouse) {
		if(backButton.isPressed(xMouse, yMouse)) {
			System.out.println("Back to Home Activity");
			return 3;
		}else {
			
		}
		return -1;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.orange);
		g.fillRect(65, 40, 830, 415);
		
		g.setColor(Color.yellow);
		g.fillRect(65, 40, 415, 415);
		
		backButton.paint(g);
	}

}
