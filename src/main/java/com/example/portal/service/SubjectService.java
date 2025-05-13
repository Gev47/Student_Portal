package com.example.portal.service;

import com.example.portal.dto.SubjectRequest;
import com.example.portal.dto.SubjectResponse;
import com.example.portal.entity.Subject;
import com.example.portal.mapper.SubjectMapper;
import com.example.portal.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectResponse create(SubjectRequest request) {
        Subject subject = SubjectMapper.toEntity(request);
        Subject saved = subjectRepository.save(subject);
        return SubjectMapper.toResponse(saved);
    }

    public List<SubjectResponse> getAll() {
        return subjectRepository.findAll()
                .stream()
                .map(SubjectMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<SubjectResponse> getById(Long id) {
        return subjectRepository.findById(id)
                .map(SubjectMapper::toResponse);
    }

    public boolean existsByName(String name) {
        return subjectRepository.existsByName(name);
    }

    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
}
