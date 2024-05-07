package com.plc.digitalschoolproject.students;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long>{


    Set<StudentEntity> findByFirstNameOrEmailIgnoreCase(String firstname,String email);
}
