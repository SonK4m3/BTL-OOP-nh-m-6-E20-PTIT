package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import button.ConfirmButton;
import button.SwitchActivityButton;
import input.MouseState;
import notification.GameNotificationHelper;

public class PlayActivity extends ActivityAbs{
	SwitchActivityButton backButton;
	
	int[] rec1 = new int[] {65, 40, 830, 415};
	int[] boardLayout = new int[] {65, 40, 415, 415};
	int[] posBoard = new int[] {122, 93};
	int[] posMessage = new int[] {514, 86, 350, 200};
	int[] posBackButton = new int[] {714, 389};
	
	Color rec1Color = new Color(117,213,227);
	Color boardLayoutColor = new Color(250,252,144);
	
	public GameNotificationHelper gameNotificationHelper;
	
	public PlayActivity() {
		this.myActivity();
		this.init();	
	}
	
	@Override
	public void myActivity() {
		this.setSize1();
	}
	
	@Override
	public void init() {
		this.setPreferredSize(new Dimension(activityWidth, activityHeight));
		this.setBackground(new Color(255,255,255));			
		backButton = new SwitchActivityButton(this, posBackButton[0], posBackButton[1]);
	
		gameNotificationHelper = new GameNotificationHelper();
		gameNotificationHelper.setPosSize(posMessage[0], posMessage[1] + 20, posMessage[2], posMessage[3]/5);
	}

	@Override
	public void update() {
		this.backgroundImage = this.screen.getImageController().blueSkyImage; 
		backButton.setImage(this.screen.getImageController().backButtonImage);
	}
	
	@Override
	public void setSize1() {
		super.setSize1();
		rec1 = new int[] {65, 40, 830, 415};
		boardLayout = new int[] {65, 40, 415, 415};
		posBoard = new int[] {122, 93};
		posMessage = new int[] {514, 86, 350, 200};
		posBackButton = new int[] {714, 389};
		
		if(gameNotificationHelper != null) {
			gameNotificationHelper.setPosSize(posMessage[0], posMessage[1] + 20, posMessage[2], posMessage[3]/5);
			gameNotificationHelper.setNumberMessage(4);
		}
		resetButton();
	}
	
	@Override
	public void setSize2() {
		super.setSize2();
		rec1 = new int[] {115, 86, 1050, 520};
		boardLayout = new int[] {190, 121, 450, 450};
		posBoard = new int[] {260, 191};
		posMessage = new int[] {677, 146, 450, 300};
		posBackButton = new int[] {977, 543};

		if(gameNotificationHelper != null) {
			gameNotificationHelper.setPosSize(posMessage[0], posMessage[1] + 30, posMessage[2] - 1, posMessage[3]/6);
			gameNotificationHelper.setNumberMessage(5);
		}
		resetButton();
	}
	
	void resetButton() {
		setButtonSize(backButton, posBackButton[0], posBackButton[1]);
	}
	
	@Override
	public void setTheme1() {
		this.backgroundImage = this.screen.getImageController().blueSkyImage; 
		rec1Color = new Color(117,213,227);
		boardLayoutColor = new Color(250,252,144);
		this.gameNotificationHelper.setTheme1();
	}

	@Override
	public void setTheme2() {
		this.backgroundImage = this.screen.getImageController().nightSkyImage; 
		rec1Color = new Color(72,52,117);
		boardLayoutColor = new Color(36,40,70);
		this.gameNotificationHelper.setTheme2();
	}
	
	@Override
	public int action(int xMouse, int yMouse) {
		if(backButton.isPressed(xMouse, yMouse) && this.screen.getMouseState() == MouseState.LEFTPRESSED) {
			System.out.println("Back to Home Activity");
			return 3;
		} 
		// if ....
		
		return -1;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(rec1Color);
		g.fillRect(rec1[0], rec1[1], rec1[2], rec1[3]);
		
		g.setColor(boardLayoutColor);
		g.fillRect(boardLayout[0],boardLayout[1],boardLayout[2],boardLayout[3]);
		
		g.setColor(Color.gray);
		g.fillRect(posMessage[0], posMessage[1], posMessage[2], posMessage[3]);
		
		gameNotificationHelper.paint(g);
		
		backButton.paint(g);
	}

}
