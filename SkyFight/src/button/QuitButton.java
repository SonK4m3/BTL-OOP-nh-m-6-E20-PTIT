package button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import frame.ActivityAbs;

public class QuitButton extends ButtonAbs implements ButtonImp{
	public QuitButton(ActivityAbs activity, int xPos, int yPos) {
		this.setAcivity(activity);
		this.xPos = xPos;
		this.yPos = yPos;
		this.init();
		this.myButton();
	}

	@Override
	public void init() {
		this.isMouseOnButton = false;
	}

	@Override
	public void myButton() {
		this.buttonHeight = 30;
		this.buttonWidth = 130;
	}

	@Override
	public void action() {		
		System.out.println("Exit Game");
	}

	@Override
	public boolean checkMouseOnButton(int x, int y) {
		return false;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.fillRect(this.xPos, this.yPos, this.buttonWidth, this.buttonHeight);
	}
}
