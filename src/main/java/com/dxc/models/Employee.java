package com.dxc.models;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	
	@NotBlank(message = "Name is required")
	@Size(max = 50, min = 1, message = "Name is within 50 characters")
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	@Column(name = "EMPLOYEE_PHONE")
	private String employeePhone;

	@Temporal(TemporalType.DATE)
	@Column(name = "EMPLOYEE_START_DATE")
	private Date employeeStartDate;



	// bi-directional many-to-many association to Project
	@ManyToMany(mappedBy = "employees")
	private List<Project> Projects;

	

	// bi-directional many-to-many association to Task
	@ManyToMany(mappedBy = "employees")
	private List<Task> tasks;

	public Employee() {
	}

	public int getEmployeeId() {
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


	
	
	public static long getSerialversionuid() {
        return serialVersionUID;
    }

   
	

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}



	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Project> getProjects() {
		return Projects;
	}

	public void setProjects(List<Project> projects) {
		Projects = projects;
	}

}