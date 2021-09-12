package com.dxc.services;

import java.util.List;


import com.dxc.models.Employee;

public interface EmployeeService {
public List<Employee> getEmployees();
public void saveEmployee(Employee employee);

public Employee getEmployeebyId(int Id);
public Employee getEmployeebyCode(String employeeCode);

}
