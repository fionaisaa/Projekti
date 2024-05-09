package com.plc.digitalschoolproject.students;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity findById(Long id) {
        
          StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Student with id " +id+ " is not found."
                ));

                return studentEntity;
    }



    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        
       
      return studentRepository.save(studentEntity);
    }

    @Override
    public Page<StudentEntity> findAllStudents(Pageable pageable) {
    
      return studentRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {

     studentRepository.deleteById(id);
    }

   
}
