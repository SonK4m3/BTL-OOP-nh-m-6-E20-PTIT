package test;

import logicControl.Computation;
import test.AirCraft;

public class Player{
	Board board;
	PlayerState ps;
	String name;
	
	int aircraft_limit;
	int remain_aircraft;
	AirCraft air_craft1;
	AirCraft air_craft2;
	public Player(String name, int aircraft_limit) {
		this.name = name;
		board = new Board(122, 93);
		initInfo();
		this.aircraft_limit = aircraft_limit;
	}
	
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
	
}
