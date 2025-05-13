package com.example.portal.repository;

import com.example.portal.entity.Schedule;
import com.example.portal.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByDayOfWeek(String dayOfWeek);

    List<Schedule> findBySubject(Subject subject);

    List<Schedule> findByRoom(String room);

    List<Schedule> findByStartTimeBefore(java.time.LocalTime time);

    List<Schedule> findByEndTimeAfter(java.time.LocalTime time);

}
