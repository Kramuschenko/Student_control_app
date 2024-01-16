package com.project.tin.service;

import com.project.tin.backend.Grade;
import com.project.tin.backend.Project;
import com.project.tin.backend.Student;
import com.project.tin.backend.Subject;
import com.project.tin.backend.repository.GradeRepository;
import com.project.tin.backend.repository.ProjectRepository;
import com.project.tin.backend.repository.StudentRepository;
import com.project.tin.backend.repository.SubjectRepository;
import com.project.tin.dto.GradeDto;
import com.project.tin.dto.ProjectDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.project.tin.frontend.UserController.getCurrentUser;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProjectService {
    private final GradeRepository gradeRepository;

    private final ProjectRepository projectRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;


    public Page<Project> getAllProjects(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return projectRepository.findAll(pageable);
    }

    public List<Project> getEmptyProjects() {
        return projectRepository.findAll().stream().filter(project -> Objects.isNull(project.getSubjectId())).toList();
    }

    public ProjectDto getProjectById(int id) {
        return projectRepository.findById(id)
                .map(project -> {
                    String abbreviation = null;
                    if (Objects.nonNull(project.getSubjectId())) {
                        Subject subject = subjectRepository.getReferenceById(project.getSubjectId());
                        abbreviation = subject.getAbbreviation();
                    }
                    List<Grade> grades = project.getGrades();
                    List<GradeDto> gradeDtos = gradeToDto(grades);
                    return new ProjectDto(project.getId(), project.getName(), project.getComment(), project.getSubjectId(), abbreviation, gradeDtos, project.getCreatedAt(), project.getModifiedAt(), null);
                }).orElse(null);
    }

    private List<GradeDto> gradeToDto(List<Grade> grades) {
        return grades.stream()
                .map(grade -> {
                    Project project1 = projectRepository.getReferenceById(grade.getProjectId());
                    Student student = studentRepository.getReferenceById(grade.getStudentId());
                    return new GradeDto(grade.getId(), grade.getGrade(), grade.getProjectId(), grade.getStudentId(), grade.getCreatedAt(), grade.getModifiedAt(), student.getName(), student.getSurname(), project1.getName());
                })
                .toList();
    }

    @Transactional
    public void createProject(ProjectDto projectDto) {
        if (Objects.isNull(getCurrentUser()))
            return;
        Project project = new Project();

        Integer id = projectRepository.generateNextId();
        project.setId(id);
        project.setName(projectDto.getName());
        project.setComment(projectDto.getComment());
        project.setSubjectId(projectDto.getSubjectId());

        if (Objects.nonNull(projectDto.getStudentIds())) {
            List<Grade> grades = new ArrayList<>();

            int gradeId = gradeRepository.generateNextId();

            for (Integer studentId : projectDto.getStudentIds()) {
                Grade grade = new Grade();
                grade.setId(gradeId++);
                grade.setGrade(null);
                grade.setProjectId(id);
                grade.setStudentId(studentId);
                grades.add(grade);
            }

            project.setGrades(grades);
        }

        projectRepository.save(project);
    }

    public void deleteProject(int id) {
        if (Objects.isNull(getCurrentUser()))
            return;
        List<Grade> grades = gradeRepository.findAllByProjectId(id);

        for (Grade grade : grades) {
            gradeRepository.deleteById(grade.getId());
        }

        projectRepository.deleteById(id);
    }

    public List<Project> getEmptyProjectsWithId(int id) {
        List<Project> projects = new ArrayList<>(getEmptyProjects());

        List<Project> bySubjectId = projectRepository.findBySubjectId(id);

        if (Objects.nonNull(bySubjectId) && !bySubjectId.isEmpty())
            projects.addAll(bySubjectId);

        return projects;
    }

    public void updateProject(ProjectDto projectDto) {
        if (Objects.isNull(getCurrentUser()))
            return;
        Project project = projectRepository.findById(projectDto.getId()).orElse(null);

        if (Objects.nonNull(project)) {
            project.setName(projectDto.getName());
            project.setComment(projectDto.getComment());
            project.setSubjectId(projectDto.getSubjectId());

            List<Grade> grades = gradeRepository.findAllByProjectId(projectDto.getId());

            List<Integer> studentIds = projectDto.getStudentIds();
            List<Integer> containStudents = new ArrayList<>(grades.stream().map(Grade::getStudentId).toList());

            if (Objects.nonNull(studentIds)) {
                int gradeId = gradeRepository.generateNextId();

                for (Integer studentId : studentIds) {
                    if (containStudents.contains(studentId)) {
                        continue;
                    }

                    Grade grade = new Grade();
                    grade.setId(gradeId++);
                    grade.setGrade(null);
                    grade.setProjectId(projectDto.getId());
                    grade.setStudentId(studentId);
                    grades.add(grade);
                }
            }

            containStudents.removeAll(studentIds);

            for (Integer studentId : containStudents) {
                for (Grade grade : grades) {
                    if (grade.getStudentId().equals(studentId)) {
                        gradeRepository.deleteById(grade.getId());
                    }
                }
                grades.removeIf(grade -> grade.getStudentId().equals(studentId));
            }

            project.setGrades(grades);
            projectRepository.save(project);
        }
    }
}