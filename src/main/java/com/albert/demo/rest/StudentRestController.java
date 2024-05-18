package com.albert.demo.rest;

import com.albert.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<Student>();
        students.add(new Student("Jack", "Harrington"));
        students.add(new Student("Theo", "Brown"));
        students.add(new Student("Jeff", "Hardy"));
    }

    //Get all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    //Get a single student
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return students.get(studentId);
    }


}
