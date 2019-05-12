package com.screen.main.tasks;

import java.util.Scanner;

import com.screen.Screen;

public class DeleteTaskScreen extends Screen {

	private static Screen screen = null;
	
	private String EXIT_KEY = "E";
	
	private DeleteTaskScreen() {
		this.setPreviousScreen(Screen.TASK_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new DeleteTaskScreen();
		}
		
		return screen;
	}
	
	@Override
	public void display() {
		System.out.println("\t\tDELETE TASK");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		boolean taskExists = false;
		String code = null;
		
		System.out.println("Enter task code (or press "+EXIT_KEY+" to exit):");
		
		do {
			code = scanner.next();
			
			if (EXIT_KEY.equals(code)) {
				return this.getPreviousScreen();
			}
			
			// planExists = getController().deleteTaskCode(code);
		} while(!taskExists);
		
		System.out.println("Task successfully deleted.");
		
		return Screen.MAIN_SCREEN;
	}

}
