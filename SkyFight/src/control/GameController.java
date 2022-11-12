package control;

import java.awt.image.BufferedImage;
import java.util.ArrayDeque;

import figure.Board;
import input.MouseState;
import player.*;

public class GameController {
	
	boolean Finished;
	Computation cal = new Computation();
	ArrayDeque<Player> turn = new ArrayDeque<>();
	Player P1;
	Player P2;
	int xMouse = -1;
	int yMouse = -1;
	int xBoardPos = 122;
	int yBoardPos = 93;
	
	public GameController() {
		P1 = new Player(this, "Player 1", 2);
		P2 = new Player(this, "Player 2", 2);
		turn.addLast(P1);
		turn.addLast(P2);
		
		
	}
	
	public void setBoardImage(BufferedImage boardImage) {
		P1.setBoardImage(boardImage);
		P2.setBoardImage(boardImage);
	}
	
	public void setAircraftImage(BufferedImage imageLeft, BufferedImage imageRight, BufferedImage imageTop, BufferedImage imageBottom) {
		P1.setAircraftImage(imageLeft, imageRight, imageTop, imageBottom);
		P2.setAircraftImage(imageLeft, imageRight, imageTop, imageBottom);
	}
	
	public int getXBoardPos() {
		return this.xBoardPos;
	}
	
	public int getYBoardPos() {
		return this.yBoardPos;
	}
	
	public void setMousePos(int xMouse, int yMouse) {
		this.xMouse = xMouse;
		this.yMouse = yMouse;
	}
	
	public boolean finishPlacing(Player P) {
		if(P.getState() == PlayerState.complete_place) return true;
		else if(P.getPlacedAircraft() == 0) {
			P.setState(PlayerState.complete_place);
			return true;
		}
		return false;
	}
	
	public Player getCurrentPlayer() {
		return this.turn.peekFirst();
	}
	
	public Board getCurrentPlayerBoard() {
		return this.getCurrentPlayer().getBoardOfPlayer();
	}
	
	public void setBoardPos(int x, int y) {
		this.xBoardPos = x;
		this.yBoardPos = y;
		P1.getBoardOfPlayer().setOxyCoor(this.xBoardPos, this.yBoardPos);
		P2.getBoardOfPlayer().setOxyCoor(this.xBoardPos, this.yBoardPos);
	}
	
	public void shootingStage(Player P1) {
		P2 = turn.peekLast();
		cal.shootAircraft(this.xMouse, this.yMouse, P2);
	}
	
	public void playerPlaceAircraft(int xMouse, int yMouse, MouseState mouseState) {
		if(mouseState == MouseState.LEFTPRESSED)
			cal.placeAirCraft(xMouse, yMouse, this.getCurrentPlayer());
		else
			cal.resetOneAircraft(xMouse, yMouse, this.getCurrentPlayer());
	}
	
	public void playerResetAllAircraft() {
		cal.resetAll(this.getCurrentPlayer());
	}
	
	public void changeTurn() {
		Player cur = turn.pollFirst();
		turn.addLast(cur);
	}
	
	public void print() {
		Player curr = this.getCurrentPlayer();
		System.out.println(curr.getPlayerName() + ": " + curr.getPlacedAircraft());
	}
	
}
