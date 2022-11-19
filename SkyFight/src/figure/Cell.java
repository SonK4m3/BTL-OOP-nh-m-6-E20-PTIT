package figure;

public class Cell implements Cloneable{
	private int i;
	private int j;
	protected int value;
	private boolean isShooted = false;
	private CellShootedState state = CellShootedState.None;
	
	public Cell() {
	
	}
	
	public Cell(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public Cell(int i, int j, int value) {
		this.i = i;
		this.j = j;
		this.value = value;
	}
	
	public void setCoor(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getI() {
		return this.i;
	}
	
	public int getJ() {
		return this.j;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setState(CellShootedState state) {
		this.state = state;
	}
	
	public void setHeadState() {
		this.state = CellShootedState.Head;
	}
	
	public void setPartState() {
		this.state = CellShootedState.Part;
	}
	
	public void setMissState() {
		this.state = CellShootedState.Miss;
	}
	
	public CellShootedState getState() {
		return this.state;
	}
	
	public boolean stateIsHead() {
		return this.state == CellShootedState.Head;
	}
	
	public boolean stateIsPart() {
		return this.state == CellShootedState.Part;
	}
	
	public boolean stateIsMiss() {
		return this.state == CellShootedState.Miss;
	}
	/*
	 * check cell is in board matrix or not
	 */
	public boolean isValid() {
		if(this.i < 0 || this.i >= Board.row) return false;
		if(this.j < 0 || this.j >= Board.column) return false;
		return true;
	}
	/*
	 * check cell is clicked or not
	 */
	public boolean collide(Cell c) {
		if(this.i == c.getI() && this.j == c.getJ()) return true;
		return false;
	}
	
	public boolean isShooted() {
		return this.isShooted;
	}
	
	public void updateShooted(boolean bool) {
		this.isShooted = bool;
	}
}