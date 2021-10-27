package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxc.models.Employee;
import com.dxc.models.Project;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {

	@Autowired
	private SessionFactory mySessionFactory;

	@Override
	public List<Employee> getEmployees() {

		Session currentSession = mySessionFactory.getCurrentSession();
		Query<Employee> myEmployeeQuery = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employeeList = myEmployeeQuery.getResultList();

		return employeeList;

	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session currentSession = mySessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(employee);
	}

	@Override
	public Employee getEmployeeByID(int ID) {
		// TODO Auto-generated method stub
		Session currentSession = mySessionFactory.getCurrentSession();
		return currentSession.get(Employee.class, ID);
	}

	@Override
	public Employee getEmployeeByCode(String employeeCode) {
		Session currentSession = mySessionFactory.getCurrentSession();
		Employee employee = (Employee) currentSession.createQuery("from Employee s where s.employeeCode = :code").setParameter("code", employeeCode).getSingleResult();
		return employee;
	}

	@Override
	public void deleteEmployeeByCode(String employeeCode) {
		Session currentSession = mySessionFactory.getCurrentSession();
		Employee employee = getEmployeeByCode(employeeCode);
		currentSession.delete(employee);
		
	}

    @Override
    public void updateEmployee(Employee employee) {
        Session currentSession = mySessionFactory.getCurrentSession();
       currentSession.update(employee);
        
    }

	@Override
	public List<Project> getEmployeeProjects(Employee employee) {
        Session currentSession = mySessionFactory.getCurrentSession();
	    currentSession.createQuery("from ")

}
