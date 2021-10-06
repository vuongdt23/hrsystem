package com.dxc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.TaskDAO;
import com.dxc.models.Task;

@Service
public class TaskServiceImp implements TaskService {
    
    @Autowired
    private TaskDAO taskDAO;

    @Override
    @Transactional
    public List<Task> getTasks() {
        List<Task> allTasks = taskDAO.getTasks();
        return allTasks;
    }

}
