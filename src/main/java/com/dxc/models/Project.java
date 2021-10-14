package com.dxc.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

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
	@Column(name="PROJECT_ID")
	private int projectId;

	@Column(name="PROJECT_CODE")
	private String projectCode;



	@Column(name="PROJECT_DESCR")
	private String projectDescr;



	@Column(name="PROJECT_NAME")
	private String projectName;


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



	public List<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



	public Manager getProjectManager() {
		return projectManager;
	}



	public void setProjectManager(Manager projectManager) {
		this.projectManager = projectManager;
	}

	//bi-directional many-to-one association to Manager
	@ManyToOne
	@JoinColumn(name="PROJECT_MANAGER")
	private Manager projectManager;

	public Project() {
	}



	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}



	public String getProjectDescr() {
		return this.projectDescr;
	}

	public void setProjectDescr(String projectDescr) {
		this.projectDescr = projectDescr;
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}



	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	

}