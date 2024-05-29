package com.plc.digitalschoolproject.groups;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plc.digitalschoolproject.commons.BaseEntity;
import com.plc.digitalschoolproject.instructorgroup.InstructorGroupEntity;
import com.plc.digitalschoolproject.students.StudentEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "groups")
public class GroupEntity extends BaseEntity {
    
    private String title;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "students_groups",
        joinColumns = {@JoinColumn(name = "group_id")},
        inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    @JsonIgnore
    Set<StudentEntity> students = new HashSet<>();

    @OneToMany(mappedBy = "group")
    @JsonIgnore
    private Set<InstructorGroupEntity> instructorGroupSet = new HashSet<>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }
}
