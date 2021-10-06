package com.dxc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.models.Task;
import com.dxc.services.TaskService;

@Controller
@RequestMapping("/tasks")

public class TaskController {

    @Autowired
    private TaskService taskService;

    
    @GetMapping
    public String taskList(Model model) {
        List<Task> taskList = taskService.getTasks();
        System.out.print(taskList.size());
        model.addAttribute("taskList", taskList);
        return "taskList";
    }

}
