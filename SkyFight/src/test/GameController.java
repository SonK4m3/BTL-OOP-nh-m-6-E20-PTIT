package test;

import java.util.ArrayDeque;

import logicControl.Computation;

public class GameController {
	boolean Finished;
	Computation cal;
	int current_player;
	Player P1;
	Player P2;
	int xMouse = -1;
	int yMouse = -1;
	public GameController() {
		current_player = 1;
		P1 = new Player("Player 1", 2);
		P2 = new Player("Player 2", 2);
	}
	public void setMousePos(int xMouse, int yMouse) {
		this.xMouse = xMouse;
		this.yMouse = yMouse;
	}
	public String getGameState() {
		
	}
	public int getCurrentPlayer() {
		return this.current_player;
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
		if(current_player == 1) cal.placeAirCraft(xMouse, yMouse, P1);
		else cal.placeAirCraft(xMouse, yMouse, P2);
	}
}
	

