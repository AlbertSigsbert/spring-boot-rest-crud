package com.albert.demo.rest;

import com.albert.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {

         List<Student> students = new ArrayList<Student>();
         students.add(new Student("Jack", "Harrington"));
         students.add(new Student("Theo", "Brown"));
         students.add(new Student("Jeff", "Hardy"));
        return students;

    }
}
