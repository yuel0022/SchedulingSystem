package com.screen.main.tasks;

import java.util.Scanner;

import com.scheduler.GenUtil;
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
		boolean parentTaskExists = false;
		
		String code = null;
		String name = null;
		int duration = 0;
		String parentTaskCode = null;
		
		System.out.println("Enter task code (or press "+EXIT_KEY+" to exit):");
		
		while (true) {
			code = scanner.next();
			
			if (EXIT_KEY.equals(code.toUpperCase())) {
				return this.getPreviousScreen();
			}
			
			if (getController().isTaskExisting(code)) {
				break;
			}
			
			System.out.println("Task with code " + code + " does not exist.");
		}
		
		System.out.println("Enter Task Name:");
		
		name = scanner.next();
		
		System.out.println("Enter Duration (Number of days):");
		
		duration = GenUtil.getDuration(scanner);
		
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
