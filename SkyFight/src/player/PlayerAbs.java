 package player;

import java.awt.Graphics;

import figure.*;

public abstract class PlayerAbs {
	String name;
	PlayerState ps;
	int placed_aircraft;
	int original_aircraft;
	int remain_aircraft;

	protected Board board;
	protected AirCraft air_craft1;
	protected AirCraft air_craft2;
	
	/*
	 * player create aircraft before start game
	 * 
	 */
	protected void initInfo() {
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
	
	/*
	 * set placed aircraft and update player state
	 */
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
	/*
	 * set remain aircraft and update player state
	 */
	public void updateRemainAircraft(int number) {
		this.remain_aircraft = number;
		if(this.remain_aircraft == 0) {
			this.setState(PlayerState.lose);
		}
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