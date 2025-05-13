package com.example.portal.repository;

import com.example.portal.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Teacher> findByDepartment(String department);

    List<Teacher> findByLastNameContainingIgnoreCase(String part);

    List<Teacher> findByPhoneNumberContaining(String part);

    List<Teacher> findByFirstNameAndLastName(String firstName, String lastName);

}
