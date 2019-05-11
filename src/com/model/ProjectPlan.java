package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectPlan {

	private String code;
	private String name;
	private Date startDate;
	private Date endDate;
	private List<Task> tasks;
	
	public ProjectPlan(String code, String name, Date startDate) {
		this.code = code;
		this.name = name;
		this.startDate = startDate;
		this.endDate = null;
		this.tasks = new ArrayList<Task>();
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}
	
	public void removeTask(Task task) {
		this.tasks.remove(task);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
