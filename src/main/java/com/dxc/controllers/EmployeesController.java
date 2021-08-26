package com.dxc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.models.Employee;
import com.dxc.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public String allEmployees(Model model) {
		
		List<Employee> employeeList = employeeService.getEmployees();
		model.addAttribute(employeeList);
		return "employeeList";
	}
	
	@GetMapping("/newEmployee")
	public String newEmployeePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "newEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/")
	public String EmployeeDetail(@RequestParam("employeeID") int employeeID, Model model) {
		Employee employee = employeeService.getEmployeebyId(employeeID);
		
		model.addAttribute("employee", employee);
		return "employeeDetail";
	}
	
}
