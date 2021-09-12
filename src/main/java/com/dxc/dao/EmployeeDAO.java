package com.dxc.dao;

import java.util.List;

import com.dxc.models.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();
	
	public void saveEmployee(Employee employee);
	
	public Employee getEmployeeByID(int ID);
	public Employee getEmployeeByCode(String employeeCode);
}
