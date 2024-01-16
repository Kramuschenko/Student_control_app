package com.project.tin.backend;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "GRADE")
@Data
public class Grade {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "STUDENT_ID")
    private Integer studentId;

    @Column(name = "PROJECT_ID")
    private Integer projectId;

    @Column(name = "GRADE")
    private Double grade;

    @Column(name = "CREATED_AT", columnDefinition = "TIMESTAMP(3)")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "MODIFIED_AT", columnDefinition = "TIMESTAMP(3)")
    @UpdateTimestamp
    private LocalDateTime modifiedAt;
}