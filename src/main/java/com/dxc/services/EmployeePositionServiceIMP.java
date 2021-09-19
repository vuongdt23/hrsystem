package com.dxc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.EmployeePositionDAO;
import com.dxc.models.EmployeePosition;

@Service
public class EmployeePositionServiceIMP implements EmployeePositionService {

	@Autowired
	private EmployeePositionDAO employeePositionDAO;
	
	
	@Override
	@Transactional
	public List<EmployeePosition> getAllPositions() {
		return employeePositionDAO.getAllPositions();
	}


	@Override
	@Transactional
	public EmployeePosition getPositionById(int id) {
		// TODO Auto-generated method stub
		return employeePositionDAO.getPositionById(id);
	}

	
}
