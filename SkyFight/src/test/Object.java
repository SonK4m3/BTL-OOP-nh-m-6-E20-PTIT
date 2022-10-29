package test;

import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import figure.Cell;

public abstract class Object extends JLabel{
	int x;
	int y;
	
	int width;
	int height;
	
	Cell[][] cells;
	
	BufferedImage image;

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setPos(int xPos, int yPos) {
		this.x = xPos;
		this.y = yPos;
	}
	
	int[] convertPixcelToCell(int xPos, int yPos){
		int[] cellPos = new int[2]; 
		cellPos[0] = xPos - this.x;
		cellPos[1] = yPos - this.y;
		return cellPos;
	}
	
	public Cell pressedCell(int xPos, int yPos) {
		return cells[xPos][yPos];
	}

}
