package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import button.*;
import frame.ActivityAbs;
import frame.ActivityImp;

public class MenuActivity extends ActivityAbs implements ActivityImp{

	ButtonAbs button1;
	ButtonAbs button2;
	ButtonAbs button3;
	
	public MenuActivity() {
		this.myActivity();
		this.init();
	}
	
	@Override
	public void myActivity() {
		this.activityHeight = 500;
		this.activityWidth = 886;
		this.button1 = new SwitchScreenButton(this, 378, 313);
		this.button2 = new SwitchScreenButton(this, 378, 349);
		this.button3 = new SwitchScreenButton(this, 378, 385);
		try {
			this.image = ImageIO.read(new File("image//aircraft//left.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public int action(int xPos, int yPos) {
		if(button1.isPressed(xPos, yPos)) {
			System.out.println("button 1");
			return 1;
		}
		if(button2.isPressed(xPos, yPos)) {
			System.out.println("button 2");
			return 2;
		}
		if(button3.isPressed(xPos, yPos)) {
			System.out.println("button 3");
			return 2;
		}
		return -1;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		this.button1.paint(g);
		this.button2.paint(g);
		this.button3.paint(g);
	}

}
