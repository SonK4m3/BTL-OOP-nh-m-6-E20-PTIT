package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PageAttributes;
import java.util.ArrayDeque;
import java.util.ArrayList;

import button.*;
import logicControl.Computation;
import logicControl.LogicControl;
import logicControl.PlaceAircraft;
import test.AirCraft;
import test.Board;
import test.Cell;
import test.GameController;
import test.MatrixCoor;
import test.OxyCoor;
import test.Player;

public class ChooseCraftActivity extends ActivityAbs implements ActivityImp{
	SwitchActivityButton backButton;
	
	Board board = new Board(122, 93);
	GameController gameController;
	AirCraft airCraft = new AirCraft(-1, -1);
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
		
		
	}
	
	public void setGameController(GameController gameController){
		this.gameController = gameController;
	}
	@Override
	public int action(int xMouse, int yMouse) {
		if(backButton.isPressed(xMouse, yMouse)) {
			System.out.println("Back to Home Activity");
			return 3;
		} else {
			if(gameController != null) {
				gameController.setMousePos(xMouse, yMouse);
				
				
			}
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
		board.paint(g);
		airCraft = gameController.getCurrentPlayer().getAircraft(UNDEFINED_CONDITION);
		
	}

}
