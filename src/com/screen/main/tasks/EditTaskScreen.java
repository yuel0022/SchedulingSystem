package com.screen.main.tasks;

import java.util.Scanner;

import com.screen.Screen;

public class EditTaskScreen extends Screen {

	private static Screen screen = null;
	
	private String EXIT_KEY = "E";
	private final String NO_PARENT_TASK = "N";
	
	private EditTaskScreen() {
		this.setPreviousScreen(Screen.TASK_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new EditTaskScreen();
		}
		
		return screen;
	}
	
	@Override
	public void display() {
		System.out.println("\t\tEDIT TASK");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		boolean taskExists = false;
		boolean isValidDuration = false;
		boolean parentTaskExists = false;
		
		String input = null;
		String code = null;
		String name = null;
		int duration = 0;
		String parentTaskCode = null;
		
		System.out.println("Enter task code (or press "+EXIT_KEY+" to exit):");
		
		do {
			code = scanner.next();
			
			if (EXIT_KEY.equals(code.toUpperCase())) {
				return this.getPreviousScreen();
			}
			
			// taskExists = getController().getTaskCode(code);
		} while(!taskExists);
		
		System.out.println("Enter Task Name:");
		
		name = scanner.next();
		
		System.out.println("Enter Duration (Number of days):");
		
		while (!isValidDuration) {
			input = scanner.next();
			
			if (!input.matches("[0-9]")) {
				System.out.println("Invalid number format. Please try again.");
			} else {
				duration = Integer.parseInt(input);
				
				if (duration <= 0) {
					System.out.println("Invalid value. Duration should be an integer value greater than zero.");
				} else {
					isValidDuration = true;
				}
			}
		}
		
		System.out.println("Enter Parent Task (The task on which this task will be dependent on. Press "+NO_PARENT_TASK+" if this task is not dependent on another task.):");
		
		while (!parentTaskExists) {
			parentTaskCode = scanner.next();
			
			// parentTaskExists = getController().isCodeAlreadyExisting(parentTaskCode);
			parentTaskExists = NO_PARENT_TASK.equals(parentTaskCode);
		}
		
		System.out.println("Task has been modified.");
		
		return Screen.MAIN_SCREEN;
	}

}
