package com.plc.digitalschoolproject.students.commons;

import com.plc.digitalschoolproject.students.StudentDto;
import com.plc.digitalschoolproject.students.StudentEntity;

public class StudentMapper {

    public static void mapDtoToEntity(StudentDto source, StudentEntity target){


     if(source.getFirstName() != null){
        target.setFirstName(source.getFirstName());
     }

     if(source.getLastName() != null){
        target.setLastName(source.getLastName());
     }

     if(source.getProfilePicture() != null){
        target.setProfilePicture(source.getProfilePicture());
     }

     if(source.getEmail() != null){
        target.setEmail(source.getEmail());
     }

     if(source.getPhoneNumber() != null){
        target.setPhoneNumber(source.getPhoneNumber());
     }

      if(source.getAddress() != null){
        target.setAddress(source.getAddress());
     }


    }

    public static StudentDto mapEntityToDto(StudentEntity source){
        StudentDto studentDto = new StudentDto();

        studentDto.setId(source.getId());
        studentDto.setFirstName(source.getFirstName());
        studentDto.setLastName(source.getLastName());
        studentDto.setEmail(source.getEmail());
        studentDto.setProfilePicture(source.getProfilePicture());
        studentDto.setAddress(source.getAddress());
        studentDto.setPhoneNumber(source.getPhoneNumber());
        studentDto.setCreatedAt(source.getCreatedAt());
        studentDto.setCreatedBy(source.getCreatedBy());
        studentDto.setUpdatedAt(source.getUpdatedAt());
        studentDto.setUpdatedBy(source.getUpdatedBy());
        studentDto.setDeletedAt(source.getDeletedAt());
        studentDto.setDeletedBy(source.getDeletedBy());


        return  studentDto;
    }
}
