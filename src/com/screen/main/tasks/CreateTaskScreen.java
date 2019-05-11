package com.screen.main.tasks;

import java.util.Scanner;

import com.screen.Screen;

public class CreateTaskScreen extends Screen {

	private static Screen screen = null;
	
	private final String EXIT_KEY = "E";
	
	private CreateTaskScreen() {
		this.setPreviousScreen(Screen.TASK_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new CreateTaskScreen();
		}
		
		return screen;
	}
	
	@Override
	public void display() {
		System.out.println("\t\tCREATE TASK");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		boolean isValidDuration = false;
		boolean parentTaskExists = false;
		
		String input = null;
		String code = null;
		String name = null;
		int duration = 0;
		String parentTaskCode = null;
		
		// if list of plans is empty, return to main screen
		/*if (getController().isPlanListEmpty()) {
			System.out.println("There are no project plans created yet. Please create a project plan.\n");
			return Screen.PLAN_CREATE_SCREEN;
		}*/
		
		System.out.println("Enter Project Plan Code (or press "+EXIT_KEY+" to return:");
		/*do {
			code = scanner.next();
			
			if (EXIT_KEY.equals(code)) {
				return this.getPreviousScreen();
			}
		} while (!getController().isPlanExisting(code));
		
		System.out.println("Enter Task Code (Must consist of four alphanumeric characters):");
		
		do {
			code = scanner.next();
		} while (!getController().isCodeValid(code) && getController().isTaskExisting(code));*/
		
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
		
		System.out.println("Enter Parent Task (The task on which this task will be dependent on. Press "+EXIT_KEY+" to stop entering tasks and proceed):");
		
		while (!parentTaskExists) {
			parentTaskCode = scanner.next();
			
			// parentTaskExists = getController().isTaskExisting(parentTaskCode);
			parentTaskExists = EXIT_KEY.equals(parentTaskCode);
		}
		
		System.out.println("Task has been created.");
		
		return Screen.MAIN_SCREEN;
	}

}
