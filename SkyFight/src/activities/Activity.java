package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Activity extends ActivityAbs{
	
	private static final long serialVersionUID = 1L;

	public Activity() {
		this.myActivity();
		this.init();
	}

	@Override
	public void myActivity() {
		this.activityWidth = 500;		
		this.activityHeight = 500;
	}
	
	@Override
	public void init() {
		this.setPreferredSize(new Dimension(activityWidth, activityHeight));
		this.setBackground(new Color(255,0,0));
	}

	@Override
	public int action(int xMouse, int yMouse) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTheme1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTheme2() {
		// TODO Auto-generated method stub
		
	}
}