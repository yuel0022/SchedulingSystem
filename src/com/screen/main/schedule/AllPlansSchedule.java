package com.screen.main.schedule;

import java.util.Scanner;

import com.screen.Screen;

public class AllPlansSchedule extends Screen {

	private static Screen screen = null;
	private final String EXIT_KEY = "E";
	
	private AllPlansSchedule() {
		this.setPreviousScreen(Screen.VIEW_SCHEDULE_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new AllPlansSchedule();
		}
		
		return screen;
	}
	
	@Override
	public void display() {
		System.out.println("\t\tVIEW SCHEDULE OF ALL PLANS");
		System.out.println("Press " + EXIT_KEY + " to return to previous screen.");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		String input = scanner.next();
		
		if (EXIT_KEY.equals(input)) {
			return this.getPreviousScreen();
		}
		
		return this;
	}

}
