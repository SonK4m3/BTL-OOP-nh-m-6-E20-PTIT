package player;

import control.GameController;
import figure.Board;

public class Bot extends PlayerAbs{
	GameController gameController;
	public Bot(GameController gameController, String name, int original_aircraft) {
		this.gameController = gameController;
		this.name = name;
		this.board = new Board(gameController.getXBoardPos(), gameController.getYBoardPos());
		initInfo();
		this.placed_aircraft = 0;
		this.original_aircraft = original_aircraft;
		this.remain_aircraft = original_aircraft;
	}

}
