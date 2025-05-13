package com.example.portal.service;

import com.example.portal.dto.ScheduleRequest;
import com.example.portal.dto.ScheduleResponse;
import com.example.portal.entity.Schedule;
import com.example.portal.entity.Subject;
import com.example.portal.mapper.ScheduleMapper;
import com.example.portal.repository.ScheduleRepository;
import com.example.portal.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final SubjectRepository subjectRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, SubjectRepository subjectRepository) {
        this.scheduleRepository = scheduleRepository;
        this.subjectRepository = subjectRepository;
    }

    public ScheduleResponse create(ScheduleRequest request) {
        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        Schedule schedule = ScheduleMapper.toEntity(request, subject);
        Schedule saved = scheduleRepository.save(schedule);
        return ScheduleMapper.toResponse(saved);
    }

    public List<ScheduleResponse> getAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<ScheduleResponse> getById(Long id) {
        return scheduleRepository.findById(id)
                .map(ScheduleMapper::toResponse);
    }

    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }
}
