package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {

	private String code;
	private String name;
	private int duration;
	private Date startDate;
	private Date endDate;
	private List<Task> parentTasks;
	private List<Task> childTasks;
	private ProjectPlan plan;
	
	public Task(String code) {
		this(code, null, 0);
	}
	
	public Task(String code, String name, int duration) {
		this.code = code;
		this.name = name;
		this.duration = duration;
		parentTasks = new ArrayList<Task>();
		childTasks = new ArrayList<Task>();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Task)) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		return this.code.equals(((Task)obj).getCode());
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
		return result;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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

	public ProjectPlan getPlan() {
		return plan;
	}

	public void setPlan(ProjectPlan plan) {
		this.plan = plan;
	}
}
