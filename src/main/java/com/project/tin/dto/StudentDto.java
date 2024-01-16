package com.project.tin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class StudentDto {
    private Integer id;
    private String name;
    private String surname;
    private List<GradeDto> grades = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
