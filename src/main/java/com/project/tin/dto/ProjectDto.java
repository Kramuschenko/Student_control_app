package com.project.tin.dto;

import com.project.tin.backend.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ProjectDto {

    private Integer id;
    private String name;
    private String comment;
    private Integer subjectId;
    private String subjectName;
    private List<GradeDto> grades = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<Integer> studentIds = new ArrayList<>();
}