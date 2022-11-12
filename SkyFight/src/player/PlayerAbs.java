package player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import figure.*;

public abstract class PlayerAbs {
	Board board;
	PlayerState ps;
	String name;
	
	int aircraft_limit;
	int remain_aircraft;
	AirCraft air_craft1;
	AirCraft air_craft2;
	
	public void initInfo() {
		ps = PlayerState.incomplete_place;
		air_craft1 = new AirCraft();
		air_craft2 = new AirCraft();
	}
	
	public String getPlayerName() {
		return this.name;
	}
	public Board getBoardOfPlayer() {
		return this.board;
	}
	public void setState(PlayerState state) {
		this.ps = state;
	}
	public PlayerState getState() {
		return this.ps;
	}
	public void updateRemainAircraft(int remain_aircraft) {
		this.remain_aircraft = remain_aircraft;
	}
	
	public int getRemainAircraft() {
		return this.remain_aircraft;
	}
	public AirCraft getAircraft(int index) {
		if(index == 1) return air_craft1;
		return air_craft2;
	}
	
	public void paintAircraft(Graphics g) {
		air_craft1.paint(g);
		air_craft2.paint(g);
	}
	
}
