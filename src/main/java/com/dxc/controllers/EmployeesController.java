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
import com.dxc.models.EmployeePosition;
import com.dxc.services.EmployeePositionService;
import com.dxc.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeePositionService employeePositionService;

    @GetMapping
    public String allEmployees(Model model) {

        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute(employeeList);
        return "employeeList";
    }

    @GetMapping("/newEmployee")
    public String newEmployeePage(Model model) {
        List<EmployeePosition> positionList = employeePositionService.getAllPositions();
        model.addAttribute("positionList", positionList);

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

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
        employeeTemp.setEmployeePosition(employee.getEmployeePosition());
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
        List<EmployeePosition> positionList = employeePositionService.getAllPositions();
        model.addAttribute("employee", employee);
        model.addAttribute("positionList", positionList);
        return "employeeDetail";
    }

}
