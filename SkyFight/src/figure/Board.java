package figure;

import java.util.ArrayList;

public class Board extends Object{
	static int row = 10;
	static int column = 10;
	public Board(int x, int y) {
		this.x = x;
		this.y = y;
		this.setSize();
		this.initMatrix();
	}
	
	public void setSize() {
		this.width = 310;
		this.height = 310;
	}
	public static int getRow() {
		return row;
	}
	public static int getColumn() {
		return column;
	}
	
	public void initMatrix() {
		this.matrix = new Cell[this.row][this.column];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				this.matrix[i][j] = new Cell(i, j, 0);
			}
		}
		
	}
	
	public void updateMatrix(ArrayList<Cell> aircraft_parts_coor) {
		for(Cell c : aircraft_parts_coor) {
			this.matrix[c.getI()][c.getJ()].setValue(c.getValue());
		}
	}
	public void reDirectAircraft(ArrayList<Cell> aircraft_parts_coor) {
		for(Cell c : aircraft_parts_coor) {
			this.matrix[c.getI()][c.getJ()].setValue(0);
		}
	}
	public void printMatrix() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				System.out.print(this.matrix[i][j].getValue() + " ");
			}
			System.out.println();
		}
	}
}
