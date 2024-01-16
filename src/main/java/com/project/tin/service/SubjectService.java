package com.project.tin.service;

import com.project.tin.backend.Project;
import com.project.tin.backend.Subject;
import com.project.tin.backend.repository.ProjectRepository;
import com.project.tin.backend.repository.SubjectRepository;
import com.project.tin.dto.ProjectDto;
import com.project.tin.dto.SubjectDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.project.tin.frontend.UserController.getCurrentUser;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SubjectService {
    private final ProjectRepository projectRepository;

    private final SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Integer id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Transactional
    public void createSubject(SubjectDto subjectDto) {
        if (Objects.isNull(getCurrentUser()))
            return;
        Subject subject = new Subject();

        subject.setId(subjectRepository.generateNextId());
        saveSubject(subjectDto, subject);
    }

    @Transactional
    public void updateSubject(SubjectDto subjectDto) {
        if (Objects.isNull(getCurrentUser()))
            return;
        Subject subject = subjectRepository.findById(subjectDto.getId()).orElse(null);

        if(Objects.nonNull(subject)) {
            saveSubject(subjectDto, subject);
        }
    }

    private void saveSubject(SubjectDto subjectDto, Subject subject) {
        subject.setAbbreviation(subjectDto.getAbbreviation());
        subject.setTeacher(subjectDto.getTeacher());

        List<Project> projects = new ArrayList<>();

        if(Objects.nonNull(subjectDto.getProjectIds())) {
            projects = projectRepository.findAllById(Arrays.stream(subjectDto.getProjectIds()).toList());
        }

        subject.setProjects(projects);
        subjectRepository.save(subject);

        for (Project project : projects) {
            project.setSubjectId(subject.getId());
            projectRepository.save(project);
        }
    }

    @Transactional
    public void deleteSubject(int id) {
        if (Objects.isNull(getCurrentUser()))
            return;
        List<Project> projects = projectRepository.findBySubjectId(id);

        for (Project project : projects) {
            project.setSubjectId(null);
            projectRepository.save(project);
        }

        projectRepository.flush();

        subjectRepository.deleteById(id);

    }
}