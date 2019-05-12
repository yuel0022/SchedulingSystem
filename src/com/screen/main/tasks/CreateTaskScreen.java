package com.screen.main.tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.scheduler.GenUtil;
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
		boolean validCode = false;
		
		String planCode = null;
		String taskCode = null;
		String name = null;
		int duration = 0;
		List<String> parentTasks = new ArrayList<String>();
		String parentTaskCode = null;
		
		// if list of plans is empty, return to main screen
		if (!getController().hasExistingPlans()) {
			System.out.println("There are no project plans created yet. Please create a project plan. (Press ENTER to proceed)\n");
			try {
				System.in.read();
			} catch (IOException e) {
				System.out.println("Error reading command.");
				e.printStackTrace();
			}
			return Screen.PLAN_CREATE_SCREEN;
		}
		
		System.out.println("Enter Project Plan Code (or press "+EXIT_KEY+" to return):");
		while (true) {
			planCode = scanner.next();
			
			if (EXIT_KEY.equals(planCode)) {
				return this.getPreviousScreen();
			}
			
			if (getController().isPlanExisting(planCode)) {
				break;
			}
			
			System.out.println("Project Plan with code " + planCode + " does not exist.");
		}
		
		System.out.println("Enter Task Code (Must consist of four alphanumeric characters):");
		
		do {
			taskCode = scanner.next();
			
			if (getController().isCodeValid(taskCode)) {
				if (getController().isCodeAlreadyExisting(taskCode)) {
					System.out.println("Code already exists.");
				} else {
					validCode = true;
				}
			}
		} while (!validCode);
		
		System.out.println("Enter Task Name:");
		
		name = scanner.next();
		
		System.out.println("Enter Duration (Number of days):");
		
		duration = GenUtil.getDuration(scanner);
		
		System.out.println("Enter Parent Task(s) (The task on which this task will be dependent on. Press "+EXIT_KEY+" to stop entering tasks and proceed):");
		System.out.println("NOTE: Parent tasks should belong to the same project plan as this task.");
		
		while (true) {
			parentTaskCode = scanner.next();
			
			if (EXIT_KEY.equals(parentTaskCode)) {
				break;
			}
			
			if (!getController().isTaskExisting(parentTaskCode)) {
				System.out.println("Task Code " + parentTaskCode + " does not exist.");
			} else if (!getController().isTaskInTheSamePlan(parentTaskCode, planCode)) {
				System.out.println("Task does not belong in project plan " + planCode);
			} /*if (getController().isChildTask(taskCode, parentTaskCode)) {
				System.out.println("You cannot set a task dependent to this task as a parent task.");
			} */else {
				if (!parentTasks.contains(parentTaskCode)) {
					System.out.println("Task " + parentTaskCode + " added.");
					parentTasks.add(parentTaskCode);
				} else {
					System.out.println("Task " + parentTaskCode + " is already added in the lsit.");
				}
			}
		}
		
		getController().createTask(planCode, taskCode, name, duration, parentTasks);
		
		System.out.println("Task has been created.");
		
		return Screen.MAIN_SCREEN;
	}

}
