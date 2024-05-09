package com.plc.digitalschoolproject.students;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface StudentService {

    StudentEntity findById(Long id);
    StudentEntity save(StudentEntity studentEntity);
    Page<StudentEntity> findAllStudents(Pageable pageable);
    void delete(Long id);

}
