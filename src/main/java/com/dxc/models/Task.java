package com.dxc.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tasks database table.
 * 
 */
@Entity
@Table(name="tasks")
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TASK_ID")
	private int taskId;

	@Column(name="TASK_DESC")
	private String taskDesc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TASK_DUE")
	private Date taskDue;

	@Column(name="TASK_NAME")
	private String taskName;

	//bi-directional many-to-many association to Employee
	@ManyToMany
	@JoinTable(
		name="task_staff"
		, joinColumns={
			@JoinColumn(name="TASK_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="EMPLOYEE_ID")
			}
		)
	private List<Employee> employees;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="TASK_PROJECT")
	private Project project;

	//bi-directional many-to-one association to TaskPriority
	@ManyToOne
	@JoinColumn(name="TASK_PRIORITY")
	private TaskPriority taskPriorityBean;

	//bi-directional many-to-one association to TaskStatus
	@ManyToOne
	@JoinColumn(name="TASK_STATUS")
	private TaskStatus taskStatusBean;

	//bi-directional many-to-one association to TaskUrgency
	@ManyToOne
	@JoinColumn(name="TASK_URGENCY")
	private TaskUrgency taskUrgencyBean;

	public Task() {
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskDesc() {
		return this.taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Date getTaskDue() {
		return this.taskDue;
	}

	public void setTaskDue(Date taskDue) {
		this.taskDue = taskDue;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public TaskPriority getTaskPriorityBean() {
		return this.taskPriorityBean;
	}

	public void setTaskPriorityBean(TaskPriority taskPriorityBean) {
		this.taskPriorityBean = taskPriorityBean;
	}

	public TaskStatus getTaskStatusBean() {
		return this.taskStatusBean;
	}

	public void setTaskStatusBean(TaskStatus taskStatusBean) {
		this.taskStatusBean = taskStatusBean;
	}

	public TaskUrgency getTaskUrgencyBean() {
		return this.taskUrgencyBean;
	}

	public void setTaskUrgencyBean(TaskUrgency taskUrgencyBean) {
		this.taskUrgencyBean = taskUrgencyBean;
	}

}