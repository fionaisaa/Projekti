package com.plc.digitalschoolproject.students;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class StudentController {

    @GetMapping(path = "/students")
    public String getStudentName(){

        return "fiona isa";
    }

    @PostMapping(path = "/students")
    public void createStudent(){

    }

    @DeleteMapping(path = "/students")
    public void deleteAllStudents(){

    }

    }
