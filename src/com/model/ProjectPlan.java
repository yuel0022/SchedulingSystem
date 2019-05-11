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
	
	public ProjectPlan(String code) {
		this(code, null, null);
	}
	
	public ProjectPlan(String code, String name, Date startDate) {
		this.code = code;
		this.name = name;
		this.startDate = startDate;
		this.endDate = startDate;
		this.tasks = new ArrayList<Task>();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ProjectPlan)) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		return this.code.equals(((ProjectPlan)obj).getCode());
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
		return result;
	}
	
	public List<Task> getAllTasks() {
		return this.tasks;
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
