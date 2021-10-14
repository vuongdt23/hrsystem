package com.dxc.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the managers database table.
 * 
 */
@Entity
@Table(name="managers")
@NamedQuery(name="Manager.findAll", query="SELECT m FROM Manager m")
public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MANAGER_ID")
	private int managerId;

	@Column(name="MANAGER_ADDRESS")
	private String managerAddress;



	@Column(name="MANAGER_CODE")
	private String managerCode;


	@Column(name="MANAGER_EMAIL")
	private String managerEmail;



	@Column(name="MANAGER_NAME")
	private String managerName;

	@Column(name="MANAGER_PHONE")
	private String managerPhone;



	@Column(name="MANAGER_START_DATE")
	private String managerStartDate;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="projectManager")
	private List<Project> projects;


	public Manager() {
	}

	public int getManagerId() {
		return this.managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerAddress() {
		return this.managerAddress;
	}

	public void setManagerAddress(String managerAddress) {
		this.managerAddress = managerAddress;
	}




	public String getManagerCode() {
		return this.managerCode;
	}

	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}



	public String getManagerEmail() {
		return this.managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	
	

	public String getManagerPhone() {
		return this.managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getManagerStartDate() {
		return this.managerStartDate;
	}

	public void setManagerStartDate(String managerStartDate) {
		this.managerStartDate = managerStartDate;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProjects(Project project) {
		getProjects().add(project);
		project.setProjectManager(this);

		return project;
	}

	public Project removeProjects(Project project) {
		getProjects().remove(project);
		project.setProjectManager(null);

		return project;
	}

	


}