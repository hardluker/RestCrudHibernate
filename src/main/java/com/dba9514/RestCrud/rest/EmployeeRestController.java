package com.dba9514.RestCrud.rest;

import com.dba9514.RestCrud.entity.Employee;
import com.dba9514.RestCrud.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //Accessing the service layer.
    private EmployeeService employeeService;
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //GET Mapping for returning all employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //GET Mapping for returning specific employee by ID.
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null)
            throw new RuntimeException("Employee id of " + employeeId + " not found!");
        else
            return employee;
    }
}
