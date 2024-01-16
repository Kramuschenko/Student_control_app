package com.project.tin.service;

import com.project.tin.backend.Grade;
import com.project.tin.backend.Project;
import com.project.tin.backend.Student;
import com.project.tin.backend.repository.GradeRepository;
import com.project.tin.backend.repository.ProjectRepository;
import com.project.tin.backend.repository.StudentRepository;
import com.project.tin.dto.GradeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.project.tin.frontend.UserController.getCurrentUser;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GradeService {

    private final GradeRepository gradeRepository;
    private final ProjectRepository projectRepository;
    private final StudentRepository studentRepository;

    public Page<GradeDto> getAllGrades(Pageable pageable) {
        Page<Grade> grades = gradeRepository.findAll(pageable);

        return grades.map(this::toDto);
    }

    private GradeDto toDto(Grade grade) {
        if (grade == null) return null;
        Project project = projectRepository.getReferenceById(grade.getProjectId());
        Student student = studentRepository.getReferenceById(grade.getStudentId());
        return new GradeDto(grade.getId(), grade.getGrade(), grade.getProjectId(), grade.getStudentId(), grade.getCreatedAt(), grade.getModifiedAt(), student.getName(), student.getSurname(), project.getName());
    }

    public GradeDto getGradeById(Integer id) {
        return toDto(gradeRepository.findById(id).orElse(null));
    }

    public void createGrade(GradeDto gradeDto) {
        if (Objects.isNull(getCurrentUser()))
            return;
        Grade grade = new Grade();
        grade.setId(gradeRepository.generateNextId());
        grade.setGrade(gradeDto.getGrade());
        grade.setProjectId(gradeDto.getProjectId());
        grade.setStudentId(gradeDto.getStudentId());
        gradeRepository.save(grade);
    }

    public void updateGrade(GradeDto gradeDto) {
        if (Objects.isNull(getCurrentUser()))
            return;
        Grade grade = gradeRepository.findById(gradeDto.getId()).orElse(null);
        if (grade == null) return;
        grade.setGrade(gradeDto.getGrade());
        grade.setProjectId(gradeDto.getProjectId());
        grade.setStudentId(gradeDto.getStudentId());
        gradeRepository.save(grade);
    }

    public void deleteGrade(Integer id) {
        if (Objects.isNull(getCurrentUser()))
            return;
        gradeRepository.deleteById(id);
    }
}