package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxc.models.Project;

@Repository
public class ProjectDAOImp implements ProjectDAO {

	@Autowired
	private SessionFactory mySessionFactory;
	
	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		Session currentSession = mySessionFactory.getCurrentSession();
		Query<Project> myProjectQuery = currentSession.createQuery("from Project", Project.class);
		List<Project> allProjects = myProjectQuery.getResultList();
	return allProjects;
		
	}

	
	
}
