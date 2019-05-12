package com.screen.main.plans;

import java.util.Scanner;

import com.model.ProjectPlan;
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
		ProjectPlan plan = null;
		String code = null;
		
		System.out.println("Enter plan code (or press "+EXIT_KEY+" to exit):");
		
		do {
			code = scanner.next();
			
			if (EXIT_KEY.equals(code)) {
				return this.getPreviousScreen();
			}
			
			plan = getController().getPlan(code);
			
			if (plan == null) {
				System.out.println("Project with Plan Code " + code + " does not exist.");
			}
		} while(plan == null);
		
		this.displayPlan(plan);
		
		return Screen.MAIN_SCREEN;
	}

}
