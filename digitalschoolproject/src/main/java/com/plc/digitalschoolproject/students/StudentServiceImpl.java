package com.plc.digitalschoolproject.students;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity findById(Long id) {
        
        return studentRepository.findById(id).get();
    }

    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        
       
      return studentRepository.save(studentEntity);
    }

}
