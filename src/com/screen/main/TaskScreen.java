package com.screen.main;

import java.util.Scanner;

import com.screen.Screen;

public class TaskScreen extends Screen {
	
	private final String INPUT_CREATE = "1";
	private final String INPUT_VIEW = "2";
	private final String INPUT_DELETE = "3";
	private final String INPUT_RETURN = "4";

	private static Screen screen = null;
	
	private TaskScreen() {
		this.setPreviousScreen(Screen.MAIN_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new TaskScreen();
		}
		
		return screen;
	}
	
	@Override
	public void display() {
		System.out.println("\t\tTASKS");
		System.out.println(Screen.DISPLAY_CHOOSE_OPTION);
		System.out.println(INPUT_CREATE + ". Create Task");
		System.out.println(INPUT_VIEW + ". Edit Task");
		System.out.println(INPUT_DELETE + ". Delete Task");
		System.out.println(INPUT_RETURN + ". Return");
	}

	@Override
	public Screen acceptCommand() {
		Scanner scanner = getController().getScanner();
		String input = null;
		boolean invalidInput = false;
		
		do {
			invalidInput = false;
			input = scanner.next();
			
			if (INPUT_CREATE.equals(input)) {
				return Screen.TASK_CREATE_SCREEN;
			} else if (INPUT_VIEW.equals(input)) {
				return Screen.TASK_EDIT_SCREEN;
			} else if (INPUT_DELETE.equals(input)) {
				return Screen.TASK_DELETE_SCREEN;
			} else if (INPUT_RETURN.equals(input)) {
				return this.getPreviousScreen();
			} else {
				System.out.println(Screen.DISPLAY_ERROR_MSG);
				invalidInput = true;
			}
		} while (invalidInput);
		
		return this;
	}

}
