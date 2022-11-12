package figure;

public class MatrixCoor {
	private int i;
	private int j;
	public MatrixCoor() {
		
	}
	public MatrixCoor(int i, int j) {
		this.i = i;
		this.j = j;
	}
	public void setCoor(int i, int j) {
		this.i = i;
		this.j = j;
	}
	public int getI() {
		return this.i;
	}
	public int getJ() {
		return this.j;
	}
	public boolean isValid() {
		if(this.i < 0 || this.i > Board.row) return false;
		if(this.j < 0 || this.j > Board.column) return false;
		return true;
	}
}
