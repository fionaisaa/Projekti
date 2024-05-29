package com.plc.digitalschoolproject.instructors;

import java.util.Set;

import com.plc.digitalschoolproject.groups.GroupEntity;

public interface InstructorService {

    InstructorEntity findById(Long id);

    InstructorEntity create(InstructorEntity instructor);

    Set<GroupEntity> findGroupByInstructorId(Long id);
}
