package com.example.portal.service;

import com.example.portal.dto.TeacherRequest;
import com.example.portal.dto.TeacherResponse;
import com.example.portal.entity.Teacher;
import com.example.portal.mapper.TeacherMapper;
import com.example.portal.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherResponse create(TeacherRequest request) {
        Teacher teacher = TeacherMapper.toEntity(request);
        Teacher saved = teacherRepository.save(teacher);
        return TeacherMapper.toResponse(saved);
    }

    public List<TeacherResponse> getAll() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<TeacherResponse> getById(Long id) {
        return teacherRepository.findById(id)
                .map(TeacherMapper::toResponse);
    }

    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }
}
