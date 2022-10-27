package test;

import control.AppController;
import frame.Activity;
import frame.ActivityAbs;
import frame.Screen;
import input.MouseState;

public class Test{
	
	AppController myAppController = new AppController();
	
	Screen screen;
	
	ActivityAbs home;
	ActivityAbs menu;
	
	public Test() {
		screen = new Screen(new Activity());
		home = new HomeScreen();
		menu = new MenuActivity();
		screen.addActivity(home);
		
	}
	
	public void run() {
		while(true) {
			if(screen.getMouseState() == MouseState.LEFTPRESSED) {
				System.out.println(screen.getXMouse() + " " + screen.getYMouse());
				int state = screen.getCurrentActivity().action(screen.getXMouse(), screen.getYMouse());
				if(state == 1) {
//					try {
//						Thread.sleep(60);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					
//					screen.remove(home);
//					screen.add(menu);
//					screen.revalidate();
					screen.addActivity(menu);
				}
			}
			
			try {
				Thread.sleep(85);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		Test test = new Test();
		test.run();
	}
}
