package com.screen.main;

import java.util.Scanner;

import com.screen.Screen;

public class ViewScheduleScreen extends Screen {

	private final String INPUT_SINGLE_PLAN = "1";
	private final String INPUT_ALL_PLANS = "2";
	private final String INPUT_RETURN = "3";
	
	private static Screen screen = null;
	
	private ViewScheduleScreen() {
		this.setPreviousScreen(Screen.MAIN_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new ViewScheduleScreen();
		}
		
		return screen;
	}
	
	@Override
	public void display() {
		
		System.out.println("\t\tVIEW SCHEDULE");
		System.out.println(Screen.DISPLAY_CHOOSE_OPTION);
		System.out.println(INPUT_SINGLE_PLAN + ". For a single plan");
		System.out.println(INPUT_ALL_PLANS + ". For all plans");
		System.out.println(INPUT_RETURN + ". Return");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		String input = null;
		boolean invalidInput = false;
		
		do {
			invalidInput = false;
			input = scanner.next();
			
			if (INPUT_SINGLE_PLAN.equals(input)) {
				return Screen.SCHEDULE_SINGLE_PLAN_SCREEN;
			} else if (INPUT_ALL_PLANS.equals(input)) {
				return Screen.SCHEDULE_ALL_PLANS_SCREEN;
			} else if (INPUT_RETURN.equals(input)) {
				return this.getPreviousScreen();
			} else {
				System.out.println(Screen.DISPLAY_ERROR_MSG);
				invalidInput = true;
			}
		} while (invalidInput);
		
		return this;
	}

	
}
