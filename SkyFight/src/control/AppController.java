package control;

import java.util.ArrayList;

import activities.*;
import frame.*;
import input.*;

public class AppController{

	boolean appIsRunning;
	boolean gameIsRunning;
	
	public int theme = 1;
	public int gameSize = 1;
	public int aircraftType = 1;
	public int boardType = 1;
	
	Screen mainScreen;
	
	HomeActivity homeActivity;
	OptionActivity optionActivity;
	ChooseCraftActivity chooseScraftActivity;
	FightActivity fightActivity;
	
	ArrayList<ActivityAbs> listActivities = new ArrayList<ActivityAbs>();
	
	GameController gameController;
	public ImageController imageController = new ImageController();
	
	public AppController() {
		
	}
	
	public void initApp() {
		//1. loading image before start game
		imageController.initImage();
		//2. initial screen and activities
		mainScreen = new Screen(this, new Activity());
		//3. initial activities and update image
		homeActivity = (HomeActivity) createActivity(new HomeActivity());
		optionActivity = (OptionActivity) createActivity(new OptionActivity());
		chooseScraftActivity = (ChooseCraftActivity) createActivity(new ChooseCraftActivity());
		fightActivity = (FightActivity) createActivity(new FightActivity());	
		//4. add first screen
		mainScreen.addActivity(homeActivity);
		//5. declare loop variables control
		appIsRunning = true;
		gameIsRunning = false;
	}
	
	/* 
	 *  set screen for activity
	 * 	update: read image for components
	 * 	return activity after update
	 */
	ActivityAbs createActivity(ActivityAbs activity) {
		this.listActivities.add(activity);
		activity.setScreen(mainScreen);
		activity.update();
		return activity;
	}
	
	/*
	 * all activities change size and theme
	 */
	public void resetAllActivitiesOptions() {
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
	
	/*
	 * update, read image for board and aircraft before game start
	 */
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
	
	/*
	 *  loop to catch event of each activity returned
	 * 
	 */
	public void loopApp() {
		// application loop
		while(appIsRunning) {
			// 1. set thread to clicked
			// game loop is very fast so we give thread sleep to catch with user input
			try {
				Thread.sleep(60);
			} catch(Exception e) {
				e.printStackTrace();
			}
			//2. get mouse event 
			if(mainScreen.getMouseState() == MouseState.LEFTPRESSED || mainScreen.getMouseState() == MouseState.RIGHTPRESSED) {
				//debug
				//print mouse position
//				System.out.println("pressed mouse position: " + mainScreen.getXMouse() + " " + mainScreen.getYMouse());
				// get element is pressed in current activity
				int state = mainScreen.getCurrentActivity().action(mainScreen.getXMouse(), mainScreen.getYMouse());
				// check each activity event
				// check what activity is active
				if(mainScreen.getCurrentActivity() == homeActivity) {
					/*	1 == go to chooseScraftActivity
					*	2 == go to optionActivity
					*/
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
						// option get current setting to backup
						optionActivity.getCurrentSetting();
					}				
				}
				else if(mainScreen.getCurrentActivity() == optionActivity) {
					/*
					 *	1 == back to homeActivity after do not setting
					 *	2 == save setting and back to homeActivity
					 */
					if(state == 1) {
						mainScreen.addActivity(homeActivity);
					}
					else if(state == 2) {
						mainScreen.addActivity(homeActivity);
					}
				}
				else if(mainScreen.getCurrentActivity() == chooseScraftActivity) {
					/*
					 *	1 == back to homeActivity
					 *	2 == go to fightActivity
					 */
					if(state == 1) {
						// game is out
						gameIsRunning = false;
						mainScreen.addActivity(homeActivity);
					} else if(state == 2) {
						// forward current state of board, player to fight activity
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
					
					if(fightActivity.isLabelOn()) {
						if(state == 1) {
							// back to home activity
							fightActivity.setLabel(false);
							gameIsRunning = false;
							mainScreen.addActivity(homeActivity);
						} 
						else if(state == 2) {
							// renew game state
							fightActivity.setLabel(false);
							gameController.newGame();
							this.setImageBeforeStartGame();
							mainScreen.addActivity(chooseScraftActivity);
							chooseScraftActivity.gameNotificationHelper.addNotice("--- New game ---");
						}						
					}
					
					if(fightActivity.getIsClickedBackButton()) {
						if(fightActivity.getIsClickedBackButton()) {
							chooseScraftActivity.gameNotificationHelper.setHeadMessage(null);							
						}

						if(state == 1) {
							// continue game
							fightActivity.setIsClickedBackButton(false);
						}
						else if(state == 2) {
							// renew game state
							fightActivity.setIsClickedBackButton(false);
							gameController.newGame();
							this.setImageBeforeStartGame();
							mainScreen.addActivity(chooseScraftActivity);
							chooseScraftActivity.gameNotificationHelper.addNotice("--- New game ---");
						}
						else if(state == 3) {
							// back to home activity
							fightActivity.setIsClickedBackButton(false);
							gameIsRunning = false;
							mainScreen.addActivity(homeActivity);
						}
					}
				}
			}
			// set mouse state to none to get next state
			// each user pressed we take 1 input/ 1 pressed
			mainScreen.setIsPressedMouse(MouseState.NONE);
			// 3. repaint image
			mainScreen.repaint();
		}
	}
}
