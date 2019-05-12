package com.screen.main.schedule;

import java.io.IOException;
import java.util.Scanner;

import com.screen.Screen;

public class AllPlansSchedule extends Screen {

	private static Screen screen = null;
	
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
		System.out.println("Press ENTER to return to previous screen.");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		String input = null;
		
		this.displayAllPlans();
		
		try {
			System.in.read();
		} catch (IOException e) {
			System.out.println("Error reading command.");
			e.printStackTrace();
		}
		
		return this.getPreviousScreen();
	}

}
