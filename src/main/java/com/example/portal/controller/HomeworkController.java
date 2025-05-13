package com.example.portal.controller;

import com.example.portal.dto.HomeworkRequest;
import com.example.portal.dto.HomeworkResponse;
import com.example.portal.service.HomeworkService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/homeworks")
public class HomeworkController {

    private final HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @PostMapping
    public ResponseEntity<HomeworkResponse> create(@Valid @RequestBody HomeworkRequest request) {
        HomeworkResponse response = homeworkService.create(request);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<HomeworkResponse>> getAll() {
        return ResponseEntity.ok(homeworkService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HomeworkResponse> getById(@PathVariable Long id) {
        Optional<HomeworkResponse> homework = homeworkService.getById(id);
        return homework.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        homeworkService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
