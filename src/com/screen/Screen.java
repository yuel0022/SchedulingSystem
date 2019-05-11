package com.screen;

import java.text.SimpleDateFormat;
import java.util.List;

import com.model.ProjectPlan;
import com.model.Task;
import com.scheduler.MainController;
import com.screen.main.Exit;
import com.screen.main.MainScreen;
import com.screen.main.PlanScreen;
import com.screen.main.TaskScreen;
import com.screen.main.ViewScheduleScreen;
import com.screen.main.plans.CreatePlanScreen;
import com.screen.main.plans.DeletePlanScreen;
import com.screen.main.plans.ViewPlanScreen;
import com.screen.main.schedule.AllPlansSchedule;
import com.screen.main.schedule.SinglePlanSchedule;
import com.screen.main.tasks.CreateTaskScreen;
import com.screen.main.tasks.DeleteTaskScreen;
import com.screen.main.tasks.EditTaskScreen;

public abstract class Screen {
	
	/* Main Screen */
	public static final Screen EXIT = Exit.getInstance();
	public static final Screen MAIN_SCREEN = MainScreen.getInstance();
	public static final Screen PLAN_SCREEN = PlanScreen.getInstance();
	public static final Screen TASK_SCREEN = TaskScreen.getInstance();
	public static final Screen VIEW_SCHEDULE_SCREEN = ViewScheduleScreen.getInstance();
	
	/* Plan Screen */
	public static final Screen PLAN_CREATE_SCREEN = CreatePlanScreen.getInstance();
	public static final Screen PLAN_DELETE_SCREEN = DeletePlanScreen.getInstance();
	public static final Screen PLAN_VIEW_SCREEN = ViewPlanScreen.getInstance();
	
	/* Task Screen */
	public static final Screen TASK_CREATE_SCREEN = CreateTaskScreen.getInstance();
	public static final Screen TASK_DELETE_SCREEN = DeleteTaskScreen.getInstance();
	public static final Screen TASK_EDIT_SCREEN = EditTaskScreen.getInstance();
	
	/* Schedule Screen */
	public static final Screen SCHEDULE_SINGLE_PLAN_SCREEN = SinglePlanSchedule.getInstance();
	public static final Screen SCHEDULE_ALL_PLANS_SCREEN = AllPlansSchedule.getInstance();
	
	public static final String DISPLAY_CHOOSE_OPTION = "\tPlease choose an option (Enter the number of chosen command):";
	public static final String DISPLAY_ERROR_MSG = "You have entered an invalid input! Please try again.";
	public static final String MSG_NO_EXISTING_PLANS = "There are no existing plans yet. Please create a new plan.";
	public static final String MSG_NO_EXISTING_TASKS = "There are no existing tasks yet. Please create a new task.";
	
	private final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	private Screen prevScreen = null;
	private MainController controller = null;

	public abstract void display();
	
	public abstract Screen acceptCommand();
	
	/**
	 * Displays project plan information.
	 * @param plan The project plan.
	 */
	protected void displayPlan(ProjectPlan plan) {
		if (plan == null) {
			System.out.println("Error displaying plan - no available information.");
			return;
		}
		List<Task> tasks = plan.getAllTasks();
		System.out.println("\t\tPROJECT PLAN INFORMATION\n");
		System.out.println("Code: " + plan.getCode());
		System.out.println("Name: " + plan.getName());
		
		if (tasks == null || tasks.size() > 0) {
			System.out.println("No registered tasks yet.");
		} else {
			System.out.println("Tasks:");
			for (Task task : tasks) {
				this.displayTask(task);
			}
		}
		
		System.out.println("Start Date: " + format.format(plan.getStartDate()));
		System.out.println("End Date: " + format.format(plan.getEndDate()));
	}
	
	/**
	 * Display task information without showing the plan in which it belongs.
	 * @param task The task.
	 */
	protected void displayTask(Task task) {
		this.displayTask(task, false);
	}
	
	/**
	 * Display task information.
	 * @param task The task.
	 * @param showPlan Value is "true" if you also want to display the plan in which the task belongs.
	 */
	protected void displayTask(Task task, boolean showPlan) {
		if (task == null) {
			System.out.println("Error displaying task - no available information.");
			return;
		}
		if (showPlan) {
			System.out.println("Plan Code: " + task.getPlan().getCode());
		}
		System.out.println("Task Code: " + task.getCode());
		System.out.println("Task Name: " + task.getName());
		System.out.println("Duration: " + task.getDuration() + " days");
		System.out.println("Start Date: " + format.format(task.getStartDate()));
		System.out.println("End Date: " + format.format(task.getEndDate()));
		System.out.println();
	}
	
	protected void setPreviousScreen(Screen prevScreen) {
		this.prevScreen = prevScreen;
	}
	
	protected Screen getPreviousScreen() {
		return this.prevScreen;
	}
	
	public void setController(MainController controller) {
		this.controller = controller;
	}
	
	public MainController getController() {
		return this.controller;
	}
}