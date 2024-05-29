package com.plc.digitalschoolproject.instructors;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.plc.digitalschoolproject.groups.GroupEntity;
import com.plc.digitalschoolproject.groups.GroupRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

   private InstructorRepository instructorRepository;
   private GroupRepository groupRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository, GroupRepository groupRepository) {
    this.instructorRepository = instructorRepository;
    this.groupRepository=groupRepository;
 }

    @Override
    public InstructorEntity findById(Long id) {
        InstructorEntity instructorEntity = instructorRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor with id " +id+ " is not found."));

        return instructorEntity;
    }


    @Override
    public InstructorEntity create(InstructorEntity instructor) {
        
        return instructorRepository.save(instructor);
    }

    @Override
    public Set<GroupEntity> findGroupByInstructorId(Long id) {
        
        InstructorEntity instructorEntity = instructorRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor with id " +id+ " is not found."));

            return groupRepository.findAllByInstructorGroupSetInstructorId(instructorEntity.getId());
    }
}