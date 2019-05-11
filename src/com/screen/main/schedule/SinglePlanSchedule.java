package com.screen.main.schedule;

import java.util.Scanner;

import com.screen.Screen;

public class SinglePlanSchedule extends Screen {

	private static Screen screen = null;
	private final String EXIT_KEY = "E";
	private final String EDIT_TASK_KEY = "E";
	private final String DELETE_TASK_KEY = "D";
	
	private SinglePlanSchedule() {
		this.setPreviousScreen(Screen.VIEW_SCHEDULE_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new SinglePlanSchedule();
		}
		
		return screen;
	}
	
	@Override
	public void display() {
		System.out.println("\t\tVIEW PLAN SCHEDULE");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		boolean planExists = false;
		String input = null;
		
		System.out.println("Enter plan code (or press "+EXIT_KEY+" to exit):");
		
		do {
			input = scanner.next();
			
			if (EXIT_KEY.equals(input.toUpperCase())) {
				return this.getPreviousScreen();
			}
			
			// plan = getController().getPlanCode(input);
		} while(!planExists);
		
		System.out.println("Press "+EDIT_TASK_KEY+" if you want to go to EDIT TASK screen. Or press "+DELETE_TASK_KEY+" if you want to go to DELETE TASK screen.");
		
		input = scanner.next();
		
		if (EDIT_TASK_KEY.equals(input)) {
			return Screen.TASK_EDIT_SCREEN;
		}
		if (DELETE_TASK_KEY.equals(input)) {
			return Screen.TASK_DELETE_SCREEN;
		}
		
		return Screen.MAIN_SCREEN;
	}

}
