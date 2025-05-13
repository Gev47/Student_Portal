package com.example.portal.mapper;

import com.example.portal.dto.StudentRequest;
import com.example.portal.dto.StudentResponse;
import com.example.portal.entity.Student;

public class StudentMapper {

    public static Student toEntity(StudentRequest dto) {

        Student student = new Student();

        student.setFirstName(dto.getFirstName());

        student.setLastName(dto.getLastName());

        student.setEmail(dto.getEmail());

        student.setPassword(dto.getPassword());

        return student;

    }

    public static StudentResponse toResponse(Student entity) {

        return new StudentResponse(

                entity.getId(),

                entity.getFirstName(),

                entity.getLastName(),

                entity.getEmail()

        );

    }
}
