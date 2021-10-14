package com.dxc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeesController.class);

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
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {

    	if(result.hasErrors())
    	{
    		for(ObjectError error: result.getAllErrors())
    		LOGGER.info(error.getDefaultMessage());
    		
    		return "newEmployee";
    	}
    	
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {

        Employee employeeTemp = employeeService.getEmployeeByCode(employee.getEmployeeCode());
        System.out.print(employeeTemp.getEmployeeName());
        employeeTemp.setEmployeeCode(employee.getEmployeeCode());
        employeeTemp.setEmployeeName(employee.getEmployeeName());
        employeeTemp.setEmployeePhone(employee.getEmployeePhone());
        employeeTemp.setEmployeeAddress(employee.getEmployeeAddress());
        employeeService.updateEmployee(employeeTemp);

        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String deleteEmployee(String employeeCode) {
        employeeService.deleteEmployeeByCode(employeeCode);
        return "redirect:/employees";
    }

    @GetMapping("/{employeeCode}")
    public String EmployeeDetail(@PathVariable String employeeCode, Model model) {
        Employee employee = employeeService.getEmployeeByCode(employeeCode);
        model.addAttribute("employee", employee);
        return "employeeDetail";
    }

}
