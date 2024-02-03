package com.dba9514.RestCrud.DAO;

import com.dba9514.RestCrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    //CREATE / UPDATE Method
    Employee save(Employee employee);

    //READ Methods
    List<Employee> findAll();
    Employee findById(int id);


    //DELETE Method
    void deleteById(int id);

}
