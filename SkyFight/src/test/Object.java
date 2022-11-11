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
		cellPos[0] = (xPos - this.x);
		cellPos[1] = (yPos - this.y);
		
		
		if((cellPos[0] >= 0 && cellPos[0] <= this.width)
			&& (cellPos[1] >= 0 && cellPos[1] <= this.height)) {
			cellPos[0] = cellPos[0] / 31; 
			cellPos[1] = cellPos[1] / 31; 
		}
		else {
			cellPos[0] = -1; // clicked out of board
			cellPos[1] = -1; // clicked out of board
		}
		
		return cellPos;
	}
	
	public Cell pressedCell(int xPos, int yPos) {
		return cells[xPos][yPos];
	}

}
