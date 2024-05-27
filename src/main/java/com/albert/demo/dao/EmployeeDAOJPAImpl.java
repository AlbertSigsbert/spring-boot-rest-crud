package com.albert.demo.dao;


import com.albert.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery <Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        return theQuery.getResultList();
    }
}
