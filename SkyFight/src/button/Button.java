package button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import frame.*;

public class Button extends ButtonAbs implements ButtonImp{
	
	public Button(ActivityAbs activity, int xPos, int yPos) {
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
		this.buttonWidth = 200;
		this.buttonHeight = 100;
	}

	@Override
	public void action() {
		System.out.println("Button");
		
	}

	@Override
	public boolean checkMouseOnButton(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.blue);
		g2d.fillRect(this.xPos, this.yPos, this.buttonWidth, this.buttonHeight);
	}
}
