package com.dba9514.RestCrud.DAO;

import com.dba9514.RestCrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    //Define the entitymanager
    private EntityManager entityManager;

    //Constructor for entity manager init
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    @Override
    public Employee save(Employee employee) {
        //If employee exist, UPDATE
        //Else, CREATE new
        return entityManager.merge(employee);
    }

    //Find all Employees, return as a list.
    @Override
    public List<Employee> findAll() {
        //Create the query for finding all Employee class mapping in the database.
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        //Returning the results as a List
        return query.getResultList();
    }

    //Find specific Employee by ID.
    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    //Remove an Employee by ID.
    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Employee.class, id));
    }
}
