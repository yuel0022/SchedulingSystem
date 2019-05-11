package com.screen.main.plans;

import java.util.Scanner;

import com.screen.Screen;

public class DeletePlanScreen extends Screen {

	private static Screen screen = null;
	
	private DeletePlanScreen() {
		this.setPreviousScreen(Screen.PLAN_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new DeletePlanScreen();
		}
		
		return screen;
	}
	
	@Override
	public void display() {
		System.out.println("\t\tDELETE PLAN");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		String input = null;
		
		System.out.println("Enter plan code to delete:");
		
		input = scanner.next();
		
		if (input != null && input.equals("1")) {
			return this.getPreviousScreen();
		}
		
		return this;
	}

}
