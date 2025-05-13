package com.example.portal.mapper;

import com.example.portal.dto.TeacherRequest;
import com.example.portal.dto.TeacherResponse;
import com.example.portal.entity.Teacher;

public class TeacherMapper {

    public static Teacher toEntity(TeacherRequest dto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setEmail(dto.getEmail());
        teacher.setPhoneNumber(dto.getPhoneNumber());
        teacher.setDepartment(dto.getDepartment());
        return teacher;
    }

    public static TeacherResponse toResponse(Teacher entity) {
        return new TeacherResponse(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getDepartment()
        );
    }
}
