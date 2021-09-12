package com.dxc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.EmployeeDAO;
import com.dxc.models.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
		
	}

	@Override
	@Transactional
	public Employee getEmployeebyId(int Id) {
		return employeeDAO.getEmployeeByID(Id);
	}

	@Override
	@Transactional
	public Employee getEmployeebyCode(String employeeCode) {
		return employeeDAO.getEmployeeByCode(employeeCode);
	}
	
	
}
