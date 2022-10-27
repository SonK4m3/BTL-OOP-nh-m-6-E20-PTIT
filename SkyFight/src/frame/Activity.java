package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Activity extends ActivityAbs implements ActivityImp{
	
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
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int action(int xPos, int yPos) {
		return -1;
		// TODO Auto-generated method stub
		
	}
}