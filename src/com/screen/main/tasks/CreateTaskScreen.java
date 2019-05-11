package com.screen.main.tasks;

import java.util.Scanner;

import com.screen.Screen;

public class CreateTaskScreen extends Screen {

	private static Screen screen = null;
	
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
		String input = null;
		
		System.out.println("Enter Task Code (Must consist of four alphanumeric characters):");
		
		input = scanner.next();
		
		System.out.println("Enter Task Name:");
		
		input = scanner.next();
		
		System.out.println("Enter Duration (Number of days):");
		
		input = scanner.next();
		
		System.out.println("Enter Parent Task (The task on which this task will be dependent on. Leave blank if this task is not dependent on another task.):");
		
		input = scanner.next();
		
		if (input != null && input.equals("1")) {
			return this.getPreviousScreen();
		}
		
		return this;
	}

}
