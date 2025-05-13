package com.example.portal.mapper;

import com.example.portal.dto.SubjectRequest;
import com.example.portal.dto.SubjectResponse;
import com.example.portal.entity.Subject;

public class SubjectMapper {

    public static Subject toEntity(SubjectRequest dto) {
        Subject subject = new Subject();
        subject.setName(dto.getName());
        subject.setCredits(dto.getCredits());
        return subject;
    }

    public static SubjectResponse toResponse(Subject entity) {
        return new SubjectResponse(
                entity.getId(),
                entity.getName(),
                entity.getCredits()
        );
    }
}
