package com.screen.main.plans;

import java.util.Scanner;

import com.screen.Screen;

public class ViewPlanScreen extends Screen {

	private static Screen screen = null;
	
	private String EXIT_KEY = "E";
	
	private ViewPlanScreen() {
		this.setPreviousScreen(Screen.PLAN_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new ViewPlanScreen();
		}
		
		return screen;
	}
	
	@Override
	public void display() {
		System.out.println("VIEW PLAN");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		boolean planExists = false;
		String code = null;
		
		System.out.println("Enter plan code (or press "+EXIT_KEY+" to exit):");
		
		do {
			code = scanner.next();
			
			if (EXIT_KEY.equals(code.toUpperCase())) {
				return this.getPreviousScreen();
			}
			
			// plan = getController().getPlanCode(code);
		} while(!planExists);
		
		return Screen.MAIN_SCREEN;
	}

}
