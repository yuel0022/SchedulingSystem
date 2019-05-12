package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.scheduler.GenUtil;

public class Task {

	private String code;
	private String name;
	private int duration;
	private Date startDate;
	private Date endDate;
	private List<Task> parentTasks;
	private List<Task> childTasks;
	private ProjectPlan plan;
	boolean deleted = false;
	
	public Task(String code) {
		this(code, null, 0, null);
	}
	
	public Task(String code, String name, int duration, ProjectPlan plan) {
		this.code = code;
		if (plan != null) {
			this.name = name;
			this.duration = duration;
			this.plan = plan;
			this.startDate = plan.getStartDate();
			this.endDate = GenUtil.addDays(this.startDate, duration - 1);
			parentTasks = new ArrayList<Task>();
			childTasks = new ArrayList<Task>();
		}
	}
	
	/**
	 * Recalculate the schedule of this task and then notifies its child tasks that an update has been made.
	 */
	public void recalculateSchedule() {
		Date maxEndDate = null;
		Date newStartDate = null;
		
		for (Task parentTask : parentTasks) {
			if (maxEndDate == null || maxEndDate.compareTo(parentTask.getEndDate()) < 0) {
				maxEndDate = parentTask.getEndDate();
			}
		}
		
		newStartDate = (maxEndDate == null) ? this.getPlan().getStartDate() : GenUtil.addDays(maxEndDate, 1);
		
		if (newStartDate.compareTo(this.startDate) != 0) {
			this.startDate = newStartDate;
			this.endDate = GenUtil.addDays(this.startDate, duration - 1);
			for (Task childTask : childTasks) {
				childTask.notifyChanges(this);
			}
		}
	}
	
	public void addParentTask(Task task) {
		if (!parentTasks.contains(task)) {
			parentTasks.add(task);
			task.addChildTask(this);
		}
	}
	
	public boolean removeParentTask(Task task) {
		boolean hasTaskRemoved = parentTasks.remove(task);
		
		if (hasTaskRemoved) {
			task.removeChildTask(this);
		}
		
		return hasTaskRemoved;
	}
	
	public void addChildTask(Task task) {
		if (!childTasks.contains(task)) {
			childTasks.add(task);
		}
	}
	
	public boolean removeChildTask(Task task) {
		return childTasks.remove(task);
	}
	
	/**
	 * Checks if the parent task code belongs to the tasks dependent on the task being edited.
	 * @param code
	 * @return
	 */
	public boolean isChildTask(String code) {
		boolean isChild = false;
		
		for (Task child : childTasks) {
			if (child.getCode().equals(code)) {
				return true;
			} else {
				isChild = child.isChildTask(code);
			}
		}
		
		return isChild;
	}
	
	/**
	 * Notify this task that a linked task has recently been modified/deleted.
	 * @param task
	 */
	private void notifyChanges(Task task) {
		if (task.isDeleted()) {
			if (!task.removeParentTask(task)) {
				task.removeChildTask(task);
			}
		}
		
		this.recalculateSchedule();
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
	
	public boolean isDeleted() {
		return deleted;
	}
}
