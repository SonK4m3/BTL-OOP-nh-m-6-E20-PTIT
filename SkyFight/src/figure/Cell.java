package figure;

import frame.ActivityAbs;

public class Cell {
	int x = 0;
	int y = 0;
	
	final int WIDTH = 30;
	final int HEIGHT = 30;
	
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
}
