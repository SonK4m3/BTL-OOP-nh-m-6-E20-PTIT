package test;

import control.AppController;
import frame.Activity;
import frame.ActivityAbs;
import frame.Screen;
import input.MouseState;

public class Test{
	
	AppController myAppController = new AppController();
	
	Screen screen;
	
	// activities 
	ActivityAbs home;
	ActivityAbs menu;
	ActivityAbs play;
	
	public Test() {
		// initial first activities
		screen = new Screen(new Activity());
		//constructor
		home = new HomeScreen();
		menu = new MenuActivity();
		play = new PlayActivity();
		//add first activity
		screen.addActivity(home);
		
	}
	
	public void run() {
		//application loop
		while(true) {
			// when clicked left pressed
			if(screen.getMouseState() == MouseState.LEFTPRESSED) {
				// debug
				// print mouse position
				System.out.println(screen.getXMouse() + " " + screen.getYMouse());
				// get element is pressed in activity
				int state = screen.getCurrentActivity().action(screen.getXMouse(), screen.getYMouse());
				// check each activity event
				// check what activity is active
				if(screen.getCurrentActivity() == home) {
					if(state == 1) {
						// if click switch button, we reset current activity
						screen.addActivity(play);
					}
					else if(state == 2) {
						screen.addActivity(menu);
					}					
				}
				else if (screen.getCurrentActivity() == menu) {
					if(state == 1) {
						screen.addActivity(home);
					}
				}
			}
			// set thread to clicked
			try {
				Thread.sleep(85);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			// repaint image
			screen.repaint();
		}
	}
	
	public static void main(String args[]) {
		// initial test app
		Test test = new Test();
		// run loop
		test.run();
	}
}
