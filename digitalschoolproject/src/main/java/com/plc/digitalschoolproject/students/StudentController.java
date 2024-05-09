package com.plc.digitalschoolproject.students;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



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

    @GetMapping(path = "/students", params = "name")
    public Set<StudentEntity> findByNameOrEmail(@RequestParam(name = "name")String name ,@RequestParam (name = "email" , required = false) String email){

        return studentService.findByNameOrEmail(name, email);
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllStudents(@PathVariable(name = "id") Long id){

        studentService.delete(id);

    }

    @PutMapping(path = "/students/{id}")
    public StudentEntity updateStudent(@PathVariable(name= "id") Long id, @RequestBody StudentEntity studentEntity){

        if(id==null || studentEntity == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(!id.equals(studentEntity.getId())){

        }
        
        return studentService.update(id, studentEntity);
    }

    }
