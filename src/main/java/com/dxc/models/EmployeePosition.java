package com.dxc.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee_positions database table.
 * 
 */
@Entity
@Table(name="employee_positions")
@NamedQuery(name="EmployeePosition.findAll", query="SELECT e FROM EmployeePosition e")
public class EmployeePosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPLOYEE_POSITION_ID")
	private int employeePositionId;

	public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Column(name="EMPLOYEE_POSITION_DESC")
	private String employeePositionDesc;

	@Column(name="EMPLOYEE_POSITION_NAME")
	private String employeePositionName;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employeePosition")
	private List<Employee> employees;

	public EmployeePosition() {
	}

	public int getEmployeePositionId() {
		return this.employeePositionId;
	}

	public void setEmployeePositionId(int employeePositionId) {
		this.employeePositionId = employeePositionId;
	}

	public String getEmployeePositionDesc() {
		return this.employeePositionDesc;
	}

	public void setEmployeePositionDesc(String employeePositionDesc) {
		this.employeePositionDesc = employeePositionDesc;
	}

	public String getEmployeePositionName() {
		return this.employeePositionName;
	}

	public void setEmployeePositionName(String employeePositionName) {
		this.employeePositionName = employeePositionName;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setEmployeePosition(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setEmployeePosition(null);

		return employee;
	}
 

}