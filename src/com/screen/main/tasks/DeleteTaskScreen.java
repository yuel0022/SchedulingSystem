package com.screen.main.tasks;

import java.util.Scanner;

import com.screen.Screen;

public class DeleteTaskScreen extends Screen {

	private static Screen screen = null;
	
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
		String input = null;
		
		System.out.println("Enter task code to delete:");
		
		input = scanner.next();
		
		if (input != null && input.equals("1")) {
			return this.getPreviousScreen();
		}
		
		return this;
	}

}
