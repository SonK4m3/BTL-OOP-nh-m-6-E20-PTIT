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
		this.matrix = new Cell[Board.row][Board.column];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				this.matrix[i][j] = new Cell(i, j, 0);
			}
		}
		
	}
	
	public Cell[][] getMatrix(){
		return this.matrix;
	}
	
	public void updateMatrix(ArrayList<Cell> aircraft_parts_coor) {
		for(Cell c : aircraft_parts_coor) {
			this.matrix[c.getI()][c.getJ()].setValue(c.getValue());
		}
	}
	
	public void deleteAircraft(ArrayList<Cell> aircraft_parts_coor) {
		for(Cell c : aircraft_parts_coor) {
			this.matrix[c.getI()][c.getJ()].setValue(0);
		}
	}
	/*
	 * print matrix board in console
	 */
	public void printMatrix() {
		System.out.println("----------");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				System.out.print(this.matrix[i][j].getValue() + " ");
			}
			System.out.println();
		}
	}
}
