package player;

import java.awt.image.BufferedImage;

import control.GameController;
import figure.Board;

public class Player extends PlayerAbs{
	
	GameController gameController;
	
	public Player(GameController gameController, String name, int original_aircraft) {
		this.gameController = gameController;
		this.name = name;
		this.board = new Board(gameController.getXBoardPos(), gameController.getYBoardPos());
		initInfo();
		this.placed_aircraft = 0;
		this.original_aircraft = original_aircraft;
		this.remain_aircraft = original_aircraft;
	}
	
	public void setBoardImage(BufferedImage image) {
		this.board.setImage(image);
	}
	
	public void setAircraftImage(BufferedImage imageLeft, BufferedImage imageRight, BufferedImage imageTop, BufferedImage imageBottom) {
		air_craft1.setImage(imageLeft, imageRight, imageTop, imageBottom);
		air_craft2.setImage(imageLeft, imageRight, imageTop, imageBottom);
	}
}
