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
		String input = null;
		
		System.out.println("Enter Plan Code (Must consist of four alphanumeric characters):");
		
		input = scanner.next();
		
		System.out.println("Enter Plan Name:");
		
		input = scanner.next();
		
		System.out.println("Enter Start Date:");
		
		input = scanner.next();
		
		if (input != null && input.equals("1")) {
			return this.getPreviousScreen();
		}
		
		return this;
	}

}
