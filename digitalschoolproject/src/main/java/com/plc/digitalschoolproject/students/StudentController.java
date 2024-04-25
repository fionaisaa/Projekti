package com.plc.digitalschoolproject.students;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {

    
    private StudentService studentService;

    public StudentController( final StudentService studentService) {
        this.studentService = studentService;
    }


    //e merr nje student me id te caktuar
    @GetMapping(path = "/students/{id}")
    public StudentEntity getStudentById(@PathVariable(name = "id") Long id){

        return studentService.findById(id);
    }


    // e merr nje list
    @GetMapping(path = "/students")
    public String getStudentName(){

        return "fiona isa";
    }

    @PostMapping(path = "/students")
    public StudentEntity createStudent(@RequestBody StudentEntity studentEntity){

        return studentService.save(studentEntity);
    }

    @DeleteMapping(path = "/students")
    public void deleteAllStudents(){

    }

    }