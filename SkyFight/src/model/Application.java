package model;

import control.AppController;

public class Application {
	
	AppController appController = new AppController();
	
	public Application() {
		
	}
	
	public void run() {
		//1. initialize entities
		appController.initApp();
		//2. start run application in a loop
		appController.loopApp();
	}
}
