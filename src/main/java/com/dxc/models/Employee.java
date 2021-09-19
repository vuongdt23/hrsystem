package com.dxc.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name = "employees")
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;

	@Column(name = "EMPLOYEE_CODE", unique = true, nullable = false)
	private String employeeCode;

	@Column(name = "EMPLOYEE_ADDRESS")
	private String employeeAddress;

	@Column(name = "EMPLOYEE_EMAIL")
	private String employeeEmail;

	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	@Column(name = "EMPLOYEE_PHONE")
	private String employeePhone;

	@Temporal(TemporalType.DATE)
	@Column(name = "EMPLOYEE_START_DATE")
	private Date employeeStartDate;

	// bi-directional many-to-one association to EmployeePosition
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_POSITION")
	private EmployeePosition employeePosition;

	// bi-directional many-to-many association to Project
	@ManyToMany(mappedBy = "employees")
	private List<Project> inProjects;

	// bi-directional many-to-one association to Project
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	private List<Project> manageProjects;

	// bi-directional many-to-many association to Task
	@ManyToMany(mappedBy = "employees")
	private List<Task> tasks;

	public Employee() {
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeAddress() {
		return this.employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeEmail() {
		return this.employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePhone() {
		return this.employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public Date getEmployeeStartDate() {
		return this.employeeStartDate;
	}

	public void setEmployeeStartDate(Date employeeStartDate) {
		this.employeeStartDate = employeeStartDate;
	}

	public EmployeePosition getEmployeePosition() {
		return this.employeePosition;
	}

	public void setEmployeePosition(EmployeePosition employeePosition) {
		this.employeePosition = employeePosition;
	}
	
	
	public List<Project> getInProjects() {
		return this.inProjects;
	}

	public void setInProjects(List<Project> inProjects) {
		this.inProjects = inProjects;
	}

	public List<Project> getManageProjects() {
		return this.manageProjects;
	}

	public void manageProjects(List<Project> manageProjects) {
		this.manageProjects = manageProjects;
	}

	public Project addManageProject(Project manageProject) {
		getManageProjects().add(manageProject);
		manageProject.setEmployee(this);

		return manageProject;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Project removeManageProject(Project manageProject) {
		getManageProjects().remove(manageProject);
		manageProject.setEmployee(null);

		return manageProject;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}