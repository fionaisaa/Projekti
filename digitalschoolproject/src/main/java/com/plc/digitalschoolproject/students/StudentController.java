package com.plc.digitalschoolproject.students;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public Page<StudentEntity> findAllStudents(Pageable pageable){

        return studentService.findAllStudents(pageable);
    }

    @PostMapping(path = "/students")

    @ResponseStatus(HttpStatus.CREATED)
    public StudentEntity createStudent(@RequestBody StudentEntity studentEntity){

        return studentService.save(studentEntity);
    }

    @DeleteMapping(path = "/students/{id}")
    public void deleteAllStudents(@PathVariable(name = "id") Long id){

        studentService.delete(id);

    }

    }
