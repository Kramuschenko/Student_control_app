package com.project.tin.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class SubjectDto {

    private Integer id;
    private String abbreviation;
    private String teacher;
    private List<ProjectDto> projects = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Integer[] projectIds;
}