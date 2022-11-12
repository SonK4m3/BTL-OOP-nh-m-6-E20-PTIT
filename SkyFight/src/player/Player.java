package player;

import java.awt.image.BufferedImage;

import control.GameController;
import figure.Board;

public class Player extends PlayerAbs{
	
	GameController gameController;
	
	public Player(GameController gameController, String name, int aircraft_limit) {
		this.gameController = gameController;
		this.name = name;
		this.board = new Board(gameController.getXBoardPos(), gameController.getYBoardPos());
		initInfo();
		this.aircraft_limit = aircraft_limit;
	}
	
	public void setBoardImage(BufferedImage image) {
		this.board.setImage(image);
	}
	
	public void setAircraftImage(BufferedImage imageLeft, BufferedImage imageRight, BufferedImage imageTop, BufferedImage imageBottom) {
		air_craft1.initImage(imageLeft, imageRight, imageTop, imageBottom);
		air_craft2.initImage(imageLeft, imageRight, imageTop, imageBottom);
	}
}
