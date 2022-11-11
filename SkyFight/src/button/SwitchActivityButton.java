package button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import activities.ActivityAbs;
import frame.*;

public class SwitchActivityButton extends ButtonAbs implements ButtonImp{

	public SwitchActivityButton(ActivityAbs activity, int xPos, int yPos) {
		this.setAcivity(activity);
		this.xPos = xPos;
		this.yPos = yPos;
		this.myButton();
	}
	
	@Override
	public void myButton() {
		this.buttonWidth = 150;
		this.buttonHeight = 40;	
		this.isMouseOnButton = false;		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}
}
