package com.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.ProjectPlan;
import com.model.Task;

public class MainController {

	private Scanner scanner;
	
	private final String VALID_CODE_FORMAT = "[0-9a-zA-Z]+";
	private final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	private List<ProjectPlan> plans;
	private List<Task> tasks;
	
	public MainController() {
		setScanner(new Scanner(System.in));
		plans = new ArrayList<ProjectPlan>();
		tasks = new ArrayList<Task>();
	}
	
	public void close() {
		if (scanner != null) {
			scanner.close();
		}
	}
	
	/**
	 * Creates plan and adds to the list of plans.
	 * @param code Plan code.
	 * @param name Plan name.
	 * @param startDate Start date.
	 */
	public void createPlan(String code, String name, String startDate) {
		/* All parameter values are presumed to have already passed the validations. */
		try {
			ProjectPlan plan = new ProjectPlan(code, name, format.parse(startDate));
			this.plans.add(plan);
		} catch (ParseException e) {
			System.out.println("Date format exception encountered. Start Date parameter value: " + startDate);
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes existing plan. Returns false if plan code does not exist and no plan was deleted.
	 * @param code Plan code.
	 * @return
	 */
	public boolean deletePlan(String code) {
		ProjectPlan plan = null;
		for (int i = 0; i < this.plans.size(); i++) {
			if (this.plans.get(i).getCode().equals(code)) {
				plan = this.plans.remove(i);
				break;
			}
		}
		
		if (plan != null) {
			this.tasks.removeAll(plan.getAllTasks());
			return true;
		}
		
		return false;
	}
	
	/**
	 * Gets plan by code. Returns null if plan is not found.
	 * @param code Plan code.
	 * @return
	 */
	public ProjectPlan getPlan(String code) {
		ProjectPlan plan = null;
		
		for (ProjectPlan existingPlan : plans) {
			if (existingPlan.getCode().equals(code)) {
				plan = existingPlan;
				break;
			}
		}
		
		return plan;
	}
	
	/**
	 * Validates plan or task Code. Code must be four letters long and should consist of only
	 * alphanumeric characters. 
	 * @param code The plan/task code.
	 * @return Is the code valid or not.
	 */
	public boolean isCodeValid(String code) {
		boolean isValid = (code == null) ? false : code.length() == 4 && code.matches(VALID_CODE_FORMAT);
		
		if (!isValid) {
			System.out.println("Invalid Code! Please try again.");
		}
		
		return isValid;
	}
	
	/**
	 * Checks if the plan or task code already existing.
	 * @param code The plan/task code.
	 * @return Is the code already existing.
	 */
	public boolean isCodeAlreadyExisting(String code) {
		return isPlanExisting(code) || isTaskExisting(code);
	}
	
	/**
	 * Checks if the plan code already existing.
	 * @param code The plan code.
	 * @return
	 */
	public boolean isPlanExisting(String code) {
		return this.plans.contains(new ProjectPlan(code));
	}
	
	/**
	 * Checks if the task code already existing.
	 * @param code The task code.
	 * @return
	 */
	public boolean isTaskExisting(String code) {
		return this.tasks.contains(new Task(code));
	}
	
	/**
	 * Checks if there are existing project plans.
	 * @return
	 */
	public boolean hasExistingPlans() {
		return !this.plans.isEmpty();
	}
	
	/**
	 * Checks if there are existing project tasks.
	 * @return
	 */
	public boolean hasExistingTasks() {
		return !this.tasks.isEmpty();
	}
	
	/**
	 * Checks if date is in valid format.
	 * @param date The date parameter.
	 * @return Is the date in valid format.
	 */
	public boolean isValidDate(String date) {
		boolean isValid = (date == null);
		
		try {
			format.parse(date);
			isValid = true;
		} catch (ParseException e) {
			isValid = false;
		}
		
		if (!isValid) {
			System.out.println("Invalid date format! Please try again.");
		}
		
		return isValid;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public List<ProjectPlan> getAllPlans() {
		return this.plans;
	}
}
