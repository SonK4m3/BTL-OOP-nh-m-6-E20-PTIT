package figure;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AirCraft extends Object{
	int x;
	int y;
	boolean onBoard;
	int create_order;
	String current_direction;
	Cell head;
	BufferedImage north_image, east_image, south_image, west_image;
	static int[] I = new int[] {0,1,1,1,2,3, 3,3,  0,-1, 1, 0, 0, 0,-1, 1,   0,-1,-1,-1,-2,-3,-3,-3,    0,1,-1,0,0,0,1,-1};
	static int[] J = new int[] {0,-1,1,0,0,0,-1,1,  0,-1,-1,-1,-2,-3,-3,-3,   0,1,-1, 0, 0, 0, 1,-1,    0,1, 1,1,2,3,3, 3};
	private HashMap<String, ArrayList<Cell>> parts_coor;
	public ArrayDeque<String> all_direction = new ArrayDeque<>();
	
	public AirCraft(int x, int y) {
		this.x = x;
		this.y = y; 
	}
	public AirCraft() {
		updateOnBoard(false);
		InitPartsCoor();
		InitAllDirection();
	}
	
	public void InitPartsCoor() {
		parts_coor = new HashMap<>();
		head = new Cell(); 		
		ArrayList<Cell> north = new ArrayList<>();
		ArrayList<Cell> east = new ArrayList<>();
		ArrayList<Cell> south = new ArrayList<>();
		ArrayList<Cell> west = new ArrayList<>();
		this.parts_coor.put("North", north);
		this.parts_coor.put("East", east);
		this.parts_coor.put("South", south);
		this.parts_coor.put("West", west);
	}
	
	public void InitAllDirection() {
		this.all_direction.add("North");
		this.all_direction.add("East");
		this.all_direction.add("South");
		this.all_direction.add("West");
	}
	
	public void setPartsCoor(Cell pos_Click) {
		int k;
		this.head = pos_Click;
		for(Map.Entry<String, ArrayList<Cell>> entry : parts_coor.entrySet()) {
			ArrayList<Cell> temp = new ArrayList<>();
			String direction = entry.getKey();
			if(direction == "North") k = 0;
			else if(direction == "East") k = 8;
			else if(direction == "South") k = 16;
			else k = 24;
			
			for(int i = 0; i <= 7; i++) {
				Cell c  = new Cell(head.getI() + I[k], head.getJ() + J[k]);
				if(k == 0 || k == 8 || k == 16 || k == 24) c.setValue(2);
				else c.setValue(1);
				k++;
				temp.add(c);
			}
			this.parts_coor.put(direction, temp);
		}
	}
	public void setImage(BufferedImage imageLeft, BufferedImage imageRight, BufferedImage imageTop, BufferedImage imageBottom) {
		this.east_image = imageRight;
		this.west_image = imageLeft;
		this.south_image = imageBottom;
		this.north_image = imageTop;
	}
	
	public HashMap<String, ArrayList<Cell>> getPartsCoor(){
		return this.parts_coor;
	}
	
	public String getFirstDirectionInDeque() {
		String first = all_direction.pollFirst();
		all_direction.addLast(first);
		return first;
	}
	
	public boolean isOnBoard() {
		return this.onBoard;
	}
	
	public void updateOnBoard(boolean bool) {
		if(bool == false && this.head != null) this.head.setCoor(-1, -1);
		this.onBoard = bool;
	}
	
	public Cell getHead() {
		return this.head;
	}
	
	public void setCurrentDirection(String direction) {
		this.current_direction = direction;
	}
	
	public String getCurrentDirection() {
		return this.current_direction;
	}
	
	public void setOxyCoor(int xPos, int yPos) {
		this.x = xPos;
		this.y = yPos;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	/*
	 * debug
	 * 
	 */
	public void print() {
		System.out.println(head.getI() + " " + head.getJ() + " " + head.value);
		System.out.println(this.x + " " + this.y);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(onBoard == true && north_image != null && south_image != null && west_image != null && east_image != null) {
			if(this.current_direction.equals("North")) {
				// top
				g.drawImage(north_image, this.x - 31, this.y, null);
			} else if(this.current_direction.equals("South")){
				// bottom
				g.drawImage(south_image, this.x - 31, this.y - 93, null);
			} else if(this.current_direction.equals("West")){
				//left
				g.drawImage(west_image, this.x, this.y - 31, null);
			} else {
				//right
				g.drawImage(east_image, this.x - 93, this.y - 31, null);
			}
		}
	}
	
}
