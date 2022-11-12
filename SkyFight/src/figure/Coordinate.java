package figure;

public abstract class Coordinate {
	public int coor_x_Axis;		//toa do theo chieu ngang
	public int coor_y_Axis;		//toa do theo chieu doc
	public Coordinate() {
		
	}
	public Coordinate(int coor_x_Axis, int coor_y_Axis) {
		this.coor_x_Axis = coor_x_Axis;
		this.coor_y_Axis = coor_y_Axis;
	}
	/** set vi tri trong he toa do 
	 * @param xPos: toa do theo chieu ngang
	 * @param yPos: toa do theo chieu doc
	 */
	public abstract void setCoor(int coor_x_Axis, int coor_y_Axis);
}
