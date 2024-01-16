package com.project.tin.backend;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "SUBJECT")
public class Subject {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "ABBREVIATION")
    private String abbreviation;

    @Column(name = "TEACHER")
    private String teacher;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUBJECT_ID")
    @ToString.Exclude
    private List<Project> projects = new ArrayList<>();

    @Column(name = "CREATED_AT", columnDefinition = "TIMESTAMP(3)")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "MODIFIED_AT", columnDefinition = "TIMESTAMP(3)")
    @UpdateTimestamp
    private LocalDateTime modifiedAt;
}