package com.screen.main.plans;

import java.util.Scanner;

import com.screen.Screen;

public class CreatePlanScreen extends Screen {

	private static Screen screen = null;
	
	private CreatePlanScreen() {
		this.setPreviousScreen(Screen.PLAN_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new CreatePlanScreen();
		}
		
		return screen;
	}
	
	@Override
	public void display() {
		System.out.println("\t\tCREATE PLAN");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		boolean validCode = false;
		String code = null;
		String name = null;
		String date = null;
		
		System.out.println("Enter Plan Code (Must consist of four alphanumeric characters):");
		
		do {
			code = scanner.next();
			
			if (getController().isCodeValid(code)) {
				if (getController().isCodeAlreadyExisting(code)) {
					System.out.println("Code already exists.");
				} else {
					validCode = true;
				}
			}
		} while (!validCode);
		
		System.out.println("Enter Plan Name:");
		
		name = scanner.next();
		
		System.out.println("Enter Start Date (mm/dd/yyyy):");
		
		do {
			date = scanner.next();
		} while (!getController().isValidDate(date));
		
		getController().createPlan(code, name, date);
		
		System.out.println("Plan successfully created.\n\n");
		
		return Screen.MAIN_SCREEN;
	}

}
