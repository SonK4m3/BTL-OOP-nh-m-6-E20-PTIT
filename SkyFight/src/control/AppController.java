package control;

import java.util.ArrayList;

import activities.*;
import frame.*;
import input.MouseState;
import notification.GameNotificationHelper;

public class AppController{
	
	public ImageController imageController = new ImageController();
	
	boolean appIsRunning;
	boolean gameIsRunning;
	
	Screen mainScreen;
	
	HomeActivity homeActivity;
	OptionActivity optionActivity;
	ChooseCraftActivity chooseScraftActivity;
	FightActivity fightActivity;
	
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
		optionActivity = (OptionActivity) createActivity(new OptionActivity());
		chooseScraftActivity = (ChooseCraftActivity) createActivity(new ChooseCraftActivity());
		fightActivity = (FightActivity) createActivity(new FightActivity());	
		
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
	
	public void resetAllActivitiesOptions() {
		for(ActivityAbs activity : listActivities) {
			if(activity.getClass() == PlayActivity.class)
				activity = (PlayActivity) activity;
			
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
	
	void setImageBeforeStartGame() {
		
		if(this.gameSize == 1) {
			gameController.setBoardPos(122, 93);
		} else {
			gameController.setBoardPos(260, 191);
		}

		if(this.aircraftType == 1) {
			gameController.setAircraftImage(imageController.blueAircraftLeftImage, 
											imageController.blueAircraftRightImage, 
											imageController.blueAircraftTopImage, 
											imageController.blueAircraftBottomImage);
		} else {
			gameController.setAircraftImage(imageController.redAircraftLeftImage, 
											imageController.redAircraftRightImage, 
											imageController.redAircraftTopImage, 
											imageController.redAircraftBottomImage);
		}
		
		if(this.boardType == 1) {
			gameController.setBoardImage(imageController.board1Image);								
		} else {
			gameController.setBoardImage(imageController.board2Image);
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
			if(mainScreen.getMouseState() == MouseState.LEFTPRESSED || mainScreen.getMouseState() == MouseState.RIGHTPRESSED) {
				//debug
				//print mouse position
//				System.out.println("pressed mouse position: " + mainScreen.getXMouse() + " " + mainScreen.getYMouse());
				// get element is pressed in activity
				int state = mainScreen.getCurrentActivity().action(mainScreen.getXMouse(), mainScreen.getYMouse());
				// check each activity event
				// check what activity is active
				if(mainScreen.getCurrentActivity() == homeActivity) {
					if(state == 1) {
						if(!gameIsRunning) {
							gameIsRunning = true;
							this.gameController = new GameController();
							//initial image before start game loop
							this.setImageBeforeStartGame();
							chooseScraftActivity.setGameController(gameController);
						}
						// if click switch button, we reset current activity
						mainScreen.addActivity(chooseScraftActivity);
					}
					else if(state == 2) {
						mainScreen.addActivity(optionActivity);
						optionActivity.getCurrentSetting();
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
					
					if(state == 1) {
						gameIsRunning = false;
						mainScreen.addActivity(homeActivity);
					} else if(state == 2) {
						fightActivity.setGameController(gameController);
						fightActivity.displayHeadMessage();
						mainScreen.addActivity(fightActivity);
					}
				} 
				else if(mainScreen.getCurrentActivity() == fightActivity) {
					if(gameController.gameFinished()) {
						fightActivity.setLabel(true);
						chooseScraftActivity.gameNotificationHelper.setHeadMessage(null);
					}
					
					if(state == 1) {
						gameIsRunning = false;
						fightActivity.setLabel(false);
						mainScreen.addActivity(homeActivity);
					} 
					else if(state == 2) {
						fightActivity.setLabel(false);
						gameController.newGame();
						this.setImageBeforeStartGame();
						mainScreen.addActivity(chooseScraftActivity);
					}
				}
			}
			mainScreen.setIsPressedMouse(MouseState.NONE);
			// repaint image
			mainScreen.repaint();
		}
	}
}
