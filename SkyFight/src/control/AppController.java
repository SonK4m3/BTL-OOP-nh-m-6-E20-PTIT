package control;

import java.util.ArrayList;

import javax.swing.ComponentInputMap;

import activities.*;
import frame.*;
import input.MouseState;
import test.GameController;


public class AppController {
	
	public ImageController imageController;
	
	boolean appIsRunning;
	GameController gameController;
	Screen mainScreen;			//frame
	boolean gameIsRunning = false;
	HomeActivity homeActivity;	//title panel
	OptionActivity optionActivity;	// option panel
	ChooseCraftActivity chooseScraftActivity;	//place craft panel
	ActivityAbs playActivity;			// shoot panel
	
	ArrayList<ActivityAbs> listActivities = new ArrayList<ActivityAbs>();		//list of panel
	
	public AppController() {
		
	}
	
	public void initApp() {		//initialize application
		//loading image before start game
//		imageController = new ImageController();
//		imageController.initImage();
		
		appIsRunning = true;	//app is running
		
		mainScreen = new Screen(this, new Activity());		//create frame
		
		homeActivity = (HomeActivity) createActivity(new HomeActivity());		//create title panel
		chooseScraftActivity = (ChooseCraftActivity) createActivity(new ChooseCraftActivity());		//create place craft panel	
		optionActivity = (OptionActivity) createActivity(new OptionActivity());		//create option panel
		
		//add first activity to screen
		mainScreen.addActivity(chooseScraftActivity);			//add place craft panel to frame
//		mainScreen.addActivity(homeActivity);
	}
	
	ActivityAbs createActivity(ActivityAbs activity) {			
		this.listActivities.add(activity);
		return activity;
	}
	
	public void resizeAllActivities() {
		int newWidth = optionActivity.getActivityWidth();
		int newHeight = optionActivity.getActivityHeight();
		
		for(ActivityAbs activity : listActivities) {
			activity.reSize(newWidth, newHeight);			
		}
	}
	
	public void loopApp() {
		// application loop
		while(appIsRunning) {
			try {
				Thread.sleep(85);
			} catch(Exception e) {
				e.printStackTrace();
			}
			//get mouse event 
			if(mainScreen.getMouseState() == MouseState.LEFTPRESSED) {
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
					}
					else if(state == 2) {
						mainScreen.addActivity(optionActivity);
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
					else if(state == 3) {
						mainScreen.addActivity(homeActivity);
					}
				}
				else if(mainScreen.getCurrentActivity() == chooseScraftActivity) {
					if(gameIsRunning == false) {
						gameIsRunning = true;
						gameController = new GameController();
						chooseScraftActivity.setGameController(gameController);
					
					
					}
					if(state == 3) {
						gameIsRunning = false;
						mainScreen.addActivity(homeActivity);
					}
				}
				
				
			}
//			computation logic = new computation(board);
			// set thread to clicked
		
			this.mainScreen.setIsPressedMouse(MouseState.NONE);
//			mainScreen.setIsPressedMouse(MouseState.NONE);
			// repaint image
			mainScreen.repaint();
		}
	}
}
