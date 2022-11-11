package button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import activities.ActivityAbs;

public abstract class ButtonAbs extends JLabel{
	
	private ActivityAbs activity;
	
	protected int xPos;
	protected int yPos;
	protected int buttonWidth;
	protected int buttonHeight;
	protected boolean isMouseOnButton;
	
	BufferedImage buttonImage;
	
	public void setPos(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getButtonWidth() {
		return buttonWidth;
	}
	
	public int getButtonHeight() {
		return buttonHeight;
	}
	
	public void setImage(BufferedImage image){
		this.buttonImage = image;
	}
	
	public boolean isPressed(int xPos, int yPos) {
		if(xPos >= this.xPos && xPos <= (this.xPos + this.buttonWidth) && 
				yPos >= this.yPos && yPos <= (this.yPos + this.buttonHeight)) {
			return true;
		}
		return false;
	}
	
	protected void setAcivity(ActivityAbs newActivity) {
		this.activity = newActivity;
	}
	
	protected ActivityAbs getActivity() {
		return this.activity;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(buttonImage != null)
			g.drawImage(buttonImage, xPos, yPos, null);
		else {
			g.setColor(Color.blue);
			g.fillRect(xPos, yPos, buttonWidth, buttonHeight);
		}
	}
}
