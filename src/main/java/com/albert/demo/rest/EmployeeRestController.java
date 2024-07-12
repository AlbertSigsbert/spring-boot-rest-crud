package com.albert.demo.rest;


//import com.albert.demo.dao.EmployeeDAO;

import com.albert.demo.entity.Employee;
import com.albert.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService)   {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException(STR."Employee with the id \{employeeId} is not found");
        }

        return theEmployee;
    }


    //add new employee
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody  Employee theEmployee){
        //set id 0 to force an insert instead of update in case user post an id
        theEmployee.setId(0);

        return employeeService.save(theEmployee);
    }

    //update an existing employee
    @PutMapping("/employees")
    public Employee updateEmployee (@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }
}

