package com.dxc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.EmployeeDAO;
import com.dxc.models.Employee;
import com.dxc.models.Project;

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
	public Employee getEmployeeById(int Id) {
		return employeeDAO.getEmployeeByID(Id);
	}

	@Override
	@Transactional
	public Employee getEmployeeByCode(String employeeCode) {
		return employeeDAO.getEmployeeByCode(employeeCode);
	}

	@Override
	@Transactional
	public void deleteEmployeeByCode(String employeeCode) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployeeByCode(employeeCode);
	}

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
        
    }

	@Override
	@Transactional
	public List<Project> getEmployeeProjects(Employee employee) {
		return employeeDAO.getEmployeeProjects(employee);
	}
	
	
}
