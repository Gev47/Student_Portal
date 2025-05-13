package com.example.portal.repository;

import com.example.portal.entity.Homework;
import com.example.portal.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {

    List<Homework> findBySubject(Subject subject);

    List<Homework> findByDueDateBefore(LocalDateTime date);

    List<Homework> findByDueDateAfter(LocalDateTime date);

    List<Homework> findByTitleContainingIgnoreCase(String keyword);

    List<Homework> findByAssignedAtBetween(LocalDateTime start, LocalDateTime end);

}
