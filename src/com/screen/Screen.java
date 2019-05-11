package com.screen;

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
	public static final Screen TASK_VIEW_SCREEN = EditTaskScreen.getInstance();
	
	/* Schedule Screen */
	public static final Screen SCHEDULE_SINGLE_PLAN_SCREEN = SinglePlanSchedule.getInstance();
	public static final Screen SCHEDULE_ALL_PLANS_SCREEN = AllPlansSchedule.getInstance();
	
	public static final String DISPLAY_CHOOSE_OPTION = "\tPlease choose an option (Enter the number of chosen command):";
	public static final String DISPLAY_ERROR_MSG = "You have entered an invalid input! Please try again.";
	
	private Screen prevScreen = null;
	private MainController controller = null;

	public abstract void display();
	
	public abstract Screen acceptCommand();
	
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