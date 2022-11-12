package figure;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class AirCraft extends Object{
	int x;
	int y;
//	int row = 4;
//	int column = 3;
	boolean onBoard;
	int create_order;
	String current_direction;
	Cell head;
	BufferedImage north_image, east_image, south_image, west_image;
	static int[] I = new int[] {0,1,1,1,2,3, 3,3,  0,-1, 1, 0, 0, 0,-1, 1,   0,-1,-1,-1,-2,-3,-3,-3,    0,1,-1,0,0,0,1,-1};
	static int[] J = new int[] {0,-1,1,0,0,0,-1,1,  0,-1,-1,-1,-2,-3,-3,-3,   0,1,-1, 0, 0, 0, 1,-1,    0,1, 1,1,2,3,3, 3};
	private HashMap<String, ArrayList<Cell>> parts_coor;
	public ArrayDeque<String> origin_valid_direction;
	public AirCraft(int x, int y) {
		this.x = x;
		this.y = y; 
	}
	public AirCraft() {
		updateOnBoard(false);
		InitPartsCoor();
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
	public void initImage(BufferedImage imageLeft, BufferedImage imageRight, BufferedImage imageTop, BufferedImage imageBottom) {
		this.east_image = imageRight;
		this.west_image = imageLeft;
		this.south_image = imageBottom;
		this.north_image = imageTop;
	}
	public HashMap<String, ArrayList<Cell>> getPartsCoor(){
		return this.parts_coor;
	}
	
	public void setAllValidDirection(ArrayDeque<String> origin_valid_direction) {
		this.origin_valid_direction = origin_valid_direction;
	}
	public String getFirstValidDirection() {
		String first = this.origin_valid_direction.pollFirst();
		this.origin_valid_direction.addLast(first);
		return first;
	}
	
	public boolean isOnBoard() {
		return this.onBoard;
	}
	public void updateOnBoard(boolean bool) {
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
	@Override
	public void setOxyCoor(int xPos, int yPos) {
		super.setOxyCoor(xPos, yPos);
	}
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
//		g.drawImage(this.image, x, y, null);
		if(onBoard == true && north_image != null && south_image != null && west_image != null && east_image != null) {
			if(this.current_direction.equals("North")) {
				g.drawImage(north_image, this.x, this.y, null);
			} else if(this.current_direction.equals("South")){
				g.drawImage(south_image, this.x, this.y, null);
			} else if(this.current_direction.equals("West")){
				g.drawImage(west_image, this.x, this.y, null);
			} else {
				g.drawImage(east_image, this.x, this.y, null);
			}
		}
	}
	
}
