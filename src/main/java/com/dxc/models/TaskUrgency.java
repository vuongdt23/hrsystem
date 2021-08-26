package com.dxc.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the task_urgencies database table.
 * 
 */
@Entity
@Table(name="task_urgencies")
@NamedQuery(name="TaskUrgency.findAll", query="SELECT t FROM TaskUrgency t")
public class TaskUrgency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int TASK_URGENCY_ID;

	@Column(name="TASK_URGENCY_DESCR")
	private String taskUrgencyDescr;

	@Column(name="TASK_URGENCY_NAME")
	private String taskUrgencyName;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="taskUrgencyBean")
	private List<Task> tasks;

	public TaskUrgency() {
	}

	public int getTASK_urgency_ID() {
		return this.TASK_URGENCY_ID;
	}

	public void setTASK_urgency_ID(int TASK_urgency_ID) {
		this.TASK_URGENCY_ID = TASK_urgency_ID;
	}

	public String getTaskUrgencyDescr() {
		return this.taskUrgencyDescr;
	}

	public void setTaskUrgencyDescr(String taskUrgencyDescr) {
		this.taskUrgencyDescr = taskUrgencyDescr;
	}

	public String getTaskUrgencyName() {
		return this.taskUrgencyName;
	}

	public void setTaskUrgencyName(String taskUrgencyName) {
		this.taskUrgencyName = taskUrgencyName;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setTaskUrgencyBean(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setTaskUrgencyBean(null);

		return task;
	}

}