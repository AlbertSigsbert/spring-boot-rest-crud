package com.albert.demo.dao;

import com.albert.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
