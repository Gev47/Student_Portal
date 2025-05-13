package com.example.portal.mapper;

import com.example.portal.dto.ScheduleRequest;
import com.example.portal.dto.ScheduleResponse;
import com.example.portal.entity.Schedule;
import com.example.portal.entity.Subject;

public class ScheduleMapper {

    public static Schedule toEntity(ScheduleRequest dto, Subject subject) {
        Schedule schedule = new Schedule();
        schedule.setSubject(subject);
        schedule.setStartTime(dto.getStartTime());
        schedule.setEndTime(dto.getEndTime());
        schedule.setDayOfWeek(dto.getDayOfWeek());
        schedule.setRoom(dto.getRoom());
        return schedule;
    }

    public static ScheduleResponse toResponse(Schedule entity) {
        return new ScheduleResponse(
                entity.getId(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getDayOfWeek(),
                entity.getRoom(),
                entity.getSubject().getName()
        );
    }
}
