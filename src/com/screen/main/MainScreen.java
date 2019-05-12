package com.screen.main;

import java.util.Scanner;

import com.screen.Screen;

public class MainScreen extends Screen {
	
	private final String INPUT_PLANS = "1";
	private final String INPUT_TASKS = "2";
	private final String INPUT_SCHED = "3";
	private final String INPUT_EXIT = "4";
	
	private static Screen screen = null;
	
	private MainScreen() {
		this.setPreviousScreen(Screen.MAIN_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new MainScreen();
		}
		
		return screen;
	}

	@Override
	public void display() {
		System.out.println("\t\tWelcome to DR. SOLUS' PROJECT SCHEDULER");
		System.out.println(Screen.DISPLAY_CHOOSE_OPTION);
		System.out.println(INPUT_PLANS + ". Project Plans");
		System.out.println(INPUT_TASKS + ". Tasks");
		System.out.println(INPUT_SCHED + ". View Schedule");
		System.out.println(INPUT_EXIT + ". Exit");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		String input = null;
		boolean invalidInput = false;
		
		do {
			invalidInput = false;
			input = scanner.next();
			
			if (INPUT_PLANS.equals(input)) {
				return Screen.PLAN_SCREEN;
			} else if (INPUT_TASKS.equals(input)) {
				return Screen.TASK_SCREEN;
			} else if (INPUT_SCHED.equals(input)) {
				if (getController().hasExistingPlans()) {
					return Screen.VIEW_SCHEDULE_SCREEN;
				}
				System.out.println(Screen.MSG_NO_EXISTING_PLANS);
				return this;
			} else if (INPUT_EXIT.equals(input)) {
				return Screen.EXIT;
			} else {
				System.out.println(Screen.DISPLAY_ERROR_MSG);
				invalidInput = true;
			}
		} while (invalidInput);
		
		return this;
	}

}
