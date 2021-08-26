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
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPLOYEE_ID", unique = true)
	private int employeeId;

	@Column(name="EMPLOYEE_ADDRESS")
	private String employeeAddress;

	@Column(name="EMPLOYEE_EMAIL")
	private String employeeEmail;

	@Column(name="EMPLOYEE_NAME")
	private String employeeName;

	@Column(name="EMPLOYEE_PHONE")
	private String employeePhone;

	@Temporal(TemporalType.DATE)
	@Column(name="EMPLOYEE_START_DATE")
	private Date employeeStartDate;

	//bi-directional many-to-one association to EmployeePosition
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_POSITION")
	private EmployeePosition employeePositionBean;

	//bi-directional many-to-many association to Project
	@ManyToMany(mappedBy="employees")
	private List<Project> projects1;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="employee")
	private List<Project> projects2;

	//bi-directional many-to-many association to Task
	@ManyToMany(mappedBy="employees")
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

	public EmployeePosition getEmployeePositionBean() {
		return this.employeePositionBean;
	}

	public void setEmployeePositionBean(EmployeePosition employeePositionBean) {
		this.employeePositionBean = employeePositionBean;
	}

	public List<Project> getProjects1() {
		return this.projects1;
	}

	public void setProjects1(List<Project> projects1) {
		this.projects1 = projects1;
	}

	public List<Project> getProjects2() {
		return this.projects2;
	}

	public void setProjects2(List<Project> projects2) {
		this.projects2 = projects2;
	}

	public Project addProjects2(Project projects2) {
		getProjects2().add(projects2);
		projects2.setEmployee(this);

		return projects2;
	}

	public Project removeProjects2(Project projects2) {
		getProjects2().remove(projects2);
		projects2.setEmployee(null);

		return projects2;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}