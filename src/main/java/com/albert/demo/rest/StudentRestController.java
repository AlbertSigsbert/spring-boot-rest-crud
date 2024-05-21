package com.albert.demo.rest;

import com.albert.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if ((studentId >= students.size()) || (studentId < 0)){
              throw new StudentNotFoundException(STR."Student id not found - \{studentId}");
        }
        return students.get(studentId);
    }

}
