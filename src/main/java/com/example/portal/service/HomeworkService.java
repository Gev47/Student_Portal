package com.example.portal.service;

import com.example.portal.dto.HomeworkRequest;
import com.example.portal.dto.HomeworkResponse;
import com.example.portal.entity.Homework;
import com.example.portal.entity.Subject;
import com.example.portal.mapper.HomeworkMapper;
import com.example.portal.repository.HomeworkRepository;
import com.example.portal.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final SubjectRepository subjectRepository;

    public HomeworkService(HomeworkRepository homeworkRepository, SubjectRepository subjectRepository) {
        this.homeworkRepository = homeworkRepository;
        this.subjectRepository = subjectRepository;
    }

    public HomeworkResponse create(HomeworkRequest request) {
        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        Homework homework = HomeworkMapper.toEntity(request, subject);
        Homework saved = homeworkRepository.save(homework);
        return HomeworkMapper.toResponse(saved);
    }

    public List<HomeworkResponse> getAll() {
        return homeworkRepository.findAll()
                .stream()
                .map(HomeworkMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<HomeworkResponse> getById(Long id) {
        return homeworkRepository.findById(id)
                .map(HomeworkMapper::toResponse);
    }

    public void delete(Long id) {
        homeworkRepository.deleteById(id);
    }
}

