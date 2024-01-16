package com.project.tin.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GradeDto {

    private int id;
    private Double grade;
    private int studentId;
    private int projectId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private String name;
    private String surname;
    private String projectName;
}