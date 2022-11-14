package control;

import java.awt.image.BufferedImage;
import java.util.ArrayDeque;

import figure.Board;
import input.MouseState;
import player.*;

public class GameController {
	
	Computation cal = new Computation();
	ArrayDeque<Player> turn = new ArrayDeque<>();
	Player P1;
	Player P2;
	int xBoardPos = 122;
	int yBoardPos = 93;
	
	public GameController() {
		P1 = new Player(this, "P1", 2);
		P2 = new Player(this, "P2", 2);
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
	
	public void setBoardPos(int x, int y) {
		this.xBoardPos = x;
		this.yBoardPos = y;
		P1.getBoardOfPlayer().setOxyCoor(this.xBoardPos, this.yBoardPos);
		P2.getBoardOfPlayer().setOxyCoor(this.xBoardPos, this.yBoardPos);
	}
	
	public int getXBoardPos() {
		return this.xBoardPos;
	}
	
	public int getYBoardPos() {
		return this.yBoardPos;
	}
	
	public void changeTurn() {
		Player cur = turn.pollFirst();
		turn.addLast(cur);
	}
	
	public Player getCurrentPlayer() {
		return this.turn.peekFirst();
	}
	
	public Board getCurrentPlayerBoard() {
		return this.getCurrentPlayer().getBoardOfPlayer();
	}
	
	public Player getWattingPlayer() {
		return this.turn.peekLast();
	}
	
	public Player getPlayerIsShooting() {
		return (P1.getState() == PlayerState.shooting) ? P1 : P2;
	}
	
	public Board getWaitingPlayerBoard() {
		return this.getWattingPlayer().getBoardOfPlayer();
	}
	
	public boolean currentPlayerIsCompletedPlaced() {
		return this.getCurrentPlayer().getState() == PlayerState.complete_place;
	}
	
	public boolean twoPlayerIsCompletePlaced() {
		if ((this.P1.getState() == PlayerState.complete_place) && (this.P2.getState() == PlayerState.complete_place)){
			P1.setState(PlayerState.shooting);
			P2.setState(PlayerState.waiting);
			return true;
		} else 
			return false;
	}
	
	public String  playerPlaceAircraft(int xMouse, int yMouse, MouseState mouseState) {
		if(mouseState == MouseState.LEFTPRESSED) {
			return cal.placeAirCraft(xMouse, yMouse, this.getCurrentPlayer());
		}
		else {
			return cal.resetOneAircraft(xMouse, yMouse, this.getCurrentPlayer());
		}
	}
	
	public void playerResetAllAircraft() {
		cal.resetAll(this.getCurrentPlayer());
	}
	
	public String shootingStage(int xMouse, int yMouse, Player P1) { 
		if(P1.getState() == PlayerState.shooting) {
			P2 = turn.peekLast();
			String player_shooted = P1.getPlayerName() + " shoot " + P2.getPlayerName() + " ";
			String notify = cal.shootAircraft(xMouse, yMouse, P2); 
			if(notify != null) {
				notify = player_shooted + notify;
				P1.setState(PlayerState.waiting);
				P2.setState(PlayerState.shooting);
			} else {
				notify = "invalid shoot";
			}
			return notify;
		} else {
			return null;
		}
	}
	
	public void print() {
		System.out.println(P1.getPlayerName() + ": " + P1.getState());
		System.out.println(P2.getPlayerName() + ": " + P2.getState());
	}
	
}
