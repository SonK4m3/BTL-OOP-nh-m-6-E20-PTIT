package test;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.swing.JLabel;

import figure.Cell;

public abstract class Object extends JLabel{
	int x;		
	int y;		
	
	int width;
	int height;	
	
	public Cell[][] matrix;		
	
	BufferedImage image;	

	/** tra ve toa do x cua doi tuong
	 *
	 */
	public int getX() {		
		return this.x;
	}
	
	/** tra ve toa do y cua doi tuong
	 *
	 */
	public int getY() {		
		return this.y;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	/** set vi tri cho doi tuong trong he toa do x, y
	 * @param xPos: toa do x
	 * @param yPos: toa do y
	 */
	public void setOxyCoor(int xPos, int yPos) {		// set vi tri cho doi tuong
		this.x = xPos;
		this.y = yPos;
	}
	
	/** chuyen pixel sang vi tri o trong ma tran
	 * @param xPos : toa do x lay tu mouselistener
	 * @param yPos	: toa do y lay tu mouselistener
	 * @return	mang hai chieu chua vi tri [j][i] trong ma tran
	 */
	public Cell convertPixcelToCell(int xPos, int yPos){		
		Cell c = new Cell();
		int j = (xPos - this.x);		//j
		int i = (yPos - this.y);		//i
		if((j >= 0 && j <= this.width)
			&& (i >= 0 && i <= this.height)) {
			j /= 31; 		// ~ x
			i /= 31; 		// ~ y
		}
		else {
			j = -1; // clicked out of board
			i = -1; // clicked out of board
		}
		c.setCoor(i, j);
		return c;
	}
	/**	chuyen vi tri trong ma tran sang vi tri toa do
	 * @param jPos	: cot j trong ma tran cua doi tuong
	 * @param iPos	: cot i trong ma tran cua doi tuong
	 * @return	toa do x, y
	 */
	public OxyCoor convertCellToPixel(Cell c) {		
		OxyCoor Coor = new OxyCoor(c.getJ() * 31 + 122, c.getJ() * 31 + 93);
				//board.getWidth()
				//board.getHeight()
		return Coor;
	}
	
	public Cell pressedCell(int xPos, int yPos) {		// ?
		return matrix[xPos][yPos];
	}
	
}
