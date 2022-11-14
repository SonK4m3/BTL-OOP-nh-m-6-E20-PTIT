package player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import figure.*;

public abstract class PlayerAbs {
	Board board;
	PlayerState ps;
	String name;
	int placed_aircraft;
	int original_aircraft;
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
	public void updatePlacedAircraft(int number) {
		this.placed_aircraft = (number > 0) ? number : 0;
		if(this.placed_aircraft == 2) 
			this.setState(PlayerState.complete_place);
		else 
			this.setState(PlayerState.incomplete_place);
	}
	public int getPlacedAircraft() {
		return this.placed_aircraft;
	}
	public void updateRemainAircraft(int number) {
		this.remain_aircraft = number;
	}
	public int getRemainAircraft() {
		return this.remain_aircraft;
	}	
	
	public AirCraft getAircraft(int index) {
		return (index == 1) ? air_craft1 : air_craft2;
	}
	
	public void paintAircraft(Graphics g) {
		air_craft1.paint(g);
		air_craft2.paint(g);
	}
}
