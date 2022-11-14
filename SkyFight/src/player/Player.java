package player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
	
	public void paint1(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int[] posNameBoard = new int[] {65, 40, 415, 34};

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Monospaced", Font.BOLD, 3*posNameBoard[3]/4));
		g2.setColor(Color.gray);
	    g2.fillRect(posNameBoard[0], posNameBoard[1], posNameBoard[2], posNameBoard[3]);    	
	    g2.setColor(Color.blue);
	    g2.drawString(this.getPlayerName() + " Board", posNameBoard[0] + 150, posNameBoard[1] + 3*posNameBoard[3]/4);
	}
	
	public void paint2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int[] posNameBoard = new int[] {190, 121, 450, 50};

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Monospaced", Font.BOLD, 3*posNameBoard[3]/4));
		g2.setColor(Color.gray);
	    g2.fillRect(posNameBoard[0], posNameBoard[1], posNameBoard[2], posNameBoard[3]);    	
	    g2.setColor(Color.blue);
	    g2.drawString(this.getPlayerName() + " Board", posNameBoard[0] + 135, posNameBoard[1] + 3*posNameBoard[3]/4);
	}
}
