package activities;

public abstract class RollActivity extends ActivityAbs{
	
	protected FightActivity playActivity;
	
	public RollActivity(FightActivity playActivity, int x, int y) {
		this.playActivity = playActivity;
		this.xPos = x;
		this.yPos = y;
	}
	
	public abstract void setPosSize1();
	
	public abstract void setPosSize2();

	@Override
	public void setTheme1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTheme2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int action(int xMouse, int yMouse) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void myActivity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
