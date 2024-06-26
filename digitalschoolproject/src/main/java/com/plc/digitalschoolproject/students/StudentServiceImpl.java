package com.plc.digitalschoolproject.students;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

import com.plc.digitalschoolproject.groups.GroupEntity;
import com.plc.digitalschoolproject.groups.GroupRepository;
import com.plc.digitalschoolproject.students.commons.StudentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private GroupRepository groupRepository;

    public StudentServiceImpl(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository=groupRepository;
    }

    @Override
    public StudentEntity findById(Long id) {
        
          StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Student with id " +id+ " is not found." ));

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

   

    public Set<StudentEntity> findByNameOrEmail(String name, String email) {
     
      Set<StudentEntity> studentEntities = studentRepository.findByFirstNameOrEmailIgnoreCase(name, email);
       if(studentEntities.isEmpty()){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with name " +name+ " is not found.");
     }

       return studentEntities;
    }

    @Override
    public StudentEntity update(Long id, StudentEntity studentEntity) {
      
      studentRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Student with id " +id+ " is not found."));

      return studentRepository.save(studentEntity);
    }

    @Override
    public StudentDto patch(Long id, StudentDto studentDto) {

      //before update
      StudentEntity studentEntity = this.findById(id);

     //after mapping
     StudentMapper.mapDtoToEntity(studentDto, studentEntity);

     StudentEntity patched = studentRepository.save(studentEntity);

      //masi qe u bo mapping edhe u bo save ne db
      return StudentMapper.mapEntityToDto(patched);

    }

    @Override
    public Set<GroupEntity> getGroupsByStudentId(Long id) {

      StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(
        () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Student with id " +id+ " is not found." ));
     
        return studentEntity.getGroups();
    }

    @Override
    public void addStudentToGroup(Long studentId, Long groupId) {
      
      StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(
        () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Student with id " +studentId+ " is not found." ));

      GroupEntity groupEntity = groupRepository.findById(groupId).orElseThrow(
          () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Group with id " +groupId+ " is not found." ));

        groupEntity.getStudents().add(studentEntity);

        groupRepository.save(groupEntity);
    }

    @Override
    public Set<StudentEntity> getStudentsByGroupId(Long id) {
      
        GroupEntity groupEntity = groupRepository.findById(id).orElseThrow(
          () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Group with id " +id+ " is not found." ));

        return groupEntity.getStudents();
    }

    @Override
    public void removeStudentFromGroup(Long studentId, Long groupId) {

        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(
        () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Student with id " +studentId+ " is not found." ));

        GroupEntity groupEntity = groupRepository.findById(groupId).orElseThrow(
          () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Group with id " +groupId+ " is not found." ));
     
        groupEntity.getStudents().remove(studentEntity);
        studentEntity.getGroups().remove(groupEntity);

        studentRepository.save(studentEntity);

    }

    

}
