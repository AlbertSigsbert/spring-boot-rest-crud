package com.albert.demo.service;

import com.albert.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService  {

    List<Employee> findAll();
}
