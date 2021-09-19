package com.dxc.services;
import java.util.List;

import com.dxc.models.EmployeePosition;

public interface EmployeePositionService {

	public List<EmployeePosition> getAllPositions();
	public EmployeePosition getPositionById(int id);
}
