package com.plc.digitalschoolproject.students;

import java.util.Set;

public interface StudentService {

    StudentEntity findById(Long id);
    StudentEntity save(StudentEntity studentEntity);
    Set<StudentEntity> findByNameOrEmail(String name, String email);

}
