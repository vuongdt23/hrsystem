package com.dxc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.ProjectDAO;
import com.dxc.models.Project;

@Service
public class ProjectServiceImp implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	
	@Override
	@Transactional
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projectDAO.getProjects();
	}

}
