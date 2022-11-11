package control;

import java.util.ArrayList;

import activities.*;
import frame.*;
import input.MouseState;

public class AppController{
	
	public ImageController imageController = new ImageController();
	
	boolean appIsRunning;
	boolean gameIsRunning;
	
	Screen mainScreen;
	
	HomeActivity homeActivity;
	OptionActivity optionActivity;
	ChooseCraftActivity chooseScraftActivity;
	ActivityAbs playActivity;
	
	ArrayList<ActivityAbs> listActivities = new ArrayList<ActivityAbs>();
	
	GameController gameController;
	
	public int theme = 1;
	public int gameSize = 1;
	public int aircraftType = 1;
	public int boardType = 1;
	
	public AppController() {
		
	}
	
	public void initApp() {
		//loading image before start game
		imageController.initImage();
		//initial screen and activities
		mainScreen = new Screen(this, new Activity());
				
		homeActivity = (HomeActivity) createActivity(new HomeActivity());
		chooseScraftActivity = (ChooseCraftActivity) createActivity(new ChooseCraftActivity());
		optionActivity = (OptionActivity) createActivity(new OptionActivity());
			
		mainScreen.addActivity(homeActivity);
		
		appIsRunning = true;
		gameIsRunning = false;
	}
	
	ActivityAbs createActivity(ActivityAbs activity) {
		this.listActivities.add(activity);
		activity.setScreen(mainScreen);
		activity.update();
		return activity;
	}
	
	public void resettingAllActivities() {
		
		for(ActivityAbs activity : listActivities) {
			if(this.gameSize == 1) {
				activity.setSize1();
			} else {
				activity.setSize2();
			}
			if(this.theme == 1) {
				activity.setTheme1();
			} else {
				activity.setTheme2();
			}
		}
	}
	
	public void loopApp() {
		// application loop
		while(appIsRunning) {
			// set thread to clicked
			try {
				Thread.sleep(60);
			} catch(Exception e) {
				e.printStackTrace();
			}
			//get mouse event 
			if(mainScreen.getMouseState() == MouseState.LEFTPRESSED || mainScreen.getMouseState() == MouseState.LEFTPRESSED) {
				//debug
				//print mouse position
				System.out.println("pressed mouse position: " + mainScreen.getXMouse() + " " + mainScreen.getYMouse());
				// get element is pressed in activity
				int state = mainScreen.getCurrentActivity().action(mainScreen.getXMouse(), mainScreen.getYMouse());
				// check each activity event
				// check what activity is active
				if(mainScreen.getCurrentActivity() == homeActivity) {
					if(state == 1) {
						// if click switch button, we reset current activity
						mainScreen.addActivity(chooseScraftActivity);
						// and start initial gameLoop
						gameIsRunning = true;
					}
					else if(state == 2) {
						mainScreen.addActivity(optionActivity);
						optionActivity.getCurrentSetting();
					}				
					else if(state == 3) {
						appIsRunning = false;
						System.exit(0);
					}
				}
				else if(mainScreen.getCurrentActivity() == optionActivity) {
					if(state == 1) {
						mainScreen.addActivity(homeActivity);
					}
					else if(state == 2) {
						mainScreen.addActivity(homeActivity);
					}
				}
				else if(mainScreen.getCurrentActivity() == chooseScraftActivity) {
					
					if(!gameIsRunning) {
						this.gameController = new GameController();
					}
					else {
						chooseScraftActivity.gameNotificationHelper.addNotice(this.mainScreen.getXMouse() + " " + this.mainScreen.getYMouse());
					}
					
					if(state == 3) {
						mainScreen.addActivity(homeActivity);
						gameIsRunning = false;
					}
				}
				
			}
			mainScreen.setIsPressedMouse(MouseState.NONE);
			// repaint image
			mainScreen.repaint();
		}
	}
}
