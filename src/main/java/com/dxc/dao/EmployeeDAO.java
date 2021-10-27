package com.dxc.dao;

import java.util.List;

import com.dxc.models.Employee;
import com.dxc.models.Project;

public interface EmployeeDAO {
	public List<Employee> getEmployees();
	
	public void saveEmployee(Employee employee);
	
	public Employee getEmployeeByID(int ID);
	public Employee getEmployeeByCode(String employeeCode);
	
	public void deleteEmployeeByCode(String employeeCode);
	
	public void updateEmployee(Employee employee);
	public List<Project> getEmployeeProjects(Employee employee);
}
