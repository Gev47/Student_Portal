package com.example.portal.repository;

import com.example.portal.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Optional<Subject> findByName(String name);

    boolean existsByName(String name);

    List<Subject> findByCreditsGreaterThan(int credits);

    List<Subject> findByCreditsBetween(int min, int max);

}
