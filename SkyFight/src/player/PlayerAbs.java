package player;

public abstract class PlayerAbs {
	
	boolean isInTurn = false;
	
	PlayerState playerState = PlayerState.Playing;
	
	public void inTurn(boolean in) {
		this.isInTurn = in;
	}
	
	public boolean getIsInTurn() {
		return this.isInTurn;
	}
	
	public PlayerState getState() {
		return this.playerState;
	}
	
	public void isWin() {
		this.playerState = PlayerState.Win;
	}
	
	public void isLose() {
		this.playerState = PlayerState.Lose;
	}
	
	public abstract void move();
	
}
