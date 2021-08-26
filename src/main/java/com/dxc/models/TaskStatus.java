package com.dxc.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the task_status database table.
 * 
 */
@Entity
@Table(name="task_status")
@NamedQuery(name="TaskStatus.findAll", query="SELECT t FROM TaskStatus t")
public class TaskStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TASK_STATUS_ID")
	private int taskStatusId;

	@Column(name="TASK_STATUS_DESCR")
	private String taskStatusDescr;

	@Column(name="TASK_STATUS_NAME")
	private String taskStatusName;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="taskStatusBean")
	private List<Task> tasks;

	public TaskStatus() {
	}

	public int getTaskStatusId() {
		return this.taskStatusId;
	}

	public void setTaskStatusId(int taskStatusId) {
		this.taskStatusId = taskStatusId;
	}

	public String getTaskStatusDescr() {
		return this.taskStatusDescr;
	}

	public void setTaskStatusDescr(String taskStatusDescr) {
		this.taskStatusDescr = taskStatusDescr;
	}

	public String getTaskStatusName() {
		return this.taskStatusName;
	}

	public void setTaskStatusName(String taskStatusName) {
		this.taskStatusName = taskStatusName;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setTaskStatusBean(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setTaskStatusBean(null);

		return task;
	}

}