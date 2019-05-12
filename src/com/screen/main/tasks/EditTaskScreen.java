package com.screen.main.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.scheduler.GenUtil;
import com.screen.Screen;

public class EditTaskScreen extends Screen {

	private static Screen screen = null;
	
	private String EXIT_KEY = "E";
	
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
		
		String planCode = null;
		String taskCode = null;
		String name = null;
		int duration = 0;
		List<String> parentTasks = new ArrayList<String>();
		String parentTaskCode = null;
		
		System.out.println("Enter task code (or press "+EXIT_KEY+" to exit):");
		
		while (true) {
			taskCode = scanner.next();
			
			if (EXIT_KEY.equals(taskCode)) {
				return this.getPreviousScreen();
			}
			
			if (getController().isTaskExisting(taskCode)) {
				break;
			}
			
			System.out.println("Task with code " + taskCode + " does not exist.");
		}
		
		planCode = getController().getTask(taskCode).getPlan().getCode();
		
		System.out.println("Enter Task Name:");
		
		name = scanner.next();
		
		System.out.println("Enter Duration (Number of days):");
		
		duration = GenUtil.getDuration(scanner);
		
		System.out.println("Enter Parent Task(s) (The task on which this task will be dependent on. Press "+EXIT_KEY+" to stop entering tasks and proceed):");
		System.out.println("NOTE: Parent tasks should belong to the same project plan as this task.");
		System.out.println("NOTE: If you enter a task that already exists as parent task, it will be removed. Otherwise, it will be added as parent task.");
		
		while (true) {
			parentTaskCode = scanner.next();
			
			if (EXIT_KEY.equals(parentTaskCode)) {
				break;
			}
			
			if (!getController().isTaskExisting(parentTaskCode)) {
				System.out.println("Task Code " + parentTaskCode + " does not exist.");
			} else if (!getController().isTaskInTheSamePlan(parentTaskCode, planCode)) {
				System.out.println("Task does not belong in project plan " + planCode);
			} else if (getController().isChildTask(taskCode, parentTaskCode)) {
				System.out.println("You cannot set a task dependent to this task as a parent task.");
			} else {
				if (!parentTasks.contains(parentTaskCode)) {
					System.out.println("Task " + parentTaskCode + " added.");
					parentTasks.add(parentTaskCode);
				} else {
					System.out.println("Task " + parentTaskCode + " is already added in the lsit.");
				}
			}
		}
		
		getController().editTask(taskCode, name, duration, parentTasks);
		
		System.out.println("Task has been modified.");
		
		return Screen.MAIN_SCREEN;
	}

}
