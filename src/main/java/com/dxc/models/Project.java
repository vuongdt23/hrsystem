package com.dxc.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the projects database table.
 * 
 */
@Entity
@Table(name="projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROJECT_ID")
	private int projectId;

	@Column(name="PROJECT_DESCR")
	private String projectDescr;

	@Column(name="PROJECT_NAME")
	private String projectName;

	//bi-directional many-to-many association to Employee
	@ManyToMany
	@JoinTable(
		name="project_staff"
		, joinColumns={
			@JoinColumn(name="PROJECT_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="EMPLOYEE_ID")
			}
		)
	private List<Employee> employees;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="PROJECT_MANAGER")
	private Employee manager;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="project")
	private List<Task> tasks;

	public Project() {
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectDescr() {
		return this.projectDescr;
	}

	public void setProjectDescr(String projectDescr) {
		this.projectDescr = projectDescr;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getManager() {
		return this.manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setProject(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setProject(null);

		return task;
	}

}