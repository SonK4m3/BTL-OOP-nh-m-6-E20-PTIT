package player;

public class Bot extends PlayerAbs{
	
	public Bot(String name, int aircraft_limit) {
		this.name = name;
		initInfo();
		this.aircraft_limit = aircraft_limit;
	}

}
