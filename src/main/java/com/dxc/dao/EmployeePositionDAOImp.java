package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxc.models.EmployeePosition;

@Repository
public class EmployeePositionDAOImp implements EmployeePositionDAO {


	@Autowired
	private SessionFactory mySessionFactory;
	@Override
	public List<EmployeePosition> getAllPositions() {
		Session currentSession = mySessionFactory.getCurrentSession();
		Query<EmployeePosition> myEmployeePositionQuery = currentSession.createQuery("from EmployeePosition", EmployeePosition.class);
		List<EmployeePosition> employeePositionList = myEmployeePositionQuery.getResultList();

		return employeePositionList;
	}
	@Override
	public EmployeePosition getPositionById(int id) {
		// TODO Auto-generated method stub
		Session currentSession = mySessionFactory.getCurrentSession();
		EmployeePosition position = currentSession.get(EmployeePosition.class, id);
		return position;
	}

}
