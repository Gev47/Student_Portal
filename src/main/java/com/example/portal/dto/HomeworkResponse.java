package com.example.portal.dto;

import java.time.LocalDateTime;

public class HomeworkResponse {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private LocalDateTime assignedAt;
    private String subjectName;

    public HomeworkResponse() {}

    public HomeworkResponse(Long id, String title, String description, LocalDateTime dueDate,
                            LocalDateTime assignedAt, String subjectName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.assignedAt = assignedAt;
        this.subjectName = subjectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
