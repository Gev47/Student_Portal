package com.example.portal.mapper;

import com.example.portal.dto.HomeworkRequest;
import com.example.portal.dto.HomeworkResponse;
import com.example.portal.entity.Homework;
import com.example.portal.entity.Subject;

import java.time.LocalDateTime;

public class HomeworkMapper {

    public static Homework toEntity(HomeworkRequest dto, Subject subject) {
        Homework homework = new Homework();
        homework.setSubject(subject);
        homework.setTitle(dto.getTitle());
        homework.setDescription(dto.getDescription());
        homework.setDueDate(dto.getDueDate());
        homework.setAssignedAt(LocalDateTime.now());
        return homework;
    }

    public static HomeworkResponse toResponse(Homework entity) {
        return new HomeworkResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getDueDate(),
                entity.getAssignedAt(),
                entity.getSubject().getName()
        );
    }
}
