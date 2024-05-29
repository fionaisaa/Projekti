package com.plc.digitalschoolproject.students;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.plc.digitalschoolproject.groups.GroupEntity;

import java.util.Set;


public interface StudentService {

    StudentEntity findById(Long id);
    StudentEntity save(StudentEntity studentEntity);
    Page<StudentEntity> findAllStudents(Pageable pageable);
    Set<StudentEntity> findByNameOrEmail(String name, String email);
    void delete(Long id);
    StudentEntity update(Long id, StudentEntity studentEntity);
    StudentDto  patch(Long id, StudentDto studentDto);
    Set<GroupEntity> getGroupsByStudentId(Long id);
    void addStudentToGroup(Long studentId, Long groupId);
    Set<StudentEntity> getStudentsByGroupId(Long id);
    void removeStudentFromGroup(Long studentId, Long groupId);
}
