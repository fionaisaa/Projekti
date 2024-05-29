package com.plc.digitalschoolproject.studentgroup;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.plc.digitalschoolproject.groups.GroupEntity;
import com.plc.digitalschoolproject.groups.GroupService;
import com.plc.digitalschoolproject.students.StudentEntity;
import com.plc.digitalschoolproject.students.StudentService;

@RestController
public class StudentGroupController {

    private StudentService studentService;
    private GroupService groupService;

    

    public StudentGroupController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }



    @GetMapping(path = "/students/{id}/groups")
    public Set<GroupEntity> getGroupsByStudentId(@PathVariable(name ="id") Long id){

        return studentService.getGroupsByStudentId(id);
    }

    @GetMapping(path = "/groups/{id}/students")
    public Set<StudentEntity> getStudentsByGroupId(@PathVariable(name ="id") Long id){

        return studentService.getStudentsByGroupId(id);
    }

    @PostMapping(path = "/students/{sid}/groups/{gid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addStudentToGroup(@PathVariable(name = "sid") Long studentId, @PathVariable(name = "gid") Long groupId){

         studentService.addStudentToGroup(studentId,groupId);
    }

    @DeleteMapping(path = "students/{sid}/groups/{gid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeStudentFromGroup(@PathVariable(name = "sid") Long studentId, @PathVariable(name = "gid") Long groupId){

        studentService.removeStudentFromGroup(studentId,groupId);
    }
    
}
