package com.dxc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.models.Project;
import com.dxc.services.ProjectService;

@Controller
@RequestMapping(value = "/projects")
public class ProjectsController {

	@Autowired
	private ProjectService projectService;
	
	
	@GetMapping
	public String Projects(Model model) {
	List<Project> projects =	projectService.getAllProjects();
	System.out.print(projects.size());
	model.addAttribute("projectList", projects);
		return "projects";
	}
	
}
