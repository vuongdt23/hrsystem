package com.dxc.dao;
import java.util.List;

import com.dxc.models.EmployeePosition;

public interface EmployeePositionDAO {

	
public List<EmployeePosition> getAllPositions();

public EmployeePosition getPositionById(int id);
}
