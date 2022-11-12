package control;

import java.awt.image.BufferedImage;

import figure.Board;
import player.*;

public class GameController {
	
	boolean Finished;
	Computation cal;
	int current_player;
	Player P1;
	Player P2;
	int xMouse = -1;
	int yMouse = -1;
	
	int xBoardPos = 122;
	int yBoardPos = 93;
	
	public GameController() {
		current_player = 1;
		P1 = new Player(this, "Player 1", 2);
		P2 = new Player(this, "Player 2", 2);
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
//	public String getGameState() {
//		
//	}
	
	public int currentPlayer() {
		return this.current_player;
	}
	
	public Player getCurrentPlayer() {
		if(this.current_player == 1)
			return P1;
		else 
			return P2;
	}
	
	public Board getCurrentPlayerBoard() {
		return (this.current_player == 1) ? P1.getBoardOfPlayer() : P2.getBoardOfPlayer();
	}
	
	public void setBoardPos(int x, int y) {
		this.xBoardPos = x;
		this.yBoardPos = y;
		P1.getBoardOfPlayer().setOxyCoor(this.xBoardPos, this.yBoardPos);
		P2.getBoardOfPlayer().setOxyCoor(this.xBoardPos, this.yBoardPos);
	}
	
	public boolean finishPlacing(Player P) {
		if(P.getState() == PlayerState.complete_place) return true;
		else if(P.getRemainAircraft() == 0) {
			P.setState(PlayerState.complete_place);
			return true;
		}
		return false;
		
	}
	
	public void shootingStage() {
		
	}
	public void playerPlaceAircraft(int xMouse, int yMouse) {
		if(cal != null) {
			if(current_player == 1) cal.placeAirCraft(xMouse, yMouse, P1);
			else cal.placeAirCraft(xMouse, yMouse, P2);
		}
	}
	
}
