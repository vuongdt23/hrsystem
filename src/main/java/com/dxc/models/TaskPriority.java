package com.dxc.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the task_priorities database table.
 * 
 */
@Entity
@Table(name="task_priorities")
@NamedQuery(name="TaskPriority.findAll", query="SELECT t FROM TaskPriority t")
public class TaskPriority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TASK_PRIORITY_ID")
	private int taskPriorityId;

	@Column(name="TASK_PRIORITY_DESCR")
	private String taskPriorityDescr;

	@Column(name="TASK_PRIORITY_NAME")
	private String taskPriorityName;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="taskPriorityBean")
	private List<Task> tasks;

	public TaskPriority() {
	}

	public int getTaskPriorityId() {
		return this.taskPriorityId;
	}

	public void setTaskPriorityId(int taskPriorityId) {
		this.taskPriorityId = taskPriorityId;
	}

	public String getTaskPriorityDescr() {
		return this.taskPriorityDescr;
	}

	public void setTaskPriorityDescr(String taskPriorityDescr) {
		this.taskPriorityDescr = taskPriorityDescr;
	}

	public String getTaskPriorityName() {
		return this.taskPriorityName;
	}

	public void setTaskPriorityName(String taskPriorityName) {
		this.taskPriorityName = taskPriorityName;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setTaskPriorityBean(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setTaskPriorityBean(null);

		return task;
	}

}