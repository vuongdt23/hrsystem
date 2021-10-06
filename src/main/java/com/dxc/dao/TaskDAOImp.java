package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxc.models.Task;

@Repository
public class TaskDAOImp implements TaskDAO {

    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public List<Task> getTasks() {
    Session   currentSession = mySessionFactory.getCurrentSession();
    Query<Task> myQuery = currentSession.createQuery("from Task", Task.class);
    List<Task>  myTasks = myQuery.getResultList();
    return myTasks;
   }
}
