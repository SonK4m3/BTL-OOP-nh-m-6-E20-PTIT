package control;

import java.util.ArrayList;

import activities.*;
import frame.*;
import input.MouseState;

public class AppController {
	
	public ImageController imageController;
	
	boolean appIsRunning;
	
	Screen mainScreen;
	
	HomeActivity homeActivity;
	OptionActivity optionActivity;
	ChooseCraftActivity chooseScraftActivity;
	ActivityAbs playActivity;
	
	ArrayList<ActivityAbs> listActivities = new ArrayList<ActivityAbs>();
	
	public AppController() {
		
	}
	
	public void initApp() {
		//loading image before start game
		imageController = new ImageController();
		imageController.initImage();
		
		appIsRunning = true;
		
		mainScreen = new Screen(this, new Activity());
		
		homeActivity = (HomeActivity) createActivity(new HomeActivity());
		chooseScraftActivity = (ChooseCraftActivity) createActivity(new ChooseCraftActivity());
		optionActivity = (OptionActivity) createActivity(new OptionActivity());
		
		mainScreen.addActivity(homeActivity);
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
					if(state == 3) {
						mainScreen.addActivity(homeActivity);
					}
				}
				
				
			}
			// set thread to clicked
			try {
				Thread.sleep(85);
			} catch(Exception e) {
				e.printStackTrace();
			}
			// repaint image
			mainScreen.repaint();
		}
	}
}
