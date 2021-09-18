package com.dxc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/delete")
	public String deleteEmployee(String employeeCode) {
	employeeService.deleteEmployeebyCode(employeeCode);
	return "redirect:/employees";
	}

	
	@GetMapping("/{employeeCode}")
	public String EmployeeDetail(@PathVariable String employeeCode, Model model) {
		Employee employee = employeeService.getEmployeebyCode(employeeCode);
		int a = employee.getProjects1().size();
		model.addAttribute("employee", employee);
		System.out.print(a);
		return "employeeDetail";
	}
	
}
