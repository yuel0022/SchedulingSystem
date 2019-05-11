package com.screen.main.schedule;

import java.util.Scanner;

import com.screen.Screen;

public class SinglePlanSchedule extends Screen {

	private static Screen screen = null;
	
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
		String input = null;
		
		System.out.println("Enter plan code:");
		
		input = scanner.next();
		
		if (input != null && input.equals("1")) {
			return this.getPreviousScreen();
		}
		
		return this;
	}

}
