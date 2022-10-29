package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import activities.ActivityAbs;
import activities.ActivityImp;
import button.QuitButton;
import frame.*;

public class PlayActivity extends ActivityAbs implements ActivityImp{
	
	Board board;
	
	public PlayActivity() {
		this.myActivity();
		this.init();
	}

	@Override
	public void myActivity() {
		this.activityHeight = 500;
		this.activityWidth = 886;
		board = new Board(138, 75);
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
		// postion of cell
		int[] pos = board.convertPixcelToCell(xMouse, yMouse);
		
		System.out.println("Cell: " + pos[0] + " " + pos[1]);
		
		return 0;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.yellow);
		g.fillRect(93, 30, 400, 400);
		board.paint(g);
	}
}
