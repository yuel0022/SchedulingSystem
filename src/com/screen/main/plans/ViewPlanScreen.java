package com.screen.main.plans;

import java.util.Scanner;

import com.screen.Screen;

public class ViewPlanScreen extends Screen {

	private static Screen screen = null;
	
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
		String input = null;
		
		System.out.println("Enter plan code to delete:");
		
		input = scanner.next();
		
		if (input != null) {
			return this.getPreviousScreen();
		}
		
		return this;
	}

}
