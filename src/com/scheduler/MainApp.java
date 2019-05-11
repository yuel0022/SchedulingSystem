package com.scheduler;

import com.screen.Screen;

public class MainApp {
	
	public static void main(String[] args) {
		Screen appScreen = Screen.MAIN_SCREEN;
		MainController controller = new MainController();
		
		/* initialize controller in view */
		Screen.MAIN_SCREEN.setController(controller);
		Screen.PLAN_SCREEN.setController(controller);
		Screen.TASK_SCREEN.setController(controller);
		Screen.VIEW_SCHEDULE_SCREEN.setController(controller);
		Screen.PLAN_CREATE_SCREEN.setController(controller);
		Screen.PLAN_DELETE_SCREEN.setController(controller);
		Screen.PLAN_VIEW_SCREEN.setController(controller);
		Screen.TASK_CREATE_SCREEN.setController(controller);
		Screen.TASK_DELETE_SCREEN.setController(controller);
		Screen.TASK_VIEW_SCREEN.setController(controller);
		Screen.SCHEDULE_SINGLE_PLAN_SCREEN.setController(controller);
		Screen.SCHEDULE_ALL_PLANS_SCREEN.setController(controller);
		
		while(true) {
			appScreen.display();
			appScreen = appScreen.acceptCommand();
			
			if (Screen.EXIT.equals(appScreen)) {
				appScreen.display();
				break;
			} else if (appScreen == null) {
				System.out.println("An unexpected error has occured.");
			}
		}
		
		controller.close();
	}
}
