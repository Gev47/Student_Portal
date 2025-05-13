package com.example.portal.repository;

import com.example.portal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Student> findByLastName(String lastName);

    List<Student> findByFirstNameIgnoreCase(String firstName);

    List<Student> findByLastNameContainingIgnoreCase(String substring);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findTop5ByOrderByLastNameAsc();
}
