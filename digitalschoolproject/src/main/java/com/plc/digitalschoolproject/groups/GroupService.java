package com.plc.digitalschoolproject.groups;

public interface GroupService {

    GroupEntity findById(Long id);

    GroupEntity save(GroupEntity group);

}
