package com.dba9514.RestCrud.service;

import com.dba9514.RestCrud.entity.Employee;

import java.util.List;

//This is the interface for the service layer.
//This is an example of the Facade design pattern.
//This allows to abstract complex, multistep logic.
public interface EmployeeService {

    //CREATE / UPDATE Method
    Employee save(Employee employee);

    //READ Methods
    List<Employee> findAll();
    Employee findById(int id);


    //DELETE Method
    void deleteById(int id);
}
