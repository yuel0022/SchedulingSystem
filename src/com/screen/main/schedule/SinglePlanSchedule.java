package com.screen.main.schedule;

import java.io.IOException;
import java.util.Scanner;

import com.model.ProjectPlan;
import com.screen.Screen;

public class SinglePlanSchedule extends Screen {

	private static Screen screen = null;
	private final String EXIT_KEY = "E";
	
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
		
		System.out.println("Press ENTER to return to previous screen.");
		
		try {
			System.in.read();
		} catch (IOException e) {
			System.out.println("Error reading command.");
			e.printStackTrace();
		}
		
		return Screen.MAIN_SCREEN;
	}

}
