package com.example.portal.service;

import com.example.portal.dto.StudentRequest;
import com.example.portal.dto.StudentResponse;
import com.example.portal.entity.Student;
import com.example.portal.mapper.StudentMapper;
import com.example.portal.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse create(StudentRequest request) {
        Student student = StudentMapper.toEntity(request);
        Student saved = studentRepository.save(student);
        return StudentMapper.toResponse(saved);
    }

    public List<StudentResponse> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<StudentResponse> getById(Long id) {
        return studentRepository.findById(id)
                .map(StudentMapper::toResponse);
    }

    public Optional<StudentResponse> getByEmail(String email) {
        return studentRepository.findByEmail(email)
                .map(StudentMapper::toResponse);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }
}
